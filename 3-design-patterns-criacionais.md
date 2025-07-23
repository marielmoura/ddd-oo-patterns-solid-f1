# Design Patterns Criacionais com Java e Spring

Os padrões criacionais tratam da criação de objetos, promovendo flexibilidade e desacoplamento. Na Fórmula 1, ajudam a construir componentes complexos como carros, motores e estratégias.

## Factory Method
Permite criar objetos sem expor a lógica de criação ao cliente. Exemplo: fábricas para diferentes tipos de motores ou pneus.

```java
public abstract class FabricaComponenteCarroF1 {
    public abstract ComponenteCarroF1 criarComponente();
}
public class FabricaMotorMercedes extends FabricaComponenteCarroF1 {
    public ComponenteCarroF1 criarComponente() { return new MotorMercedes(); }
}
public class FabricaPneuMacio extends FabricaComponenteCarroF1 {
    public ComponenteCarroF1 criarComponente() { return new PneuMacio(); }
}
// Uso
FabricaComponenteCarroF1 fabricaMotor = new FabricaMotorMercedes();
ComponenteCarroF1 motor = fabricaMotor.criarComponente();
```

## Abstract Factory
Cria famílias de objetos relacionados. Exemplo: montar carros completos de diferentes temporadas.

```java
public interface FabricaCarroF1 {
    Motor criarMotor();
    Pneu criarPneu();
}
public class FabricaCarroF1Temporada2024 implements FabricaCarroF1 {
    public Motor criarMotor() { return new MotorMercedes(); }
    public Pneu criarPneu() { return new PneuMacio(); }
}
public class FabricaCarroF1Temporada2023 implements FabricaCarroF1 {
    public Motor criarMotor() { return new MotorFerrari(); }
    public Pneu criarPneu() { return new PneuMedio(); }
}
// Uso
FabricaCarroF1 fabrica2024 = new FabricaCarroF1Temporada2024();
Motor motor = fabrica2024.criarMotor();
Pneu pneu = fabrica2024.criarPneu();
```

## Builder
Separa a construção de um objeto complexo da sua representação. Exemplo: configurar diferentes versões de carros de F1.

```java
public class CarroF1Builder {
    private String equipe;
    private String piloto;
    private Motor motor;
    private Pneu pneu;
    public CarroF1Builder equipe(String equipe) { this.equipe = equipe; return this; }
    public CarroF1Builder piloto(String piloto) { this.piloto = piloto; return this; }
    public CarroF1Builder motor(Motor motor) { this.motor = motor; return this; }
    public CarroF1Builder pneu(Pneu pneu) { this.pneu = pneu; return this; }
    public CarroF1 build() { return new CarroF1(equipe, piloto, motor, pneu); }
}
// Uso
CarroF1 carro = new CarroF1Builder()
    .equipe("Mercedes")
    .piloto("Hamilton")
    .motor(new MotorMercedes())
    .pneu(new PneuMacio())
    .build();
```

## Singleton
Garante que uma classe tenha apenas uma instância. Exemplo: motor homologado da equipe.

```java
public class MotorEquipeF1 {
    private static MotorEquipeF1 instancia;
    private MotorEquipeF1() {}
    public static MotorEquipeF1 getInstancia() {
        if (instancia == null) instancia = new MotorEquipeF1();
        return instancia;
    }
    public void exibirInfo() {
        System.out.println("Motor único homologado da equipe");
    }
}
// Uso
MotorEquipeF1 motor = MotorEquipeF1.getInstancia();
motor.exibirInfo();
```

## Prototype
Permite criar novos objetos copiando uma instância existente. Exemplo: clonar configurações de carro para testes.

```java
public class ConfiguracaoCarroF1 implements Cloneable {
    private String setupAerodinamico;
    private String calibragemPneus;
    public ConfiguracaoCarroF1(String setup, String calibragem) {
        this.setupAerodinamico = setup;
        this.calibragemPneus = calibragem;
    }
    public ConfiguracaoCarroF1 clone() {
        return new ConfiguracaoCarroF1(setupAerodinamico, calibragemPneus);
    }
}
// Uso
ConfiguracaoCarroF1 configOriginal = new ConfiguracaoCarroF1("Alta carga", "28psi");
ConfiguracaoCarroF1 configClone = configOriginal.clone();
```

## Aplicação na Fórmula 1

Padrões criacionais facilitam a evolução dos sistemas, permitem testes rápidos de novas configurações e garantem consistência na criação de componentes críticos.
