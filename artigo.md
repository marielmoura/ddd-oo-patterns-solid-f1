
# Desvendando a Engenharia de Software na Fórmula 1: Design Patterns, SOLID e Orientação a Objetos com Java 21 e Spring




## Introdução

No mundo da engenharia de software, a busca por sistemas robustos, flexíveis e de fácil manutenção é constante. Para alcançar esses objetivos, desenvolvedores e arquitetos de software se apoiam em pilares fundamentais como a Programação Orientada a Objetos (POO), os Princípios SOLID e os Design Patterns. Estes conceitos, embora teóricos, encontram sua aplicação prática em diversos domínios, e um dos mais fascinantes e exigentes é o automobilismo de alta performance, em particular a Fórmula 1.

Este artigo se propõe a desmistificar esses conceitos, apresentando-os de forma didática e contextualizada. Utilizaremos a linguagem Java 21 e o framework Spring como base para nossos exemplos de código, demonstrando como a teoria se traduz em soluções elegantes e eficientes. O diferencial será a aplicação desses conceitos em cenários inspirados no universo da Fórmula 1, desde a telemetria de carros de corrida até a gestão de estratégias de pit stop, proporcionando uma compreensão mais intuitiva e envolvente. Ao final, o leitor terá uma visão clara de como esses princípios e padrões podem ser aplicados para construir software de alta qualidade, mesmo em ambientes tão dinâmicos e críticos quanto o automobilismo de elite.




## Sumário

1.  **Introdução**
2.  **Programação Orientada a Objetos (POO) em Java**
    *   2.1. Conceitos Fundamentais: Classes, Objetos, Atributos e Métodos
    *   2.2. Pilares da POO: Encapsulamento, Herança, Polimorfismo e Abstração
    *   2.3. POO na Fórmula 1: Modelando Carros e Equipes
3.  **Princípios SOLID com Java e Spring**
    *   3.1. Single Responsibility Principle (SRP): Princípio da Responsabilidade Única
    *   3.2. Open/Closed Principle (OCP): Princípio Aberto/Fechado
    *   3.3. Liskov Substitution Principle (LSP): Princípio da Substituição de Liskov
    *   3.4. Interface Segregation Principle (ISP): Princípio da Segregação de Interfaces
    *   3.5. Dependency Inversion Principle (DIP): Princípio da Inversão de Dependência
    *   3.6. SOLID na Fórmula 1: Melhorando a Manutenibilidade do Software de Telemetria
4.  **Design Patterns Criacionais com Java e Spring**
    *   4.1. Factory Method: Fábrica de Componentes de Carro de F1
    *   4.2. Abstract Factory: Linha de Montagem de Carros de F1 por Temporada
    *   4.3. Builder: Construindo um Carro de F1 Personalizado
    *   4.4. Singleton: O Motor da Equipe de F1
    *   4.5. Prototype: Clonando Configurações de Carro para Testes
5.  **Design Patterns Estruturais com Java e Spring**
    *   5.1. Adapter: Adaptando Dados de Sensores Antigos
    *   5.2. Bridge: Conectando Sistemas de Telemetria e Exibição
    *   5.3. Composite: Estrutura de Componentes do Carro
    *   5.4. Decorator: Adicionando Funcionalidades a um Carro de F1
    *   5.5. Facade: Simplificando a Interação com o Sistema de Gerenciamento de Corrida
    *   5.6. Flyweight: Otimizando a Representação de Pneus
    *   5.7. Proxy: Controle de Acesso a Dados Confidenciais da Equipe
6.  **Design Patterns Comportamentais com Java e Spring**
    *   6.1. Chain of Responsibility: Processamento de Eventos de Corrida
    *   6.2. Command: Comandos do Pit Wall
    *   6.3. Iterator: Navegando pelos Dados de Volta
    *   6.4. Mediator: Comunicação entre Componentes do Carro
    *   6.5. Memento: Salvando o Estado da Corrida
    *   6.6. Observer: Monitoramento de Dados em Tempo Real
    *   6.7. State: Estados do Carro de F1
    *   6.8. Strategy: Estratégias de Corrida
    *   6.9. Template Method: Algoritmo de Pit Stop
    *   6.10. Visitor: Análise de Desempenho de Componentes do Carro
7.  **Domain-Driven Design (DDD) na Fórmula 1**
    *   7.1. O que é Domain-Driven Design?
    *   7.2. Blocos Construtivos do DDD
    *   7.3. Contextos Delimitados e Mapas de Contexto na F1
    *   7.4. Linguagem Ubíqua no Desenvolvimento de Software para F1
    *   7.5. Aplicação Prática do DDD em um Sistema de Telemetria de F1 com Java e Spring
8.  **Conclusão**
9.  **Bibliografia***




## 2. Programação Orientada a Objetos (POO) em Java

A Programação Orientada a Objetos (POO) é um paradigma de programação que organiza o design do software em torno de dados, ou objetos, em vez de funções e lógica. Um objeto pode ser definido como uma instância de uma classe, que é um modelo ou um projeto para criar objetos. A POO visa simular o mundo real, onde entidades possuem características (atributos) e comportamentos (métodos) [3].

### 2.1. Conceitos Fundamentais: Classes, Objetos, Atributos e Métodos

**Classes** são os moldes ou plantas para a criação de objetos. Elas definem a estrutura e o comportamento que os objetos terão. Pense em uma classe como o projeto de um carro de Fórmula 1: ela especifica que todo carro de F1 terá um motor, pneus, uma cor, e que poderá acelerar, frear e fazer curvas. No contexto da Fórmula 1, poderíamos ter uma classe `CarroF1`.

**Objetos** são instâncias concretas de uma classe. Se a classe `CarroF1` é o projeto, um objeto seria um carro específico, como o carro do Lewis Hamilton na temporada de 2025 ou o carro do Max Verstappen. Cada objeto terá seus próprios valores para os atributos definidos na classe, mas compartilhará os mesmos métodos.

**Atributos** são as características ou propriedades de uma classe. Eles representam o estado de um objeto. Para a classe `CarroF1`, atributos poderiam incluir `motor`, `pneus`, `cor`, `velocidadeAtual`, `combustivel`, entre outros. No contexto de uma corrida, a `velocidadeAtual` e o `combustivel` de um carro específico seriam atributos que mudam dinamicamente.

**Métodos** são as ações ou comportamentos que um objeto pode realizar. Eles representam a funcionalidade de uma classe. Para a classe `CarroF1`, métodos poderiam ser `acelerar()`, `frear()`, `fazerCurva()`, `abastecer()`, `trocarPneus()`. Esses métodos operam sobre os atributos do objeto e podem alterar seu estado.

**Exemplo em Java 21:**

```java
// Classe CarroF1
public class CarroF1 {
    // Atributos
    private String equipe;
    private String piloto;
    private double velocidadeAtual;
    private double combustivel;
    private String tipoPneu;

    // Construtor
    public CarroF1(String equipe, String piloto, String tipoPneu) {
        this.equipe = equipe;
        this.piloto = piloto;
        this.velocidadeAtual = 0.0;
        this.combustivel = 100.0; // Capacidade inicial do tanque
        this.tipoPneu = tipoPneu;
    }

    // Métodos
    public void acelerar(double intensidade) {
        if (combustivel > 0) {
            this.velocidadeAtual += intensidade * 10; // Aumenta a velocidade
            this.combustivel -= intensidade * 0.5; // Consome combustível
            System.out.println(piloto + " da equipe " + equipe + " acelerando. Velocidade atual: " + velocidadeAtual + " km/h. Combustível restante: " + String.format("%.2f", combustivel) + "%");
        } else {
            System.out.println(piloto + " da equipe " + equipe + " está sem combustível!");
        }
    }

    public void frear() {
        this.velocidadeAtual = 0.0;
        System.out.println(piloto + " da equipe " + equipe + " freou. Velocidade atual: " + velocidadeAtual + " km/h.");
    }

    public void trocarPneus(String novoTipoPneu) {
        this.tipoPneu = novoTipoPneu;
        System.out.println(piloto + " da equipe " + equipe + " trocou para pneus " + novoTipoPneu + ".");
    }

    public void abastecer(double quantidade) {
        this.combustivel = Math.min(100.0, this.combustivel + quantidade);
        System.out.println(piloto + " da equipe " + equipe + " abasteceu. Combustível atual: " + String.format("%.2f", combustivel) + "%");
    }

    // Getters
    public String getPiloto() {
        return piloto;
    }

    public String getEquipe() {
        return equipe;
    }

    public double getVelocidadeAtual() {
        return velocidadeAtual;
    }

    public String getTipoPneu() {
        return tipoPneu;
    }

    public double getCombustivel() {
        return combustivel;
    }

    public static void main(String[] args) {
        // Criação de objetos (instâncias da classe CarroF1)
        CarroF1 carroHamilton = new CarroF1("Mercedes", "Lewis Hamilton", "Macio");
        CarroF1 carroVerstappen = new CarroF1("Red Bull", "Max Verstappen", "Médio");

        System.out.println("\n--- Início da Corrida ---");
        carroHamilton.acelerar(8.0);
        carroVerstappen.acelerar(9.0);
        carroHamilton.acelerar(5.0);

        System.out.println("\n--- Pit Stop Hamilton ---");
        carroHamilton.frear();
        carroHamilton.trocarPneus("Duro");
        carroHamilton.abastecer(20.0);
        carroHamilton.acelerar(7.0);

        System.out.println("\n--- Fim da Demonstração ---");
    }
}
```

Neste exemplo, a classe `CarroF1` serve como um modelo para criar diferentes carros de corrida, cada um com seus próprios atributos (equipe, piloto, velocidade, combustível, tipo de pneu) e a capacidade de realizar ações (acelerar, frear, trocar pneus, abastecer). Os objetos `carroHamilton` e `carroVerstappen` são instâncias dessa classe, demonstrando como cada um pode ter seu estado gerenciado de forma independente [3].



### 2.2. Pilares da POO: Encapsulamento, Herança, Polimorfismo e Abstração

Os quatro pilares da POO são conceitos cruciais que permitem a criação de software modular, flexível e de fácil manutenção. Eles trabalham em conjunto para promover a reutilização de código e a organização do sistema [3].

**Encapsulamento:** Refere-se à prática de agrupar dados (atributos) e os métodos que operam sobre esses dados em uma única unidade, a classe, e restringir o acesso direto a alguns dos componentes do objeto. Isso significa que os detalhes internos de como um objeto funciona são ocultados do mundo exterior, e a interação com o objeto ocorre apenas através de uma interface bem definida (métodos públicos). No nosso `CarroF1`, os atributos como `velocidadeAtual` e `combustivel` são `private`, o que significa que só podem ser acessados e modificados pelos métodos da própria classe (`acelerar`, `frear`, `abastecer`). Isso evita que o estado do carro seja alterado de forma inconsistente por código externo.

**Herança:** Permite que uma classe (subclasse ou classe filha) herde atributos e métodos de outra classe (superclasse ou classe pai). Isso promove a reutilização de código e estabelece uma relação 


de 


generalização-especialização (é-um). Por exemplo, poderíamos ter uma classe `Veiculo` com atributos e métodos genéricos, e `CarroF1` herdaria de `Veiculo`, adicionando características específicas de um carro de Fórmula 1. Isso evita a duplicação de código para funcionalidades comuns a todos os veículos.

**Polimorfismo:** Significa 


a capacidade de um objeto assumir muitas formas. Em POO, isso se manifesta de duas maneiras principais: sobrecarga de métodos (mesmo nome de método com diferentes parâmetros) e sobrescrita de métodos (subclasses fornecem sua própria implementação de um método herdado da superclasse). No contexto da F1, um método `calcularTempoVolta()` poderia ter diferentes implementações dependendo do tipo de pneu (`Macio`, `Médio`, `Duro`) ou das condições da pista (seca, molhada), mas a chamada ao método seria a mesma, demonstrando polimorfismo.

**Abstração:** Foca na representação das características essenciais de um objeto, ocultando os detalhes de implementação complexos. Classes abstratas e interfaces são os mecanismos em Java para alcançar a abstração. Por exemplo, uma interface `SistemaTelemetria` poderia definir métodos como `coletarDados()` e `enviarDados()`, sem especificar como esses dados são coletados ou enviados. Diferentes implementações dessa interface poderiam lidar com diferentes tipos de sensores ou protocolos de comunicação, mas a interação com o sistema de telemetria seria sempre através da interface abstrata.

**Exemplo em Java 21 (Herança e Polimorfismo):**

```java
// Classe base abstrata para um Veículo de Corrida
public abstract class VeiculoCorrida {
    protected String nome;
    protected double velocidadeMaxima;

    public VeiculoCorrida(String nome, double velocidadeMaxima) {
        this.nome = nome;
        this.velocidadeMaxima = velocidadeMaxima;
    }

    public abstract void acelerar();
    public abstract void frear();

    public void exibirInfo() {
        System.out.println("Veículo: " + nome + ", Velocidade Máxima: " + velocidadeMaxima + " km/h");
    }
}

// Subclasse CarroF1 herdando de VeiculoCorrida
public class CarroF1 extends VeiculoCorrida {
    private String equipe;

    public CarroF1(String nome, double velocidadeMaxima, String equipe) {
        super(nome, velocidadeMaxima);
        this.equipe = equipe;
    }

    @Override
    public void acelerar() {
        System.out.println(nome + " da equipe " + equipe + " acelera com a potência máxima do motor de F1!");
    }

    @Override
    public void frear() {
        System.out.println(nome + " da equipe " + equipe + " freia bruscamente com os freios de carbono!");
    }

    public void fazerPitStop() {
        System.out.println(nome + " da equipe " + equipe + " entra no pit stop para troca de pneus e reabastecimento.");
    }
}

// Subclasse CarroSeguranca herdando de VeiculoCorrida
public class CarroSeguranca extends VeiculoCorrida {
    public CarroSeguranca(String nome, double velocidadeMaxima) {
        super(nome, velocidadeMaxima);
    }

    @Override
    public void acelerar() {
        System.out.println(nome + " acelera para manter o ritmo da corrida.");
    }

    @Override
    public void frear() {
        System.out.println(nome + " freia suavemente para controlar o pelotão.");
    }

    public void acionarSafetyCar() {
        System.out.println(nome + " aciona o Safety Car para neutralizar a corrida.");
    }
}

// Exemplo de uso do Polimorfismo
public class PistaDeCorrida {
    public static void main(String[] args) {
        VeiculoCorrida carroHamilton = new CarroF1("W15", 360.0, "Mercedes");
        VeiculoCorrida carroSeguranca = new CarroSeguranca("Safety Car", 250.0);

        System.out.println("\n--- Simulação de Corrida ---");
        carroHamilton.exibirInfo();
        carroHamilton.acelerar();
        carroHamilton.frear();

        System.out.println("\n");

        carroSeguranca.exibirInfo();
        carroSeguranca.acelerar();
        carroSeguranca.frear();

        // Polimorfismo em ação: chamando métodos específicos da subclasse através da referência da superclasse
        if (carroHamilton instanceof CarroF1) {
            ((CarroF1) carroHamilton).fazerPitStop();
        }
        if (carroSeguranca instanceof CarroSeguranca) {
            ((CarroSeguranca) carroSeguranca).acionarSafetyCar();
        }
    }
}
```

Neste exemplo, `VeiculoCorrida` é uma classe abstrata que define o comportamento básico de qualquer veículo de corrida. `CarroF1` e `CarroSeguranca` são subclasses que herdam de `VeiculoCorrida` e fornecem suas próprias implementações para os métodos `acelerar()` e `frear()`, demonstrando polimorfismo. A classe `PistaDeCorrida` mostra como podemos tratar objetos de diferentes subclasses de forma uniforme através da referência da superclasse `VeiculoCorrida`, e como podemos acessar métodos específicos da subclasse quando necessário [3].




### 2.3. POO na Fórmula 1: Modelando Carros e Equipes

A aplicação da POO no contexto da Fórmula 1 é vasta e fundamental para o desenvolvimento de sistemas complexos que gerenciam desde o design e a simulação de carros até a telemetria em tempo real e a estratégia de corrida. Modelar o mundo da F1 usando POO permite uma representação mais fiel e gerenciável das entidades envolvidas.

**Modelagem de Entidades:**

*   **Carro de F1:** Como vimos, um `CarroF1` pode ser uma classe com atributos como `motor`, `chassi`, `aerodinamica`, `pneus`, `piloto` e `equipe`. Métodos como `acelerar()`, `frear()`, `virar()` e `coletarDadosTelemetria()` representariam suas ações. Diferentes modelos de carros (por exemplo, `CarroMercedes`, `CarroRedBull`) poderiam herdar de `CarroF1`, implementando suas especificidades.

*   **Piloto:** Uma classe `Piloto` poderia ter atributos como `nome`, `numero`, `nacionalidade`, `pontosNoCampeonato` e `habilidadeDeCorrida`. Métodos como `pilotar()`, `comunicarComEquipe()` e `reagirAEventos()` seriam comportamentos relevantes.

*   **Equipe:** A classe `Equipe` agruparia `Pilotos`, `CarrosF1`, `Engenheiros`, `Mecanicos` e `Estrategistas`. Atributos como `nomeDaEquipe`, `sede` e `orcamento` seriam importantes. Métodos como `desenvolverCarro()`, `gerenciarPitStop()` e `definirEstrategiaDeCorrida()` encapsulariam as operações da equipe.

*   **Pista:** Uma classe `Pista` poderia conter `nome`, `comprimento`, `numeroDeCurvas` e `condicoesClimaticas`. Métodos como `simularVolta()` ou `registrarRecordeDeVolta()` seriam apropriados.

**Cenários de Aplicação:**

*   **Simulação de Corrida:** Utilizando objetos de `CarroF1`, `Piloto` e `Pista`, é possível criar simulações detalhadas de corridas. Cada carro, com suas características e o piloto com sua habilidade, interagiria com a pista, permitindo testar diferentes configurações e estratégias antes da corrida real.

*   **Sistema de Telemetria:** Os carros de F1 são equipados com centenas de sensores que coletam dados em tempo real. Um sistema de telemetria orientado a objetos poderia ter classes para diferentes tipos de sensores (`SensorVelocidade`, `SensorTemperaturaPneu`, `SensorCombustivel`), que enviariam dados para um objeto `CentralDeDados` que os processaria e os disponibilizaria para a equipe. O encapsulamento garantiria que a complexidade da coleta de dados ficasse oculta, enquanto o polimorfismo permitiria adicionar novos tipos de sensores facilmente.

*   **Gerenciamento de Pit Stop:** Um `PitStopManager` poderia coordenar as ações de `Mecanicos` e `CarroF1` durante um pit stop. O encapsulamento seria usado para garantir que o pit stop ocorra de forma eficiente e segura, com cada membro da equipe realizando sua tarefa específica (troca de pneus, abastecimento, ajuste da asa) de forma coordenada.

*   **Estratégia de Corrida:** A classe `Estrategista` poderia utilizar diferentes algoritmos (polimorfismo) para definir a melhor estratégia de pit stop, gerenciamento de pneus e consumo de combustível, baseando-se em dados em tempo real do `CarroF1` e da `Pista`. O uso de interfaces para diferentes `EstrategiasDeCorrida` permitiria a fácil adição de novas abordagens sem modificar o código existente.

Ao aplicar os conceitos de POO, as equipes de Fórmula 1 podem desenvolver sistemas de software que são não apenas funcionais, mas também adaptáveis às constantes mudanças e inovações exigidas pelo esporte. A modularidade e a reutilização de código, proporcionadas pela POO, são cruciais em um ambiente onde a velocidade de desenvolvimento e a confiabilidade são primordiais [3].




## 3. Princípios SOLID com Java e Spring

Os princípios SOLID são um conjunto de cinco princípios de design de software que visam tornar os designs de software mais compreensíveis, flexíveis e manuteníveis. Eles foram popularizados por Robert C. Martin (Uncle Bob) e são amplamente utilizados na programação orientada a objetos [4].

### 3.1. Single Responsibility Principle (SRP): Princípio da Responsabilidade Única

O SRP afirma que uma classe deve ter apenas um, e somente um, motivo para mudar [4]. Isso significa que uma classe deve ter apenas uma responsabilidade. Se uma classe tem múltiplas responsabilidades, ela se torna mais difícil de manter, testar e entender, pois uma mudança em uma responsabilidade pode afetar as outras.

No contexto da Fórmula 1, imagine uma classe `CarroDeCorrida`. Se essa classe for responsável por gerenciar o motor, a telemetria e a estratégia de pit stop, ela viola o SRP. Uma mudança na lógica do motor afetaria a classe `CarroDeCorrida`, assim como uma mudança no formato dos dados de telemetria ou na estratégia de pit stop. O ideal é segregar essas responsabilidades em classes distintas.

**Exemplo em Java 21 com Spring:**

Considere um sistema de telemetria para carros de F1. Em vez de uma única classe `GerenciadorTelemetria` que lida com a coleta, processamento e armazenamento de dados, podemos separá-los:

```java
// Interface para coleta de dados
public interface ColetorDeDados {
    String coletarDadosSensor(String sensorId);
}

// Implementação para coletar dados do motor
@Component
public class ColetorDadosMotor implements ColetorDeDados {
    @Override
    public String coletarDadosSensor(String sensorId) {
        // Lógica para coletar dados do sensor do motor
        return "Dados do motor do sensor " + sensorId + ": RPM=15000, TempAgua=105C";
    }
}

// Interface para processamento de dados
public interface ProcessadorDeDados {
    String processarDados(String dadosBrutos);
}

// Implementação para processar dados de telemetria
@Component
public class ProcessadorDadosTelemetria implements ProcessadorDeDados {
    @Override
    public String processarDados(String dadosBrutos) {
        // Lógica para processar dados brutos da telemetria
        return "Dados processados: " + dadosBrutos.toUpperCase();
    }
}

// Interface para armazenamento de dados
public interface ArmazenadorDeDados {
    void armazenarDados(String dadosProcessados);
}

// Implementação para armazenar dados em um banco de dados (simulado)
@Component
public class ArmazenadorDadosBancoDeDados implements ArmazenadorDeDados {
    @Override
    public void armazenarDados(String dadosProcessados) {
        System.out.println("Armazenando dados no banco de dados: " + dadosProcessados);
    }
}

// Classe que orquestra as operações, mas não executa as responsabilidades diretamente
@Component
public class SistemaTelemetriaF1 {
    private final ColetorDeDados coletor;
    private final ProcessadorDeDados processador;
    private final ArmazenadorDeDados armazenador;

    public SistemaTelemetriaF1(ColetorDeDados coletor, ProcessadorDeDados processador, ArmazenadorDeDados armazenador) {
        this.coletor = coletor;
        this.processador = processador;
        this.armazenador = armazenador;
    }

    public void executarCicloTelemetria(String sensorId) {
        String dadosBrutos = coletor.coletarDadosSensor(sensorId);
        String dadosProcessados = processador.processarDados(dadosBrutos);
        armazenador.armazenarDados(dadosProcessados);
        System.out.println("Ciclo de telemetria para sensor " + sensorId + " concluído.");
    }

    public static void main(String[] args) {
        // Simulação de contexto Spring para demonstração
        // Em uma aplicação Spring real, a injeção de dependência seria feita automaticamente
        ColetorDeDados coletor = new ColetorDadosMotor();
        ProcessadorDeDados processador = new ProcessadorDadosTelemetria();
        ArmazenadorDeDados armazenador = new ArmazenadorDadosBancoDeDados();

        SistemaTelemetriaF1 sistema = new SistemaTelemetriaF1(coletor, processador, armazenador);
        sistema.executarCicloTelemetria("SensorMotor001");
    }
}
```

Neste exemplo, cada interface e sua implementação têm uma única responsabilidade: `ColetorDeDados` coleta, `ProcessadorDeDados` processa e `ArmazenadorDeDados` armazena. A classe `SistemaTelemetriaF1` apenas orquestra essas operações, delegando as responsabilidades específicas. Isso torna o sistema mais modular e fácil de modificar; se o método de armazenamento de dados mudar (por exemplo, para um sistema de arquivos), apenas a classe `ArmazenadorDadosBancoDeDados` (ou uma nova implementação de `ArmazenadorDeDados`) precisaria ser alterada, sem afetar as outras partes do sistema [4].




### 3.2. Open/Closed Principle (OCP): Princípio Aberto/Fechado

O OCP afirma que as entidades de software (classes, módulos, funções, etc.) devem ser abertas para extensão, mas fechadas para modificação [4]. Isso significa que o comportamento de um módulo pode ser estendido sem a necessidade de alterar seu código-fonte existente. Isso é geralmente alcançado através do uso de abstrações (interfaces e classes abstratas) e polimorfismo.

Imagine um sistema de simulação de corrida onde você precisa calcular o desempenho de diferentes tipos de pneus (macio, médio, duro) em diferentes condições de pista. Se você tiver uma única classe com uma série de `if-else` ou `switch` para cada tipo de pneu e condição, adicionar um novo tipo de pneu ou uma nova condição de pista exigiria modificar essa classe existente, violando o OCP.

**Exemplo em Java 21 com Spring:**

Vamos considerar um sistema que calcula o desgaste de pneus de F1 com base no tipo de pneu e na condição da pista. Em vez de modificar uma classe existente para cada novo tipo de pneu ou condição, podemos usar o OCP:

```java
// Interface para o comportamento de desgaste do pneu
public interface EstrategiaDesgastePneu {
    double calcularDesgaste(double tempoVolta, double temperaturaPista);
}

// Implementação para pneu macio
@Component("pneuMacio")
public class DesgastePneuMacio implements EstrategiaDesgastePneu {
    @Override
    public double calcularDesgaste(double tempoVolta, double temperaturaPista) {
        // Pneu macio desgasta mais rápido, especialmente em altas temperaturas
        return (tempoVolta * 0.05) + (temperaturaPista * 0.01);
    }
}

// Implementação para pneu médio
@Component("pneuMedio")
public class DesgastePneuMedio implements EstrategiaDesgastePneu {
    @Override
    public double calcularDesgaste(double tempoVolta, double temperaturaPista) {
        // Pneu médio tem desgaste intermediário
        return (tempoVolta * 0.03) + (temperaturaPista * 0.005);
    }
}

// Implementação para pneu duro
@Component("pneuDuro")
public class DesgastePneuDuro implements EstrategiaDesgastePneu {
    @Override
    public double calcularDesgaste(double tempoVolta, double temperaturaPista) {
        // Pneu duro desgasta mais lentamente
        return (tempoVolta * 0.01) + (temperaturaPista * 0.002);
    }
}

// Classe que utiliza a estratégia de desgaste, aberta para extensão, fechada para modificação
@Component
public class SimuladorDesgastePneu {
    private final EstrategiaDesgastePneu estrategia;

    // Injeção de dependência via construtor, Spring escolhe a implementação
    public SimuladorDesgastePneu(@Qualifier("pneuMacio") EstrategiaDesgastePneu estrategia) {
        this.estrategia = estrategia;
    }

    public double simular(double tempoVolta, double temperaturaPista) {
        return estrategia.calcularDesgaste(tempoVolta, temperaturaPista);
    }

    // Método para mudar a estratégia em tempo de execução (exemplo didático)
    public SimuladorDesgastePneu comEstrategia(EstrategiaDesgastePneu novaEstrategia) {
        return new SimuladorDesgastePneu(novaEstrategia);
    }

    public static void main(String[] args) {
        // Simulação de contexto Spring para demonstração
        // Em uma aplicação Spring real, a injeção de dependência seria feita automaticamente
        SimuladorDesgastePneu simuladorMacio = new SimuladorDesgastePneu(new DesgastePneuMacio());
        System.out.println("Desgaste Pneu Macio (Volta: 90s, Temp: 30C): " + String.format("%.2f", simuladorMacio.simular(90, 30)));

        SimuladorDesgastePneu simuladorMedio = simuladorMacio.comEstrategia(new DesgastePneuMedio());
        System.out.println("Desgaste Pneu Médio (Volta: 90s, Temp: 30C): " + String.format("%.2f", simuladorMedio.simular(90, 30)));

        SimuladorDesgastePneu simuladorDuro = simuladorMacio.comEstrategia(new DesgastePneuDuro());
        System.out.println("Desgaste Pneu Duro (Volta: 90s, Temp: 30C): " + String.format("%.2f", simuladorDuro.simular(90, 30)));
    }
}
```

