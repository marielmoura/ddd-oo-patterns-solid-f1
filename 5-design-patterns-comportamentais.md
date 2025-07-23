# Design Patterns Comportamentais com Java e Spring

Os padrões comportamentais tratam da interação entre objetos e da atribuição de responsabilidades. Na Fórmula 1, ajudam a organizar fluxos de eventos, comandos, observação de dados e estratégias.

## Chain of Responsibility
Permite que múltiplos objetos processem uma solicitação em cadeia. Exemplo: tratar eventos como bandeiras, pit stops e incidentes.

```java
public abstract class HandlerEventoCorrida {
    protected HandlerEventoCorrida proximo;
    public void setProximo(HandlerEventoCorrida proximo) { this.proximo = proximo; }
    public abstract void processar(String evento);
}
public class HandlerBandeiraAmarela extends HandlerEventoCorrida {
    public void processar(String evento) {
        if (evento.equals("Bandeira Amarela")) {
            System.out.println("Processando bandeira amarela");
        } else if (proximo != null) proximo.processar(evento);
    }
}
```

### Exemplo de uso do Chain of Responsibility

```java
// Exemplo de uso do Chain of Responsibility
HandlerEventoCorrida handlerBandeira = new HandlerBandeiraAmarela();
HandlerEventoCorrida handlerPitStop = new HandlerPitStop();
handlerBandeira.setProximo(handlerPitStop);
handlerBandeira.processar("Bandeira Amarela");
handlerBandeira.processar("Pit Stop");
```

## Command
Encapsula uma solicitação como um objeto. Exemplo: comandos enviados do pit wall para o carro.

```java
public interface Comando {
    void executar();
}
public class ComandoTrocaPneus implements Comando {
    public void executar() { System.out.println("Executando troca de pneus"); }
}
```

### Exemplo de uso do Command

```java
// Exemplo de uso do Command
Comando comandoTroca = new ComandoTrocaPneus();
comandoTroca.executar();
```

## Iterator
Permite percorrer uma coleção sem expor sua estrutura interna. Exemplo: navegar pelos dados de voltas de um carro.

```java
public class VoltasCorrida implements Iterable<String> {
    private final List<String> voltas = new ArrayList<>();
    public void adicionarVolta(String volta) { voltas.add(volta); }
    public Iterator<String> iterator() { return voltas.iterator(); }
}
```

### Exemplo de uso do Iterator

```java
// Exemplo de uso do Iterator
VoltasCorrida voltas = new VoltasCorrida();
voltas.adicionarVolta("Volta 1: 1:32.5");
voltas.adicionarVolta("Volta 2: 1:31.8");
for (String v : voltas) {
    System.out.println(v);
}
```

## Mediator
Centraliza a comunicação entre objetos. Exemplo: coordenar a interação entre sistemas do carro.

```java
public interface MediadorCarro {
    void enviarMensagem(String origem, String destino, String mensagem);
}
public class CentralCarro implements MediadorCarro {
    public void enviarMensagem(String origem, String destino, String mensagem) {
        System.out.println("Mensagem de " + origem + " para " + destino + ": " + mensagem);
    }
}
```

### Exemplo de uso do Mediator

```java
// Exemplo de uso do Mediator
CentralCarro central = new CentralCarro();
central.enviarMensagem("Motor", "Painel", "Temperatura alta");
```

## Memento
Armazena o estado interno de um objeto. Exemplo: salvar o estado do carro ou da corrida.

```java
public class EstadoCarro {
    private final double combustivel;
    public EstadoCarro(double combustivel) { this.combustivel = combustivel; }
    public double getCombustivel() { return combustivel; }
}
public class CarroF1ComMemento {
    private double combustivel;
    public EstadoCarro salvarEstado() { return new EstadoCarro(combustivel); }
    public void restaurarEstado(EstadoCarro estado) { combustivel = estado.getCombustivel(); }
}
```

### Exemplo de uso do Memento

