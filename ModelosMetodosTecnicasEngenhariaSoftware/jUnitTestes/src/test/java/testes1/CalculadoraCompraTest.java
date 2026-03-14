package testes1;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraCompraTest {

    @Test
    public void testTotalSemDesconto() {
        CalculadoraCompra compra = new CalculadoraCompra(Arrays.asList(10.0, 20.0, 30.0));
        assertEquals(60.0, compra.calcularTotal());
    }

    @Test
    public void testTotalComDesconto() {
        CalculadoraCompra compra = new CalculadoraCompra(Arrays.asList(10.0, 20.0, 30.0), 10.0);
        assertEquals(50.0, compra.calcularTotal());
    }

    @Test
    public void testListaVazia() {
        CalculadoraCompra compra = new CalculadoraCompra(Collections.emptyList());
        assertThrows(IllegalArgumentException.class, () -> compra.calcularTotal());
    }

    @Test
    public void testPrecoInvalido() {
        CalculadoraCompra compra = new CalculadoraCompra(Arrays.asList(10.0, -5.0, 30.0));
        assertThrows(IllegalArgumentException.class, () -> compra.calcularTotal());
    }

    @Test
    public void testDescontoInvalido() {
        CalculadoraCompra compra = new CalculadoraCompra(Arrays.asList(10.0, 20.0), -5.0);
        assertThrows(IllegalArgumentException.class, () -> compra.calcularTotal());
    }
}