Neste exemplo, a interface `EstrategiaDesgastePneu` define o contrato para o cálculo do desgaste. Cada tipo de pneu (macio, médio, duro) é uma nova implementação dessa interface. A classe `SimuladorDesgastePneu` depende da abstração `EstrategiaDesgastePneu`, não de implementações concretas. Se um novo tipo de pneu (por exemplo, 'super macio') for introduzido, basta criar uma nova classe que implemente `EstrategiaDesgastePneu`, sem modificar `SimuladorDesgastePneu`. Isso demonstra o OCP em ação, tornando o sistema extensível sem a necessidade de modificações no código existente [4].




### 3.3. Liskov Substitution Principle (LSP): Princípio da Substituição de Liskov

O LSP, formulado por Barbara Liskov, afirma que objetos de uma superclasse devem ser substituíveis por objetos de suas subclasses sem quebrar a aplicação [4]. Em outras palavras, se um programa espera um objeto de uma determinada classe, ele deve ser capaz de usar qualquer subclasse dessa classe sem problemas. Isso garante que a herança seja usada corretamente, mantendo a integridade do comportamento do sistema.

No contexto da Fórmula 1, imagine que você tem uma classe `VeiculoCorrida` e subclasses como `CarroF1` e `MotoGP`. Se um método que espera um `VeiculoCorrida` receber um `CarroF1` ou um `MotoGP`, ele deve funcionar corretamente, sem a necessidade de verificações de tipo (`instanceof`) ou comportamentos inesperados. Se uma subclasse altera o comportamento esperado da superclasse de forma que o contrato da superclasse não é mais válido, o LSP é violado.

**Exemplo em Java 21 com Spring:**

Vamos considerar a modelagem de veículos de corrida que podem ser pilotados. Tanto um carro de F1 quanto um carro de segurança são veículos, mas suas formas de "pilotar" podem ter nuances. O LSP nos ajuda a garantir que qualquer veículo de corrida possa ser pilotado de forma consistente.

```java
// Interface base para um Veículo Pilotável
public interface Pilotavel {
    void pilotar();
    void virar(String direcao);
}

// Classe base abstrata para um Veículo de Corrida (para herdar atributos comuns)
public abstract class VeiculoCorridaBase implements Pilotavel {
    protected String nome;
    protected double velocidadeAtual;

    public VeiculoCorridaBase(String nome) {
        this.nome = nome;
        this.velocidadeAtual = 0.0;
    }

    public String getNome() {
        return nome;
    }

    public double getVelocidadeAtual() {
        return velocidadeAtual;
    }

    public void acelerar(double intensidade) {
        this.velocidadeAtual += intensidade * 10;
        System.out.println(nome + " acelerando. Velocidade atual: " + velocidadeAtual + " km/h.");
    }

    public void frear() {
        this.velocidadeAtual = 0.0;
        System.out.println(nome + " freando. Velocidade atual: " + velocidadeAtual + " km/h.");
    }
}

// Implementação de Carro de F1
@Component
public class CarroF1LSP extends VeiculoCorridaBase {
    private String piloto;

    public CarroF1LSP(String nome, String piloto) {
        super(nome);
        this.piloto = piloto;
    }

    @Override
    public void pilotar() {
        System.out.println(piloto + " está pilotando o " + nome + " em alta velocidade na pista.");
        acelerar(10.0);
    }

    @Override
    public void virar(String direcao) {
        System.out.println(piloto + " vira o " + nome + " para a " + direcao + " com precisão de corrida.");
    }

    public void ativarDRS() {
        System.out.println(nome + " ativando DRS para ultrapassagem!");
    }
}

// Implementação de Carro de Segurança
@Component
public class CarroSegurancaLSP extends VeiculoCorridaBase {
    public CarroSegurancaLSP(String nome) {
        super(nome);
    }

    @Override
    public void pilotar() {
        System.out.println(nome + " está pilotando em ritmo controlado para segurança.");
        acelerar(3.0);
    }

    @Override
    public void virar(String direcao) {
        System.out.println(nome + " vira para a " + direcao + " mantendo a linha de segurança.");
    }

    public void acionarLuzesEmergencia() {
        System.out.println(nome + " acionando luzes de emergência.");
    }
}

// Classe que interage com veículos pilotáveis
@Component
public class GerenciadorPista {

    public void iniciarVolta(Pilotavel veiculo) {
        System.out.println("\n--- Iniciando volta com " + ((VeiculoCorridaBase)veiculo).getNome() + " ---");
        veiculo.pilotar();
        veiculo.virar("esquerda");
        veiculo.virar("direita");
        ((VeiculoCorridaBase)veiculo).frear();
    }

    public static void main(String[] args) {
        GerenciadorPista gerenciador = new GerenciadorPista();

        Pilotavel carroF1 = new CarroF1LSP("W16", "George Russell");
        Pilotavel carroSeguranca = new CarroSegurancaLSP("Safety Car AMG");

        gerenciador.iniciarVolta(carroF1);
        gerenciador.iniciarVolta(carroSeguranca);

        // Podemos chamar métodos específicos da subclasse após um cast seguro
        if (carroF1 instanceof CarroF1LSP) {
            ((CarroF1LSP) carroF1).ativarDRS();
        }
        if (carroSeguranca instanceof CarroSegurancaLSP) {
            ((CarroSegurancaLSP) carroSeguranca).acionarLuzesEmergencia();
        }
    }
}
```

Neste exemplo, `Pilotavel` é uma interface que define o comportamento de pilotagem. `VeiculoCorridaBase` é uma classe abstrata que implementa `Pilotavel` e fornece funcionalidades comuns. `CarroF1LSP` e `CarroSegurancaLSP` são subclasses que implementam `Pilotavel` e estendem `VeiculoCorridaBase`. O método `iniciarVolta` em `GerenciadorPista` aceita qualquer objeto `Pilotavel`. Graças ao LSP, podemos passar tanto um `CarroF1LSP` quanto um `CarroSegurancaLSP` para este método, e o comportamento esperado (pilotar, virar, frear) será consistente, mesmo que as implementações específicas de `pilotar()` e `acelerar()` sejam diferentes para cada tipo de veículo. Isso demonstra que as subclasses podem ser substituídas pela superclasse sem quebrar a funcionalidade do sistema [4].




### 3.4. Interface Segregation Principle (ISP): Princípio da Segregação de Interfaces

O ISP afirma que os clientes não devem ser forçados a depender de interfaces que não usam [4]. Em outras palavras, é melhor ter muitas interfaces pequenas e específicas do que uma única interface grande e genérica. Se uma interface contém métodos que não são relevantes para todas as classes que a implementam, essas classes são forçadas a implementar métodos que não utilizam, o que pode levar a código desnecessário ou a implementações vazias.

No contexto da Fórmula 1, imagine uma interface `GerenciadorDeVeiculo` que inclui métodos para `pilotar()`, `abastecer()`, `trocarPneus()`, `acionarDRS()`, `acionarSafetyCar()`. Um `CarroF1` usaria `pilotar()`, `abastecer()`, `trocarPneus()` e `acionarDRS()`, mas não `acionarSafetyCar()`. Um `CarroSeguranca` usaria `pilotar()` e `acionarSafetyCar()`, mas não `abastecer()`, `trocarPneus()` ou `acionarDRS()`. Forçar ambas as classes a implementar todos esses métodos violaria o ISP.

**Exemplo em Java 21 com Spring:**

Vamos segregar a interface `GerenciadorDeVeiculo` em interfaces menores e mais específicas:

```java
// Interface para veículos que podem ser pilotados
public interface PilotavelISP {
    void pilotar();
}

// Interface para veículos que podem ser reabastecidos
public interface Abastecivel {
    void abastecer(double quantidade);
}

// Interface para veículos que podem ter pneus trocados
public interface TrocadorDePneus {
    void trocarPneus(String novoTipoPneu);
}

// Interface para carros de F1 com DRS
public interface DRSAtivavel {
    void ativarDRS();
}

// Interface para carros de segurança
public interface SafetyCarControlavel {
    void acionarSafetyCar();
}

// Implementação de Carro de F1
@Component
public class CarroF1ISP implements PilotavelISP, Abastecivel, TrocadorDePneus, DRSAtivavel {
    private String nome;

    public CarroF1ISP(String nome) {
        this.nome = nome;
    }

    @Override
    public void pilotar() {
        System.out.println(nome + " está pilotando na pista.");
    }

    @Override
    public void abastecer(double quantidade) {
        System.out.println(nome + " sendo abastecido com " + quantidade + " litros.");
    }

    @Override
    public void trocarPneus(String novoTipoPneu) {
        System.out.println(nome + " trocando para pneus " + novoTipoPneu + ".");
    }

    @Override
    public void ativarDRS() {
        System.out.println(nome + " ativando DRS.");
    }
}

// Implementação de Carro de Segurança
@Component
public class CarroSegurancaISP implements PilotavelISP, SafetyCarControlavel {
    private String nome;

    public CarroSegurancaISP(String nome) {
        this.nome = nome;
    }

    @Override
    public void pilotar() {
        System.out.println(nome + " está pilotando em modo de segurança.");
    }

    @Override
    public void acionarSafetyCar() {
        System.out.println(nome + " acionando o Safety Car.");
    }
}

// Exemplo de uso
public class GaragemF1 {
    public static void main(String[] args) {
        CarroF1ISP carroF1 = new CarroF1ISP("W16");
        CarroSegurancaISP safetyCar = new CarroSegurancaISP("Safety Car");

        carroF1.pilotar();
        carroF1.abastecer(50.0);
        carroF1.trocarPneus("Macio");
        carroF1.ativarDRS();

        System.out.println("\n");

        safetyCar.pilotar();
        safetyCar.acionarSafetyCar();

        // Não é possível chamar métodos não implementados:
        // safetyCar.abastecer(10.0); // Erro de compilação
    }
}
```

Ao segregar a interface `GerenciadorDeVeiculo` em interfaces menores e mais coesas (`PilotavelISP`, `Abastecivel`, `TrocadorDePneus`, `DRSAtivavel`, `SafetyCarControlavel`), garantimos que `CarroF1ISP` e `CarroSegurancaISP` implementem apenas os métodos que realmente utilizam. Isso resulta em um código mais limpo, mais fácil de entender e manter, e menos propenso a erros, pois as classes não são forçadas a depender de funcionalidades que não lhes pertencem [4].




### 3.5. Dependency Inversion Principle (DIP): Princípio da Inversão de Dependência

O DIP afirma que módulos de alto nível não devem depender de módulos de baixo nível. Ambos devem depender de abstrações. Além disso, abstrações não devem depender de detalhes. Detalhes devem depender de abstrações [4]. Este princípio é fundamental para a construção de sistemas flexíveis, desacoplados e testáveis, e é amplamente suportado pela Injeção de Dependência (DI), um conceito central no Spring Framework.

Em um sistema de telemetria de F1, um módulo de alto nível pode ser o `SistemaAnaliseDados` que exibe informações para os engenheiros. Um módulo de baixo nível pode ser o `SensorDeVelocidade` que coleta os dados brutos. Sem o DIP, o `SistemaAnaliseDados` dependeria diretamente do `SensorDeVelocidade`, tornando-o rígido e difícil de mudar se um novo tipo de sensor fosse introduzido.

**Exemplo em Java 21 com Spring:**

Vamos aplicar o DIP a um sistema de monitoramento de desempenho de carros de F1. O módulo de alto nível (`MonitorDeDesempenho`) não deve depender diretamente de implementações concretas de sensores, mas sim de abstrações.

```java
// Abstração para um Sensor de Carro de F1
public interface SensorF1 {
    double getValor();
    String getNomeSensor();
}

// Implementação de baixo nível: Sensor de Velocidade
@Component
public class SensorVelocidade implements SensorF1 {
    private double velocidade;

    public SensorVelocidade() {
        this.velocidade = 0.0;
    }

    public void setVelocidade(double velocidade) {
        this.velocidade = velocidade;
    }

    @Override
    public double getValor() {
        return velocidade;
    }

    @Override
    public String getNomeSensor() {
        return "Velocidade";
    }
}

// Implementação de baixo nível: Sensor de Temperatura do Pneu
@Component
public class SensorTemperaturaPneu implements SensorF1 {
    private double temperatura;

    public SensorTemperaturaPneu() {
        this.temperatura = 0.0;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    @Override
    public double getValor() {
        return temperatura;
    }

    @Override
    public String getNomeSensor() {
        return "Temperatura do Pneu";
    }
}

// Módulo de alto nível: Monitor de Desempenho
@Component
public class MonitorDeDesempenho {
    private final SensorF1 sensorPrincipal;

    // Injeção de dependência via construtor
    public MonitorDeDesempenho(@Qualifier("sensorVelocidade") SensorF1 sensorPrincipal) {
        this.sensorPrincipal = sensorPrincipal;
    }

    public void exibirDadosSensor() {
        System.out.println("Monitorando " + sensorPrincipal.getNomeSensor() + ": " + sensorPrincipal.getValor());
    }

    public static void main(String[] args) {
        // Simulação de contexto Spring para demonstração
        SensorVelocidade sensorVelocidade = new SensorVelocidade();
        sensorVelocidade.setVelocidade(320.5);

        MonitorDeDesempenho monitorVelocidade = new MonitorDeDesempenho(sensorVelocidade);
        monitorVelocidade.exibirDadosSensor();

        SensorTemperaturaPneu sensorTemperatura = new SensorTemperaturaPneu();
        sensorTemperatura.setTemperatura(105.2);

        // Criando um novo monitor com um sensor diferente, sem alterar o código do MonitorDeDesempenho
        MonitorDeDesempenho monitorTemperatura = new MonitorDeDesempenho(sensorTemperatura);
        monitorTemperatura.exibirDadosSensor();
    }
}
```

Neste exemplo, `SensorF1` é a abstração que tanto `SensorVelocidade` quanto `SensorTemperaturaPneu` implementam. O `MonitorDeDesempenho` (módulo de alto nível) depende da interface `SensorF1`, não das classes concretas. Isso significa que podemos facilmente trocar o tipo de sensor que o monitor está usando (por exemplo, de velocidade para temperatura do pneu) sem modificar o código do `MonitorDeDesempenho`. O Spring, com sua Injeção de Dependência, facilita a aplicação do DIP, gerenciando a criação e a injeção das dependências, promovendo um acoplamento fraco e um design mais flexível [4].




### 3.6. SOLID na Fórmula 1: Melhorando a Manutenibilidade do Software de Telemetria

A aplicação dos princípios SOLID em um sistema de telemetria de Fórmula 1 é crucial para garantir que o software seja robusto, adaptável e fácil de manter em um ambiente tão dinâmico e de alta pressão. A telemetria na F1 envolve a coleta, transmissão, processamento e análise de enormes volumes de dados em tempo real, provenientes de centenas de sensores espalhados pelo carro. A capacidade de rapidamente adaptar o software a novos sensores, regulamentos ou estratégias de corrida é um diferencial competitivo.

Vamos consolidar como os princípios SOLID contribuem para a manutenibilidade e flexibilidade de um sistema de telemetria:

*   **SRP (Single Responsibility Principle):** Em vez de ter uma única classe monolítica que lida com todos os aspectos da telemetria (coleta, processamento, armazenamento, visualização), o SRP nos levaria a criar classes especializadas. Por exemplo, uma classe `ColetorDadosSensor` seria responsável apenas por ler dados brutos de um sensor específico. Uma `ProcessadorDadosMotor` se encarregaria de transformar esses dados brutos em informações significativas (como RPM, temperatura do óleo). Um `ArmazenadorDadosHistoricos` seria responsável por persistir esses dados em um banco de dados. Essa segregação de responsabilidades garante que uma mudança no formato de dados de um sensor não afete a lógica de armazenamento, por exemplo, reduzindo o risco de bugs e facilitando a depuração.

*   **OCP (Open/Closed Principle):** A F1 está em constante evolução, com novos sensores e tipos de dados sendo introduzidos regularmente. O OCP permite que o sistema de telemetria seja estendido para suportar esses novos elementos sem modificar o código existente. Isso pode ser alcançado através de interfaces e classes abstratas. Por exemplo, uma interface `SensorTelemetria` definiria o contrato para qualquer sensor. Ao adicionar um novo `SensorDePressaoPneu`, basta criar uma nova classe que implemente `SensorTelemetria`, sem a necessidade de alterar o `SistemaTelemetria` principal. O mesmo se aplica a diferentes algoritmos de análise de dados ou formatos de exportação, que poderiam ser implementados como novas estratégias sem modificar o código que os utiliza.

*   **LSP (Liskov Substitution Principle):** O LSP garante que, se um componente do sistema espera um `SensorTelemetria`, ele pode receber qualquer subclasse de `SensorTelemetria` (como `SensorVelocidade` ou `SensorTemperaturaPneu`) e o sistema continuará funcionando corretamente. Isso é vital para a flexibilidade. Por exemplo, um módulo de visualização de dados pode exibir informações de qualquer tipo de sensor, desde que ele implemente a interface `SensorTelemetria`, sem precisar saber os detalhes específicos de cada sensor. Isso permite que a equipe de telemetria adicione novos tipos de sensores e os visualize imediatamente, sem reescrever o código de visualização.

*   **ISP (Interface Segregation Principle):** Em vez de uma interface `ControleCarro` gigante que inclua métodos para tudo (acelerar, frear, ativar DRS, ligar faróis, etc.), o ISP sugere interfaces menores e mais focadas. Por exemplo, `ControleMotor`, `ControleAerodinamica`, `ControlePneus`. Um módulo que precisa apenas controlar o motor não seria forçado a depender de métodos de controle de aerodinâmica que não utiliza. Isso reduz o acoplamento e torna as classes mais coesas, facilitando a compreensão e a manutenção do código, especialmente em um sistema com tantas funcionalidades distintas como um carro de F1.

*   **DIP (Dependency Inversion Principle):** O DIP é fundamental para desacoplar os módulos de alto nível (como o painel de controle do engenheiro de pista) dos módulos de baixo nível (como os drivers de hardware dos sensores). Em vez de o painel de controle depender diretamente de uma implementação específica de `SensorVelocidadeHardware`, ele dependeria de uma abstração `SensorDeVelocidade`. A Injeção de Dependência (com o Spring Framework) seria usada para fornecer a implementação concreta em tempo de execução. Isso significa que a equipe pode facilmente trocar o fornecedor de um sensor ou simular dados de sensores para testes sem alterar o código do painel de controle, tornando o sistema muito mais testável e flexível a mudanças tecnológicas.

Em resumo, a aplicação dos princípios SOLID no desenvolvimento de software para a Fórmula 1 não é apenas uma boa prática de engenharia; é uma necessidade. Eles permitem que as equipes de software construam sistemas que podem evoluir rapidamente, integrar novas tecnologias e responder às demandas em constante mudança do esporte, mantendo a estabilidade e a performance críticas para o sucesso nas pistas [4].




## 4. Design Patterns Criacionais com Java e Spring

Design Patterns Criacionais são padrões de projeto de software que lidam com mecanismos de criação de objetos, tentando criar objetos de uma maneira adequada para a situação. Eles aumentam a flexibilidade e a reutilização do código, fornecendo uma maneira controlada de instanciar objetos [1].

### 4.1. Factory Method: Fábrica de Componentes de Carro de F1

O padrão Factory Method define uma interface para criar um objeto, mas permite que as subclasses decidam qual classe instanciar. Isso permite que uma classe delegue a criação de objetos para suas subclasses [1]. No contexto da Fórmula 1, imagine que você precisa criar diferentes tipos de componentes para um carro, como motores, chassis ou pneus, e a lógica de criação pode variar dependendo do fornecedor ou da especificação da temporada.

**Problema:** Um sistema de montagem de carros de F1 precisa criar diferentes tipos de motores (V6 Híbrido, V8, V10, etc.) dependendo da era da F1 ou do regulamento. A lógica para criar cada motor é complexa e específica. Se a classe que monta o carro for diretamente responsável por instanciar esses motores, ela se tornará acoplada a implementações concretas de motores, dificultando a adição de novos tipos de motores no futuro.

**Solução com Factory Method:** Criamos uma interface `MotorF1` e uma classe abstrata `FabricaDeMotor` com um método `criarMotor()`. Cada tipo de fábrica (por exemplo, `FabricaMotorV6Hibrido`, `FabricaMotorV8`) implementará esse método para retornar o tipo de motor correspondente.

```java
// Interface para o Motor de F1
public interface MotorF1 {
    String getTipo();
    void ligar();
    void desligar();
}

// Implementação de Motor V6 Híbrido (era atual)
public class MotorV6Hibrido implements MotorF1 {
    @Override
    public String getTipo() {
        return "V6 Híbrido";
    }

    @Override
    public void ligar() {
        System.out.println("Motor V6 Híbrido ligado. Sistema de recuperação de energia (ERS) pronto.");
    }

    @Override
    public void desligar() {
        System.out.println("Motor V6 Híbrido desligado.");
    }
}

// Implementação de Motor V8 (era anterior)
public class MotorV8 implements MotorF1 {
    @Override
    public String getTipo() {
        return "V8";
    }

    @Override
    public void ligar() {
        System.out.println("Motor V8 ligado. Som clássico da F1!");
    }

    @Override
    public void desligar() {
        System.out.println("Motor V8 desligado.");
    }
}

// Classe abstrata Factory Method
public abstract class FabricaDeMotor {
    public MotorF1 montarMotor() {
        MotorF1 motor = criarMotor(); // O Factory Method
        System.out.println("Montando motor: " + motor.getTipo());
        motor.ligar();
        return motor;
    }

    protected abstract MotorF1 criarMotor();
}

// Fábrica concreta para Motor V6 Híbrido
@Component("fabricaV6")
public class FabricaMotorV6Hibrido extends FabricaDeMotor {
    @Override
    protected MotorF1 criarMotor() {
        return new MotorV6Hibrido();
    }
}

// Fábrica concreta para Motor V8
@Component("fabricaV8")
public class FabricaMotorV8 extends FabricaDeMotor {
    @Override
    protected MotorF1 criarMotor() {
        return new MotorV8();
    }
}

// Exemplo de uso com Spring (simulado)
public class MontadoraF1 {
    public static void main(String[] args) {
        // Usando a fábrica para criar um Motor V6 Híbrido
        FabricaDeMotor fabricaV6 = new FabricaMotorV6Hibrido();
        MotorF1 motorAtual = fabricaV6.montarMotor();
        System.out.println("Motor criado: " + motorAtual.getTipo());

        System.out.println("\n");

        // Usando a fábrica para criar um Motor V8
        FabricaDeMotor fabricaV8 = new FabricaMotorV8();
        MotorF1 motorAntigo = fabricaV8.montarMotor();
        System.out.println("Motor criado: " + motorAntigo.getTipo());

        motorAtual.desligar();
        motorAntigo.desligar();
    }
}
```

Neste exemplo, a `FabricaDeMotor` é a classe criadora, e suas subclasses (`FabricaMotorV6Hibrido`, `FabricaMotorV8`) são as criadoras concretas que implementam o `Factory Method` (`criarMotor()`). O cliente (`MontadoraF1`) interage apenas com a interface `FabricaDeMotor`, tornando-o independente das classes de motor concretas. Isso permite adicionar novos tipos de motores (por exemplo, `MotorEletrico`) simplesmente criando uma nova fábrica, sem modificar o código existente da `MontadoraF1` [1].




### 4.2. Abstract Factory: Linha de Montagem de Carros de F1 por Temporada

O padrão Abstract Factory fornece uma interface para criar famílias de objetos relacionados ou dependentes sem especificar suas classes concretas [1]. É útil quando o sistema precisa ser independente de como seus produtos são criados, compostos e representados, e quando uma família de objetos de produto deve ser usada em conjunto.

**Problema:** Uma equipe de Fórmula 1 precisa montar carros completos para diferentes temporadas, e cada temporada pode ter regulamentos e especificações de componentes distintos (motor, chassi, aerodinâmica, pneus). Se a lógica de montagem do carro estiver acoplada a componentes específicos de uma temporada, será difícil adaptar o sistema para novas temporadas ou para testar diferentes configurações de componentes.

**Solução com Abstract Factory:** Criamos uma `FabricaDeComponentesF1` abstrata que define métodos para criar diferentes partes do carro (motor, chassi, asa). Em seguida, criamos fábricas concretas para cada temporada (por exemplo, `FabricaComponentes2024`, `FabricaComponentes2025`), que implementam esses métodos para produzir os componentes específicos daquela temporada.

