# Princípios SOLID com Java e Spring

Os princípios SOLID são fundamentais para criar software flexível, manutenível e de fácil evolução. Na Fórmula 1, ajudam a estruturar sistemas de telemetria, estratégia e simulação de forma robusta.

## 1. Single Responsibility Principle (SRP)
Uma classe deve ter apenas uma razão para mudar. Exemplo:

```java
// SRP: Separação de responsabilidades
public class ColetorTelemetria {
    public DadoTelemetrico coletar() { /* coleta dados do carro */ }
}
public class ProcessadorTelemetria {
    public Resultado processar(DadoTelemetrico dado) { /* processa dados */ }
}
public class ArmazenadorTelemetria {
    public void salvar(Resultado resultado) { /* salva resultado */ }
}
```

## 2. Open/Closed Principle (OCP)
Classes devem ser abertas para extensão, mas fechadas para modificação. Exemplo:

```java
// OCP: Estratégia de desgaste de pneus
public interface EstrategiaDesgastePneu {
    double calcularDesgaste(double tempoVolta, double temperatura);
}
public class DesgastePneuMacio implements EstrategiaDesgastePneu {
    public double calcularDesgaste(double tempoVolta, double temperatura) {
        return tempoVolta * 0.02 + temperatura * 0.01;
    }
}
public class DesgastePneuDuro implements EstrategiaDesgastePneu {
    public double calcularDesgaste(double tempoVolta, double temperatura) {
        return tempoVolta * 0.01 + temperatura * 0.005;
    }
}
public class SimuladorDesgastePneu {
    private EstrategiaDesgastePneu estrategia;
    public SimuladorDesgastePneu(EstrategiaDesgastePneu estrategia) {
        this.estrategia = estrategia;
    }
    public double simular(double tempoVolta, double temperatura) {
        return estrategia.calcularDesgaste(tempoVolta, temperatura);
    }
    public void setEstrategia(EstrategiaDesgastePneu estrategia) {
        this.estrategia = estrategia;
    }
}
```

## 3. Liskov Substitution Principle (LSP)
Subtipos devem ser substituíveis por seus tipos base. Exemplo:

```java
public abstract class VeiculoCorrida {
    public abstract void acelerar();
}
public class CarroF1 extends VeiculoCorrida {
    public void acelerar() { System.out.println("Carro de F1 acelerando!"); }
}
public class SafetyCar extends VeiculoCorrida {
    public void acelerar() { System.out.println("Safety Car acelerando!"); }
}
// Uso
VeiculoCorrida v = new CarroF1();
v.acelerar(); // Funciona para qualquer subtipo
```

## 4. Interface Segregation Principle (ISP)
Prefira várias interfaces específicas a uma única interface genérica. Exemplo:

```java
public interface Abastecivel {
    void abastecer(double quantidade);
}
public interface TrocaPneus {
    void trocarPneus(String tipo);
}
public interface AtivaDRS {
    void ativarDRS();
}
public class CarroF1 implements Abastecivel, TrocaPneus, AtivaDRS {
    // Implementações específicas
}
```

## 5. Dependency Inversion Principle (DIP)
Dependa de abstrações, não de implementações concretas. Exemplo:

```java
public interface SensorF1 {
    double getValor();
}
public class SensorVelocidade implements SensorF1 {
    public double getValor() { return 320.5; }
}
public class MonitorDeDesempenho {
    private final SensorF1 sensor;
    public MonitorDeDesempenho(SensorF1 sensor) { this.sensor = sensor; }
    public void exibir() {
        System.out.println("Monitorando: " + sensor.getValor());
    }
}
```

## Aplicação na Fórmula 1

SOLID facilita a evolução dos sistemas, permite integração de novos sensores, estratégias e componentes sem grandes refatorações, e torna o software mais seguro e confiável para ambientes críticos como a F1.
