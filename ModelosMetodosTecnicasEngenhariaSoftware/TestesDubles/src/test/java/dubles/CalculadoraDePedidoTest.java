package dubles;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CalculadoraDePedidoTest {

    @Mock
    private IMotorDesconto motorDesconto;

    @Mock
    private IPedido pedido;

    @InjectMocks
    private CalculadoraDePedido calculadora;

    @Test
    public void testSemDesconto() {
        when(pedido.getValorBruto()).thenReturn(200.0);
        when(motorDesconto.calcularDesconto(pedido)).thenReturn(0.0);

        assertEquals(200.0, calculadora.calcularValorFinal(pedido));
    }

    @Test
    public void testComDesconto10Porcento() {
        when(pedido.getValorBruto()).thenReturn(200.0);
        when(motorDesconto.calcularDesconto(pedido)).thenReturn(0.1);

        assertEquals(180.0, calculadora.calcularValorFinal(pedido));
    }

    @Test
    public void testComDesconto100Porcento() {
        when(pedido.getValorBruto()).thenReturn(200.0);
        when(motorDesconto.calcularDesconto(pedido)).thenReturn(1.0);

        assertEquals(0.0, calculadora.calcularValorFinal(pedido));
    }

    @Test
    public void testComDesconto50Porcento() {
        when(pedido.getValorBruto()).thenReturn(100.0);
        when(motorDesconto.calcularDesconto(pedido)).thenReturn(0.5);

        assertEquals(50.0, calculadora.calcularValorFinal(pedido));
    }
}