```java
// Interfaces para os produtos abstratos
public interface MotorF1Abstract {
    String getDescricao();
}

public interface ChassiF1Abstract {
    String getDescricao();
}

public interface AsaF1Abstract {
    String getDescricao();
}

// Implementações de produtos para a temporada 2024
public class Motor2024 implements MotorF1Abstract {
    @Override
    public String getDescricao() {
        return "Motor V6 Híbrido de Alta Performance 2024";
    }
}

public class Chassi2024 implements ChassiF1Abstract {
    @Override
    public String getDescricao() {
        return "Chassi de Fibra de Carbono Ultra-Leve 2024";
    }
}

public class Asa2024 implements AsaF1Abstract {
    @Override
    public String getDescricao() {
        return "Asa Dianteira de Baixo Arrasto 2024";
    }
}

// Implementações de produtos para a temporada 2025
public class Motor2025 implements MotorF1Abstract {
    @Override
    public String getDescricao() {
        return "Motor V6 Híbrido Otimizado para Combustível Sustentável 2025";
    }
}

public class Chassi2025 implements ChassiF1Abstract {
    @Override
    public String getDescricao() {
        return "Chassi com Efeito Solo Aprimorado 2025";
    }
}

public class Asa2025 implements AsaF1Abstract {
    @Override
    public String getDescricao() {
        return "Asa Traseira de Alta Downforce 2025";
    }
}

// Abstract Factory: Interface para criar famílias de objetos
public interface FabricaDeComponentesF1 {
    MotorF1Abstract criarMotor();
    ChassiF1Abstract criarChassi();
    AsaF1Abstract criarAsa();
}

// Fábrica Concreta para a temporada 2024
@Component("fabrica2024")
public class FabricaComponentes2024 implements FabricaDeComponentesF1 {
    @Override
    public MotorF1Abstract criarMotor() {
        return new Motor2024();
    }

    @Override
    public ChassiF1Abstract criarChassi() {
        return new Chassi2024();
    }

    @Override
    public AsaF1Abstract criarAsa() {
        return new Asa2024();
    }
}

// Fábrica Concreta para a temporada 2025
@Component("fabrica2025")
public class FabricaComponentes2025 implements FabricaDeComponentesF1 {
    @Override
    public MotorF1Abstract criarMotor() {
        return new Motor2025();
    }

    @Override
    public ChassiF1Abstract criarChassi() {
        return new Chassi2025();
    }

    @Override
    public AsaF1Abstract criarAsa() {
        return new Asa2025();
    }
}

// Cliente que utiliza a Abstract Factory
@Component
public class MontadorDeCarroF1 {
    private final FabricaDeComponentesF1 fabrica;

    public MontadorDeCarroF1(FabricaDeComponentesF1 fabrica) {
        this.fabrica = fabrica;
    }

    public void montarCarro() {
        MotorF1Abstract motor = fabrica.criarMotor();
        ChassiF1Abstract chassi = fabrica.criarChassi();
        AsaF1Abstract asa = fabrica.criarAsa();

        System.out.println("\nCarro de F1 montado com:");
        System.out.println("- " + motor.getDescricao());
        System.out.println("- " + chassi.getDescricao());
        System.out.println("- " + asa.getDescricao());
    }

    public static void main(String[] args) {
        // Montando um carro para a temporada 2024
        MontadorDeCarroF1 montador2024 = new MontadorDeCarroF1(new FabricaComponentes2024());
        montador2024.montarCarro();

        // Montando um carro para a temporada 2025
        MontadorDeCarroF1 montador2025 = new MontadorDeCarroF1(new FabricaComponentes2025());
        montador2025.montarCarro();
    }
}
```

Neste exemplo, `FabricaDeComponentesF1` é a Abstract Factory, e `FabricaComponentes2024` e `FabricaComponentes2025` são as fábricas concretas. O `MontadorDeCarroF1` (cliente) depende apenas da interface `FabricaDeComponentesF1`, o que permite que ele monte carros com componentes de diferentes temporadas sem conhecer as classes concretas dos componentes. Isso garante que todos os componentes de um carro (motor, chassi, asa) sejam compatíveis para uma determinada temporada, e facilita a adição de novas temporadas ou configurações de componentes no futuro [1].




### 4.3. Builder: Construindo um Carro de F1 Personalizado

O padrão Builder separa a construção de um objeto complexo de sua representação, de modo que o mesmo processo de construção possa criar diferentes representações [1]. É útil quando um objeto pode ser construído em várias etapas ou quando possui muitas configurações opcionais.

**Problema:** A criação de um carro de Fórmula 1 é um processo complexo, envolvendo a configuração de diversos componentes como motor, chassi, aerodinâmica, suspensão, pneus, etc. Se o construtor da classe `CarroF1` tiver muitos parâmetros, ele se torna difícil de usar e manter. Além disso, nem todas as configurações são obrigatórias em todas as situações, e a ordem de construção pode ser importante.

**Solução com Builder:** Criamos uma classe `CarroF1` com um construtor privado e uma classe `CarroF1Builder` que encapsula a lógica de construção. O `CarroF1Builder` fornece métodos para configurar cada parte do carro e um método `build()` que retorna o objeto `CarroF1` final.

```java
// Classe CarroF1 (o produto complexo)
public class CarroF1BuilderPattern {
    private String motor;
    private String chassi;
    private String aerodinamica;
    private String suspensao;
    private String tipoPneu;
    private String asaDianteira;
    private String asaTraseira;

    // Construtor privado para forçar o uso do Builder
    private CarroF1BuilderPattern(CarroF1Builder builder) {
        this.motor = builder.motor;
        this.chassi = builder.chassi;
        this.aerodinamica = builder.aerodinamica;
        this.suspensao = builder.suspensao;
        this.tipoPneu = builder.tipoPneu;
        this.asaDianteira = builder.asaDianteira;
        this.asaTraseira = builder.asaTraseira;
    }

    // Getters para os atributos
    public String getMotor() {
        return motor;
    }

    public String getChassi() {
        return chassi;
    }

    public String getAerodinamica() {
        return aerodinamica;
    }

    public String getSuspensao() {
        return suspensao;
    }

    public String getTipoPneu() {
        return tipoPneu;
    }

    public String getAsaDianteira() {
        return asaDianteira;
    }

    public String getAsaTraseira() {
        return asaTraseira;
    }

    @Override
    public String toString() {
        return "CarroF1 Personalizado:\n" +
               "  Motor: " + motor + "\n" +
               "  Chassi: " + chassi + "\n" +
               "  Aerodinâmica: " + aerodinamica + "\n" +
               "  Suspensão: " + suspensao + "\n" +
               "  Pneu: " + tipoPneu + "\n" +
               "  Asa Dianteira: " + asaDianteira + "\n" +
               "  Asa Traseira: " + asaTraseira;
    }

    // Classe Builder aninhada
    public static class CarroF1Builder {
        private String motor;
        private String chassi;
        private String aerodinamica;
        private String suspensao;
        private String tipoPneu;
        private String asaDianteira;
        private String asaTraseira;

        public CarroF1Builder comMotor(String motor) {
            this.motor = motor;
            return this;
        }

        public CarroF1Builder comChassi(String chassi) {
            this.chassi = chassi;
            return this;
        }

        public CarroF1Builder comAerodinamica(String aerodinamica) {
            this.aerodinamica = aerodinamica;
            return this;
        }

        public CarroF1Builder comSuspensao(String suspensao) {
            this.suspensao = suspensao;
            return this;
        }

        public CarroF1Builder comTipoPneu(String tipoPneu) {
            this.tipoPneu = tipoPneu;
            return this;
        }

        public CarroF1Builder comAsaDianteira(String asaDianteira) {
            this.asaDianteira = asaDianteira;
            return this;
        }

        public CarroF1Builder comAsaTraseira(String asaTraseira) {
            this.asaTraseira = asaTraseira;
            return this;
        }

        public CarroF1BuilderPattern build() {
            // Validações podem ser feitas aqui antes de construir o objeto
            if (motor == null || chassi == null || tipoPneu == null) {
                throw new IllegalStateException("Motor, Chassi e Tipo de Pneu são obrigatórios.");
            }
            return new CarroF1BuilderPattern(this);
        }
    }

    public static void main(String[] args) {
        // Construindo um carro de F1 para corrida
        CarroF1BuilderPattern carroCorrida = new CarroF1Builder()
                .comMotor("Mercedes-AMG F1 M15 E Performance")
                .comChassi("W15 Carbon Fiber Monocoque")
                .comAerodinamica("Alto Downforce")
                .comSuspensao("Push-rod dianteira, Pull-rod traseira")
                .comTipoPneu("Macio")
                .comAsaDianteira("Asa de Ataque")
                .comAsaTraseira("Asa de Arrasto Reduzido")
                .build();
        System.out.println(carroCorrida);

        System.out.println("\n");

        // Construindo um carro de F1 para testes de baixa velocidade
        CarroF1BuilderPattern carroTeste = new CarroF1Builder()
                .comMotor("Motor de Teste V6")
                .comChassi("Chassi de Teste")
                .comTipoPneu("Médio")
                .build(); // Apenas os componentes obrigatórios
        System.out.println(carroTeste);
    }
}
```

Neste exemplo, a classe `CarroF1BuilderPattern` é o objeto complexo a ser construído. A classe aninhada `CarroF1Builder` é o construtor que permite a criação passo a passo do `CarroF1BuilderPattern`. Cada método `comXyz()` retorna a própria instância do `Builder`, permitindo o encadeamento de chamadas. O método `build()` finaliza a construção e retorna o objeto `CarroF1BuilderPattern`. Isso torna a criação de objetos `CarroF1BuilderPattern` mais legível e flexível, especialmente quando há muitas opções de configuração, e permite a criação de diferentes representações do carro (carro de corrida completo vs. carro de teste básico) usando o mesmo processo de construção [1].




### 4.4. Singleton: O Motor da Equipe de F1

O padrão Singleton garante que uma classe tenha apenas uma instância e fornece um ponto de acesso global a ela [1]. É útil quando exatamente um objeto é necessário para coordenar ações em todo o sistema. No contexto da Fórmula 1, um exemplo perfeito seria o motor de uma equipe. Embora cada carro tenha um motor, a equipe de engenharia pode ter um "motor mestre" ou um "simulador de motor" que é a única fonte de verdade para dados de desempenho, calibrações e atualizações para todos os carros da equipe.

**Problema:** Em um sistema de gerenciamento de equipe de F1, pode haver a necessidade de um único ponto de controle para o motor principal da equipe, que gerencia as especificações, telemetria global e atualizações de software para todos os carros. Se várias instâncias desse "motor mestre" pudessem ser criadas, haveria inconsistência nos dados e nas operações.

**Solução com Singleton:** Criamos uma classe `MotorMestreEquipe` com um construtor privado e um método estático `getInstance()` que retorna a única instância da classe. O Spring, através de seus beans, gerencia Singletons por padrão, tornando a implementação ainda mais simples.

```java
// Classe Singleton para o Motor Mestre da Equipe
public class MotorMestreEquipe {
    private static MotorMestreEquipe instance;
    private String especificacaoMotor;
    private double potenciaAtualHP;

    // Construtor privado para evitar instanciação externa
    private MotorMestreEquipe(String especificacaoMotor) {
        this.especificacaoMotor = especificacaoMotor;
        this.potenciaAtualHP = 1000.0; // Potência inicial
        System.out.println("Motor Mestre da Equipe (Singleton) inicializado: " + especificacaoMotor);
    }

    // Método estático para obter a única instância
    public static MotorMestreEquipe getInstance(String especificacaoMotor) {
        if (instance == null) {
            instance = new MotorMestreEquipe(especificacaoMotor);
        }
        return instance;
    }

    public String getEspecificacaoMotor() {
        return especificacaoMotor;
    }

    public double getPotenciaAtualHP() {
        return potenciaAtualHP;
    }

    public void atualizarSoftwareMotor(double novaPotencia) {
        this.potenciaAtualHP = novaPotencia;
        System.out.println("Software do Motor Mestre atualizado. Nova potência: " + potenciaAtualHP + " HP.");
    }

    public void enviarDadosTelemetriaGlobal() {
        System.out.println("Enviando dados de telemetria global do Motor Mestre.");
    }

    public static void main(String[] args) {
        // Tentando obter a instância do Motor Mestre
        MotorMestreEquipe motor1 = MotorMestreEquipe.getInstance("Mercedes-AMG F1 M15 E Performance");
        System.out.println("Motor 1: " + motor1.getEspecificacaoMotor() + ", Potência: " + motor1.getPotenciaAtualHP());

        // Tentando obter outra instância (deve retornar a mesma)
        MotorMestreEquipe motor2 = MotorMestreEquipe.getInstance("Ferrari 066/7"); // Este argumento será ignorado
        System.out.println("Motor 2: " + motor2.getEspecificacaoMotor() + ", Potência: " + motor2.getPotenciaAtualHP());

        // Verificando se são a mesma instância
        System.out.println("São a mesma instância? " + (motor1 == motor2));

        motor1.atualizarSoftwareMotor(1020.0);
        System.out.println("Motor 2 (após atualização): " + motor2.getPotenciaAtualHP());
    }
}
```

No Spring Framework, a maioria dos beans são Singletons por padrão. Se você definir `MotorMestreEquipe` como um `@Component` ou `@Service`, o Spring garantirá que apenas uma instância seja criada e injetada onde for necessário, simplificando a implementação do padrão Singleton e garantindo que o "motor mestre" da equipe seja um recurso único e consistente em toda a aplicação [1].




### 4.5. Prototype: Clonando Configurações de Carro para Testes

O padrão Prototype especifica os tipos de objetos a serem criados usando uma instância protótipo e cria novos objetos copiando este protótipo [1]. É útil quando a criação de um objeto é cara ou complexa, e você precisa criar muitas instâncias semelhantes com pequenas variações.

**Problema:** Em uma equipe de Fórmula 1, os engenheiros frequentemente precisam testar diferentes configurações de carro (por exemplo, ajustes de suspensão, aerodinâmica, mapeamento do motor) para uma mesma base de carro. Criar um novo objeto `CarroF1` do zero para cada variação de teste pode ser ineficiente e propenso a erros, especialmente se o processo de construção for complexo.

**Solução com Prototype:** A classe `CarroF1Prototype` implementa a interface `Cloneable` e sobrescreve o método `clone()`. Isso permite que novas instâncias de `CarroF1` sejam criadas a partir de uma instância existente, copiando seu estado e, em seguida, modificando apenas as propriedades desejadas.

```java
// Classe CarroF1 que implementa Cloneable
public class CarroF1Prototype implements Cloneable {
    private String modelo;
    private String configuracaoMotor;
    private String configuracaoAerodinamica;
    private String ajusteSuspensao;
    private String tipoPneu;

    public CarroF1Prototype(String modelo, String configuracaoMotor, String configuracaoAerodinamica, String ajusteSuspensao, String tipoPneu) {
        this.modelo = modelo;
        this.configuracaoMotor = configuracaoMotor;
        this.configuracaoAerodinamica = configuracaoAerodinamica;
        this.ajusteSuspensao = ajusteSuspensao;
        this.tipoPneu = tipoPneu;
    }

    // Getters e Setters
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getConfiguracaoMotor() {
        return configuracaoMotor;
    }

    public void setConfiguracaoMotor(String configuracaoMotor) {
        this.configuracaoMotor = configuracaoMotor;
    }

    public String getConfiguracaoAerodinamica() {
        return configuracaoAerodinamica;
    }

    public void setConfiguracaoAerodinamica(String configuracaoAerodinamica) {
        this.configuracaoAerodinamica = configuracaoAerodinamica;
    }

    public String getAjusteSuspensao() {
        return ajusteSuspensao;
    }

    public void setAjusteSuspensao(String ajusteSuspensao) {
        this.ajusteSuspensao = ajusteSuspensao;
    }

    public String getTipoPneu() {
        return tipoPneu;
    }

    public void setTipoPneu(String tipoPneu) {
        this.tipoPneu = tipoPneu;
    }

    @Override
    public String toString() {
        return "CarroF1 [Modelo: " + modelo +
               ", Motor: " + configuracaoMotor +
               ", Aerodinâmica: " + configuracaoAerodinamica +
               ", Suspensão: " + ajusteSuspensao +
               ", Pneu: " + tipoPneu + "]";
    }

    @Override
    public CarroF1Prototype clone() {
        try {
            return (CarroF1Prototype) super.clone();
        } catch (CloneNotSupportedException e) {
            System.err.println("Erro ao clonar CarroF1: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        // Carro protótipo com configuração base
        CarroF1Prototype carroBase = new CarroF1Prototype(
                "W15",
                "Mapeamento Padrão",
                "Alto Downforce",
                "Rígida",
                "Médio"
        );
        System.out.println("Carro Base: " + carroBase);

        // Clonando o carro base para uma configuração de teste de baixa arrasto
        CarroF1Prototype carroTesteBaixoArrasto = carroBase.clone();
        if (carroTesteBaixoArrasto != null) {
            carroTesteBaixoArrasto.setConfiguracaoAerodinamica("Baixo Arrasto");
            carroTesteBaixoArrasto.setTipoPneu("Duro");
            System.out.println("Carro Teste Baixo Arrasto: " + carroTesteBaixoArrasto);
        }

        // Clonando o carro base para uma configuração de teste de chuva
        CarroF1Prototype carroTesteChuva = carroBase.clone();
        if (carroTesteChuva != null) {
            carroTesteChuva.setAjusteSuspensao("Macio para Chuva");
            carroTesteChuva.setTipoPneu("Chuva");
            System.out.println("Carro Teste Chuva: " + carroTesteChuva);
        }

        // Verificando se os objetos são diferentes (mas com base no mesmo protótipo)
        System.out.println("Carro Base é o mesmo que Carro Teste Baixo Arrasto? " + (carroBase == carroTesteBaixoArrasto));
    }
}
```

Neste exemplo, `CarroF1Prototype` é o protótipo. Ao invés de instanciar novos carros de F1 com `new CarroF1Prototype(...)` e redefinir todas as propriedades, usamos o método `clone()` para criar cópias do carro base. Isso é muito mais eficiente e conciso, especialmente quando a maioria das propriedades permanece a mesma e apenas algumas precisam ser alteradas para cada cenário de teste. O padrão Prototype é ideal para cenários onde a criação de objetos é custosa e a maioria das instâncias compartilha uma configuração inicial semelhante [1].




## 5. Design Patterns Estruturais com Java e Spring

Design Patterns Estruturais lidam com a composição de classes e objetos. Eles ajudam a formar estruturas maiores a partir de objetos e classes menores, garantindo flexibilidade e eficiência. Esses padrões explicam como montar objetos e classes em estruturas maiores, mantendo as estruturas flexíveis e eficientes [1].

### 5.1. Adapter: Adaptando Dados de Sensores Antigos

O padrão Adapter (também conhecido como Wrapper) permite que interfaces incompatíveis trabalhem juntas. Ele atua como um "tradutor" entre duas interfaces que, de outra forma, não poderiam se comunicar devido a incompatibilidades [1].

**Problema:** Em um sistema de telemetria de Fórmula 1, novos sensores podem ter interfaces de dados modernas, enquanto sensores mais antigos (ou de fornecedores diferentes) podem ter interfaces legadas. O sistema principal de processamento de dados espera uma interface unificada, mas não pode ser modificado para lidar com cada tipo de sensor legado.

**Solução com Adapter:** Criamos uma interface `SensorModerno` que o sistema espera. Para cada sensor legado, criamos uma classe Adapter que implementa `SensorModerno` e encapsula o sensor legado, traduzindo suas chamadas para a interface moderna.

```java
// Interface que o sistema de telemetria moderno espera
public interface SensorModerno {
    double getValorNumerico();
    String getUnidade();
    String getNome();
}

// Sensor legado de temperatura (interface incompatível)
public class SensorTemperaturaLegado {
    private int temperaturaCelsius;

    public SensorTemperaturaLegado(int temperaturaCelsius) {
        this.temperaturaCelsius = temperaturaCelsius;
    }

    public int obterTemperaturaC() {
        return temperaturaCelsius;
    }

    public void definirTemperaturaC(int temperaturaCelsius) {
        this.temperaturaCelsius = temperaturaCelsius;
    }
}

// Adapter para o SensorTemperaturaLegado
public class SensorTemperaturaAdapter implements SensorModerno {
    private final SensorTemperaturaLegado sensorLegado;

    public SensorTemperaturaAdapter(SensorTemperaturaLegado sensorLegado) {
        this.sensorLegado = sensorLegado;
    }

    @Override
    public double getValorNumerico() {
        // Converte Celsius para um valor numérico padrão (ex: para gráficos)
        return sensorLegado.obterTemperaturaC();
    }

    @Override
    public String getUnidade() {
        return "Celsius";
    }

    @Override
    public String getNome() {
        return "Sensor de Temperatura (Adaptado)";
    }
}

// Sistema de Telemetria que usa a interface moderna
public class SistemaProcessamentoTelemetria {
    public void processarDados(SensorModerno sensor) {
        System.out.println("Processando dados do " + sensor.getNome() + ":");
        System.out.println("  Valor: " + sensor.getValorNumerico() + " " + sensor.getUnidade());
        // Lógica de processamento de dados...
    }

    public static void main(String[] args) {
        SistemaProcessamentoTelemetria sistema = new SistemaProcessamentoTelemetria();

        // Usando um sensor moderno diretamente
        SensorModerno sensorPressaoPneu = new SensorModerno() {
            @Override
            public double getValorNumerico() { return 2.1; }
            @Override
            public String getUnidade() { return "Bar"; }
            @Override
            public String getNome() { return "Sensor de Pressão do Pneu"; }
        };
        sistema.processarDados(sensorPressaoPneu);

        System.out.println("\n");

        // Usando o sensor legado através do Adapter
        SensorTemperaturaLegado sensorOleoLegado = new SensorTemperaturaLegado(120);
        SensorModerno adapterTemperatura = new SensorTemperaturaAdapter(sensorOleoLegado);
        sistema.processarDados(adapterTemperatura);
    }
}
```

Neste exemplo, `SensorTemperaturaLegado` tem uma interface `obterTemperaturaC()` que é incompatível com a `SensorModerno` esperada pelo `SistemaProcessamentoTelemetria`. O `SensorTemperaturaAdapter` atua como um intermediário, adaptando as chamadas do sensor legado para a interface moderna. Isso permite que o sistema de telemetria continue usando sua interface unificada sem precisar ser modificado para cada tipo de sensor legado, promovendo a reutilização de código e a flexibilidade [1].




### 5.2. Bridge: Conectando Sistemas de Telemetria e Exibição

O padrão Bridge (Ponte) desacopla uma abstração de sua implementação, de modo que as duas possam variar independentemente [1]. É útil quando tanto a abstração quanto a implementação podem mudar ou evoluir de forma independente, e você precisa combinar diferentes variações de ambos.

**Problema:** Em um sistema de telemetria de F1, você pode ter diferentes formas de coletar dados (por exemplo, via rede, via arquivo, simulado) e diferentes formas de exibir esses dados (por exemplo, console, interface gráfica, dashboard web). Se você criar uma hierarquia de classes para cada combinação (por exemplo, `ColetorDeRedeExibidorDeConsole`, `ColetorDeArquivoExibidorGrafico`), o número de classes explodirá, tornando o sistema complexo e difícil de manter.

**Solução com Bridge:** Criamos duas hierarquias de classes independentes: uma para a abstração (o que o sistema faz, por exemplo, `SistemaTelemetria`) e outra para a implementação (como o sistema faz, por exemplo, `ExibidorDeDados`). A abstração contém uma referência à implementação, permitindo que elas sejam combinadas dinamicamente.

```java
// Implementador (Implementor): Define a interface para as classes de implementação
public interface ExibidorDeDados {
    void exibir(String dados);
}

// Implementações Concretas (ConcreteImplementor): Diferentes formas de exibir dados
@Component
public class ExibidorConsole implements ExibidorDeDados {
    @Override
    public void exibir(String dados) {
        System.out.println("Exibindo no Console: " + dados);
    }
}

@Component
public class ExibidorGrafico implements ExibidorDeDados {
    @Override
    public void exibir(String dados) {
        System.out.println("Exibindo Graficamente: " + dados + " (simulação de plotagem)");
    }
}

@Component
public class ExibidorWebDashboard implements ExibidorDeDados {
    @Override
    public void exibir(String dados) {
        System.out.println("Enviando para Web Dashboard: " + dados + " (atualização em tempo real)");
    }
}

// Abstração (Abstraction): Define a interface de alto nível e mantém uma referência ao Implementor
public abstract class SistemaTelemetria {
    protected ExibidorDeDados exibidor;

    public SistemaTelemetria(ExibidorDeDados exibidor) {
        this.exibidor = exibidor;
    }

    public abstract void coletarEProcessarDados();
}

// Abstrações Refinadas (RefinedAbstraction): Diferentes tipos de sistemas de telemetria
@Component
public class TelemetriaMotor extends SistemaTelemetria {
    public TelemetriaMotor(ExibidorDeDados exibidor) {
        super(exibidor);
    }

    @Override
    public void coletarEProcessarDados() {
        String dadosMotor = "RPM: 18000, Temp. Óleo: 120C, Potência: 950HP";
        System.out.println("Coletando e processando dados do motor...");
        exibidor.exibir("Dados do Motor: " + dadosMotor);
    }
}

@Component
public class TelemetriaPneus extends SistemaTelemetria {
    public TelemetriaPneus(ExibidorDeDados exibidor) {
        super(exibidor);
    }

    @Override
    public void coletarEProcessarDados() {
        String dadosPneus = "Pneu Diant. Esq.: 105C, Pneu Diant. Dir.: 102C, Desgaste: 15%";
        System.out.println("Coletando e processando dados dos pneus...");
        exibidor.exibir("Dados dos Pneus: " + dadosPneus);
    }
}

// Exemplo de uso com Spring (simulado)
public class CentroDeControleF1 {
    public static void main(String[] args) {
        // Exibindo dados do motor no console
        SistemaTelemetria telemetriaMotorConsole = new TelemetriaMotor(new ExibidorConsole());
        telemetriaMotorConsole.coletarEProcessarDados();

        System.out.println("\n");

        // Exibindo dados dos pneus em um dashboard web
        SistemaTelemetria telemetriaPneusWeb = new TelemetriaPneus(new ExibidorWebDashboard());
        telemetriaPneusWeb.coletarEProcessarDados();

        System.out.println("\n");

        // Exibindo dados do motor graficamente
        SistemaTelemetria telemetriaMotorGrafico = new TelemetriaMotor(new ExibidorGrafico());
        telemetriaMotorGrafico.coletarEProcessarDados();
    }
}
```

Neste exemplo, `SistemaTelemetria` é a abstração e `ExibidorDeDados` é a interface do implementador. As classes `TelemetriaMotor` e `TelemetriaPneus` são abstrações refinadas, enquanto `ExibidorConsole`, `ExibidorGrafico` e `ExibidorWebDashboard` são implementações concretas. O padrão Bridge permite que combinemos qualquer tipo de telemetria (motor, pneus) com qualquer forma de exibição (console, gráfico, web) de forma independente, sem criar um emaranhado de classes. Isso facilita a adição de novos tipos de telemetria ou novas formas de exibição sem afetar as classes existentes, promovendo a flexibilidade e a manutenibilidade do sistema [1].




### 5.3. Composite: Estrutura de Componentes do Carro

O padrão Composite (Composto) permite que você trate objetos individuais e composições de objetos de forma uniforme [1]. Ele é usado para compor objetos em estruturas de árvore para representar hierarquias de parte-todo. Isso permite que os clientes tratem objetos individuais e composições de objetos de forma consistente.

**Problema:** Um carro de Fórmula 1 é composto por uma hierarquia de componentes: o carro inteiro é um componente, que contém o motor, o chassi, as asas, etc. Cada um desses, por sua vez, pode ser composto por subcomponentes (por exemplo, o motor tem cilindros, turbos, etc.). Seria útil ter uma maneira de tratar um único componente (como um pneu) e um conjunto de componentes (como o motor completo) da mesma forma para operações como cálculo de peso total ou inspeção.

**Solução com Composite:** Definimos uma interface `ComponenteCarroF1` que declara operações comuns para componentes simples e compostos. Criamos classes para componentes individuais (`Pneu`, `Motor`, `Asa`) e uma classe `ConjuntoDeComponentes` que pode conter outros `ComponenteCarroF1`.

