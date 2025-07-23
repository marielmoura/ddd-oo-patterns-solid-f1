# Programação Orientada a Objetos (POO) em Java

A Programação Orientada a Objetos (POO) é um paradigma que organiza o software em torno de objetos, facilitando a modelagem de sistemas complexos. Na Fórmula 1, POO permite representar carros, pilotos, equipes e pistas de forma intuitiva e flexível.

## Conceitos Fundamentais

- **Classe**: Define o molde para criar objetos. Exemplo: `CarroF1`.
- **Objeto**: Instância de uma classe, com estado e comportamento próprios.
- **Atributos**: Características do objeto (ex: velocidade, combustível).
- **Métodos**: Ações que o objeto pode realizar (ex: acelerar, frear).

## Exemplo em Java

```java
public class CarroF1 {
    private String equipe;
    private String piloto;
    private double velocidadeAtual;
    private double combustivel;
    private String tipoPneu;

    public CarroF1(String equipe, String piloto, String tipoPneu) {
        this.equipe = equipe;
        this.piloto = piloto;
        this.velocidadeAtual = 0.0;
        this.combustivel = 100.0;
        this.tipoPneu = tipoPneu;
    }

    public void acelerar(double intensidade) {
        if (combustivel > 0) {
            velocidadeAtual += intensidade * 10;
            combustivel -= intensidade * 0.5;
            System.out.printf("%s da equipe %s acelerando. Velocidade: %.1f km/h. Combustível: %.2f%%%n", piloto, equipe, velocidadeAtual, combustivel);
        } else {
            System.out.printf("%s da equipe %s está sem combustível!%n", piloto, equipe);
        }
    }

    public void frear() {
        velocidadeAtual = 0.0;
        System.out.printf("%s da equipe %s freou. Velocidade: %.1f km/h.%n", piloto, equipe, velocidadeAtual);
    }

    public void trocarPneus(String novoTipoPneu) {
        tipoPneu = novoTipoPneu;
        System.out.printf("%s da equipe %s trocou para pneus %s.%n", piloto, equipe, novoTipoPneu);
    }

    public void abastecer(double quantidade) {
        combustivel = Math.min(100.0, combustivel + quantidade);
        System.out.printf("%s da equipe %s abasteceu. Combustível: %.2f%%%n", piloto, equipe, combustivel);
    }
}
```

## Pilares da POO

- **Encapsulamento**: Protege o estado interno do objeto.
- **Herança**: Permite criar hierarquias de classes.
- **Polimorfismo**: Objetos podem assumir diferentes formas.
- **Abstração**: Foca nas características essenciais do objeto.

## Exemplo Avançado: Herança, Polimorfismo e Simulação

```java
// Classe base
public abstract class VeiculoF1 {
    protected String equipe;
    protected String piloto;
    protected double velocidadeAtual;
    public VeiculoF1(String equipe, String piloto) {
        this.equipe = equipe;
        this.piloto = piloto;
        this.velocidadeAtual = 0.0;
    }
    public abstract void acelerar();
    public void frear() {
        velocidadeAtual = 0.0;
        System.out.printf("%s da equipe %s freou. Velocidade: %.1f km/h.%n", piloto, equipe, velocidadeAtual);
    }
}

// Subclasse CarroF1
public class CarroF1 extends VeiculoF1 {
    private String tipoPneu;
    public CarroF1(String equipe, String piloto, String tipoPneu) {
        super(equipe, piloto);
        this.tipoPneu = tipoPneu;
    }
    @Override
    public void acelerar() {
        velocidadeAtual += 15;
        System.out.printf("%s da equipe %s acelerou. Velocidade: %.1f km/h. Pneu: %s%n", piloto, equipe, velocidadeAtual, tipoPneu);
    }
    public void trocarPneus(String novoTipoPneu) {
        tipoPneu = novoTipoPneu;
        System.out.printf("%s trocou para pneus %s.%n", piloto, tipoPneu);
    }
}

// Subclasse SafetyCar
public class SafetyCar extends VeiculoF1 {
    public SafetyCar(String piloto) {
        super("Direção de Prova", piloto);
    }
    @Override
    public void acelerar() {
        velocidadeAtual += 5;
        System.out.printf("Safety Car acelerou. Velocidade: %.1f km/h.%n", velocidadeAtual);
    }
}

// Simulação de corrida
public class SimulacaoCorrida {
    public static void main(String[] args) {
        VeiculoF1[] veiculos = {
            new CarroF1("Mercedes", "Hamilton", "Macio"),
            new CarroF1("Red Bull", "Verstappen", "Médio"),
            new SafetyCar("Bernd Mayländer")
        };
        for (VeiculoF1 v : veiculos) {
            v.acelerar();
        }
        veiculos[0].frear();
        ((CarroF1) veiculos[1]).trocarPneus("Duro");
    }
}
```

## Aplicação na Fórmula 1

POO facilita a modelagem de entidades como carros, pilotos, equipes e pistas, tornando o software mais modular, reutilizável e fácil de manter.
