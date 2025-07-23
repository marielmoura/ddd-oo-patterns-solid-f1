# Design Patterns Estruturais com Java e Spring

Os padrões estruturais tratam da composição de classes e objetos para formar estruturas flexíveis e eficientes. Na Fórmula 1, ajudam a conectar sistemas, adaptar componentes e organizar entidades complexas.

## Adapter
Converte a interface de uma classe em outra esperada pelo cliente. Exemplo: integrar sensores antigos ao sistema moderno de telemetria.

```java
public interface SensorNovo {
    String lerDados();
}
public class SensorAntigo {
    public String obterDadosAntigos() { return "dados do sensor legado"; }
}
public class SensorAdapter implements SensorNovo {
    private final SensorAntigo sensorAntigo;
    public SensorAdapter(SensorAntigo sensorAntigo) { this.sensorAntigo = sensorAntigo; }
    public String lerDados() { return sensorAntigo.obterDadosAntigos(); }
}
```

## Bridge
Separa abstração da implementação, permitindo variar ambos independentemente. Exemplo: conectar diferentes sistemas de telemetria a múltiplos tipos de exibição de dados.

```java
public interface ExibicaoDados {
    void exibir(String dados);
}
public class ExibicaoPainel implements ExibicaoDados {
    public void exibir(String dados) { System.out.println("Painel: " + dados); }
}
public abstract class Telemetria {
    protected ExibicaoDados exibicao;
    public Telemetria(ExibicaoDados exibicao) { this.exibicao = exibicao; }
    public abstract void mostrarDados();
}
public class TelemetriaMotor extends Telemetria {
    public TelemetriaMotor(ExibicaoDados exibicao) { super(exibicao); }
    public void mostrarDados() { exibicao.exibir("RPM=15000, Temp=105C"); }
}
```

## Composite
Permite tratar objetos individuais e composições de objetos de forma uniforme. Exemplo: estrutura hierárquica de componentes do carro.

```java
public interface ComponenteCarro {
    void exibir();
}
public class Pneu implements ComponenteCarro {
    public void exibir() { System.out.println("Pneu"); }
}
public class Chassi implements ComponenteCarro {
    public void exibir() { System.out.println("Chassi"); }
}
public class CarroComposite implements ComponenteCarro {
    private final List<ComponenteCarro> componentes = new ArrayList<>();
    public void adicionar(ComponenteCarro c) { componentes.add(c); }
    public void exibir() {
        System.out.println("Carro:");
        for (ComponenteCarro c : componentes) c.exibir();
    }
}
```

## Decorator
Adiciona funcionalidades a objetos de forma dinâmica. Exemplo: adicionar recursos extras ao carro sem alterar sua estrutura base.

```java
public interface Carro {
    void montar();
}
public class CarroBase implements Carro {
    public void montar() { System.out.println("Carro básico"); }
}
public class CarroComDRS implements Carro {
    private final Carro carro;
    public CarroComDRS(Carro carro) { this.carro = carro; }
    public void montar() {
        carro.montar();
        System.out.println("Adicionando DRS");
    }
}
```

## Facade
Fornece uma interface simplificada para um conjunto de subsistemas. Exemplo: facilitar o uso do sistema de gerenciamento de corrida.

```java
public class GerenciadorCorridaFacade {
    public void iniciarCorrida() { System.out.println("Corrida iniciada"); }
    public void encerrarCorrida() { System.out.println("Corrida encerrada"); }
}
```

## Flyweight
Compartilha dados comuns entre múltiplos objetos para economizar memória. Exemplo: representar pneus de forma eficiente.

```java
public class PneuFlyweight {
    private final String tipo;
    public PneuFlyweight(String tipo) { this.tipo = tipo; }
    public String getTipo() { return tipo; }
}
public class FabricaPneu {
    private final Map<String, PneuFlyweight> pool = new HashMap<>();
    public PneuFlyweight getPneu(String tipo) {
        return pool.computeIfAbsent(tipo, PneuFlyweight::new);
    }
}
```

## Proxy
Controla o acesso a objetos, podendo adicionar segurança ou cache. Exemplo: proteger dados confidenciais da equipe.

```java
public interface DadosEquipe {
    String acessar();
}
public class DadosEquipeReal implements DadosEquipe {
    public String acessar() { return "Dados confidenciais"; }
}
public class ProxyDadosEquipe implements DadosEquipe {
    private final DadosEquipeReal real;
    private final boolean autorizado;
    public ProxyDadosEquipe(DadosEquipeReal real, boolean autorizado) {
        this.real = real;
        this.autorizado = autorizado;
    }
    public String acessar() {
        if (autorizado) return real.acessar();
        else return "Acesso negado";
    }
}
```

## Aplicação na Fórmula 1

Padrões estruturais facilitam a integração de sistemas, a adaptação de componentes legados e a organização eficiente de entidades complexas no software da F1.

```java
// Exemplo de uso do Composite
ComponenteCarro pneu = new Pneu();
ComponenteCarro chassi = new Chassi();
CarroComposite carro = new CarroComposite();
carro.adicionar(pneu);
carro.adicionar(chassi);
carro.exibir();

// Exemplo de uso do Decorator
Carro carroBase = new CarroBase();
Carro carroComDRS = new CarroComDRS(carroBase);
carroComDRS.montar();

// Exemplo de uso do Facade
GerenciadorCorridaFacade corrida = new GerenciadorCorridaFacade();
corrida.iniciarCorrida();
corrida.encerrarCorrida();

// Exemplo de uso do Flyweight
FabricaPneu fabrica = new FabricaPneu();
PneuFlyweight pneuMacio = fabrica.getPneu("Macio");
PneuFlyweight pneuDuro = fabrica.getPneu("Duro");
System.out.println("Pneu criado: " + pneuMacio.getTipo());
System.out.println("Pneu criado: " + pneuDuro.getTipo());

// Exemplo de uso do Proxy
DadosEquipeReal dados = new DadosEquipeReal();
ProxyDadosEquipe proxyAutorizado = new ProxyDadosEquipe(dados, true);
ProxyDadosEquipe proxyNegado = new ProxyDadosEquipe(dados, false);
System.out.println(proxyAutorizado.acessar()); // Dados confidenciais
System.out.println(proxyNegado.acessar());     // Acesso negado
```