```java
import java.util.ArrayList;
import java.util.List;

// Componente: Interface para todos os componentes (folhas e compostos)
public interface ComponenteCarroF1 {
    String getNome();
    double getPeso();
    void exibirDetalhes(int nivel);
}

// Folha: Representa um componente individual
public class Pneu implements ComponenteCarroF1 {
    private String nome;
    private double peso;

    public Pneu(String nome, double peso) {
        this.nome = nome;
        this.peso = peso;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public double getPeso() {
        return peso;
    }

    @Override
    public void exibirDetalhes(int nivel) {
        System.out.println("  ".repeat(nivel) + "- Pneu: " + nome + " (Peso: " + peso + " kg)");
    }
}

// Folha: Representa um componente individual
public class Motor implements ComponenteCarroF1 {
    private String nome;
    private double peso;

    public Motor(String nome, double peso) {
        this.nome = nome;
        this.peso = peso;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public double getPeso() {
        return peso;
    }

    @Override
    public void exibirDetalhes(int nivel) {
        System.out.println("  ".repeat(nivel) + "- Motor: " + nome + " (Peso: " + peso + " kg)");
    }
}

// Composto: Representa um conjunto de componentes
public class ConjuntoDeComponentes implements ComponenteCarroF1 {
    private String nome;
    private List<ComponenteCarroF1> componentes = new ArrayList<>();

    public ConjuntoDeComponentes(String nome) {
        this.nome = nome;
    }

    public void adicionarComponente(ComponenteCarroF1 componente) {
        componentes.add(componente);
    }

    public void removerComponente(ComponenteCarroF1 componente) {
        componentes.remove(componente);
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public double getPeso() {
        double pesoTotal = 0;
        for (ComponenteCarroF1 componente : componentes) {
            pesoTotal += componente.getPeso();
        }
        return pesoTotal;
    }

    @Override
    public void exibirDetalhes(int nivel) {
        System.out.println("  ".repeat(nivel) + "+ " + nome + " (Peso Total: " + getPeso() + " kg)");
        for (ComponenteCarroF1 componente : componentes) {
            componente.exibirDetalhes(nivel + 1);
        }
    }

    public static void main(String[] args) {
        // Criando componentes individuais
        Pneu pneuDianteiroEsquerdo = new Pneu("Pneu Dianteiro Esquerdo", 10.0);
        Pneu pneuDianteiroDireito = new Pneu("Pneu Dianteiro Direito", 10.0);
        Pneu pneuTraseiroEsquerdo = new Pneu("Pneu Traseiro Esquerdo", 12.0);
        Pneu pneuTraseiroDireito = new Pneu("Pneu Traseiro Direito", 12.0);

        Motor motorV6 = new Motor("Motor Mercedes-AMG F1 M15", 150.0);
        Motor turbo = new Motor("Turbocharger", 15.0);

        // Criando conjuntos de componentes
        ConjuntoDeComponentes conjuntoPneus = new ConjuntoDeComponentes("Conjunto de Pneus");
        conjuntoPneus.adicionarComponente(pneuDianteiroEsquerdo);
        conjuntoPneus.adicionarComponente(pneuDianteiroDireito);
        conjuntoPneus.adicionarComponente(pneuTraseiroEsquerdo);
        conjuntoPneus.adicionarComponente(pneuTraseiroDireito);

        ConjuntoDeComponentes conjuntoMotor = new ConjuntoDeComponentes("Conjunto do Motor");
        conjuntoMotor.adicionarComponente(motorV6);
        conjuntoMotor.adicionarComponente(turbo);

        // Criando o carro completo como um conjunto de componentes
        ConjuntoDeComponentes carroF1Completo = new ConjuntoDeComponentes("Carro de Fórmula 1");
        carroF1Completo.adicionarComponente(conjuntoPneus);
        carroF1Completo.adicionarComponente(conjuntoMotor);
        carroF1Completo.adicionarComponente(new Motor("Chassi", 200.0)); // Chassi como um motor para simplificar
        carroF1Completo.adicionarComponente(new Motor("Asa Dianteira", 5.0));
        carroF1Completo.adicionarComponente(new Motor("Asa Traseira", 7.0));

        // Exibindo detalhes do carro completo
        System.out.println("--- Estrutura do Carro de F1 ---");
        carroF1Completo.exibirDetalhes(0);

        System.out.println("\n--- Detalhes do Conjunto de Pneus ---");
        conjuntoPneus.exibirDetalhes(0);

        System.out.println("\nPeso total do carro: " + carroF1Completo.getPeso() + " kg");
        System.out.println("Peso total dos pneus: " + conjuntoPneus.getPeso() + " kg");
    }
}
```

Neste exemplo, `ComponenteCarroF1` é a interface comum para folhas (`Pneu`, `Motor`) e compostos (`ConjuntoDeComponentes`). O `ConjuntoDeComponentes` pode conter tanto folhas quanto outros compostos, formando uma estrutura de árvore. Isso permite que operações como `getPeso()` e `exibirDetalhes()` sejam aplicadas de forma recursiva em toda a hierarquia, tratando um único pneu ou o carro completo de forma uniforme. O padrão Composite simplifica o código do cliente, que não precisa diferenciar entre objetos individuais e composições de objetos [1].




### 5.4. Decorator: Adicionando Funcionalidades a um Carro de F1

O padrão Decorator (Decorador) anexa responsabilidades adicionais a um objeto dinamicamente. Os decoradores fornecem uma alternativa flexível à subclassificação para estender a funcionalidade [1]. É útil quando você precisa adicionar comportamentos a objetos individuais em tempo de execução, sem afetar outros objetos da mesma classe.

**Problema:** Em um carro de Fórmula 1, diferentes funcionalidades podem ser adicionadas ou removidas dinamicamente, como um sistema de recuperação de energia (ERS) aprimorado, um sistema de telemetria avançado ou um sistema de asa móvel (DRS). Se usarmos herança para cada combinação possível de funcionalidades, teríamos uma explosão de subclasses (por exemplo, `CarroComERS`, `CarroComDRS`, `CarroComERSComDRS`), tornando o sistema rígido e difícil de gerenciar.

**Solução com Decorator:** Definimos uma interface `CarroF1Componente` para o componente base e para os decoradores. A classe `CarroF1Base` é a implementação concreta do componente. Cada funcionalidade adicional é um decorador que encapsula um `CarroF1Componente` e adiciona seu próprio comportamento antes ou depois de delegar a chamada ao componente encapsulado.

```java
// Componente: Interface base para o carro de F1 e seus decoradores
public interface CarroF1Componente {
    String getDescricao();
    double getCusto();
    double getPesoAdicional();
}

// Componente Concreto: O carro de F1 básico
public class CarroF1Base implements CarroF1Componente {
    @Override
    public String getDescricao() {
        return "Carro de F1 Básico";
    }

    @Override
    public double getCusto() {
        return 10000000.0; // 10 milhões de dólares
    }

    @Override
    public double getPesoAdicional() {
        return 0.0;
    }
}

// Decorador Abstrato: Classe base para todos os decoradores
public abstract class CarroF1Decorator implements CarroF1Componente {
    protected CarroF1Componente carroDecorado;

    public CarroF1Decorator(CarroF1Componente carroDecorado) {
        this.carroDecorado = carroDecorado;
    }

    @Override
    public String getDescricao() {
        return carroDecorado.getDescricao();
    }

    @Override
    public double getCusto() {
        return carroDecorado.getCusto();
    }

    @Override
    public double getPesoAdicional() {
        return carroDecorado.getPesoAdicional();
    }
}

// Decorador Concreto: Adiciona Sistema de Recuperação de Energia (ERS)
public class ERSDecorator extends CarroF1Decorator {
    public ERSDecorator(CarroF1Componente carroDecorado) {
        super(carroDecorado);
    }

    @Override
    public String getDescricao() {
        return carroDecorado.getDescricao() + ", com ERS Avançado";
    }

    @Override
    public double getCusto() {
        return carroDecorado.getCusto() + 2000000.0; // +2 milhões
    }

    @Override
    public double getPesoAdicional() {
        return carroDecorado.getPesoAdicional() + 50.0; // +50 kg
    }
}

// Decorador Concreto: Adiciona Sistema de Asa Móvel (DRS)
public class DRSDecorator extends CarroF1Decorator {
    public DRSDecorator(CarroF1Componente carroDecorado) {
        super(carroDecorado);
    }

    @Override
    public String getDescricao() {
        return carroDecorado.getDescricao() + ", com DRS Ativo";
    }

    @Override
    public double getCusto() {
        return carroDecorado.getCusto() + 500000.0; // +0.5 milhão
    }

    @Override
    public double getPesoAdicional() {
        return carroDecorado.getPesoAdicional() + 5.0; // +5 kg
    }
}

// Decorador Concreto: Adiciona Sistema de Telemetria Avançada
public class TelemetriaAvancadaDecorator extends CarroF1Decorator {
    public TelemetriaAvancadaDecorator(CarroF1Componente carroDecorado) {
        super(carroDecorado);
    }

    @Override
    public String getDescricao() {
        return carroDecorado.getDescricao() + ", com Telemetria Avançada";
    }

    @Override
    public double getCusto() {
        return carroDecorado.getCusto() + 1000000.0; // +1 milhão
    }

    @Override
    public double getPesoAdicional() {
        return carroDecorado.getPesoAdicional() + 10.0; // +10 kg
    }
}

// Exemplo de uso
public class ConfiguradorCarroF1 {
    public static void main(String[] args) {
        // Carro de F1 básico
        CarroF1Componente carroBasico = new CarroF1Base();
        System.out.println("Configuração 1: " + carroBasico.getDescricao() +
                           " | Custo: " + String.format("%.2f", carroBasico.getCusto()) +
                           " | Peso Adicional: " + carroBasico.getPesoAdicional() + " kg");

        // Carro com ERS
        CarroF1Componente carroComERS = new ERSDecorator(carroBasico);
        System.out.println("Configuração 2: " + carroComERS.getDescricao() +
                           " | Custo: " + String.format("%.2f", carroComERS.getCusto()) +
                           " | Peso Adicional: " + carroComERS.getPesoAdicional() + " kg");

        // Carro com ERS e DRS
        CarroF1Componente carroComERSDRS = new DRSDecorator(carroComERS);
        System.out.println("Configuração 3: " + carroComERSDRS.getDescricao() +
                           " | Custo: " + String.format("%.2f", carroComERSDRS.getCusto()) +
                           " | Peso Adicional: " + carroComERSDRS.getPesoAdicional() + " kg");

        // Carro com ERS, DRS e Telemetria Avançada
        CarroF1Componente carroCompleto = new TelemetriaAvancadaDecorator(carroComERSDRS);
        System.out.println("Configuração 4: " + carroCompleto.getDescricao() +
                           " | Custo: " + String.format("%.2f", carroCompleto.getCusto()) +
                           " | Peso Adicional: " + carroCompleto.getPesoAdicional() + " kg");

        // Ordem diferente: Carro com Telemetria Avançada e ERS
        CarroF1Componente carroTAERS = new ERSDecorator(new TelemetriaAvancadaDecorator(carroBasico));
        System.out.println("Configuração 5: " + carroTAERS.getDescricao() +
                           " | Custo: " + String.format("%.2f", carroTAERS.getCusto()) +
                           " | Peso Adicional: " + carroTAERS.getPesoAdicional() + " kg");
    }
}
```

Neste exemplo, `CarroF1Componente` é a interface que define o comportamento básico. `CarroF1Base` é o componente concreto. `CarroF1Decorator` é a classe abstrata para os decoradores, e `ERSDecorator`, `DRSDecorator`, `TelemetriaAvancadaDecorator` são os decoradores concretos. Cada decorador adiciona uma funcionalidade (e seu custo/peso associado) ao carro encapsulado. O padrão Decorator permite combinar essas funcionalidades de forma flexível em tempo de execução, sem a necessidade de criar uma hierarquia de classes complexa. Isso é ideal para cenários onde a funcionalidade pode ser adicionada ou removida dinamicamente, como as constantes atualizações e otimizações em um carro de Fórmula 1 [1].




### 5.5. Facade: Simplificando a Interação com o Sistema de Gerenciamento de Corrida

O padrão Facade (Fachada) fornece uma interface unificada para um conjunto de interfaces em um subsistema. Ele define uma interface de nível superior que torna o subsistema mais fácil de usar [1]. É útil quando um subsistema é complexo ou quando você precisa fornecer uma interface simplificada para um conjunto de funcionalidades.

**Problema:** Em um centro de controle de corrida de Fórmula 1, o engenheiro de estratégia precisa interagir com vários subsistemas complexos para tomar decisões: o sistema de telemetria (para dados do carro), o sistema meteorológico (para condições da pista), o sistema de gerenciamento de pneus (para desgaste e temperatura) e o sistema de comunicação com o piloto. Interagir diretamente com cada um desses subsistemas pode ser complicado e propenso a erros.

**Solução com Facade:** Criamos uma classe `GerenciadorCorridaFacade` que fornece uma interface simplificada para interagir com esses subsistemas complexos. O engenheiro de estratégia interage apenas com a fachada, que por sua vez coordena as chamadas para os subsistemas apropriados.

```java
// Subsistema 1: Sistema de Telemetria
public class SistemaTelemetriaFacade {
    public double getVelocidadeAtual() {
        System.out.println("Sistema Telemetria: Obtendo velocidade atual...");
        return 320.5; // Exemplo
    }

    public double getCombustivelRestante() {
        System.out.println("Sistema Telemetria: Obtendo combustível restante...");
        return 35.0; // Exemplo
    }

    public String getStatusMotor() {
        System.out.println("Sistema Telemetria: Obtendo status do motor...");
        return "OK";
    }
}

// Subsistema 2: Sistema Meteorológico
public class SistemaMeteorologicoFacade {
    public String getCondicaoClimatica() {
        System.out.println("Sistema Meteorológico: Verificando condição climática...");
        return "Ensolarado";
    }

    public double getTemperaturaPista() {
        System.out.println("Sistema Meteorológico: Obtendo temperatura da pista...");
        return 45.0; // Exemplo
    }
}

// Subsistema 3: Sistema de Gerenciamento de Pneus
public class SistemaPneusFacade {
    public double getDesgastePneu(String tipoPneu) {
        System.out.println("Sistema Pneus: Verificando desgaste do pneu " + tipoPneu + "...");
        return 0.7; // Exemplo
    }

    public double getTemperaturaPneu(String tipoPneu) {
        System.out.println("Sistema Pneus: Verificando temperatura do pneu " + tipoPneu + "...");
        return 105.0; // Exemplo
    }
}

// Subsistema 4: Sistema de Comunicação com o Piloto
public class SistemaComunicacaoPilotoFacade {
    public void enviarMensagem(String mensagem) {
        System.out.println("Comunicação Piloto: Enviando mensagem: \"" + mensagem + "\"");
    }

    public String receberMensagem() {
        System.out.println("Comunicação Piloto: Recebendo mensagem...");
        return "Piloto: 'Entendido, mantendo o ritmo.'";
    }
}

// Facade: Gerenciador de Corrida
public class GerenciadorCorridaFacade {
    private final SistemaTelemetriaFacade telemetria;
    private final SistemaMeteorologicoFacade meteorologico;
    private final SistemaPneusFacade pneus;
    private final SistemaComunicacaoPilotoFacade comunicacao;

    public GerenciadorCorridaFacade() {
        this.telemetria = new SistemaTelemetriaFacade();
        this.meteorologico = new SistemaMeteorologicoFacade();
        this.pneus = new SistemaPneusFacade();
        this.comunicacao = new SistemaComunicacaoPilotoFacade();
    }

    public void analisarSituacaoAtual() {
        System.out.println("\n--- Análise da Situação Atual da Corrida ---");
        System.out.println("Velocidade Atual: " + telemetria.getVelocidadeAtual() + " km/h");
        System.out.println("Combustível Restante: " + telemetria.getCombustivelRestante() + "%");
        System.out.println("Status do Motor: " + telemetria.getStatusMotor());
        System.out.println("Condição Climática: " + meteorologico.getCondicaoClimatica());
        System.out.println("Temperatura da Pista: " + meteorologico.getTemperaturaPista() + "C");
        System.out.println("Desgaste Pneu Dianteiro Direito: " + String.format("%.2f", pneus.getDesgastePneu("Dianteiro Direito")) + "%");
        System.out.println("Temperatura Pneu Traseiro Esquerdo: " + pneus.getTemperaturaPneu("Traseiro Esquerdo") + "C");
        comunicacao.enviarMensagem("Verificar desgaste dos pneus.");
        System.out.println(comunicacao.receberMensagem());
        System.out.println("-------------------------------------------");
    }

    public void recomendarPitStop(String tipoPneuRecomendado) {
        System.out.println("\n--- Recomendação de Pit Stop ---");
        System.out.println("Situação atual:");
        analisarSituacaoAtual();
        System.out.println("Recomendando pit stop para pneus " + tipoPneuRecomendado + ".");
        comunicacao.enviarMensagem("Pit stop na próxima volta para pneus " + tipoPneuRecomendado + ".");
        System.out.println(comunicacao.receberMensagem());
        System.out.println("-----------------------------------");
    }

    public static void main(String[] args) {
        GerenciadorCorridaFacade facade = new GerenciadorCorridaFacade();
        facade.analisarSituacaoAtual();
        facade.recomendarPitStop("Macio");
    }
}
```

Neste exemplo, `GerenciadorCorridaFacade` atua como uma fachada para os subsistemas `SistemaTelemetriaFacade`, `SistemaMeteorologicoFacade`, `SistemaPneusFacade` e `SistemaComunicacaoPilotoFacade`. O cliente (o método `main` que simula o engenheiro de estratégia) interage apenas com os métodos simplificados da fachada (`analisarSituacaoAtual`, `recomendarPitStop`), sem precisar conhecer a complexidade interna de cada subsistema. Isso reduz o acoplamento entre o cliente e os subsistemas, tornando o sistema mais fácil de usar e manter [1].




### 5.6. Flyweight: Otimizando a Representação de Pneus

O padrão Flyweight (Peso Leve) é usado para minimizar o uso de memória ou os custos computacionais, compartilhando o máximo possível de dados entre vários objetos semelhantes [1]. É eficaz quando um grande número de objetos precisa ser criado, e esses objetos compartilham muitas características comuns, mas também possuem algumas características intrínsecas que os diferenciam.

**Problema:** Em uma simulação de corrida de Fórmula 1, pode haver centenas ou milhares de pneus em uso (considerando todos os carros, pneus sobressalentes, pneus de diferentes compostos, etc.). Se cada instância de pneu armazenar todas as suas propriedades (tipo de composto, diâmetro, largura, pressão ideal, temperatura de operação ideal, etc.), o consumo de memória pode se tornar excessivo. No entanto, cada pneu também tem propriedades extrínsecas que mudam (desgaste atual, temperatura atual, pressão atual).

**Solução com Flyweight:** Separamos as propriedades intrínsecas (que são compartilhadas) das propriedades extrínsecas (que são únicas para cada instância). Criamos uma fábrica (`FabricaPneuFlyweight`) que gerencia e reutiliza as instâncias de `TipoPneu` (o flyweight) que contêm as propriedades intrínsecas. Cada `Pneu` individual armazena apenas as propriedades extrínsecas e uma referência ao `TipoPneu` compartilhado.

```java
import java.util.HashMap;
import java.util.Map;

// Flyweight: Contém as propriedades intrínsecas (compartilhadas)
public class TipoPneu {
    private final String composto;
    private final String corFaixa;
    private final double pressaoIdeal;
    private final double temperaturaOperacaoIdeal;

    public TipoPneu(String composto, String corFaixa, double pressaoIdeal, double temperaturaOperacaoIdeal) {
        this.composto = composto;
        this.corFaixa = corFaixa;
        this.pressaoIdeal = pressaoIdeal;
        this.temperaturaOperacaoIdeal = temperaturaOperacaoIdeal;
        System.out.println("Criando TipoPneu: " + composto + " (" + corFaixa + ")");
    }

    public String getComposto() {
        return composto;
    }

    public String getCorFaixa() {
        return corFaixa;
    }

    public double getPressaoIdeal() {
        return pressaoIdeal;
    }

    public double getTemperaturaOperacaoIdeal() {
        return temperaturaOperacaoIdeal;
    }

    public void exibirInfoEstatica() {
        System.out.println("  Composto: " + composto + ", Faixa: " + corFaixa +
                           ", Pressão Ideal: " + pressaoIdeal + " psi" +
                           ", Temp. Ideal: " + temperaturaOperacaoIdeal + "C");
    }
}

// Flyweight Factory: Gerencia e reutiliza as instâncias de TipoPneu
public class FabricaPneuFlyweight {
    private static final Map<String, TipoPneu> tiposPneu = new HashMap<>();

    public static TipoPneu getTipoPneu(String composto) {
        if (!tiposPneu.containsKey(composto)) {
            TipoPneu tipo = null;
            switch (composto.toLowerCase()) {
                case "macio":
                    tipo = new TipoPneu("Macio", "Vermelha", 20.0, 100.0);
                    break;
                case "medio":
                    tipo = new TipoPneu("Médio", "Amarela", 22.0, 95.0);
                    break;
                case "duro":
                    tipo = new TipoPneu("Duro", "Branca", 24.0, 90.0);
                    break;
                case "chuva":
                    tipo = new TipoPneu("Chuva", "Azul", 18.0, 80.0);
                    break;
                default:
                    throw new IllegalArgumentException("Composto de pneu desconhecido: " + composto);
            }
            tiposPneu.put(composto, tipo);
        }
        return tiposPneu.get(composto);
    }
}

// Contexto: Contém as propriedades extrínsecas (únicas) e uma referência ao Flyweight
public class PneuF1 {
    private final TipoPneu tipoPneu;
    private double desgasteAtual;
    private double temperaturaAtual;
    private double pressaoAtual;
    private String posicaoNoCarro;

    public PneuF1(String composto, String posicaoNoCarro) {
        this.tipoPneu = FabricaPneuFlyweight.getTipoPneu(composto);
        this.posicaoNoCarro = posicaoNoCarro;
        this.desgasteAtual = 0.0;
        this.temperaturaAtual = tipoPneu.getTemperaturaOperacaoIdeal();
        this.pressaoAtual = tipoPneu.getPressaoIdeal();
    }

    public void simularUso(double voltas) {
        this.desgasteAtual += voltas * 0.01; // Simula desgaste
        this.temperaturaAtual += voltas * 0.5; // Simula aumento de temperatura
        this.pressaoAtual += voltas * 0.1; // Simula aumento de pressão
        System.out.println("  " + posicaoNoCarro + " (" + tipoPneu.getComposto() + "): Desgaste: " +
                           String.format("%.2f", desgasteAtual) + "%, Temp: " +
                           String.format("%.1f", temperaturaAtual) + "C, Pressão: " +
                           String.format("%.1f", pressaoAtual) + " psi");
    }

    public void exibirDetalhesCompletos() {
        System.out.println("Pneu " + posicaoNoCarro + ":");
        tipoPneu.exibirInfoEstatica(); // Informações compartilhadas
        System.out.println("  Desgaste Atual: " + String.format("%.2f", desgasteAtual) + "%");
        System.out.println("  Temperatura Atual: " + String.format("%.1f", temperaturaAtual) + "C");
        System.out.println("  Pressão Atual: " + String.format("%.1f", pressaoAtual) + " psi");
    }

    public static void main(String[] args) {
        System.out.println("--- Criando Pneus ---");
        PneuF1 pneuFL = new PneuF1("macio", "Dianteiro Esquerdo");
        PneuF1 pneuFR = new PneuF1("macio", "Dianteiro Direito");
        PneuF1 pneuRL = new PneuF1("medio", "Traseiro Esquerdo");
        PneuF1 pneuRR = new PneuF1("medio", "Traseiro Direito");

        System.out.println("\n--- Simulando Uso ---");
        pneuFL.simularUso(5);
        pneuFR.simularUso(5);
        pneuRL.simularUso(5);
        pneuRR.simularUso(5);

        System.out.println("\n--- Detalhes Finais ---");
        pneuFL.exibirDetalhesCompletos();
        pneuRL.exibirDetalhesCompletos();

        // Verificando se os objetos TipoPneu são compartilhados
        System.out.println("\nTipoPneu 'macio' é o mesmo para FL e FR? " + (pneuFL.tipoPneu == pneuFR.tipoPneu));
        System.out.println("TipoPneu 'medio' é o mesmo para RL e RR? " + (pneuRL.tipoPneu == pneuRR.tipoPneu));
        System.out.println("TipoPneu 'macio' é o mesmo que 'medio'? " + (pneuFL.tipoPneu == pneuRL.tipoPneu));
    }
}
```

Neste exemplo, `TipoPneu` é o flyweight, contendo as propriedades intrínsecas (composto, cor da faixa, pressões e temperaturas ideais). A `FabricaPneuFlyweight` garante que apenas uma instância de `TipoPneu` seja criada para cada composto (macio, médio, duro, chuva). Cada objeto `PneuF1` (o contexto) armazena suas propriedades extrínsecas (desgaste, temperatura, pressão atuais, posição no carro) e uma referência ao `TipoPneu` compartilhado. Isso reduz significativamente o consumo de memória, pois as informações comuns a milhares de pneus são armazenadas apenas uma vez. O padrão Flyweight é ideal para otimizar o uso de recursos em sistemas com um grande número de objetos semelhantes, como simulações complexas de corrida [1].




### 5.7. Proxy: Controle de Acesso a Dados Confidenciais da Equipe

O padrão Proxy (Procurador) fornece um substituto ou um espaço reservado para outro objeto para controlar o acesso a ele [1]. É útil quando você precisa adicionar uma camada de controle ou funcionalidade extra antes de acessar um objeto real, como controle de acesso, cache, log ou carregamento lento.

**Problema:** Em uma equipe de Fórmula 1, existem dados altamente confidenciais, como estratégias de corrida secretas, configurações de motor proprietárias ou dados de telemetria detalhados de testes privados. Apenas pessoal autorizado (engenheiros-chefe, estrategistas) deve ter acesso a esses dados, enquanto outros membros da equipe (mecânicos, estagiários) podem precisar de acesso a versões simplificadas ou dados menos sensíveis. A implementação direta de verificações de segurança em cada ponto de acesso aos dados reais pode ser repetitiva e propensa a erros.

**Solução com Proxy:** Criamos uma interface `DadosConfidenciaisF1` que define o contrato para o acesso aos dados. A classe `DadosConfidenciaisReais` implementa essa interface e contém os dados sensíveis. Em seguida, criamos uma classe `ProxyDadosConfidenciais` que também implementa `DadosConfidenciaisF1` e atua como um intermediário. O proxy verifica as permissões do usuário antes de delegar a chamada para o objeto `DadosConfidenciaisReais`.

