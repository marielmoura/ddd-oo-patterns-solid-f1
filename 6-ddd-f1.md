# Domain-Driven Design (DDD) na Fórmula 1

O Domain-Driven Design (DDD) foca na modelagem do domínio do negócio, promovendo colaboração entre especialistas e desenvolvedores. Na Fórmula 1, DDD permite criar sistemas que refletem fielmente a complexidade do esporte, como telemetria, estratégia e simulação de corrida.

## Blocos Construtivos do DDD
- **Entidades**: objetos com identidade própria (ex: CarroF1, Piloto).
- **Value Objects**: objetos sem identidade, definidos apenas por seus atributos (ex: TempoDeVolta, ConfiguracaoAerodinamica).
- **Agregados**: agrupamentos de entidades e value objects que garantem consistência (ex: SessaoDePista).
- **Serviços de Domínio**: operações que não pertencem a uma entidade específica (ex: CalculoDeDesempenho).
- **Repositórios**: abstraem o acesso a dados persistentes (ex: RepositorioDeVoltas).

## Contextos Delimitados
Separação de diferentes áreas do sistema, como telemetria, estratégia e simulação. Mapas de contexto mostram como esses contextos se relacionam.

## Linguagem Ubíqua
Garante que todos usem os mesmos termos para entidades e operações do domínio, facilitando comunicação e evitando ambiguidades.

## Exemplo Prático

```java
// Entidade CarroF1
public class CarroF1 {
    private final String id;
    private final String equipe;
    private final String piloto;
    private double combustivel;
    private String tipoPneu;
    public CarroF1(String id, String equipe, String piloto, String tipoPneu) {
        this.id = id;
        this.equipe = equipe;
        this.piloto = piloto;
        this.combustivel = 100.0;
        this.tipoPneu = tipoPneu;
    }
    public void acelerar(double intensidade) {
        combustivel -= intensidade * 0.5;
    }
    // ... outros métodos ...
}

// Value Object TempoDeVolta
public record TempoDeVolta(double segundos) {}

// Agregado SessaoDePista
public class SessaoDePista {
    private final List<VoltaDeCorrida> voltas = new ArrayList<>();
    public void adicionarVolta(VoltaDeCorrida volta) { voltas.add(volta); }
    public List<VoltaDeCorrida> getVoltas() { return voltas; }
}

// Serviço de Domínio
public class CalculoDeDesempenho {
    public double calcularMediaVoltas(List<TempoDeVolta> voltas) {
        return voltas.stream().mapToDouble(TempoDeVolta::segundos).average().orElse(0.0);
    }
}

// Repositório
public interface RepositorioDeVoltas {
    void salvar(VoltaDeCorrida volta);
    List<VoltaDeCorrida> buscarPorCarro(String carroId);
}

// Simulação de uso dos blocos DDD
CarroF1 carro = new CarroF1("44", "Mercedes", "Hamilton", "Macio");
SessaoDePista sessao = new SessaoDePista();
sessao.adicionarVolta(new VoltaDeCorrida(carro, new TempoDeVolta(92.5)));
sessao.adicionarVolta(new VoltaDeCorrida(carro, new TempoDeVolta(91.8)));
CalculoDeDesempenho calc = new CalculoDeDesempenho();
double media = calc.calcularMediaVoltas(sessao.getVoltas().stream().map(VoltaDeCorrida::getTempo).toList());
System.out.println("Média de tempo de volta: " + media);
```

## Aplicação na Fórmula 1

DDD facilita a evolução dos sistemas, promove clareza e consistência, e torna o software mais alinhado ao negócio da F1.
