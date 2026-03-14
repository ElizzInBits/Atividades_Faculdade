package testes1;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraMediaTest {

    @Test
    public void testCalculoCorreto() {
        CalculadoraMedia calc = new CalculadoraMedia(Arrays.asList(6.0, 8.0, 10.0));
        assertEquals(8.0, calc.calcularMedia());
    }

    @Test
    public void testListaVazia() {
        CalculadoraMedia calc = new CalculadoraMedia(Collections.emptyList());
        assertThrows(IllegalArgumentException.class, () -> calc.calcularMedia());
    }

    @Test
    public void testNotaInvalida() {
        CalculadoraMedia calc = new CalculadoraMedia(Arrays.asList(5.0, -1.0, 8.0));
        assertThrows(IllegalArgumentException.class, () -> calc.calcularMedia());
    }
}