```java
// Supondo um sistema de autenticação e autorização simples
class Usuario {
    private String nome;
    private boolean isAdmin;

    public Usuario(String nome, boolean isAdmin) {
        this.nome = nome;
        this.isAdmin = isAdmin;
    }

    public String getNome() {
        return nome;
    }

    public boolean isAdmin() {
        return isAdmin;
    }
}

// Interface para o objeto real e o proxy
public interface DadosConfidenciaisF1 {
    String getEstrategiaCorridaSecreta(Usuario usuario);
    String getConfiguracaoMotorProprietaria(Usuario usuario);
    String getDadosTelemetriaPrivados(Usuario usuario);
}

// Objeto Real: Contém os dados confidenciais
public class DadosConfidenciaisReais implements DadosConfidenciaisF1 {
    private String estrategiaCorrida;
    private String configuracaoMotor;
    private String dadosTelemetria;

    public DadosConfidenciaisReais() {
        this.estrategiaCorrida = "Estratégia Secreta: Pit stop na volta 25, pneu duro.";
        this.configuracaoMotor = "Configuração Motor: Mapeamento de potência 7, ERS agressivo.";
        this.dadosTelemetria = "Dados Telemetria: Setor 1: 25.123s, Setor 2: 30.456s, Setor 3: 28.789s.";
    }

    @Override
    public String getEstrategiaCorridaSecreta(Usuario usuario) {
        return "[REAL] " + estrategiaCorrida;
    }

    @Override
    public String getConfiguracaoMotorProprietaria(Usuario usuario) {
        return "[REAL] " + configuracaoMotor;
    }

    @Override
    public String getDadosTelemetriaPrivados(Usuario usuario) {
        return "[REAL] " + dadosTelemetria;
    }
}

// Proxy: Controla o acesso ao objeto real
public class ProxyDadosConfidenciais implements DadosConfidenciaisF1 {
    private DadosConfidenciaisReais dadosReais;

    public ProxyDadosConfidenciais() {
        // O objeto real é criado apenas quando necessário (lazy initialization)
        // ou pode ser criado no construtor se sempre for necessário
    }

    private DadosConfidenciaisReais getDadosReais() {
        if (dadosReais == null) {
            dadosReais = new DadosConfidenciaisReais();
            System.out.println("Proxy: Carregando DadosConfidenciaisReais (lazy loading).");
        }
        return dadosReais;
    }

    private boolean verificarPermissao(Usuario usuario) {
        if (usuario.isAdmin()) {
            System.out.println("Proxy: Acesso concedido para " + usuario.getNome() + " (Admin).");
            return true;
        } else {
            System.out.println("Proxy: Acesso negado para " + usuario.getNome() + " (Não Admin).");
            return false;
        }
    }

    @Override
    public String getEstrategiaCorridaSecreta(Usuario usuario) {
        if (verificarPermissao(usuario)) {
            return getDadosReais().getEstrategiaCorridaSecreta(usuario);
        } else {
            return "Acesso negado à estratégia de corrida secreta.";
        }
    }

    @Override
    public String getConfiguracaoMotorProprietaria(Usuario usuario) {
        if (verificarPermissao(usuario)) {
            return getDadosReais().getConfiguracaoMotorProprietaria(usuario);
        } else {
            return "Acesso negado à configuração de motor proprietária.";
        }
    }

    @Override
    public String getDadosTelemetriaPrivados(Usuario usuario) {
        if (verificarPermissao(usuario)) {
            return getDadosReais().getDadosTelemetriaPrivados(usuario);
        } else {
            return "Acesso negado aos dados de telemetria privados.";
        }
    }

    public static void main(String[] args) {
        DadosConfidenciaisF1 proxy = new ProxyDadosConfidenciais();

        Usuario engenheiroChefe = new Usuario("Engenheiro Chefe", true);
        Usuario mecanico = new Usuario("Mecânico", false);

        System.out.println("\n--- Acesso do Engenheiro Chefe ---");
        System.out.println(proxy.getEstrategiaCorridaSecreta(engenheiroChefe));
        System.out.println(proxy.getConfiguracaoMotorProprietaria(engenheiroChefe));
        System.out.println(proxy.getDadosTelemetriaPrivados(engenheiroChefe));

        System.out.println("\n--- Acesso do Mecânico ---");
        System.out.println(proxy.getEstrategiaCorridaSecreta(mecanico));
        System.out.println(proxy.getConfiguracaoMotorProprietaria(mecanico));
        System.out.println(proxy.getDadosTelemetriaPrivados(mecanico));
    }
}
```

Neste exemplo, `DadosConfidenciaisF1` é a interface comum. `DadosConfidenciaisReais` é o objeto que contém os dados sensíveis. `ProxyDadosConfidenciais` atua como um proxy, controlando o acesso aos métodos do objeto real. Antes de permitir o acesso, o proxy verifica as permissões do `Usuario`. Isso centraliza a lógica de segurança e permite que o objeto real se concentre apenas em sua funcionalidade principal. Além disso, o proxy pode implementar "lazy loading" (carregamento preguiçoso), onde o objeto real só é instanciado quando realmente necessário, otimizando recursos. O padrão Proxy é uma ferramenta poderosa para adicionar camadas de controle e segurança sem modificar o objeto original [1].




## 6. Design Patterns Comportamentais com Java e Spring

Design Patterns Comportamentais lidam com a comunicação entre objetos e a atribuição de responsabilidades. Eles se preocupam com algoritmos e a atribuição de responsabilidades entre objetos, descrevendo padrões de comunicação complexos entre diferentes objetos ou classes [1].

### 6.1. Chain of Responsibility: Processamento de Eventos de Corrida

O padrão Chain of Responsibility (Cadeia de Responsabilidade) permite que você passe requisições ao longo de uma cadeia de manipuladores. Ao receber uma requisição, cada manipulador decide se a processa ou a passa para o próximo manipulador na cadeia [1]. É útil quando mais de um objeto pode lidar com uma requisição, e o manipulador real não é conhecido antecipadamente.

**Problema:** Em um sistema de gerenciamento de corrida de Fórmula 1, diversos eventos podem ocorrer durante uma volta (por exemplo, falha de motor, pneu furado, bandeira amarela, acidente). Cada tipo de evento pode exigir uma resposta diferente, e a decisão sobre quem deve lidar com o evento pode depender de vários fatores. Se a lógica de tratamento de eventos estiver centralizada, ela se tornará complexa e difícil de manter.

**Solução com Chain of Responsibility:** Criamos uma interface `ManipuladorEventoCorrida` e implementações concretas para diferentes tipos de eventos (por exemplo, `ManipuladorFalhaMotor`, `ManipuladorBandeiraAmarela`). Cada manipulador decide se pode lidar com o evento; caso contrário, ele o passa para o próximo manipulador na cadeia.

```java
// Interface para o manipulador de eventos
public interface ManipuladorEventoCorrida {
    void setProximoManipulador(ManipuladorEventoCorrida proximoManipulador);
    void lidarComEvento(EventoCorrida evento);
}

// Classe base abstrata para manipuladores
public abstract class AbstractManipuladorEvento implements ManipuladorEventoCorrida {
    private ManipuladorEventoCorrida proximoManipulador;

    @Override
    public void setProximoManipulador(ManipuladorEventoCorrida proximoManipulador) {
        this.proximoManipulador = proximoManipulador;
    }

    protected void passarParaProximo(EventoCorrida evento) {
        if (proximoManipulador != null) {
            proximoManipulador.lidarComEvento(evento);
        } else {
            System.out.println("Nenhum manipulador pode lidar com o evento: " + evento.getDescricao());
        }
    }
}

// Evento de Corrida
public class EventoCorrida {
    public enum TipoEvento { FALHA_MOTOR, PNEU_FURADO, BANDEIRA_AMARELA, ACIDENTE, OUTRO }
    private TipoEvento tipo;
    private String descricao;

    public EventoCorrida(TipoEvento tipo, String descricao) {
        this.tipo = tipo;
        this.descricao = descricao;
    }

    public TipoEvento getTipo() {
        return tipo;
    }

    public String getDescricao() {
        return descricao;
    }
}

// Manipulador concreto para Falha de Motor
public class ManipuladorFalhaMotor extends AbstractManipuladorEvento {
    @Override
    public void lidarComEvento(EventoCorrida evento) {
        if (evento.getTipo() == EventoCorrida.TipoEvento.FALHA_MOTOR) {
            System.out.println("ManipuladorFalhaMotor: Ativando protocolo de segurança para falha de motor: " + evento.getDescricao());
        } else {
            passarParaProximo(evento);
        }
    }
}

// Manipulador concreto para Pneu Furado
public class ManipuladorPneuFurado extends AbstractManipuladorEvento {
    @Override
    public void lidarComEvento(EventoCorrida evento) {
        if (evento.getTipo() == EventoCorrida.TipoEvento.PNEU_FURADO) {
            System.out.println("ManipuladorPneuFurado: Chamando carro para pit stop imediato: " + evento.getDescricao());
        } else {
            passarParaProximo(evento);
        }
    }
}

// Manipulador concreto para Bandeira Amarela
public class ManipuladorBandeiraAmarela extends AbstractManipuladorEvento {
    @Override
    public void lidarComEvento(EventoCorrida evento) {
        if (evento.getTipo() == EventoCorrida.TipoEvento.BANDEIRA_AMARELA) {
            System.out.println("ManipuladorBandeiraAmarela: Orientando piloto a reduzir velocidade e manter posição: " + evento.getDescricao());
        } else {
            passarParaProximo(evento);
        }
    }
}

// Manipulador genérico para outros eventos
public class ManipuladorEventoGenerico extends AbstractManipuladorEvento {
    @Override
    public void lidarComEvento(EventoCorrida evento) {
        System.out.println("ManipuladorEventoGenerico: Registrando evento desconhecido/não prioritário: " + evento.getDescricao());
        // Poderia logar, enviar para análise posterior, etc.
    }
}

// Exemplo de uso
public class CentroDeControleDeCorrida {
    public static void main(String[] args) {
        // Construindo a cadeia de responsabilidade
        ManipuladorEventoCorrida falhaMotorHandler = new ManipuladorFalhaMotor();
        ManipuladorEventoCorrida pneuFuradoHandler = new ManipuladorPneuFurado();
        ManipuladorEventoCorrida bandeiraAmarelaHandler = new ManipuladorBandeiraAmarela();
        ManipuladorEventoCorrida genericoHandler = new ManipuladorEventoGenerico();

        falhaMotorHandler.setProximoManipulador(pneuFuradoHandler);
        pneuFuradoHandler.setProximoManipulador(bandeiraAmarelaHandler);
        bandeiraAmarelaHandler.setProximoManipulador(genericoHandler);

        // Simulando eventos
        System.out.println("\n--- Evento: Falha de Motor ---");
        falhaMotorHandler.lidarComEvento(new EventoCorrida(EventoCorrida.TipoEvento.FALHA_MOTOR, "Perda de potência no motor do carro #44."));

        System.out.println("\n--- Evento: Pneu Furado ---");
        falhaMotorHandler.lidarComEvento(new EventoCorrida(EventoCorrida.TipoEvento.PNEU_FURADO, "Pneu traseiro direito furado no carro #1."));

        System.out.println("\n--- Evento: Bandeira Amarela ---");
        falhaMotorHandler.lidarComEvento(new EventoCorrida(EventoCorrida.TipoEvento.BANDEIRA_AMARELA, "Carro parado na curva 3."));

        System.out.println("\n--- Evento: Acidente ---");
        falhaMotorHandler.lidarComEvento(new EventoCorrida(EventoCorrida.TipoEvento.ACIDENTE, "Colisão múltipla na reta principal."));

        System.out.println("\n--- Evento: Outro ---");
        falhaMotorHandler.lidarComEvento(new EventoCorrida(EventoCorrida.TipoEvento.OUTRO, "Objeto estranho na pista."));
    }
}
```

Neste exemplo, a `ManipuladorEventoCorrida` define a interface para os manipuladores. `AbstractManipuladorEvento` fornece a implementação básica para passar a requisição adiante. `ManipuladorFalhaMotor`, `ManipuladorPneuFurado`, `ManipuladorBandeiraAmarela` e `ManipuladorEventoGenerico` são os manipuladores concretos. O `CentroDeControleDeCorrida` constrói a cadeia. Quando um evento ocorre, ele é passado para o primeiro manipulador na cadeia, que decide se o processa ou o passa para o próximo. Isso permite adicionar novos tipos de eventos ou alterar a ordem de processamento sem modificar o código existente dos manipuladores, tornando o sistema flexível e extensível [1].




### 6.2. Command: Comandos do Pit Wall

O padrão Command (Comando) encapsula uma requisição como um objeto, permitindo que você parametrize clientes com diferentes requisições, enfileire ou registre requisições, e suporte operações desfazíveis [1]. É útil quando você precisa desacoplar o objeto que invoca uma operação do objeto que sabe como realizar essa operação.

**Problema:** No pit wall de uma equipe de Fórmula 1, os estrategistas e engenheiros precisam emitir diversos comandos para o carro ou para a equipe de pit stop (por exemplo, "ativar DRS", "preparar pit stop", "mudar mapeamento do motor"). Esses comandos podem ser emitidos em diferentes momentos, por diferentes pessoas, e podem precisar ser registrados para análise posterior ou até mesmo desfeitos em algumas situações. Se a lógica de execução de cada comando estiver diretamente acoplada ao botão ou à interface que o aciona, o sistema se torna rígido.

**Solução com Command:** Criamos uma interface `ComandoF1` com um método `executar()`. Cada comando específico (por exemplo, `AtivarDRSComando`, `PrepararPitStopComando`) implementa essa interface. Um objeto `Invocador` (como um botão na interface do pit wall) pode então ser configurado com qualquer `ComandoF1`, e o `Receptor` (o carro, a equipe de pit stop) sabe como executar a ação real.

```java
// Interface Command
public interface ComandoF1 {
    void executar();
    void desfazer(); // Opcional, para operações desfazíveis
}

// Receptor: O carro de F1
public class CarroF1Comando {
    private String nomeCarro;

    public CarroF1Comando(String nomeCarro) {
        this.nomeCarro = nomeCarro;
    }

    public void ativarDRS() {
        System.out.println(nomeCarro + ": DRS ativado! Aumentando velocidade na reta.");
    }

    public void mudarMapeamentoMotor(String mapeamento) {
        System.out.println(nomeCarro + ": Mapeamento do motor alterado para \"" + mapeamento + "\".");
    }
}

// Receptor: A equipe de Pit Stop
public class EquipePitStop {
    private String nomeEquipe;

    public EquipePitStop(String nomeEquipe) {
        this.nomeEquipe = nomeEquipe;
    }

    public void prepararPitStop() {
        System.out.println(nomeEquipe + ": Equipe de pit stop preparada e aguardando o carro.");
    }

    public void executarPitStop() {
        System.out.println(nomeEquipe + ": Executando pit stop! Troca de pneus e reabastecimento.");
    }
}

// Comando Concreto: Ativar DRS
public class AtivarDRSComando implements ComandoF1 {
    private final CarroF1Comando carro;

    public AtivarDRSComando(CarroF1Comando carro) {
        this.carro = carro;
    }

    @Override
    public void executar() {
        carro.ativarDRS();
    }

    @Override
    public void desfazer() {
        System.out.println(carro.nomeCarro + ": DRS desativado (desfazer).");
    }
}

// Comando Concreto: Preparar Pit Stop
public class PrepararPitStopComando implements ComandoF1 {
    private final EquipePitStop equipe;

    public PrepararPitStopComando(EquipePitStop equipe) {
        this.equipe = equipe;
    }

    @Override
    public void executar() {
        equipe.prepararPitStop();
    }

    @Override
    public void desfazer() {
        System.out.println(equipe.nomeEquipe + ": Preparação de pit stop cancelada (desfazer). ");
    }
}

// Comando Concreto: Mudar Mapeamento do Motor
public class MudarMapeamentoMotorComando implements ComandoF1 {
    private final CarroF1Comando carro;
    private final String novoMapeamento;
    private String mapeamentoAnterior;

    public MudarMapeamentoMotorComando(CarroF1Comando carro, String novoMapeamento) {
        this.carro = carro;
        this.novoMapeamento = novoMapeamento;
    }

    @Override
    public void executar() {
        // Simula a obtenção do mapeamento anterior antes de mudar
        this.mapeamentoAnterior = "Mapeamento Padrão"; // Em um cenário real, seria obtido do carro
        carro.mudarMapeamentoMotor(novoMapeamento);
    }

    @Override
    public void desfazer() {
        if (mapeamentoAnterior != null) {
            carro.mudarMapeamentoMotor(mapeamentoAnterior); // Volta para o mapeamento anterior
            System.out.println(carro.nomeCarro + ": Mapeamento do motor restaurado para o anterior (desfazer). ");
        }
    }
}

// Invocador: O Painel do Pit Wall
public class PainelPitWall {
    private ComandoF1 comando;

    public void setComando(ComandoF1 comando) {
        this.comando = comando;
    }

    public void emitirComando() {
        if (comando != null) {
            comando.executar();
        }
    }

    public void desfazerUltimoComando() {
        if (comando != null) {
            comando.desfazer();
        }
    }

    public static void main(String[] args) {
        // Receptores
        CarroF1Comando carro44 = new CarroF1Comando("Carro #44");
        EquipePitStop equipeMercedes = new EquipePitStop("Equipe Mercedes");

        // Comandos
        ComandoF1 ativarDRS = new AtivarDRSComando(carro44);
        ComandoF1 prepararPit = new PrepararPitStopComando(equipeMercedes);
        ComandoF1 mudarMapeamentoPotencia = new MudarMapeamentoMotorComando(carro44, "Modo Qualificação");

        // Invocador
        PainelPitWall painel = new PainelPitWall();

        System.out.println("--- Cenário 1: Ativar DRS ---");
        painel.setComando(ativarDRS);
        painel.emitirComando();

        System.out.println("\n--- Cenário 2: Preparar Pit Stop ---");
        painel.setComando(prepararPit);
        painel.emitirComando();

        System.out.println("\n--- Cenário 3: Mudar Mapeamento do Motor ---");
        painel.setComando(mudarMapeamentoPotencia);
        painel.emitirComando();
        painel.desfazerUltimoComando(); // Desfaz a mudança de mapeamento
    }
}
```

Neste exemplo, `ComandoF1` é a interface Command. `CarroF1Comando` e `EquipePitStop` são os Receptores. `AtivarDRSComando`, `PrepararPitStopComando` e `MudarMapeamentoMotorComando` são os Comandos Concretos, cada um encapsulando uma ação específica e uma referência ao seu Receptor. O `PainelPitWall` é o Invocador, que apenas sabe como emitir um comando, sem conhecer os detalhes de sua execução. Isso permite que novos comandos sejam adicionados sem modificar o `PainelPitWall`, e também facilita a implementação de funcionalidades como histórico de comandos, fila de comandos e operações de desfazer/refazer, essenciais em um ambiente de corrida dinâmico [1].




### 6.3. Iterator: Navegando pelos Dados de Volta

O padrão Iterator (Iterador) fornece uma maneira de acessar sequencialmente os elementos de um objeto agregado sem expor sua representação subjacente [1]. É útil quando você precisa percorrer uma coleção de objetos sem se preocupar com a estrutura interna dessa coleção.

**Problema:** Em um sistema de telemetria de Fórmula 1, os dados de uma volta de um carro são coletados em alta frequência, resultando em uma grande coleção de pontos de dados (velocidade, RPM, posição GPS, temperatura de pneus, etc.) para cada instante de tempo. Os engenheiros precisam analisar esses dados sequencialmente, mas a forma como esses dados são armazenados internamente (lista, array, mapa) pode variar e não deve ser exposta diretamente ao cliente.

**Solução com Iterator:** Criamos uma interface `IteradorDadosVolta` que define métodos para acessar o próximo elemento e verificar se há mais elementos. A coleção de dados de volta (`DadosVoltaCorrida`) implementa um método que retorna uma instância de `IteradorDadosVolta`, permitindo que o cliente percorra os dados de forma genérica.

```java
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

// Objeto de dados para cada ponto no tempo
public class PontoDeDadosVolta {
    private double tempo;
    private double velocidade;
    private double rpmMotor;
    private double temperaturaPneuDianteiroEsquerdo;

    public PontoDeDadosVolta(double tempo, double velocidade, double rpmMotor, double temperaturaPneuDianteiroEsquerdo) {
        this.tempo = tempo;
        this.velocidade = velocidade;
        this.rpmMotor = rpmMotor;
        this.temperaturaPneuDianteiroEsquerdo = temperaturaPneuDianteiroEsquerdo;
    }

    public double getTempo() {
        return tempo;
    }

    public double getVelocidade() {
        return velocidade;
    }

    public double getRpmMotor() {
        return rpmMotor;
    }

    public double getTemperaturaPneuDianteiroEsquerdo() {
        return temperaturaPneuDianteiroEsquerdo;
    }

    @Override
    public String toString() {
        return String.format("Tempo: %.2fs, Velocidade: %.1fkm/h, RPM: %.0f, Temp. Pneu DE: %.1fC",
                tempo, velocidade, rpmMotor, temperaturaPneuDianteiroEsquerdo);
    }
}

// Interface Iterator
public interface IteradorDadosVolta {
    boolean temProximo();
    PontoDeDadosVolta proximo();
}

// Agregado Concreto: Coleção de dados de uma volta
public class DadosVoltaCorrida {
    private List<PontoDeDadosVolta> pontosDeDados;

    public DadosVoltaCorrida() {
        this.pontosDeDados = new ArrayList<>();
    }

    public void adicionarPontoDeDados(PontoDeDadosVolta ponto) {
        this.pontosDeDados.add(ponto);
    }

    public IteradorDadosVolta criarIterador() {
        return new DadosVoltaIterator();
    }

    // Implementação do Iterator
    private class DadosVoltaIterator implements IteradorDadosVolta {
        private int posicao = 0;

        @Override
        public boolean temProximo() {
            return posicao < pontosDeDados.size();
        }

        @Override
        public PontoDeDadosVolta proximo() {
            if (!temProximo()) {
                throw new NoSuchElementException("Não há mais pontos de dados na volta.");
            }
            PontoDeDadosVolta ponto = pontosDeDados.get(posicao);
            posicao++;
            return ponto;
        }
    }

    public static void main(String[] args) {
        // Criando dados de uma volta de exemplo
        DadosVoltaCorrida volta1 = new DadosVoltaCorrida();
        volta1.adicionarPontoDeDados(new PontoDeDadosVolta(0.0, 0.0, 0.0, 30.0));
        volta1.adicionarPontoDeDados(new PontoDeDadosVolta(1.5, 100.0, 8000.0, 85.0));
        volta1.adicionarPontoDeDados(new PontoDeDadosVolta(3.0, 200.0, 12000.0, 95.0));
        volta1.adicionarPontoDeDados(new PontoDeDadosVolta(4.5, 250.0, 14000.0, 100.0));
        volta1.adicionarPontoDeDados(new PontoDeDadosVolta(6.0, 280.0, 15000.0, 102.0));
        volta1.adicionarPontoDeDados(new PontoDeDadosVolta(7.5, 300.0, 15500.0, 103.0));
        volta1.adicionarPontoDeDados(new PontoDeDadosVolta(9.0, 320.0, 16000.0, 104.0));

        System.out.println("--- Analisando Dados da Volta 1 ---");
        IteradorDadosVolta iterador = volta1.criarIterador();
        while (iterador.temProximo()) {
            PontoDeDadosVolta ponto = iterador.proximo();
            System.out.println(ponto);
        }

        System.out.println("\n--- Tentando acessar mais dados (deve falhar) ---");
        try {
            iterador.proximo();
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }
}
```

Neste exemplo, `PontoDeDadosVolta` representa um único ponto de dados. `DadosVoltaCorrida` é o agregado que contém uma lista de `PontoDeDadosVolta`. A classe interna `DadosVoltaIterator` implementa a interface `IteradorDadosVolta`, fornecendo a lógica para percorrer a lista sem expor a estrutura interna (`ArrayList`). O cliente (`main` em `DadosVoltaCorrida`) usa o `IteradorDadosVolta` para acessar os dados sequencialmente, sem precisar saber que eles estão armazenados em um `ArrayList`. Isso permite que a representação interna dos dados de volta mude no futuro (por exemplo, para um `LinkedList` ou um array otimizado para memória) sem afetar o código que os consome, garantindo flexibilidade e desacoplamento [1].




### 6.4. Mediator: Comunicação entre Componentes do Carro

O padrão Mediator (Mediador) define um objeto que encapsula como um conjunto de objetos interage. Ele promove o acoplamento fraco, evitando que os objetos se refiram uns aos outros explicitamente, e permite que você varie suas interações independentemente [1]. É útil quando a comunicação entre muitos objetos se torna complexa e emaranhada.

**Problema:** Em um carro de Fórmula 1, diversos sistemas e componentes precisam interagir entre si: o motor, a caixa de câmbio, o sistema de freios, o DRS, o ERS, etc. Se cada componente se comunicar diretamente com todos os outros componentes com os quais precisa interagir, o número de dependências se torna enorme, criando um sistema altamente acoplado e difícil de modificar. Por exemplo, uma mudança no sistema de freios pode exigir alterações em vários outros componentes que interagem diretamente com ele.

**Solução com Mediator:** Criamos uma interface `MediadorCarroF1` que define os métodos para a comunicação entre os componentes. Uma classe `CentralDeControleCarro` implementa essa interface e atua como o mediador, centralizando a lógica de comunicação. Os componentes (colleagues) se comunicam apenas com o mediador, e o mediador orquestra as interações entre eles.

```java
// Interface Mediator
public interface MediadorCarroF1 {
    void notificar(ComponenteCarro componente, String evento);
}

// Componente Abstrato (Colleague)
public abstract class ComponenteCarro {
    protected MediadorCarroF1 mediador;

    public ComponenteCarro(MediadorCarroF1 mediador) {
        this.mediador = mediador;
    }

    public void setMediador(MediadorCarroF1 mediador) {
        this.mediador = mediador;
    }
}

// Componentes Concretos (Concrete Colleagues)
public class MotorMediator extends ComponenteCarro {
    private boolean ligado;

    public MotorMediator(MediadorCarroF1 mediador) {
        super(mediador);
        this.ligado = false;
    }

    public void ligar() {
        if (!ligado) {
            ligado = true;
            System.out.println("Motor: Ligado.");
            mediador.notificar(this, "motorLigado");
        }
    }

    public void desligar() {
        if (ligado) {
            ligado = false;
            System.out.println("Motor: Desligado.");
            mediador.notificar(this, "motorDesligado");
        }
    }

    public boolean isLigado() {
        return ligado;
    }
}

public class CaixaDeCambio extends ComponenteCarro {
    private int marchaAtual;

    public CaixaDeCambio(MediadorCarroF1 mediador) {
        super(mediador);
        this.marchaAtual = 0;
    }

    public void mudarMarcha(int novaMarcha) {
        this.marchaAtual = novaMarcha;
        System.out.println("Caixa de Câmbio: Marcha alterada para " + marchaAtual + ".");
        mediador.notificar(this, "marchaAlterada");
    }

    public int getMarchaAtual() {
        return marchaAtual;
    }
}

public class SistemaDRS extends ComponenteCarro {
    private boolean drsAtivado;

    public SistemaDRS(MediadorCarroF1 mediador) {
        super(mediador);
        this.drsAtivado = false;
    }

    public void ativarDRS() {
        if (!drsAtivado) {
            drsAtivado = true;
            System.out.println("Sistema DRS: DRS ativado.");
            mediador.notificar(this, "drsAtivado");
        }
    }

    public void desativarDRS() {
        if (drsAtivado) {
            drsAtivado = false;
            System.out.println("Sistema DRS: DRS desativado.");
            mediador.notificar(this, "drsDesativado");
        }
    }

    public boolean isDrsAtivado() {
        return drsAtivado;
    }
}

// Mediador Concreto: Central de Controle do Carro
public class CentralDeControleCarro implements MediadorCarroF1 {
    private MotorMediator motor;
    private CaixaDeCambio caixaDeCambio;
    private SistemaDRS sistemaDRS;

    public void setMotor(MotorMediator motor) {
        this.motor = motor;
    }

    public void setCaixaDeCambio(CaixaDeCambio caixaDeCambio) {
        this.caixaDeCambio = caixaDeCambio;
    }

    public void setSistemaDRS(SistemaDRS sistemaDRS) {
        this.sistemaDRS = sistemaDRS;
    }

    @Override
    public void notificar(ComponenteCarro componente, String evento) {
        if (componente == motor) {
            if (evento.equals("motorLigado")) {
                System.out.println("Mediador: Motor ligado. Preparando outros sistemas...");
                // Lógica de coordenação: por exemplo, verificar se a caixa de câmbio está em neutro
                if (caixaDeCambio.getMarchaAtual() != 0) {
                    System.out.println("Mediador: Aviso! Motor ligado com marcha engatada. Colocando em neutro.");
                    caixaDeCambio.mudarMarcha(0);
                }
            } else if (evento.equals("motorDesligado")) {
                System.out.println("Mediador: Motor desligado. Desativando DRS se estiver ativo.");
                if (sistemaDRS.isDrsAtivado()) {
                    sistemaDRS.desativarDRS();
                }
            }
        } else if (componente == caixaDeCambio) {
            if (evento.equals("marchaAlterada")) {
                System.out.println("Mediador: Marcha alterada para " + caixaDeCambio.getMarchaAtual() + ". Ajustando parâmetros do motor.");
                // Lógica de coordenação: por exemplo, ajustar RPM do motor
            }
        } else if (componente == sistemaDRS) {
            if (evento.equals("drsAtivado")) {
                System.out.println("Mediador: DRS ativado. Notificando telemetria.");
                // Lógica de coordenação: por exemplo, enviar alerta para telemetria
            } else if (evento.equals("drsDesativado")) {
                System.out.println("Mediador: DRS desativado. Notificando telemetria.");
            }
        }
    }

    public static void main(String[] args) {
        CentralDeControleCarro mediador = new CentralDeControleCarro();

        MotorMediator motor = new MotorMediator(mediador);
        CaixaDeCambio caixaDeCambio = new CaixaDeCambio(mediador);
        SistemaDRS sistemaDRS = new SistemaDRS(mediador);

        mediador.setMotor(motor);
        mediador.setCaixaDeCambio(caixaDeCambio);
        mediador.setSistemaDRS(sistemaDRS);

        System.out.println("\n--- Simulação de Operações do Carro ---");
        motor.ligar();
        caixaDeCambio.mudarMarcha(1);
        sistemaDRS.ativarDRS();
        motor.desligar();
        caixaDeCambio.mudarMarcha(0);
    }
}
```

