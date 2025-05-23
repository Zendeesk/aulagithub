package br.com.exemplo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraTest {
    
    private final Calculadora calculadora = new Calculadora();

    @Test
    void testSomar() {
        assertEquals(8.0, calculadora.somar(5, 3));
        assertEquals(0.0, calculadora.somar(-5, 5));
    }

    @Test
    void testSubtrair() {
        assertEquals(2.0, calculadora.subtrair(5, 3));
        assertEquals(-8.0, calculadora.subtrair(-5, 3));
    }

    @Test
    void testMultiplicar() {
        assertEquals(15.0, calculadora.multiplicar(5, 3));
        assertEquals(-15.0, calculadora.multiplicar(-5, 3));
    }

    @Test
    void testDividir() {
        assertEquals(2.0, calculadora.dividir(6, 3));
        assertEquals(-2.0, calculadora.dividir(-6, 3));
    }

    @Test
    void testDividirPorZero() {
        assertThrows(ArithmeticException.class, () -> {
            calculadora.dividir(5, 0);
        });
    }
} 