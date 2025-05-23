# aulagithub

# Projeto Calculadora Simples

Este é um projeto Java simples que implementa uma calculadora com operações matemáticas básicas e avançadas.

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

### Operações Básicas
- Soma
- Subtração
- Multiplicação
- Divisão (com tratamento para divisão por zero)

### Operações Avançadas
- Potência (exponenciação)
- Raiz Quadrada (com validação para números negativos)

### Recursos Adicionais
- Histórico de operações
- Formatação de resultados com 2 casas decimais
- Validação de entradas (divisão por zero, raiz quadrada de número negativo)

## Testes

O projeto inclui testes unitários usando JUnit 5 para todas as operações da calculadora, incluindo:
- Testes de operações básicas
- Testes de operações avançadas
- Testes de casos de erro
- Testes do histórico de operações 