Neste exemplo, `MediadorCarroF1` é a interface do mediador, e `CentralDeControleCarro` é o mediador concreto. `MotorMediator`, `CaixaDeCambio` e `SistemaDRS` são os componentes (colleagues). Em vez de se comunicarem diretamente, os componentes notificam o mediador sobre seus eventos, e o mediador orquestra as interações entre eles. Isso reduz o acoplamento entre os componentes, tornando o sistema mais fácil de entender, manter e modificar. Adicionar um novo componente ou alterar a lógica de interação entre componentes existentes agora envolve apenas modificar o mediador, em vez de alterar múltiplos componentes [1].




### 6.5. Memento: Salvando o Estado da Corrida

O padrão Memento (Lembrança) sem violar o encapsulamento, captura e externaliza o estado interno de um objeto para que o objeto possa ser restaurado para este estado mais tarde [1]. É útil quando você precisa implementar funcionalidades de "desfazer" ou "restaurar" o estado de um objeto.

**Problema:** Em uma simulação de corrida de Fórmula 1, os engenheiros podem querer salvar o estado exato da corrida em determinados pontos (por exemplo, no início de uma volta, antes de um pit stop, ou em um momento crítico da corrida) para análise posterior ou para "voltar no tempo" e testar diferentes estratégias a partir daquele ponto. Salvar e restaurar o estado de um objeto complexo como uma `CorridaF1` pode ser complicado se todos os detalhes internos forem expostos.

**Solução com Memento:** Criamos três componentes: o Originator (`CorridaF1`), que é o objeto cujo estado será salvo; o Memento (`EstadoCorrida`), que armazena o estado do Originator; e o Caretaker (`HistoricoCorrida`), que é responsável por guardar os Mementos. O Memento é uma classe interna ou uma classe com acesso restrito ao Originator, garantindo o encapsulamento.

```java
import java.util.ArrayList;
import java.util.List;

// Memento: Armazena o estado interno do Originator
// Geralmente uma classe interna ou com acesso restrito ao Originator
class EstadoCorrida {
    private final int voltaAtual;
    private final double tempoTotal;
    private final String statusPneus;
    private final double combustivelRestante;

    public EstadoCorrida(int voltaAtual, double tempoTotal, String statusPneus, double combustivelRestante) {
        this.voltaAtual = voltaAtual;
        this.tempoTotal = tempoTotal;
        this.statusPneus = statusPneus;
        this.combustivelRestante = combustivelRestante;
    }

    public int getVoltaAtual() {
        return voltaAtual;
    }

    public double getTempoTotal() {
        return tempoTotal;
    }

    public String getStatusPneus() {
        return statusPneus;
    }

    public double getCombustivelRestante() {
        return combustivelRestante;
    }

    @Override
    public String toString() {
        return String.format("Estado [Volta: %d, Tempo: %.2fs, Pneus: %s, Combustível: %.2f%%]",
                voltaAtual, tempoTotal, statusPneus, combustivelRestante);
    }
}

// Originator: O objeto cujo estado será salvo e restaurado
public class CorridaF1 {
    private int voltaAtual;
    private double tempoTotal;
    private String statusPneus;
    private double combustivelRestante;

    public CorridaF1(int voltaAtual, double tempoTotal, String statusPneus, double combustivelRestante) {
        this.voltaAtual = voltaAtual;
        this.tempoTotal = tempoTotal;
        this.statusPneus = statusPneus;
        this.combustivelRestante = combustivelRestante;
    }

    public void simularVolta(double tempoVolta, double consumoCombustivel) {
        this.voltaAtual++;
        this.tempoTotal += tempoVolta;
        this.combustivelRestante -= consumoCombustivel;
        System.out.println("Simulando volta: " + toString());
    }

    public void mudarStatusPneus(String novoStatus) {
        this.statusPneus = novoStatus;
        System.out.println("Status dos pneus alterado para: " + novoStatus);
    }

    // Cria um Memento contendo o estado atual
    public EstadoCorrida salvarEstado() {
        System.out.println("Salvando estado da corrida...");
        return new EstadoCorrida(voltaAtual, tempoTotal, statusPneus, combustivelRestante);
    }

    // Restaura o estado a partir de um Memento
    public void restaurarEstado(EstadoCorrida memento) {
        this.voltaAtual = memento.getVoltaAtual();
        this.tempoTotal = memento.getTempoTotal();
        this.statusPneus = memento.getStatusPneus();
        this.combustivelRestante = memento.getCombustivelRestante();
        System.out.println("Estado da corrida restaurado para: " + toString());
    }

    @Override
    public String toString() {
        return String.format("Corrida [Volta: %d, Tempo Total: %.2fs, Pneus: %s, Combustível: %.2f%%]",
                voltaAtual, tempoTotal, statusPneus, combustivelRestante);
    }
}

// Caretaker: Responsável por guardar os Mementos
public class HistoricoCorrida {
    private final List<EstadoCorrida> historico = new ArrayList<>();

    public void adicionarEstado(EstadoCorrida estado) {
        historico.add(estado);
    }

    public EstadoCorrida getEstado(int index) {
        if (index < 0 || index >= historico.size()) {
            throw new IndexOutOfBoundsException("Índice de estado inválido.");
        }
        return historico.get(index);
    }

    public static void main(String[] args) {
        CorridaF1 corrida = new CorridaF1(0, 0.0, "Macios", 100.0);
        HistoricoCorrida historico = new HistoricoCorrida();

        System.out.println("Estado inicial: " + corrida);

        // Salva o estado inicial
        historico.adicionarEstado(corrida.salvarEstado());

        corrida.simularVolta(90.5, 2.0);
        corrida.simularVolta(91.2, 2.1);

        // Salva o estado após algumas voltas
        historico.adicionarEstado(corrida.salvarEstado());

        corrida.mudarStatusPneus("Duros");
        corrida.simularVolta(95.0, 2.5);

        System.out.println("\n--- Restaurando estados ---");

        // Restaura para o estado inicial
        corrida.restaurarEstado(historico.getEstado(0));

        // Restaura para o estado após algumas voltas
        corrida.restaurarEstado(historico.getEstado(1));
    }
}
```

Neste exemplo, `CorridaF1` é o Originator, `EstadoCorrida` é o Memento, e `HistoricoCorrida` é o Caretaker. O `CorridaF1` cria e restaura seus próprios Mementos, enquanto o `HistoricoCorrida` apenas os armazena e os recupera, sem conhecer os detalhes internos do estado da corrida. Isso permite que o estado da corrida seja salvo e restaurado de forma segura, sem expor a complexidade interna do objeto `CorridaF1`, facilitando a implementação de funcionalidades de "desfazer" ou de análise de cenários [1].




### 6.6. Observer: Monitoramento de Dados em Tempo Real

O padrão Observer (Observador) define uma dependência um-para-muitos entre objetos, de modo que quando um objeto muda de estado, todos os seus dependentes são notificados e atualizados automaticamente [1]. É útil para implementar sistemas de eventos distribuídos, onde um objeto (o sujeito ou observável) notifica vários outros objetos (os observadores) sobre mudanças em seu estado.

**Problema:** Em um sistema de telemetria de Fórmula 1, diversos componentes precisam reagir a mudanças nos dados do carro em tempo real. Por exemplo, o painel do engenheiro de pista precisa exibir a velocidade atual, o sistema de alerta precisa disparar um aviso se a temperatura do motor exceder um limite, e o sistema de gravação de dados precisa registrar todas as mudanças. Se cada um desses componentes monitorar diretamente os dados do carro, o acoplamento se torna alto e a adição de novos monitores é complexa.

**Solução com Observer:** Criamos uma interface `ObservadorDadosCarro` para os observadores e uma interface `SujeitoDadosCarro` para o sujeito. A classe `DadosCarroTelemetria` (o sujeito concreto) mantém uma lista de observadores e os notifica quando seus dados mudam. Cada observador concreto (por exemplo, `PainelEngenheiro`, `SistemaAlertaMotor`, `GravadorDeDados`) implementa a interface `ObservadorDadosCarro` e reage às notificações.

```java
import java.util.ArrayList;
import java.util.List;

// Interface Observador
public interface ObservadorDadosCarro {
    void atualizar(double velocidade, double rpm, double temperaturaMotor);
}

// Interface Sujeito
public interface SujeitoDadosCarro {
    void adicionarObservador(ObservadorDadosCarro observador);
    void removerObservador(ObservadorDadosCarro observador);
    void notificarObservadores();
}

// Sujeito Concreto: Dados de Telemetria do Carro
public class DadosCarroTelemetria implements SujeitoDadosCarro {
    private List<ObservadorDadosCarro> observadores = new ArrayList<>();
    private double velocidade;
    private double rpmMotor;
    private double temperaturaMotor;

    public void setDados(double velocidade, double rpmMotor, double temperaturaMotor) {
        this.velocidade = velocidade;
        this.rpmMotor = rpmMotor;
        this.temperaturaMotor = temperaturaMotor;
        notificarObservadores();
    }

    @Override
    public void adicionarObservador(ObservadorDadosCarro observador) {
        observadores.add(observador);
    }

    @Override
    public void removerObservador(ObservadorDadosCarro observador) {
        observadores.remove(observador);
    }

    @Override
    public void notificarObservadores() {
        for (ObservadorDadosCarro observador : observadores) {
            observador.atualizar(velocidade, rpmMotor, temperaturaMotor);
        }
    }
}

// Observador Concreto: Painel do Engenheiro
public class PainelEngenheiro implements ObservadorDadosCarro {
    private String nomeEngenheiro;

    public PainelEngenheiro(String nomeEngenheiro) {
        this.nomeEngenheiro = nomeEngenheiro;
    }

    @Override
    public void atualizar(double velocidade, double rpm, double temperaturaMotor) {
        System.out.println(nomeEngenheiro + " (Painel): Velocidade: " + velocidade + " km/h, RPM: " + rpm + ", Temp. Motor: " + temperaturaMotor + "C");
    }
}

// Observador Concreto: Sistema de Alerta do Motor
public class SistemaAlertaMotor implements ObservadorDadosCarro {
    private static final double TEMPERATURA_LIMITE = 110.0;

    @Override
    public void atualizar(double velocidade, double rpm, double temperaturaMotor) {
        if (temperaturaMotor > TEMPERATURA_LIMITE) {
            System.out.println("!!! ALERTA DO MOTOR: Temperatura crítica: " + temperaturaMotor + "C !!!");
        }
    }
}

// Observador Concreto: Gravador de Dados
public class GravadorDeDados implements ObservadorDadosCarro {
    @Override
    public void atualizar(double velocidade, double rpm, double temperaturaMotor) {
        System.out.println("Gravador de Dados: Registrando dados - Velocidade: " + velocidade + ", RPM: " + rpm + ", Temp. Motor: " + temperaturaMotor);
    }
}

// Exemplo de uso
public class SimuladorCorridaObserver {
    public static void main(String[] args) {
        DadosCarroTelemetria carro = new DadosCarroTelemetria();

        // Criando observadores
        PainelEngenheiro engenheiroChefe = new PainelEngenheiro("Engenheiro Chefe");
        SistemaAlertaMotor alertaMotor = new SistemaAlertaMotor();
        GravadorDeDados gravador = new GravadorDeDados();

        // Adicionando observadores ao sujeito
        carro.adicionarObservador(engenheiroChefe);
        carro.adicionarObservador(alertaMotor);
        carro.adicionarObservador(gravador);

        System.out.println("--- Simulação de Dados de Telemetria ---");

        carro.setDados(250.0, 12000.0, 95.0);
        carro.setDados(300.0, 14500.0, 105.0);
        carro.setDados(320.0, 15000.0, 112.0); // Dispara alerta
        carro.setDados(280.0, 13000.0, 100.0);

        System.out.println("\n--- Removendo Gravador de Dados ---");
        carro.removerObservador(gravador);
        carro.setDados(310.0, 14800.0, 108.0);
    }
}
```

Neste exemplo, `DadosCarroTelemetria` é o sujeito, e `ObservadorDadosCarro` é a interface para os observadores. `PainelEngenheiro`, `SistemaAlertaMotor` e `GravadorDeDados` são os observadores concretos. Quando os dados do carro mudam (método `setDados`), o sujeito notifica todos os observadores registrados, que então reagem de acordo. Isso permite que o sistema de telemetria seja altamente modular e extensível; novos componentes que precisam reagir a dados do carro podem ser adicionados simplesmente implementando a interface `ObservadorDadosCarro` e se registrando no `DadosCarroTelemetria`, sem modificar o código existente do sujeito ou de outros observadores [1].




### 6.7. State: Estados do Carro de F1

O padrão State (Estado) permite que um objeto altere seu comportamento quando seu estado interno muda. O objeto parecerá ter mudado sua classe [1]. É útil quando o comportamento de um objeto depende de seu estado, e ele precisa mudar seu comportamento em tempo de execução de acordo com esse estado.

**Problema:** Um carro de Fórmula 1 pode estar em diferentes estados durante uma corrida: `EmPista`, `NoPitStop`, `SafetyCar`, `BandeiraVermelha`. O comportamento do carro (por exemplo, como ele acelera, freia, ou se o DRS pode ser ativado) muda drasticamente dependendo do seu estado atual. Se toda a lógica de transição de estado e comportamento estiver em uma única classe `CarroF1`, ela se tornará complexa e cheia de condicionais (`if-else` ou `switch`), dificultando a manutenção e a adição de novos estados.

**Solução com State:** Criamos uma interface `EstadoCarroF1` que define os comportamentos para cada estado. Cada estado concreto (por exemplo, `EstadoEmPista`, `EstadoNoPitStop`) implementa essa interface. A classe `CarroF1State` (o contexto) mantém uma referência para o objeto de estado atual e delega as chamadas de comportamento para ele. O próprio objeto de estado pode conter a lógica para transicionar para outros estados.

```java
// Interface State
public interface EstadoCarroF1 {
    void acelerar(CarroF1State carro);
    void frear(CarroF1State carro);
    void ativarDRS(CarroF1State carro);
    void entrarPitStop(CarroF1State carro);
    void sairPitStop(CarroF1State carro);
}

// Contexto: O Carro de F1
public class CarroF1State {
    private EstadoCarroF1 estadoAtual;
    private String nome;

    public CarroF1State(String nome) {
        this.nome = nome;
        // Estado inicial
        this.estadoAtual = new EstadoEmPista();
        System.out.println(nome + " está inicialmente no estado: " + estadoAtual.getClass().getSimpleName());
    }

    public void setEstado(EstadoCarroF1 novoEstado) {
        this.estadoAtual = novoEstado;
        System.out.println(nome + " mudou para o estado: " + novoEstado.getClass().getSimpleName());
    }

    public void acelerar() {
        estadoAtual.acelerar(this);
    }

    public void frear() {
        estadoAtual.frear(this);
    }

    public void ativarDRS() {
        estadoAtual.ativarDRS(this);
    }

    public void entrarPitStop() {
        estadoAtual.entrarPitStop(this);
    }

    public void sairPitStop() {
        estadoAtual.sairPitStop(this);
    }

    public String getNome() {
        return nome;
    }
}

// Estado Concreto: Em Pista
public class EstadoEmPista implements EstadoCarroF1 {
    @Override
    public void acelerar(CarroF1State carro) {
        System.out.println(carro.getNome() + " está acelerando forte na pista.");
    }

    @Override
    public void frear(CarroF1State carro) {
        System.out.println(carro.getNome() + " está freando para uma curva.");
    }

    @Override
    public void ativarDRS(CarroF1State carro) {
        System.out.println(carro.getNome() + " ativou o DRS na zona permitida.");
    }

    @Override
    public void entrarPitStop(CarroF1State carro) {
        System.out.println(carro.getNome() + " entrando no pit stop.");
        carro.setEstado(new EstadoNoPitStop());
    }

    @Override
    public void sairPitStop(CarroF1State carro) {
        System.out.println(carro.getNome() + " não pode sair do pit stop se não entrou.");
    }
}

// Estado Concreto: No Pit Stop
public class EstadoNoPitStop implements EstadoCarroF1 {
    @Override
    public void acelerar(CarroF1State carro) {
        System.out.println(carro.getNome() + " não pode acelerar no pit stop.");
    }

    @Override
    public void frear(CarroF1State carro) {
        System.out.println(carro.getNome() + " está parado no pit stop.");
    }

    @Override
    public void ativarDRS(CarroF1State carro) {
        System.out.println(carro.getNome() + " não pode ativar DRS no pit stop.");
    }

    @Override
    public void entrarPitStop(CarroF1State carro) {
        System.out.println(carro.getNome() + " já está no pit stop.");
    }

    @Override
    public void sairPitStop(CarroF1State carro) {
        System.out.println(carro.getNome() + " saindo do pit stop e voltando para a pista.");
        carro.setEstado(new EstadoEmPista());
    }
}

// Exemplo de uso
public class SimuladorEstadosCarroF1 {
    public static void main(String[] args) {
        CarroF1State carro = new CarroF1State("Carro #16");

        carro.acelerar();
        carro.ativarDRS();
        carro.entrarPitStop();

        carro.acelerar(); // Tentativa inválida
        carro.sairPitStop();
        carro.frear();
    }
}
```

Neste exemplo, `EstadoCarroF1` é a interface State. `EstadoEmPista` e `EstadoNoPitStop` são os estados concretos. `CarroF1State` é o contexto que mantém uma referência ao estado atual e delega as chamadas de comportamento para ele. A lógica de transição de estado é encapsulada dentro dos próprios objetos de estado. Isso remove a complexidade de condicionais da classe `CarroF1State`, tornando-a mais limpa e fácil de estender com novos estados. Adicionar um novo estado (por exemplo, `EstadoSafetyCar`) envolve apenas criar uma nova classe de estado e definir suas transições, sem modificar as classes de estado existentes ou a classe `CarroF1State` [1].




### 6.8. Strategy: Estratégias de Corrida

O padrão Strategy (Estratégia) define uma família de algoritmos, encapsula cada um deles e os torna intercambiáveis. Ele permite que o algoritmo varie independentemente dos clientes que o utilizam [1]. É útil quando você tem várias maneiras de realizar uma tarefa e deseja que o cliente possa escolher ou mudar o algoritmo em tempo de execução.

**Problema:** Em uma corrida de Fórmula 1, a equipe de estratégia precisa decidir a melhor abordagem para o carro em diferentes cenários: uma estratégia agressiva para ultrapassagens, uma estratégia conservadora para economizar pneus e combustível, ou uma estratégia de chuva. Se a lógica para cada estratégia estiver embutida na classe `EstrategistaDeCorrida`, ela se tornará complexa e difícil de adaptar a novas condições ou táticas.

**Solução com Strategy:** Criamos uma interface `EstrategiaCorrida` que define o método `executarEstrategia()`. Cada estratégia concreta (por exemplo, `EstrategiaAgressiva`, `EstrategiaConservadora`, `EstrategiaChuva`) implementa essa interface. A classe `EstrategistaDeCorrida` (o contexto) mantém uma referência à `EstrategiaCorrida` atual e delega a execução da estratégia para ela.

```java
// Interface Strategy
public interface EstrategiaCorrida {
    void executarEstrategia();
}

// Estratégia Concreta: Agressiva
public class EstrategiaAgressiva implements EstrategiaCorrida {
    @Override
    public void executarEstrategia() {
        System.out.println("Estratégia Agressiva: Pressionar ao máximo, buscar ultrapassagens, foco em voltas rápidas.");
        // Lógica para otimizar o carro para velocidade, talvez com mais consumo de combustível e desgaste de pneu
    }
}

// Estratégia Concreta: Conservadora
public class EstrategiaConservadora implements EstrategiaCorrida {
    @Override
    public void executarEstrategia() {
        System.out.println("Estratégia Conservadora: Gerenciar pneus e combustível, manter posição, evitar riscos.");
        // Lógica para otimizar o carro para durabilidade, talvez com menos velocidade de pico
    }
}

// Estratégia Concreta: Chuva
public class EstrategiaChuva implements EstrategiaCorrida {
    @Override
    public void executarEstrategia() {
        System.out.println("Estratégia de Chuva: Cautela, foco em manter o carro na pista, gerenciamento de aquaplanagem.");
        // Lógica para otimizar o carro para condições molhadas, como ajuste de asa e pilotagem suave
    }
}

// Contexto: O Estrategista de Corrida
public class EstrategistaDeCorrida {
    private EstrategiaCorrida estrategiaAtual;

    public EstrategistaDeCorrida(EstrategiaCorrida estrategiaInicial) {
        this.estrategiaAtual = estrategiaInicial;
    }

    public void setEstrategia(EstrategiaCorrida novaEstrategia) {
        this.estrategiaAtual = novaEstrategia;
        System.out.println("Estratégia de corrida alterada para: " + novaEstrategia.getClass().getSimpleName());
    }

    public void aplicarEstrategia() {
        System.out.println("\nAplicando estratégia atual:");
        estrategiaAtual.executarEstrategia();
    }

    public static void main(String[] args) {
        // Estratégia inicial: Conservadora
        EstrategistaDeCorrida estrategista = new EstrategistaDeCorrida(new EstrategiaConservadora());
        estrategista.aplicarEstrategia();

        // Mudando para estratégia agressiva
        estrategista.setEstrategia(new EstrategiaAgressiva());
        estrategista.aplicarEstrategia();

        // Mudando para estratégia de chuva
        estrategista.setEstrategia(new EstrategiaChuva());
        estrategista.aplicarEstrategia();
    }
}
```

Neste exemplo, `EstrategiaCorrida` é a interface Strategy. `EstrategiaAgressiva`, `EstrategiaConservadora` e `EstrategiaChuva` são as estratégias concretas. O `EstrategistaDeCorrida` (o contexto) mantém uma referência à estratégia atual e delega a execução para ela. Isso permite que a equipe de estratégia mude a tática do carro em tempo real, simplesmente trocando o objeto de estratégia, sem modificar a classe `EstrategistaDeCorrida`. O padrão Strategy promove a flexibilidade e a reutilização de código, facilitando a adição de novas estratégias de corrida no futuro [1].




### 6.9. Template Method: Algoritmo de Pit Stop

O padrão Template Method (Método Modelo) define o esqueleto de um algoritmo em uma operação, adiando alguns passos para as subclasses. Ele permite que as subclasses redefinam certos passos de um algoritmo sem mudar a estrutura do algoritmo [1]. É útil quando você tem um algoritmo com etapas fixas, mas algumas dessas etapas podem ter implementações variadas.

**Problema:** Um pit stop na Fórmula 1 segue uma sequência de passos bem definida: o carro entra no box, para na posição, a equipe troca os pneus, faz ajustes na asa, o carro é liberado e sai do box. Embora a sequência geral seja a mesma, os detalhes de cada passo podem variar ligeiramente entre as equipes ou dependendo da situação (por exemplo, a velocidade da troca de pneus, a precisão dos ajustes). Se a lógica de cada pit stop for duplicada, a manutenção se torna um pesadelo.

**Solução com Template Method:** Criamos uma classe abstrata `AlgoritmoPitStop` que define o método modelo (`executarPitStop()`) e os métodos abstratos para as etapas que podem variar (por exemplo, `trocarPneus()`, `fazerAjustesAsa()`). As subclasses concretas (por exemplo, `PitStopRapidoMercedes`, `PitStopPadraoFerrari`) implementam esses métodos abstratos, fornecendo suas próprias implementações para as etapas variáveis.

```java
// Classe abstrata com o Template Method
public abstract class AlgoritmoPitStop {

    // O Template Method: Define o esqueleto do algoritmo
    public final void executarPitStop() {
        entrarNoBox();
        pararNaPosicao();
        trocarPneus();
        fazerAjustesAsa();
        liberarCarro();
        sairDoBox();
        System.out.println("Pit Stop concluído!");
    }

    // Etapas comuns (implementadas na classe base)
    private void entrarNoBox() {
        System.out.println("1. Carro entrando no box.");
    }

    private void pararNaPosicao() {
        System.out.println("2. Carro parado na posição exata.");
    }

    private void liberarCarro() {
        System.out.println("5. Carro liberado pelo sinal verde.");
    }

    private void sairDoBox() {
        System.out.println("6. Carro saindo do box e voltando para a pista.");
    }

    // Etapas que podem ser redefinidas pelas subclasses (métodos abstratos)
    protected abstract void trocarPneus();
    protected abstract void fazerAjustesAsa();

    // Hook method (opcional): pode ser sobrescrito, mas tem uma implementação padrão
    protected void realizarVerificacoesAdicionais() {
        // Por padrão, nenhuma verificação adicional
    }
}

// Subclasse Concreta: Pit Stop Rápido da Mercedes
public class PitStopRapidoMercedes extends AlgoritmoPitStop {
    @Override
    protected void trocarPneus() {
        System.out.println("3. Mercedes: Troca de pneus ultra-rápida em 2.0 segundos!");
    }

    @Override
    protected void fazerAjustesAsa() {
        System.out.println("4. Mercedes: Ajuste mínimo na asa dianteira.");
    }

    @Override
    protected void realizarVerificacoesAdicionais() {
        System.out.println("Mercedes: Verificação de telemetria rápida durante o pit stop.");
    }
}

// Subclasse Concreta: Pit Stop Padrão da Ferrari
public class PitStopPadraoFerrari extends AlgoritmoPitStop {
    @Override
    protected void trocarPneus() {
        System.out.println("3. Ferrari: Troca de pneus em 2.5 segundos.");
    }

    @Override
    protected void fazerAjustesAsa() {
        System.out.println("4. Ferrari: Ajuste padrão na asa dianteira e traseira.");
    }
}

// Exemplo de uso
public class SimuladorPitStop {
    public static void main(String[] args) {
        System.out.println("--- Pit Stop da Mercedes ---");
        AlgoritmoPitStop pitStopMercedes = new PitStopRapidoMercedes();
        pitStopMercedes.executarPitStop();

        System.out.println("\n--- Pit Stop da Ferrari ---");
        AlgoritmoPitStop pitStopFerrari = new PitStopPadraoFerrari();
        pitStopFerrari.executarPitStop();
    }
}
```

