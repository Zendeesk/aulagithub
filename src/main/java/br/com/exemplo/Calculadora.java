package br.com.exemplo;

import java.util.ArrayList;
import java.util.List;

public class Calculadora {
    private List<String> historicoOperacoes;

    public Calculadora() {
        this.historicoOperacoes = new ArrayList<>();
    }

    public double somar(double a, double b) {
        double resultado = a + b;
        adicionarAoHistorico(String.format("%.2f + %.2f = %.2f", a, b, resultado));
        return resultado;
    }

    public double subtrair(double a, double b) {
        double resultado = a - b;
        adicionarAoHistorico(String.format("%.2f - %.2f = %.2f", a, b, resultado));
        return resultado;
    }

    public double multiplicar(double a, double b) {
        double resultado = a * b;
        adicionarAoHistorico(String.format("%.2f * %.2f = %.2f", a, b, resultado));
        return resultado;
    }

    public double dividir(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Não é possível dividir por zero!");
        }
        double resultado = a / b;
        adicionarAoHistorico(String.format("%.2f / %.2f = %.2f", a, b, resultado));
        return resultado;
    }

    public double potencia(double base, double expoente) {
        double resultado = Math.pow(base, expoente);
        adicionarAoHistorico(String.format("%.2f ^ %.2f = %.2f", base, expoente, resultado));
        return resultado;
    }

    public double raizQuadrada(double numero) {
        if (numero < 0) {
            throw new ArithmeticException("Não é possível calcular raiz quadrada de número negativo!");
        }
        double resultado = Math.sqrt(numero);
        adicionarAoHistorico(String.format("√%.2f = %.2f", numero, resultado));
        return resultado;
    }

    private void adicionarAoHistorico(String operacao) {
        historicoOperacoes.add(operacao);
    }

    public List<String> getHistorico() {
        return new ArrayList<>(historicoOperacoes);
    }

    public void limparHistorico() {
        historicoOperacoes.clear();
    }

    public static void main(String[] args) {
        Calculadora calc = new Calculadora();
        
        // Exemplos de uso
        System.out.println("Soma: " + calc.somar(5, 3));
        System.out.println("Subtração: " + calc.subtrair(5, 3));
        System.out.println("Multiplicação: " + calc.multiplicar(5, 3));
        System.out.println("Divisão: " + calc.dividir(6, 2));
    }
} 