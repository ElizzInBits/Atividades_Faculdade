package dubles;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProcessadorDeCompraTest {

    @Mock
    private IConta conta;

    @Mock
    private IRegistradora registradora;

    @InjectMocks
    private ProcessadorDeCompra processador;

    @Test
    public void testClienteInativoLancaException() {
        Cliente cliente = new Cliente(false);

        assertThrows(IllegalStateException.class,
                () -> processador.processar(cliente, conta, 100.0));
    }

    @Test
    public void testSaldoInsuficienteLancaException() {
        Cliente cliente = new Cliente(true);
        when(conta.getSaldo()).thenReturn(50.0);

        assertThrows(IllegalArgumentException.class,
                () -> processador.processar(cliente, conta, 100.0));
    }

    @Test
    public void testProcessamentoComSucesso() {
        Cliente cliente = new Cliente(true);
        when(conta.getSaldo()).thenReturn(200.0);

        processador.processar(cliente, conta, 100.0);

        verify(conta).debitar(100.0);
        verify(registradora).registrar(cliente, 100.0);
    }

    @Test
    public void testDebitoNaoOcorreSeClienteInativo() {
        Cliente cliente = new Cliente(false);

        assertThrows(IllegalStateException.class,
                () -> processador.processar(cliente, conta, 100.0));

        verify(conta, never()).debitar(anyDouble());
        verify(registradora, never()).registrar(any(), anyDouble());
    }

    @Test
    public void testRegistroNaoOcorreComSaldoInsuficiente() {
        Cliente cliente = new Cliente(true);
        when(conta.getSaldo()).thenReturn(10.0);

        assertThrows(IllegalArgumentException.class,
                () -> processador.processar(cliente, conta, 100.0));

        verify(conta, never()).debitar(anyDouble());
        verify(registradora, never()).registrar(any(), anyDouble());
    }
}