Neste exemplo, `AlgoritmoPitStop` é a classe abstrata que define o método modelo `executarPitStop()`. As etapas `entrarNoBox()`, `pararNaPosicao()`, `liberarCarro()` e `sairDoBox()` são implementadas na classe base, pois são comuns a todos os pit stops. As etapas `trocarPneus()` e `fazerAjustesAsa()` são abstratas e devem ser implementadas pelas subclasses (`PitStopRapidoMercedes`, `PitStopPadraoFerrari`), permitindo que cada equipe personalize a velocidade e a precisão dessas operações. O padrão Template Method garante que a estrutura geral do pit stop seja mantida, enquanto permite flexibilidade nas etapas específicas, facilitando a adição de novas estratégias de pit stop sem modificar o algoritmo principal [1].




### 6.10. Visitor: Análise de Desempenho de Componentes do Carro

O padrão Visitor (Visitante) representa uma operação a ser executada nos elementos de uma estrutura de objeto. Ele permite que você defina uma nova operação sem mudar as classes dos elementos nos quais opera [1]. É útil quando você precisa realizar operações diferentes em uma estrutura de objetos complexa, e essas operações podem mudar ou ser adicionadas frequentemente.

**Problema:** Em um carro de Fórmula 1, existem diversos tipos de componentes (motor, chassi, asa, pneu, sistema de freios, etc.). Os engenheiros precisam realizar diferentes tipos de análises nesses componentes: calcular o peso total, verificar a integridade estrutural, simular o desempenho aerodinâmico, ou gerar relatórios de manutenção. Se cada tipo de análise for implementado diretamente nas classes dos componentes, as classes se tornarão inchadas e difíceis de manter, especialmente quando novas análises forem adicionadas.

**Solução com Visitor:** Criamos uma interface `ComponenteCarroVisitavel` que todos os componentes do carro devem implementar, com um método `aceitar(VisitanteComponente)` que aceita um objeto `VisitanteComponente`. A interface `VisitanteComponente` define um método `visitar()` para cada tipo de componente concreto. Cada análise específica é implementada como uma classe concreta de `VisitanteComponente`.

```java
// Interface Visitor
public interface VisitanteComponente {
    void visitar(MotorComponente motor);
    void visitar(ChassiComponente chassi);
    void visitar(AsaComponente asa);
    void visitar(PneuComponente pneu);
}

// Interface Element (Visitável)
public interface ComponenteCarroVisitavel {
    void aceitar(VisitanteComponente visitante);
}

// Elementos Concretos (Componentes do Carro)
public class MotorComponente implements ComponenteCarroVisitavel {
    private String nome;
    private double potenciaHP;

    public MotorComponente(String nome, double potenciaHP) {
        this.nome = nome;
        this.potenciaHP = potenciaHP;
    }

    public String getNome() {
        return nome;
    }

    public double getPotenciaHP() {
        return potenciaHP;
    }

    @Override
    public void aceitar(VisitanteComponente visitante) {
        visitante.visitar(this);
    }
}

public class ChassiComponente implements ComponenteCarroVisitavel {
    private String material;
    private double pesoKg;

    public ChassiComponente(String material, double pesoKg) {
        this.material = material;
        this.pesoKg = pesoKg;
    }

    public String getMaterial() {
        return material;
    }

    public double getPesoKg() {
        return pesoKg;
    }

    @Override
    public void aceitar(VisitanteComponente visitante) {
        visitante.visitar(this);
    }
}

public class AsaComponente implements ComponenteCarroVisitavel {
    private String tipo;
    private double downforceN;

    public AsaComponente(String tipo, double downforceN) {
        this.tipo = tipo;
        this.downforceN = downforceN;
    }

    public String getTipo() {
        return tipo;
    }

    public double getDownforceN() {
        return downforceN;
    }

    @Override
    public void aceitar(VisitanteComponente visitante) {
        visitante.visitar(this);
    }
}

public class PneuComponente implements ComponenteCarroVisitavel {
    private String composto;
    private double desgastePercentual;

    public PneuComponente(String composto, double desgastePercentual) {
        this.composto = composto;
        this.desgastePercentual = desgastePercentual;
    }

    public String getComposto() {
        return composto;
    }

    public double getDesgastePercentual() {
        return desgastePercentual;
    }

    @Override
    public void aceitar(VisitanteComponente visitante) {
        visitante.visitar(this);
    }
}

// Visitante Concreto: Calculador de Peso Total
public class CalculadorPesoTotal implements VisitanteComponente {
    private double pesoTotal = 0.0;

    @Override
    public void visitar(MotorComponente motor) {
        pesoTotal += (motor.getPotenciaHP() / 10.0); // Exemplo: peso proporcional à potência
    }

    @Override
    public void visitar(ChassiComponente chassi) {
        pesoTotal += chassi.getPesoKg();
    }

    @Override
    public void visitar(AsaComponente asa) {
        pesoTotal += (asa.getDownforceN() / 1000.0); // Exemplo: peso proporcional ao downforce
    }

    @Override
    public void visitar(PneuComponente pneu) {
        pesoTotal += 10.0; // Peso fixo por pneu
    }

    public double getPesoTotal() {
        return pesoTotal;
    }
}

// Visitante Concreto: Gerador de Relatório de Manutenção
public class GeradorRelatorioManutencao implements VisitanteComponente {
    @Override
    public void visitar(MotorComponente motor) {
        System.out.println("Relatório Motor: Verificar " + motor.getNome() + ". Potência atual: " + motor.getPotenciaHP() + " HP.");
    }

    @Override
    public void visitar(ChassiComponente chassi) {
        System.out.println("Relatório Chassi: Inspecionar " + chassi.getMaterial() + " chassi. Peso: " + chassi.getPesoKg() + " kg.");
    }

    @Override
    public void visitar(AsaComponente asa) {
        System.out.println("Relatório Asa: Checar " + asa.getTipo() + " asa. Downforce: " + asa.getDownforceN() + " N.");
    }

    @Override
    public void visitar(PneuComponente pneu) {
        if (pneu.getDesgastePercentual() > 50) {
            System.out.println("Relatório Pneu: ATENÇÃO! Pneu " + pneu.getComposto() + " com " + pneu.getDesgastePercentual() + "% de desgaste. Sugerir troca.");
        } else {
            System.out.println("Relatório Pneu: Pneu " + pneu.getComposto() + " com " + pneu.getDesgastePercentual() + "% de desgaste. OK.");
        }
    }
}

// Exemplo de uso
public class AnaliseCarroF1Visitor {
    public static void main(String[] args) {
        List<ComponenteCarroVisitavel> componentes = new ArrayList<>();
        componentes.add(new MotorComponente("Mercedes-AMG F1 M15", 1000.0));
        componentes.add(new ChassiComponente("Fibra de Carbono", 200.0));
        componentes.add(new AsaComponente("Dianteira", 5000.0));
        componentes.add(new PneuComponente("Macio", 60.0));
        componentes.add(new PneuComponente("Médio", 30.0));

        System.out.println("--- Calculando Peso Total ---");
        CalculadorPesoTotal calculadorPeso = new CalculadorPesoTotal();
        for (ComponenteCarroVisitavel componente : componentes) {
            componente.aceitar(calculadorPeso);
        }
        System.out.println("Peso total estimado do carro: " + String.format("%.2f", calculadorPeso.getPesoTotal()) + " kg\n");

        System.out.println("--- Gerando Relatório de Manutenção ---");
        GeradorRelatorioManutencao geradorRelatorio = new GeradorRelatorioManutencao();
        for (ComponenteCarroVisitavel componente : componentes) {
            componente.aceitar(geradorRelatorio);
        }
    }
}
```

Neste exemplo, `ComponenteCarroVisitavel` é a interface que os elementos (componentes do carro) implementam. `MotorComponente`, `ChassiComponente`, `AsaComponente` e `PneuComponente` são os elementos concretos. `VisitanteComponente` é a interface Visitor, e `CalculadorPesoTotal` e `GeradorRelatorioManutencao` são os visitantes concretos. Cada visitante implementa a lógica para operar em cada tipo de componente. O padrão Visitor permite que novas operações (novos visitantes) sejam adicionadas à estrutura de objetos sem modificar as classes dos componentes. Isso é extremamente útil em sistemas complexos como o de um carro de F1, onde diferentes análises e relatórios podem ser necessários ao longo do tempo, e a estrutura dos componentes permanece relativamente estável [1].




## 7. Conclusão

Através deste artigo, exploramos a fundo os pilares da engenharia de software moderna – Programação Orientada a Objetos, Princípios SOLID e Design Patterns (Criacionais, Estruturais e Comportamentais) – contextualizando-os com exemplos práticos e didáticos inspirados no universo da Fórmula 1 e do automobilismo. A escolha da linguagem Java 21 e do framework Spring como base para os exemplos reforça a relevância dessas tecnologias no desenvolvimento de sistemas robustos e escaláveis, capazes de atender às demandas de alta performance e complexidade inerentes a um esporte como a F1.

Vimos como a **Orientação a Objetos** permite modelar o mundo real de forma intuitiva, encapsulando comportamentos e dados em entidades coesas, como um `CarroF1` ou um `Piloto`. Os **Princípios SOLID** emergiram como um guia essencial para a construção de software flexível, manutenível e extensível. A aplicação do SRP, OCP, LSP, ISP e DIP em cenários como sistemas de telemetria e gerenciamento de componentes do carro demonstra como esses princípios são cruciais para lidar com a constante evolução tecnológica e regulatória da Fórmula 1.

Os **Design Patterns**, por sua vez, revelaram-se soluções elegantes e comprovadas para problemas recorrentes no desenvolvimento de software. Os padrões Criacionais, como Factory Method e Builder, nos mostraram como gerenciar a complexidade da criação de objetos, permitindo a montagem de carros de F1 personalizados ou a produção de componentes específicos para cada temporada. Os padrões Estruturais, como Adapter e Composite, ilustraram como organizar classes e objetos em estruturas maiores e mais flexíveis, facilitando a integração de sistemas legados ou a representação hierárquica de componentes do carro. Finalmente, os padrões Comportamentais, como Observer e Strategy, demonstraram como otimizar a comunicação e a atribuição de responsabilidades entre objetos, permitindo o monitoramento em tempo real de dados de telemetria ou a adaptação dinâmica de estratégias de corrida.

Em um ambiente tão competitivo e tecnologicamente avançado como a Fórmula 1, a excelência em engenharia de software não é um luxo, mas uma necessidade. A capacidade de desenvolver sistemas que são não apenas funcionais, mas também adaptáveis, eficientes e fáceis de manter, é um diferencial que pode significar a vitória ou a derrota. Ao dominar e aplicar esses conceitos e padrões, os desenvolvedores podem construir soluções que impulsionam a inovação e o sucesso, tanto nas pistas quanto em qualquer domínio da engenharia de software.

Esperamos que este artigo tenha fornecido uma compreensão clara e prática desses conceitos fundamentais, inspirando você a aplicá-los em seus próprios projetos e a continuar explorando o vasto e fascinante mundo da engenharia de software.




## 8. Bibliografia

[1] Gamma, E., Helm, R., Johnson, R., & Vlissides, J. (1994). *Design Patterns: Elements of Reusable Object-Oriented Software*. Addison-Wesley.

