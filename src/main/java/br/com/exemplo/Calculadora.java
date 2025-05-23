package br.com.exemplo;

import java.util.ArrayList;
import java.util.List;
import java.util.DoubleSummaryStatistics;

/**
 * Calculadora com operações matemáticas básicas, avançadas e estatísticas.
 * Mantém um histórico de operações e resultados para análises posteriores.
 */
public final class Calculadora {
    private static final String MSG_DIVISAO_ZERO = "Não é possível dividir por zero!";
    private static final String MSG_RAIZ_NEGATIVA = "Não é possível calcular raiz quadrada de número negativo!";
    private static final String MSG_SEM_RESULTADOS = "Não há resultados para realizar a operação!";
    private static final String FORMATO_RESULTADO = "%.2f";
    
    private final List<String> historicoOperacoes;
    private final List<Double> resultados;

    public Calculadora() {
        this.historicoOperacoes = new ArrayList<>();
        this.resultados = new ArrayList<>();
    }

    /**
     * Realiza a soma de dois números.
     * @param a primeiro número
     * @param b segundo número
     * @return resultado da soma
     */
    public double somar(double a, double b) {
        validarNumeros(a, b);
        double resultado = a + b;
        registrarOperacao(String.format("%s + %s = %s", 
            formatarNumero(a), formatarNumero(b), formatarNumero(resultado)));
        return resultado;
    }

    /**
     * Realiza a subtração de dois números.
     * @param a primeiro número
     * @param b segundo número
     * @return resultado da subtração
     */
    public double subtrair(double a, double b) {
        validarNumeros(a, b);
        double resultado = a - b;
        registrarOperacao(String.format("%s - %s = %s", 
            formatarNumero(a), formatarNumero(b), formatarNumero(resultado)));
        return resultado;
    }

    /**
     * Realiza a multiplicação de dois números.
     * @param a primeiro número
     * @param b segundo número
     * @return resultado da multiplicação
     */
    public double multiplicar(double a, double b) {
        validarNumeros(a, b);
        double resultado = a * b;
        registrarOperacao(String.format("%s * %s = %s", 
            formatarNumero(a), formatarNumero(b), formatarNumero(resultado)));
        return resultado;
    }

    /**
     * Realiza a divisão de dois números.
     * @param a primeiro número
     * @param b segundo número
     * @return resultado da divisão
     * @throws ArithmeticException se o divisor for zero
     */
    public double dividir(double a, double b) {
        validarNumeros(a, b);
        if (b == 0) {
            throw new ArithmeticException(MSG_DIVISAO_ZERO);
        }
        double resultado = a / b;
        registrarOperacao(String.format("%s / %s = %s", 
            formatarNumero(a), formatarNumero(b), formatarNumero(resultado)));
        return resultado;
    }

    /**
     * Calcula a potência de um número.
     * @param base número base
     * @param expoente expoente
     * @return resultado da potência
     */
    public double potencia(double base, double expoente) {
        validarNumeros(base, expoente);
        double resultado = Math.pow(base, expoente);
        registrarOperacao(String.format("%s ^ %s = %s", 
            formatarNumero(base), formatarNumero(expoente), formatarNumero(resultado)));
        return resultado;
    }

    /**
     * Calcula a raiz quadrada de um número.
     * @param numero número para calcular a raiz
     * @return raiz quadrada do número
     * @throws ArithmeticException se o número for negativo
     */
    public double raizQuadrada(double numero) {
        validarNumeros(numero);
        if (numero < 0) {
            throw new ArithmeticException(MSG_RAIZ_NEGATIVA);
        }
        double resultado = Math.sqrt(numero);
        registrarOperacao(String.format("√%s = %s", 
            formatarNumero(numero), formatarNumero(resultado)));
        return resultado;
    }

    /**
     * Calcula a média dos resultados das operações.
     * @return média dos resultados
     * @throws ArithmeticException se não houver resultados
     */
    public double media() {
        validarResultados();
        DoubleSummaryStatistics stats = resultados.stream()
            .mapToDouble(Double::doubleValue)
            .summaryStatistics();
        double media = stats.getAverage();
        registrarOperacao(String.format("Média dos resultados = %s", formatarNumero(media)));
        return media;
    }

    /**
     * Encontra o maior valor entre os resultados.
     * @return maior valor
     * @throws ArithmeticException se não houver resultados
     */
    public double maiorValor() {
        validarResultados();
        double maior = resultados.stream()
            .mapToDouble(Double::doubleValue)
            .max()
            .orElseThrow(() -> new ArithmeticException(MSG_SEM_RESULTADOS));
        registrarOperacao(String.format("Maior valor = %s", formatarNumero(maior)));
        return maior;
    }

    /**
     * Encontra o menor valor entre os resultados.
     * @return menor valor
     * @throws ArithmeticException se não houver resultados
     */
    public double menorValor() {
        validarResultados();
        double menor = resultados.stream()
            .mapToDouble(Double::doubleValue)
            .min()
            .orElseThrow(() -> new ArithmeticException(MSG_SEM_RESULTADOS));
        registrarOperacao(String.format("Menor valor = %s", formatarNumero(menor)));
        return menor;
    }

    private void validarNumeros(double... numeros) {
        for (double numero : numeros) {
            if (Double.isNaN(numero) || Double.isInfinite(numero)) {
                throw new IllegalArgumentException("Número inválido: " + numero);
            }
        }
    }

    private void validarResultados() {
        if (resultados.isEmpty()) {
            throw new ArithmeticException(MSG_SEM_RESULTADOS);
        }
    }

    private String formatarNumero(double numero) {
        return String.format(FORMATO_RESULTADO, numero);
    }

    private void registrarOperacao(String operacao) {
        historicoOperacoes.add(operacao);
        if (operacao.contains("=")) {
            String[] partes = operacao.split("=");
            resultados.add(Double.parseDouble(partes[1].trim()));
        }
    }

    /**
     * Retorna uma cópia do histórico de operações.
     * @return lista com o histórico de operações
     */
    public List<String> getHistorico() {
        return new ArrayList<>(historicoOperacoes);
    }

    /**
     * Limpa o histórico de operações e resultados.
     */
    public void limparHistorico() {
        historicoOperacoes.clear();
        resultados.clear();
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