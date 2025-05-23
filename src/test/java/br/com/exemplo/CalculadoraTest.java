package br.com.exemplo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraTest {
    private Calculadora calculadora;

    @BeforeEach
    void setUp() {
        calculadora = new Calculadora();
    }

    @Test
    void testSoma() {
        assertEquals(5.0, calculadora.somar(2.0, 3.0));
        assertEquals(0.0, calculadora.somar(-2.0, 2.0));
    }

    @Test
    void testSubtracao() {
        assertEquals(1.0, calculadora.subtrair(3.0, 2.0));
        assertEquals(-5.0, calculadora.subtrair(2.0, 7.0));
    }

    @Test
    void testMultiplicacao() {
        assertEquals(6.0, calculadora.multiplicar(2.0, 3.0));
        assertEquals(-6.0, calculadora.multiplicar(2.0, -3.0));
    }

    @Test
    void testDivisao() {
        assertEquals(2.0, calculadora.dividir(6.0, 3.0));
        assertEquals(-2.0, calculadora.dividir(6.0, -3.0));
    }

    @Test
    void testDivisaoPorZero() {
        assertThrows(ArithmeticException.class, () -> calculadora.dividir(5.0, 0.0));
    }

    @Test
    void testPotencia() {
        assertEquals(8.0, calculadora.potencia(2.0, 3.0));
        assertEquals(1.0, calculadora.potencia(5.0, 0.0));
        assertEquals(0.25, calculadora.potencia(2.0, -2.0));
    }

    @Test
    void testRaizQuadrada() {
        assertEquals(3.0, calculadora.raizQuadrada(9.0));
        assertEquals(0.0, calculadora.raizQuadrada(0.0));
    }

    @Test
    void testRaizQuadradaNumeroNegativo() {
        assertThrows(ArithmeticException.class, () -> calculadora.raizQuadrada(-4.0));
    }

    @Test
    void testHistorico() {
        calculadora.somar(2.0, 3.0);
        calculadora.subtrair(5.0, 2.0);
        
        var historico = calculadora.getHistorico();
        assertEquals(2, historico.size());
        assertTrue(historico.get(0).contains("2.00 + 3.00 = 5.00"));
        assertTrue(historico.get(1).contains("5.00 - 2.00 = 3.00"));
    }

    @Test
    void testLimparHistorico() {
        calculadora.somar(2.0, 3.0);
        calculadora.limparHistorico();
        assertTrue(calculadora.getHistorico().isEmpty());
    }
} 