[2] Refactoring.Guru. *Design Patterns*. Disponível em: [https://refactoring.guru/design-patterns](https://refactoring.guru/design-patterns)

[3] Martin, R. C. (2002). *Agile Software Development, Principles, Patterns, and Practices*. Prentice Hall.

[4] FreeCodeCamp. *Os princípios SOLID da Programação Orientada a Objetos explicados em bom português*. Disponível em: [https://www.freecodecamp.org/portuguese/news/os-principios-solid-da-programacao-orientada-a-objetos-explicados-em-bom-portugues/](https://www.freecodecamp.org/portuguese/news/os-principios-solid-da-programacao-orientada-a-objetos-explicados-em-bom-portugues/)

[5] Alura. *SOLID: o que é e quais os 5 princípios da Programação Orientada a Objetos*. Disponível em: [https://www.alura.com.br/artigos/solid](https://www.alura.com.br/artigos/solid)

[6] Deitel, P. J., & Deitel, H. M. (2018). *Java: How to Program, Early Objects*. Pearson.

[7] Casa do Código. *Livro de Orientação a Objetos e Java*. Disponível em: [https://www.casadocodigo.com.br/products/livro-orientacao-objetos-java](https://www.casadocodigo.com.br/products/livro-orientacao-objetos-java)

[8] FreeCodeCamp. *Princípios de programação orientada a objetos em Java*. Disponível em: [https://www.freecodecamp.org/portuguese/news/principios-de-programacao-orientada-a-objetos-em-java-conceitos-de-poo-para-iniciantes/](https://www.freecodecamp.org/portuguese/news/principios-de-programacao-orientada-a-objetos-em-java-conceitos-de-poo-para-iniciantes/)

[9] Spring Framework Documentation. Disponível em: [https://docs.spring.io/spring-framework/reference/index.html](https://docs.spring.io/spring-framework/reference/index.html)

[10] Oracle. *Java SE 21 Documentation*. Disponível em: [https://docs.oracle.com/en/java/javase/21/](https://docs.oracle.com/en/java/javase/21/)

[11] Fluidjobs. *Software Engineering in Formula 1: What Skills are in Demand?*. Disponível em: [https://fluidjobs.com/blog/software-engineering-in-formula-1-what-skills-are-in-demand-](https://fluidjobs.com/blog/software-engineering-in-formula-1-what-skills-are-in-demand-)

[12] ISD. *Java Development & Formula 1: what do they have in common?*. Disponível em: [https://isd-soft.com/business_blog/java-development-teams-and-formula-one-teams/](https://isd-soft.com/business_blog/java-development-teams-and-formula-one-teams/)

[13] Medium. *SOLID principles using some fun analogies with Vehicle Example*. Disponível em: [https://medium.com/@sonianand11/solid-principles-using-some-fun-analogies-with-vehicle-example-4218f7c92248](https://medium.com/@sonianand11/solid-principles-using-some-fun-analogies-with-vehicle-example-4218f7c92248)

[14] CodeProject. *Implementing a Motor Race Using the Strategy Pattern*. Disponível em: [https://www.codeproject.com/Articles/14319/Implementing-a-Motor-Race-Using-the-Strategy-Patte](https://www.codeproject.com/Articles/14319/Implementing-a-Motor-Race-Using-the-Strategy-Patte)





## 7. Domain-Driven Design (DDD) na Fórmula 1

### 7.1. O que é Domain-Driven Design?

O Domain-Driven Design (DDD) é uma abordagem de desenvolvimento de software que coloca o foco principal na compreensão e modelagem do domínio de negócio. Criado por Eric Evans e detalhado em seu livro seminal "Domain-Driven Design: Tackling Complexity in the Heart of Software" [1], o DDD propõe que, para construir sistemas complexos e eficazes, a equipe de desenvolvimento deve mergulhar profundamente no conhecimento do domínio, trabalhando em estreita colaboração com especialistas da área. Em vez de focar apenas na tecnologia, o DDD enfatiza a criação de um modelo de domínio rico e expressivo que reflita a realidade do negócio.

No contexto da Fórmula 1, onde a complexidade é inerente a cada aspecto – desde a aerodinâmica e a mecânica dos carros até as estratégias de corrida e a análise de dados em tempo real – o DDD se torna uma ferramenta poderosa. Um sistema de software para uma equipe de F1 não é apenas um conjunto de funcionalidades; ele precisa encapsular o conhecimento profundo sobre o desempenho do carro, as condições da pista, o comportamento dos pneus, as táticas dos pilotos e a dinâmica da corrida. O DDD ajuda a traduzir essa complexidade do mundo real em um modelo de software que é compreensível, manutenível e evolutivo.

A essência do DDD reside na ideia de que o software deve ser uma representação fiel do domínio. Isso significa que a linguagem usada no código, nas discussões da equipe e na documentação deve ser a mesma linguagem que os especialistas do domínio utilizam. Essa "Linguagem Ubíqua" (Ubiquitous Language) é um dos pilares do DDD e garante que não haja perda de significado ou interpretação errônea entre as partes interessadas. Para uma equipe de F1, isso significa que termos como "degradação do pneu", "janela de pit stop", "ERS deployment" ou "vácuo" devem ser refletidos diretamente no código e nos modelos de software, facilitando a comunicação e a precisão do sistema.

O DDD não é uma tecnologia específica ou um framework, mas sim um conjunto de princípios e padrões que guiam a arquitetura e o design de software. Ele é particularmente útil em domínios complexos, onde a lógica de negócio é rica e as regras mudam frequentemente, características marcantes do ambiente de alta performance da Fórmula 1. Ao adotar o DDD, as equipes de desenvolvimento podem criar sistemas que não apenas funcionam, mas que também são uma verdadeira extensão do conhecimento e da inteligência de seus domínios de negócio.



### 7.2. Blocos Construtivos do DDD

O DDD define uma série de blocos construtivos que ajudam a modelar o domínio de forma eficaz. Entender esses blocos é crucial para aplicar o DDD em um contexto tão dinâmico quanto o da Fórmula 1:

#### Entidades (Entities)

Entidades são objetos que possuem uma identidade única e contínua ao longo do tempo, independentemente de seus atributos. Elas são definidas por sua identidade, não por seus valores. No mundo da F1, exemplos de entidades seriam um `CarroDeCorrida` (com um chassi e número de identificação únicos), um `Piloto` (com um ID de licença e nome únicos) ou uma `PistaDeCorrida` (com um nome e layout únicos). Mesmo que os atributos de um carro (como a asa dianteira ou o motor) mudem, ele continua sendo o mesmo carro.

```java
// Exemplo de Entidade: CarroDeCorrida
@Entity
public class CarroDeCorrida {
    @Id
    private String chassiId;
    private String equipe;
    private int numeroCarro;
    private String modeloMotor;
    // ... outros atributos e métodos

    public CarroDeCorrida(String chassiId, String equipe, int numeroCarro, String modeloMotor) {
        this.chassiId = chassiId;
        this.equipe = equipe;
        this.numeroCarro = numeroCarro;
        this.modeloMotor = modeloMotor;
    }

    // Getters e Setters
    public String getChassiId() {
        return chassiId;
    }

    public void setChassiId(String chassiId) {
        this.chassiId = chassiId;
    }

    public String getEquipe() {
        return equipe;
    }

    public void setEquipe(String equipe) {
        this.equipe = equipe;
    }

    public int getNumeroCarro() {
        return numeroCarro;
    }

    public void setNumeroCarro(int numeroCarro) {
        this.numeroCarro = numeroCarro;
    }

    public String getModeloMotor() {
        return modeloMotor;
    }

    public void setModeloMotor(String modeloMotor) {
        this.modeloMotor = modeloMotor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarroDeCorrida that = (CarroDeCorrida) o;
        return chassiId.equals(that.chassiId);
    }

    @Override
    public int hashCode() {
        return chassiId.hashCode();
    }
}
```

#### Objetos de Valor (Value Objects)

Objetos de valor são objetos que não possuem uma identidade conceitual única; eles são definidos por seus atributos. Se dois objetos de valor têm os mesmos atributos, eles são considerados iguais. Eles são imutáveis e geralmente representam conceitos descritivos. Na F1, exemplos seriam `TempoDeVolta` (com milissegundos), `CondicaoPneu` (com temperatura e desgaste), `CoordenadaGPS` ou `EstrategiaPitStop`. Se um `TempoDeVolta` de 1:20.500 é registrado em dois momentos diferentes, eles representam o mesmo valor, mesmo que sejam instâncias distintas.

```java
// Exemplo de Objeto de Valor: TempoDeVolta
public class TempoDeVolta {
    private final long milissegundos;

    public TempoDeVolta(long milissegundos) {
        if (milissegundos < 0) {
            throw new IllegalArgumentException("Tempo de volta não pode ser negativo.");
        }
        this.milissegundos = milissegundos;
    }

    public long getMilissegundos() {
        return milissegundos;
    }

    // Métodos para formatação ou operações
    public String formatarTempo() {
        long minutos = milissegundos / 60000;
        long segundos = (milissegundos % 60000) / 1000;
        long ms = milissegundos % 1000;
        return String.format("%d:%02d.%03d", minutos, segundos, ms);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TempoDeVolta that = (TempoDeVolta) o;
        return milissegundos == that.milissegundos;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(milissegundos);
    }
}
```

#### Agregados (Aggregates)

Agregados são clusters de Entidades e Objetos de Valor que são tratados como uma única unidade para fins de consistência transacional. Cada agregado tem uma raiz (Aggregate Root), que é uma Entidade e a única forma de acessar os outros objetos dentro do agregado. A raiz garante a consistência de todo o agregado. Na F1, um `AgregadoCorrida` poderia ter `Corrida` como raiz, contendo `Voltas`, `EventosDePitStop` e `Classificacao`. Todas as operações que afetam esses objetos internos devem passar pela raiz `Corrida` para garantir que as regras de negócio sejam respeitadas.

```java
// Exemplo de Raiz de Agregado: Corrida
@Entity
public class Corrida {
    @Id
    private String id;
    private String nomePista;
    private LocalDate dataCorrida;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "corrida_id")
    private List<Volta> voltas = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "corrida_id")
    private List<PitStop> pitStops = new ArrayList<>();

    // Construtor, getters e setters
    public Corrida(String id, String nomePista, LocalDate dataCorrida) {
        this.id = id;
        this.nomePista = nomePista;
        this.dataCorrida = dataCorrida;
    }

    public void adicionarVolta(Volta volta) {
        this.voltas.add(volta);
    }

    public void adicionarPitStop(PitStop pitStop) {
        this.pitStops.add(pitStop);
    }

    // ... outros métodos de negócio que garantem a consistência do agregado
}

// Exemplo de Entidade dentro do Agregado: Volta
@Entity
public class Volta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int numeroVolta;
    @Embedded
    private TempoDeVolta tempo;
    private String pilotoId;
    private String carroId;

    // Construtor, getters e setters
    public Volta(int numeroVolta, TempoDeVolta tempo, String pilotoId, String carroId) {
        this.numeroVolta = numeroVolta;
        this.tempo = tempo;
        this.pilotoId = pilotoId;
        this.carroId = carroId;
    }
}

// Exemplo de Entidade dentro do Agregado: PitStop
@Entity
public class PitStop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pilotoId;
    private int numeroVolta;
    @Embedded
    private TempoDeVolta duracao;
    private String tipoPneuAntigo;
    private String tipoPneuNovo;

    // Construtor, getters e setters
    public PitStop(String pilotoId, int numeroVolta, TempoDeVolta duracao, String tipoPneuAntigo, String tipoPneuNovo) {
        this.pilotoId = pilotoId;
        this.numeroVolta = numeroVolta;
        this.duracao = duracao;
        this.tipoPneuAntigo = tipoPneuAntigo;
        this.tipoPneuNovo = tipoPneuNovo;
    }
}
```

#### Serviços de Domínio (Domain Services)

Serviços de Domínio são operações que não se encaixam naturalmente em uma Entidade ou Objeto de Valor. Eles geralmente coordenam o comportamento de múltiplos objetos de domínio. Em um sistema de F1, um `ServicoEstrategiaCorrida` poderia calcular a estratégia ideal de pit stop com base em dados de degradação de pneu, tráfego na pista e previsão do tempo, envolvendo `CarroDeCorrida`, `Pneu` e `Pista`. Outro exemplo seria um `ServicoDeClassificacao` que calcula a posição dos pilotos em tempo real durante a corrida.

```java
// Exemplo de Serviço de Domínio: ServicoEstrategiaCorrida
@Service
public class ServicoEstrategiaCorrida {

    public EstrategiaPitStop calcularEstrategiaIdeal(
            CarroDeCorrida carro,
            List<Pneu> pneusDisponiveis,
            PistaDeCorrida pista,
            CondicoesClimaticas condicoes
    ) {
        // Lógica complexa para calcular a estratégia ideal de pit stop
        // Envolve múltiplos objetos de domínio e regras de negócio
        System.out.println("Calculando estratégia ideal para o carro " + carro.getNumeroCarro());
        // ... simulação de cálculo
        return new EstrategiaPitStop("Medium", 25, 2);
    }
}

// Classes auxiliares para o exemplo
class Pneu { /* ... */ }
class PistaDeCorrida { /* ... */ }
class CondicoesClimaticas { /* ... */ }
class EstrategiaPitStop { /* ... */ }
```

#### Repositórios (Repositories)

Repositórios são objetos que fornecem uma interface para acessar e persistir Agregados. Eles abstraem os detalhes de armazenamento de dados, permitindo que o domínio se concentre na lógica de negócio. Para um sistema de F1, teríamos um `RepositorioCarroDeCorrida` para buscar e salvar carros, ou um `RepositorioCorrida` para gerenciar as corridas. Eles atuam como coleções de objetos de domínio na memória, mas com a capacidade de persistência.

```java
// Exemplo de Repositório: RepositorioCarroDeCorrida
@Repository
public interface RepositorioCarroDeCorrida extends JpaRepository<CarroDeCorrida, String> {
    // Métodos de busca específicos do domínio, se necessário
    Optional<CarroDeCorrida> findByEquipeAndNumeroCarro(String equipe, int numeroCarro);
}

// Exemplo de uso em um serviço
@Service
public class GerenciadorCarros {
    private final RepositorioCarroDeCorrida repositorioCarro;

    public GerenciadorCarros(RepositorioCarroDeCorrida repositorioCarro) {
        this.repositorioCarro = repositorioCarro;
    }

    public CarroDeCorrida registrarNovoCarro(String chassiId, String equipe, int numeroCarro, String modeloMotor) {
        CarroDeCorrida novoCarro = new CarroDeCorrida(chassiId, equipe, numeroCarro, modeloMotor);
        return repositorioCarro.save(novoCarro);
    }

    public Optional<CarroDeCorrida> buscarCarroPorEquipeENumero(String equipe, int numeroCarro) {
        return repositorioCarro.findByEquipeAndNumeroCarro(equipe, numeroCarro);
    }
}
```



### 7.3. Contextos Delimitados e Mapas de Contexto na F1

Em sistemas complexos, especialmente em um domínio tão vasto como o da Fórmula 1, é comum que diferentes partes do negócio tenham visões ligeiramente diferentes sobre os mesmos conceitos. Por exemplo, a equipe de engenharia de desempenho pode ter uma visão de "Carro" focada em telemetria e componentes, enquanto a equipe de logística pode ter uma visão de "Carro" focada em transporte e peças de reposição. O DDD aborda isso através dos **Contextos Delimitados (Bounded Contexts)**.

Um Contexto Delimitado é um limite lógico dentro do qual um modelo de domínio específico é definido e aplicado. Dentro de um contexto, os termos e conceitos têm um significado preciso e consistente. Fora desse contexto, o mesmo termo pode ter um significado diferente ou não existir. Isso evita a confusão e a sobrecarga de um único modelo de domínio tentando abranger todo o sistema.

Na Fórmula 1, poderíamos identificar vários Contextos Delimitados:

*   **Contexto de Telemetria e Desempenho:** Focado na coleta e análise de dados em tempo real do carro (velocidade, temperatura, pressão, etc.). O modelo de domínio aqui incluiria `Sensor`, `DadoTelemetrico`, `Volta`, `Setor`, `Pneu` (com foco em degradação e temperatura).
*   **Contexto de Estratégia de Corrida:** Lida com a tomada de decisões durante a corrida, como pit stops, gerenciamento de pneus e combustível. O modelo de domínio teria `EstrategiaPitStop`, `PrevisaoClimatica`, `DegradacaoPneu`, `TrafegoNaPista`.
*   **Contexto de Logística e Manutenção:** Gerencia o transporte de equipamentos, peças de reposição e a manutenção dos carros entre as corridas. O modelo de domínio aqui incluiria `Peca`, `Estoque`, `Envio`, `CronogramaManutencao`.
*   **Contexto de Regulamentação e Conformidade:** Garante que o carro e a equipe estejam em conformidade com as regras da FIA. O modelo de domínio teria `RegraTecnica`, `Inspecao`, `Penalidade`.

O relacionamento entre esses Contextos Delimitados é definido por **Mapas de Contexto (Context Maps)**. O Mapa de Contexto descreve como os diferentes contextos interagem e se integram. Isso é crucial para entender as dependências e garantir que as informações fluam corretamente entre as diferentes partes do sistema. Por exemplo, o Contexto de Telemetria pode fornecer dados de degradação de pneu para o Contexto de Estratégia de Corrida, que por sua vez pode influenciar as decisões de pit stop.

Um Mapa de Contexto pode ser visualizado como um diagrama que mostra os limites de cada contexto e os padrões de integração entre eles (e.g., Shared Kernel, Customer/Supplier, Conformist, Anti-Corruption Layer, Open Host Service, Published Language). A clareza desses limites e interações é vital para a saúde de um sistema de software complexo como o de uma equipe de F1, permitindo que diferentes equipes trabalhem em seus respectivos domínios sem pisar nos pés umas das outras ou criar inconsistências no modelo.



### 7.4. Linguagem Ubíqua no Desenvolvimento de Software para F1

A **Linguagem Ubíqua (Ubiquitous Language)** é um dos conceitos mais fundamentais e poderosos do Domain-Driven Design. Ela se refere a uma linguagem comum, compartilhada e consistentemente usada por todos os membros da equipe – desenvolvedores, especialistas de domínio, gerentes de projeto e qualquer outra parte interessada – para descrever o domínio de negócio. Essa linguagem deve ser usada tanto na comunicação verbal quanto na escrita, e, crucialmente, deve ser refletida diretamente no código-fonte do sistema.

No ambiente de alta pressão e precisão da Fórmula 1, a clareza na comunicação é vital. Erros de interpretação podem custar milissegundos preciosos na pista ou levar a decisões estratégicas equivocadas. A Linguagem Ubíqua atua como uma ponte entre o conhecimento tácito dos engenheiros de corrida, estrategistas e mecânicos e a representação formal desse conhecimento no software.

**Como a Linguagem Ubíqua se manifesta na F1:**

*   **Terminologia Consistente:** Termos como `DegradacaoPneu`, `JanelaPitStop`, `ERSDeployment`, `DRSAtivado`, `SetorRapido` devem ser usados de forma consistente por todos. Se um engenheiro de pneus fala sobre a "degradação do pneu", o código deve ter uma classe ou um atributo chamado `DegradacaoPneu`, e não `DesgasteBorracha` ou `EstadoPneu`.
*   **Modelagem de Domínio:** A Linguagem Ubíqua influencia diretamente a forma como o modelo de domínio é construído. Os nomes de classes, métodos, variáveis e pacotes devem espelhar os termos do domínio. Por exemplo, em vez de um método genérico `calculate`, teríamos `calcularEstrategiaPitStop` ou `monitorarDesempenhoMotor`.
*   **Comunicação Eficaz:** Facilita a comunicação entre desenvolvedores e especialistas de domínio. Quando um estrategista de corrida descreve um cenário de "safety car" e suas implicações na "janela de pit stop", os desenvolvedores podem traduzir isso diretamente para o código, pois já estão familiarizados com esses termos e como eles se encaixam no modelo.
*   **Redução de Ambiguidade:** Ajuda a eliminar ambiguidades. Se um termo tem múltiplos significados em diferentes contextos, a Linguagem Ubíqua força a equipe a esclarecer e, se necessário, a definir Contextos Delimitados separados para cada significado.

**Exemplo prático:**

Considere o conceito de "volta" em um sistema de Fórmula 1. Para um engenheiro de desempenho, uma "volta" pode ser um `VoltaDeCorrida` com `TempoDeVolta`, `VelocidadeMaxima`, `DadosDeTelemetria`. Para um estrategista, pode ser uma `VoltaEstrategica` que inclui `ConsumoCombustivel` e `DegradacaoPneu`. A Linguagem Ubíqua garante que, ao discutir ou codificar sobre "voltas", todos saibam exatamente a qual tipo de volta estão se referindo, evitando mal-entendidos.

```java
// Linguagem Ubíqua refletida no código

// Entidade que representa uma volta de corrida com seus dados de telemetria
public class VoltaDeCorrida {
    private int numeroVolta;
    private TempoDeVolta tempo;
    private double velocidadeMaxima;
    private Map<String, Double> dadosTelemetria;

    // Construtor e métodos
}

// Objeto de Valor que representa o tempo de uma volta
public class TempoDeVolta {
    private long milissegundos;

    // Construtor e métodos
}

// Serviço de domínio para calcular a estratégia de pit stop
public class ServicoEstrategiaPitStop {
    public EstrategiaPitStop determinarEstrategia(List<VoltaDeCorrida> voltasAnteriores, CondicaoPneu condicaoAtual) {
        // Lógica de negócio usando termos da Linguagem Ubíqua
        // ...
        return new EstrategiaPitStop();
    }
}

// Enum para tipos de pneu, refletindo a linguagem da F1
public enum TipoPneu {
    MACIO, MEDIO, DURO, INTERMEDIARIO, CHUVA
}

// Entidade que representa um pit stop
public class PitStop {
    private Piloto piloto;
    private int voltaDoPitStop;
    private TempoDeVolta duracaoPitStop;
    private TipoPneu pneuAntigo;
    private TipoPneu pneuNovo;

    // Construtor e métodos
}
```

Ao manter uma Linguagem Ubíqua rigorosa, as equipes de desenvolvimento de software para Fórmula 1 podem garantir que o sistema construído seja uma representação precisa e funcional do complexo domínio de corrida, facilitando a colaboração e a evolução do software em um ambiente de constante inovação.



### 7.5. Aplicação Prática do DDD em um Sistema de Telemetria de F1 com Java e Spring

Para ilustrar a aplicação prática do Domain-Driven Design em um cenário de Fórmula 1, vamos considerar um sistema de telemetria. Este sistema é crucial para as equipes, pois coleta e processa dados em tempo real dos carros durante as sessões de pista, permitindo que engenheiros e estrategistas tomem decisões informadas. Usaremos Java 21 e Spring Boot para os exemplos de código.

**Cenário:** Um sistema de telemetria que coleta dados de sensores do carro, processa-os e os disponibiliza para análise em tempo real e pós-sessão.

#### Modelagem do Domínio com DDD

**1. Entidades e Objetos de Valor:**

*   **`CarroDeCorrida` (Entidade):** Representa o carro físico, com sua identidade única (chassi, número). Possui uma coleção de sensores.
*   **`Sensor` (Entidade):** Representa um sensor específico no carro (e.g., sensor de velocidade, temperatura do pneu). Tem um ID único e um tipo.
*   **`DadoTelemetrico` (Objeto de Valor):** Representa um ponto de dado coletado por um sensor em um determinado instante. Contém o valor, a unidade e o timestamp. Sua igualdade é baseada em seus atributos.
*   **`TempoDeVolta` (Objeto de Valor):** Já definido anteriormente, representa a duração de uma volta.
*   **`PosicaoGPS` (Objeto de Valor):** Latitude e longitude do carro na pista.

**2. Agregados:**

*   **`SessaoDePista` (Aggregate Root):** Representa uma sessão de treinos, qualificação ou corrida. É a raiz do agregado e gerencia a coleção de `VoltaDeCorrida` e `DadosTelemetricosBrutos` associados a essa sessão. A consistência de uma sessão (e.g., a ordem das voltas, a integridade dos dados) é garantida por esta raiz.

```java
// SessaoDePista.java (Aggregate Root)
package com.f1.telemetria.domain.model.sessao;

import com.f1.telemetria.domain.model.carro.CarroDeCorrida;
import com.f1.telemetria.domain.model.pista.PistaDeCorrida;
import com.f1.telemetria.domain.model.telemetria.DadoTelemetricoBruto;
import com.f1.telemetria.domain.model.volta.VoltaDeCorrida;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class SessaoDePista {

    @Id
    private String id;
    private String tipoSessao; // Ex: TREINO_LIVRE, QUALIFICACAO, CORRIDA
    private LocalDateTime inicioSessao;
    private LocalDateTime fimSessao;

    @ManyToOne
    @JoinColumn(name = "carro_id")
    private CarroDeCorrida carro;

    @ManyToOne
    @JoinColumn(name = "pista_id")
    private PistaDeCorrida pista;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "sessao_id")
    private List<VoltaDeCorrida> voltas = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "sessao_id")
    private List<DadoTelemetricoBruto> dadosTelemetricosBrutos = new ArrayList<>();

    // Construtor vazio para JPA
    protected SessaoDePista() {}

    public SessaoDePista(String tipoSessao, CarroDeCorrida carro, PistaDeCorrida pista) {
        this.id = UUID.randomUUID().toString();
        this.tipoSessao = tipoSessao;
        this.inicioSessao = LocalDateTime.now();
        this.carro = carro;
        this.pista = pista;
    }

    public void adicionarVolta(VoltaDeCorrida volta) {
        if (!this.voltas.contains(volta)) {
            this.voltas.add(volta);
        }
    }

    public void adicionarDadoTelemetricoBruto(DadoTelemetricoBruto dado) {
        this.dadosTelemetricosBrutos.add(dado);
    }

    public void finalizarSessao() {
        this.fimSessao = LocalDateTime.now();
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getTipoSessao() {
        return tipoSessao;
    }

    public LocalDateTime getInicioSessao() {
        return inicioSessao;
    }

    public LocalDateTime getFimSessao() {
        return fimSessao;
    }

    public CarroDeCorrida getCarro() {
        return carro;
    }

    public PistaDeCorrida getPista() {
        return pista;
    }

    public List<VoltaDeCorrida> getVoltas() {
        return voltas;
    }

    public List<DadoTelemetricoBruto> getDadosTelemetricosBrutos() {
        return dadosTelemetricosBrutos;
    }
}

// VoltaDeCorrida.java (Entidade dentro do Agregado SessaoDePista)
package com.f1.telemetria.domain.model.volta;

import com.f1.telemetria.domain.model.telemetria.TempoDeVolta;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class VoltaDeCorrida {

    @Id
    private String id;
    private int numeroVolta;
    private LocalDateTime inicioVolta;
    private LocalDateTime fimVolta;

    @Embedded
    private TempoDeVolta tempo;

    // Construtor vazio para JPA
    protected VoltaDeCorrida() {}

    public VoltaDeCorrida(int numeroVolta, LocalDateTime inicioVolta) {
        this.id = UUID.randomUUID().toString();
        this.numeroVolta = numeroVolta;
        this.inicioVolta = inicioVolta;
    }

    public void setTempo(TempoDeVolta tempo) {
        this.tempo = tempo;
        this.fimVolta = inicioVolta.plusNanos(tempo.getMilissegundos() * 1_000_000); // Exemplo simples
    }

    // Getters
    public String getId() {
        return id;
    }

    public int getNumeroVolta() {
        return numeroVolta;
    }

    public LocalDateTime getInicioVolta() {
        return inicioVolta;
    }

    public LocalDateTime getFimVolta() {
        return fimVolta;
    }

    public TempoDeVolta getTempo() {
        return tempo;
    }
}

// DadoTelemetricoBruto.java (Entidade dentro do Agregado SessaoDePista)
package com.f1.telemetria.domain.model.telemetria;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class DadoTelemetricoBruto {

    @Id
    private String id;
    private String tipoSensor;
    private double valor;
    private String unidade;
    private LocalDateTime timestamp;

    // Construtor vazio para JPA
    protected DadoTelemetricoBruto() {}

    public DadoTelemetricoBruto(String tipoSensor, double valor, String unidade, LocalDateTime timestamp) {
        this.id = UUID.randomUUID().toString();
        this.tipoSensor = tipoSensor;
        this.valor = valor;
        this.unidade = unidade;
        this.timestamp = timestamp;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getTipoSensor() {
        return tipoSensor;
    }

    public double getValor() {
        return valor;
    }

    public String getUnidade() {
        return unidade;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}

// CarroDeCorrida.java (Entidade)
package com.f1.telemetria.domain.model.carro;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.Objects;

@Entity
public class CarroDeCorrida {
    @Id
    private String chassiId;
    private String equipe;
    private int numeroCarro;
    private String modeloMotor;

    protected CarroDeCorrida() {}

    public CarroDeCorrida(String chassiId, String equipe, int numeroCarro, String modeloMotor) {
        this.chassiId = chassiId;
        this.equipe = equipe;
        this.numeroCarro = numeroCarro;
        this.modeloMotor = modeloMotor;
    }

    public String getChassiId() {
        return chassiId;
    }

    public String getEquipe() {
        return equipe;
    }

    public int getNumeroCarro() {
        return numeroCarro;
    }

    public String getModeloMotor() {
        return modeloMotor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarroDeCorrida that = (CarroDeCorrida) o;
        return Objects.equals(chassiId, that.chassiId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chassiId);
    }
}

// PistaDeCorrida.java (Entidade)
package com.f1.telemetria.domain.model.pista;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.Objects;

@Entity
public class PistaDeCorrida {
    @Id
    private String id;
    private String nome;
    private String localizacao;
    private double comprimentoKm;

    protected PistaDeCorrida() {}

    public PistaDeCorrida(String id, String nome, String localizacao, double comprimentoKm) {
        this.id = id;
        this.nome = nome;
        this.localizacao = localizacao;
        this.comprimentoKm = comprimentoKm;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public double getComprimentoKm() {
        return comprimentoKm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PistaDeCorrida that = (PistaDeCorrida) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

// TempoDeVolta.java (Objeto de Valor - reuso do exemplo anterior)
package com.f1.telemetria.domain.model.telemetria;

import jakarta.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class TempoDeVolta {
    private long milissegundos;

    protected TempoDeVolta() {}

    public TempoDeVolta(long milissegundos) {
        if (milissegundos < 0) {
            throw new IllegalArgumentException("Tempo de volta não pode ser negativo.");
        }
        this.milissegundos = milissegundos;
    }

    public long getMilissegundos() {
        return milissegundos;
    }

    public String formatarTempo() {
        long minutos = milissegundos / 60000;
        long segundos = (milissegundos % 60000) / 1000;
        long ms = milissegundos % 1000;
        return String.format("%d:%02d.%03d", minutos, segundos, ms);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TempoDeVolta that = (TempoDeVolta) o;
        return milissegundos == that.milissegundos;
    }

    @Override
    public int hashCode() {
        return Objects.hash(milissegundos);
    }
}

// PosicaoGPS.java (Objeto de Valor)
package com.f1.telemetria.domain.model.telemetria;

import jakarta.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class PosicaoGPS {
    private double latitude;
    private double longitude;

    protected PosicaoGPS() {}

    public PosicaoGPS(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PosicaoGPS that = (PosicaoGPS) o;
        return Double.compare(that.latitude, latitude) == 0 && Double.compare(that.longitude, longitude) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(latitude, longitude);
    }
}
```

**3. Repositórios:**

Os repositórios fornecem a abstração para persistir e recuperar os agregados. Usaremos Spring Data JPA para facilitar a implementação.

```java
// SessaoDePistaRepository.java
package com.f1.telemetria.domain.repository;

import com.f1.telemetria.domain.model.sessao.SessaoDePista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SessaoDePistaRepository extends JpaRepository<SessaoDePista, String> {
    List<SessaoDePista> findByCarro_ChassiId(String chassiId);
    Optional<SessaoDePista> findByIdAndCarro_ChassiId(String sessaoId, String chassiId);
}
```

**4. Serviços de Domínio:**

Operações que não pertencem a uma entidade ou objeto de valor específico, mas coordenam o comportamento de múltiplos objetos de domínio.

*   **`ServicoProcessamentoTelemetria`:** Responsável por receber dados brutos e enriquecê-los, talvez calculando a velocidade instantânea a partir de dados de roda, ou a degradação do pneu.
*   **`ServicoAnaliseVolta`:** Calcula métricas de desempenho para uma volta, como tempo de setor, velocidade média, etc.

```java
// ServicoProcessamentoTelemetria.java (Domain Service)
package com.f1.telemetria.domain.service;

import com.f1.telemetria.domain.model.sessao.SessaoDePista;
import com.f1.telemetria.domain.model.telemetria.DadoTelemetricoBruto;
import com.f1.telemetria.domain.model.telemetria.DadoTelemetricoProcessado;
import com.f1.telemetria.domain.model.telemetria.PosicaoGPS;
import com.f1.telemetria.domain.model.telemetria.TempoDeVolta;
import com.f1.telemetria.domain.repository.SessaoDePistaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ServicoProcessamentoTelemetria {

    private final SessaoDePistaRepository sessaoDePistaRepository;

    public ServicoProcessamentoTelemetria(SessaoDePistaRepository sessaoDePistaRepository) {
        this.sessaoDePistaRepository = sessaoDePistaRepository;
    }

    @Transactional
    public SessaoDePista processarNovosDados(String sessaoId, List<DadoTelemetricoBruto> novosDados) {
        SessaoDePista sessao = sessaoDePistaRepository.findById(sessaoId)
                .orElseThrow(() -> new IllegalArgumentException("Sessão de pista não encontrada."));

        for (DadoTelemetricoBruto dadoBruto : novosDados) {
            sessao.adicionarDadoTelemetricoBruto(dadoBruto);
            // Lógica para processar o dado bruto e gerar dados processados
            // Ex: calcular velocidade a partir de RPM da roda, ou consumo de combustível
            DadoTelemetricoProcessado dadoProcessado = new DadoTelemetricoProcessado(
                    dadoBruto.getTipoSensor() + "_PROCESSADO",
                    dadoBruto.getValor() * 1.2, // Exemplo de processamento
                    dadoBruto.getUnidade(),
                    dadoBruto.getTimestamp()
            );
            // sessao.adicionarDadoTelemetricoProcessado(dadoProcessado); // Se houver uma lista de processados no agregado
        }
        return sessaoDePistaRepository.save(sessao);
    }

    @Transactional
    public SessaoDePista registrarTempoDeVolta(String sessaoId, int numeroVolta, long milissegundos) {
        SessaoDePista sessao = sessaoDePistaRepository.findById(sessaoId)
                .orElseThrow(() -> new IllegalArgumentException("Sessão de pista não encontrada."));

        Optional<VoltaDeCorrida> voltaOptional = sessao.getVoltas().stream()
                .filter(v -> v.getNumeroVolta() == numeroVolta)
                .findFirst();

        if (voltaOptional.isPresent()) {
            voltaOptional.get().setTempo(new TempoDeVolta(milissegundos));
        } else {
            // Cria uma nova volta se não existir (ou lança exceção, dependendo da regra de negócio)
            VoltaDeCorrida novaVolta = new VoltaDeCorrida(numeroVolta, LocalDateTime.now().minus(Duration.ofMillis(milissegundos)));
            novaVolta.setTempo(new TempoDeVolta(milissegundos));
            sessao.adicionarVolta(novaVolta);
        }
        return sessaoDePistaRepository.save(sessao);
    }
}

// DadoTelemetricoProcessado.java (Objeto de Valor ou Entidade, dependendo do contexto)
package com.f1.telemetria.domain.model.telemetria;

import jakarta.persistence.Embeddable;
import java.time.LocalDateTime;
import java.util.Objects;

// Exemplo simplificado, pode ser uma Entidade se tiver identidade própria
@Embeddable
public class DadoTelemetricoProcessado {
    private String tipoDado;
    private double valor;
    private String unidade;
    private LocalDateTime timestamp;

    protected DadoTelemetricoProcessado() {}

    public DadoTelemetricoProcessado(String tipoDado, double valor, String unidade, LocalDateTime timestamp) {
        this.tipoDado = tipoDado;
        this.valor = valor;
        this.unidade = unidade;
        this.timestamp = timestamp;
    }

    public String getTipoDado() {
        return tipoDado;
    }

    public double getValor() {
        return valor;
    }

    public String getUnidade() {
        return unidade;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DadoTelemetricoProcessado that = (DadoTelemetricoProcessado) o;
        return Double.compare(that.valor, valor) == 0 &&
               Objects.equals(tipoDado, that.tipoDado) &&
               Objects.equals(unidade, that.unidade) &&
               Objects.equals(timestamp, that.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipoDado, valor, unidade, timestamp);
    }
}
```

**5. Linguagem Ubíqua em Ação:**

No código acima, termos como `SessaoDePista`, `VoltaDeCorrida`, `DadoTelemetricoBruto`, `TempoDeVolta`, `CarroDeCorrida`, `PistaDeCorrida` são diretamente extraídos da linguagem do domínio da Fórmula 1. Isso torna o código mais legível para especialistas de domínio e garante que a lógica de negócio esteja alinhada com a compreensão do negócio.

#### Benefícios do DDD no Sistema de Telemetria

*   **Clareza do Domínio:** O modelo de domínio reflete diretamente a complexidade e as nuances da telemetria de F1, tornando o sistema mais compreensível e alinhado com as necessidades dos engenheiros.
*   **Manutenibilidade:** A separação clara entre a lógica de domínio e a infraestrutura (persistência, UI) facilita a manutenção e a evolução do sistema. Mudanças nas regras de negócio da telemetria afetam principalmente o domínio, não a camada de dados.
*   **Consistência:** O uso de Agregados (como `SessaoDePista`) garante que as operações que modificam o estado da sessão (adicionar voltas, dados) mantenham a consistência do agregado como um todo.
*   **Colaboração:** A Linguagem Ubíqua promove uma comunicação mais eficaz entre desenvolvedores e especialistas de domínio, reduzindo mal-entendidos e acelerando o desenvolvimento.
*   **Flexibilidade:** Com Contextos Delimitados, diferentes partes do sistema de telemetria (e.g., coleta de dados, análise em tempo real, relatórios pós-sessão) podem evoluir independentemente, usando modelos de domínio otimizados para suas necessidades específicas, mas integrados através de Mapas de Contexto bem definidos.

Em resumo, a aplicação do Domain-Driven Design em um sistema de telemetria de Fórmula 1 permite construir uma solução robusta, escalável e, o mais importante, que realmente entende e modela o coração do negócio: os dados e eventos que definem o desempenho de um carro de corrida em sua busca pela vitória.



## 8. Conclusão

Com a inclusão do Domain-Driven Design (DDD), este artigo se aprofunda ainda mais na complexidade e sofisticação do desenvolvimento de software para domínios de alta performance, como o automobilismo e a Fórmula 1. A combinação de Orientação a Objetos, Princípios SOLID, Design Patterns e DDD oferece uma base robusta para a criação de sistemas resilientes, escaláveis e de fácil manutenção, capazes de lidar com os desafios inerentes a um ambiente tão dinâmico e exigente. A aplicação desses conceitos, ilustrada por exemplos do universo da F1, demonstra como a teoria se traduz em soluções práticas e eficientes, impulsionando a inovação e o sucesso nas pistas e fora delas.




## 9. Bibliografia

[1] Gamma, E., Helm, R., Johnson, R., & Vlissides, J. (1994). *Design Patterns: Elements of Reusable Object-Oriented Software*. Addison-Wesley.
[2] Refactoring.Guru. *Design Patterns*. Disponível em: https://refactoring.guru/design-patterns
[3] Martin, R. C. (2002). *Agile Software Development, Principles, Patterns, and Practices*. Prentice Hall.
[4] FreeCodeCamp. *Os princípios SOLID da Programação Orientada a Objetos explicados em bom português*. Disponível em: https://www.freecodecamp.org/portuguese/news/os-principios-solid-da-programacao-orientada-a-objetos-explicados-em-bom-portugues/
[5] Alura. *SOLID: o que é e quais os 5 princípios da Programação Orientada a Objetos*. Disponível em: https://www.alura.com.br/artigos/solid
[6] Deitel, P. J., & Deitel, H. M. (2018). *Java: How to Program, Early Objects*. Pearson.
[7] Casa do Código. *Livro de Orientação a Objetos e Java*. Disponível em: https://www.casadocodigo.com.br/products/livro-orientacao-objetos-java
[8] FreeCodeCamp. *Princípios de programação orientada a objetos em Java*. Disponível em: https://www.freecodecamp.org/portuguese/news/principios-de-programacao-orientada-a-objetos-em-java-conceitos-de-poo-para-iniciantes/
[9] Spring Framework Documentation. Disponível em: https://docs.spring.io/spring-framework/reference/index.html
[10] Oracle. *Java SE 21 Documentation*. Disponível em: https://docs.oracle.com/en/java/javase/21/
[11] Fluidjobs. *Software Engineering in Formula 1: What Skills are in Demand?*. Disponível em: https://fluidjobs.com/blog/software-engineering-in-formula-1-what-skills-are-in-demand-
[12] ISD. *Java Development & Formula 1: what do they have in common?*. Disponível em: https://isd-soft.com/business_blog/java-development-teams-and-formula-one-teams/
[13] Medium. *SOLID principles using some fun analogies with Vehicle Example*. Disponível em: https://medium.com/@sonianand11/solid-principles-using-some-fun-analogies-with-vehicle-example-4218f7c92248
[14] CodeProject. *Implementing a Motor Race Using the Strategy Pattern*. Disponível em: https://www.codeproject.com/Articles/14319/Implementing-a-Motor-Race-Using-the-Strategy-Patte
[15] Evans, E. (2003). *Domain-Driven Design: Tackling Complexity in the Heart of Software*. Addison-Wesley Professional.
[16] Vernon, V. (2013). *Implementing Domain-Driven Design*. Addison-Wesley Professional.


