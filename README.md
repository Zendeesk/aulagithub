# Projeto Calculadora Simples

Este é um projeto Java simples que implementa uma calculadora básica com as operações fundamentais de matemática.

## Requisitos

- Java 17 ou superior
- Maven 3.6 ou superior

## Estrutura do Projeto

```
projeto-simples/
├── src/
│   ├── main/java/br/com/exemplo/
│   │   └── Calculadora.java
│   └── test/java/br/com/exemplo/
│       └── CalculadoraTest.java
├── pom.xml
└── README.md
```

## Como Executar

1. Compile o projeto:
```bash
mvn compile
```

2. Execute os testes:
```bash
mvn test
```

3. Execute a aplicação:
```bash
mvn exec:java -Dexec.mainClass="br.com.exemplo.Calculadora"
```

## Funcionalidades

- Soma
- Subtração
- Multiplicação
- Divisão (com tratamento para divisão por zero)

## Testes

O projeto inclui testes unitários usando JUnit 5 para todas as operações da calculadora. 