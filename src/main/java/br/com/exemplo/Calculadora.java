package br.com.exemplo;

public class Calculadora {
    public double somar(double a, double b) {
        return a + b;
    }

    public double subtrair(double a, double b) {
        return a - b;
    }

    public double multiplicar(double a, double b) {
        return a * b;
    }

    public double dividir(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Não é possível dividir por zero!");
        }
        return a / b;
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