```java
// Exemplo de uso do Memento
CarroF1ComMemento carro = new CarroF1ComMemento();
carro.restaurarEstado(new EstadoCarro(80.0));
EstadoCarro estadoSalvo = carro.salvarEstado();
System.out.println("Combustível salvo: " + estadoSalvo.getCombustivel());
```

## Observer
Define uma dependência um-para-muitos entre objetos. Exemplo: monitorar dados de sensores em tempo real.

```java
public interface ObservadorSensor {
    void atualizar(String dados);
}
public class SensorVelocidade {
    private final List<ObservadorSensor> observadores = new ArrayList<>();
    public void adicionarObservador(ObservadorSensor obs) { observadores.add(obs); }
    public void notificar(String dados) {
        for (ObservadorSensor obs : observadores) obs.atualizar(dados);
    }
}
```

### Exemplo de uso do Observer

```java
// Exemplo de uso do Observer
SensorVelocidade sensor = new SensorVelocidade();
sensor.adicionarObservador(dados -> System.out.println("Velocidade recebida: " + dados));
sensor.notificar("320 km/h");
```

## State
Permite que um objeto altere seu comportamento quando seu estado interno muda. Exemplo: diferentes modos do carro.

```java
public interface EstadoCarroF1 {
    void acao();
}
public class EstadoCorrendo implements EstadoCarroF1 {
    public void acao() { System.out.println("Carro em modo corrida"); }
}
```

### Exemplo de uso do State

```java
// Exemplo de uso do State
EstadoCarroF1 estadoCorrida = new EstadoCorrendo();
estadoCorrida.acao();
```

## Strategy
Define uma família de algoritmos, encapsula cada um e os torna intercambiáveis. Exemplo: diferentes estratégias de corrida.

```java
public interface EstrategiaCorrida {
    void executar();
}
public class EstrategiaAgressiva implements EstrategiaCorrida {
    public void executar() { System.out.println("Executando estratégia agressiva"); }
}
```

### Exemplo de uso do Strategy

```java
// Exemplo de uso do Strategy
EstrategiaCorrida estrategia = new EstrategiaAgressiva();
estrategia.executar();
```

## Template Method
Define o esqueleto de um algoritmo, permitindo que subclasses implementem etapas específicas. Exemplo: padronizar o processo de pit stop.

```java
public abstract class PitStopTemplate {
    public final void realizarPitStop() {
        entrarBox();
        trocarPneus();
        abastecer();
        sairBox();
    }
    protected abstract void trocarPneus();
    protected abstract void abastecer();
    protected void entrarBox() { System.out.println("Entrando no box"); }
    protected void sairBox() { System.out.println("Saindo do box"); }
}
```

### Exemplo de uso do Template Method

```java
// Exemplo de uso do Template Method
PitStopTemplate pitStop = new PitStopTemplate() {
    protected void trocarPneus() { System.out.println("Trocando pneus"); }
    protected void abastecer() { System.out.println("Abastecendo"); }
};
pitStop.realizarPitStop();
```

## Visitor
Permite adicionar operações a objetos sem modificar suas classes. Exemplo: analisar diferentes componentes do carro.

```java
public interface VisitorComponente {
    void visitar(Motor motor);
    void visitar(Pneu pneu);
}
public class AnaliseDesempenhoVisitor implements VisitorComponente {
    public void visitar(Motor motor) { System.out.println("Analisando motor"); }
    public void visitar(Pneu pneu) { System.out.println("Analisando pneu"); }
}
```

### Exemplo de uso do Visitor

```java
// Exemplo de uso do Visitor
AnaliseDesempenhoVisitor visitor = new AnaliseDesempenhoVisitor();
visitor.visitar(new Motor());
visitor.visitar(new Pneu());
```

## Aplicação na Fórmula 1

Padrões comportamentais organizam fluxos de eventos, comandos e estratégias, tornando o software mais flexível e preparado para mudanças rápidas durante a corrida.
