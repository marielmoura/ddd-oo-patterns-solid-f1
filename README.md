# Desvendando a Engenharia de Software na Fórmula 1: Design Patterns, SOLID e Orientação a Objetos com Java 21 e Spring

## Sumário

1. [Introdução](#introducao)
2. [Programação Orientada a Objetos (POO) em Java](1-poo-java.md)
3. [Princípios SOLID com Java e Spring](2-solid.md)
4. [Design Patterns Criacionais com Java e Spring](3-design-patterns-criacionais.md)
5. [Design Patterns Estruturais com Java e Spring](4-design-patterns-estruturais.md)
6. [Design Patterns Comportamentais com Java e Spring](5-design-patterns-comportamentais.md)
7. [Domain-Driven Design (DDD) na Fórmula 1](6-ddd-f1.md)
8. [Conclusão](7-conclusao-bibliografia.md)
9. [Bibliografia](7-conclusao-bibliografia.md)

## Estrutura por Padrões e DDD (catálogo de exemplos)

- Padrões Criacionais:
	- [Factory Method](padroes-criacionais/factory-method/README.md) — [Exemplo Java](padroes-criacionais/factory-method/ExemploFactoryMethod.java)
	- [Abstract Factory](padroes-criacionais/abstract-factory/README.md) — [Exemplo Java](padroes-criacionais/abstract-factory/ExemploAbstractFactory.java)
	- [Builder](padroes-criacionais/builder/README.md) — [Exemplo Java](padroes-criacionais/builder/ExemploBuilder.java)
	- [Prototype](padroes-criacionais/prototype/README.md) — [Exemplo Java](padroes-criacionais/prototype/ExemploPrototype.java)
	- [Singleton](padroes-criacionais/singleton/README.md) — [Exemplo Java](padroes-criacionais/singleton/ExemploSingleton.java)
	- [Object Pool](padroes-criacionais/object-pool/README.md) — [Exemplo Java](padroes-criacionais/object-pool/ExemploObjectPool.java)

- Padrões Estruturais:
	- [Adapter](padroes-estruturais/adapter/README.md) — [Exemplo Java](padroes-estruturais/adapter/ExemploAdapter.java)
	- [Bridge](padroes-estruturais/bridge/README.md) — [Exemplo Java](padroes-estruturais/bridge/ExemploBridge.java)
	- [Composite](padroes-estruturais/composite/README.md) — [Exemplo Java](padroes-estruturais/composite/ExemploComposite.java)
	- [Decorator](padroes-estruturais/decorator/README.md) — [Exemplo Java](padroes-estruturais/decorator/ExemploDecorator.java)
	- [Facade](padroes-estruturais/facade/README.md) — [Exemplo Java](padroes-estruturais/facade/ExemploFacade.java)
	- [Flyweight](padroes-estruturais/flyweight/README.md) — [Exemplo Java](padroes-estruturais/flyweight/ExemploFlyweight.java)
	- [Proxy](padroes-estruturais/proxy/README.md) — [Exemplo Java](padroes-estruturais/proxy/ExemploProxy.java)
	- [Null Object](padroes-estruturais/null-object/README.md) — [Exemplo Java](padroes-estruturais/null-object/ExemploNullObject.java)

- Padrões Comportamentais:
	- [Chain of Responsibility](padroes-comportamentais/chain-of-responsibility/README.md) — [Exemplo Java](padroes-comportamentais/chain-of-responsibility/ExemploChainOfResponsibility.java)
	- [Command](padroes-comportamentais/command/README.md) — [Exemplo Java](padroes-comportamentais/command/ExemploCommand.java)
	- [Iterator](padroes-comportamentais/iterator/README.md) — [Exemplo Java](padroes-comportamentais/iterator/ExemploIterator.java)
	- [Mediator](padroes-comportamentais/mediator/README.md) — [Exemplo Java](padroes-comportamentais/mediator/ExemploMediator.java)
	- [Memento](padroes-comportamentais/memento/README.md) — [Exemplo Java](padroes-comportamentais/memento/ExemploMemento.java)
	- [Observer](padroes-comportamentais/observer/README.md) — [Exemplo Java](padroes-comportamentais/observer/ExemploObserver.java)
	- [State](padroes-comportamentais/state/README.md) — [Exemplo Java](padroes-comportamentais/state/ExemploState.java)
	- [Strategy](padroes-comportamentais/strategy/README.md) — [Exemplo Java](padroes-comportamentais/strategy/ExemploStrategy.java)
	- [Template Method](padroes-comportamentais/template-method/README.md) — [Exemplo Java](padroes-comportamentais/template-method/ExemploTemplateMethod.java)
	- [Visitor](padroes-comportamentais/visitor/README.md) — [Exemplo Java](padroes-comportamentais/visitor/ExemploVisitor.java)
	- [Interpreter](padroes-comportamentais/interpreter/README.md) — [Exemplo Java](padroes-comportamentais/interpreter/ExemploInterpreter.java)

- Padrões de Integração:
	- [Circuit Breaker](padroes-integracao/circuit-breaker/README.md) — [Exemplo Java](padroes-integracao/circuit-breaker/ExemploCircuitBreaker.java)
	- [Saga](padroes-integracao/saga/README.md) — [Exemplo Java](padroes-integracao/saga/ExemploSaga.java)
	- [API Gateway](padroes-integracao/api-gateway/README.md) — [Exemplo Java](padroes-integracao/api-gateway/ExemploApiGateway.java)
	- [Arquitetura Orientada a Eventos](padroes-integracao/event-driven/README.md)
	- [Retry](padroes-integracao/retry/README.md) — [Exemplo Java](padroes-integracao/retry/ExemploRetry.java)

- Padrões DDD:
	- [Especificação (Specification Pattern)](ddd-padroes/especificacao/README.md) — [Exemplo Java](ddd-padroes/especificacao/ExemploEspecificacao.java)
	- [Serviço de Domínio](ddd-padroes/servico-de-dominio/README.md) — [Exemplo Java](ddd-padroes/servico-de-dominio/ExemploServicoDominio.java)
	- [Evento de Domínio](ddd-padroes/evento-de-dominio/README.md) — [Exemplo Java](ddd-padroes/evento-de-dominio/ExemploEventoDominio.java)
	- [Repositório do Domínio](ddd-padroes/repositorio/README.md) — [Exemplo Java](ddd-padroes/repositorio/ExemploRepositorio.java)

- Extras e Idiomáticos:
	- Null Object (evitar condicionais de null) — exemplos ao longo dos capítulos.
	- DTO e mapeamento entre camadas (Aplicação/Interface) quando necessário.
	- Interpreter (GoF) — menos comum no domínio, citado para completar a lista dos 23 padrões.

## Introdução

No mundo da engenharia de software, a busca por sistemas robustos, flexíveis e de fácil manutenção é constante. Para alcançar esses objetivos, desenvolvedores e arquitetos de software se apoiam em pilares fundamentais como a Programação Orientada a Objetos (POO), os Princípios SOLID e os Design Patterns. Estes conceitos, embora teóricos, encontram sua aplicação prática em diversos domínios, e um dos mais fascinantes e exigentes é o automobilismo de alta performance, em particular a Fórmula 1.

Este artigo se propõe a desmistificar esses conceitos, apresentando-os de forma didática e contextualizada. Utilizaremos a linguagem Java 21 e o framework Spring como base para nossos exemplos de código, demonstrando como a teoria se traduz em soluções elegantes e eficientes. O diferencial será a aplicação desses conceitos em cenários inspirados no universo da Fórmula 1, desde a telemetria de carros de corrida até a gestão de estratégias de pit stop, proporcionando uma compreensão mais intuitiva e envolvente. Ao final, o leitor terá uma visão clara de como esses princípios e padrões podem ser aplicados para construir software de alta qualidade, mesmo em ambientes tão dinâmicos e críticos quanto o automobilismo de elite.


## Leituras complementares

- [Service Locator vs Injeção de Dependências (DI)](docs/service-locator-vs-di.md)
- [DTO e Mapeamento entre Camadas](docs/dto-e-mapeamento.md)
- [Testes e Builders](docs/testes-e-builders.md)

## Prompts (geração acelerada)

Para criar rapidamente agregados, VOs, eventos, serviços e casos de uso alinhados ao estilo do repo, consulte o catálogo:

- [.github/prompts/README.md](.github/prompts/README.md)


## Scripts úteis

- Compilar todos os exemplos Java de uma vez (por diretório):

```
bash scripts/compilar_todos.sh
```

- Rodar smoke-tests (executa cada Exemplo*.java e captura a saída por arquivo):

```
bash scripts/rodar_todos.sh
```

Os logs ficam em `scripts/smoke-logs/` e o resumo em `scripts/smoke-summary.txt`.

- Limpar artefatos de build (.class):

```
bash scripts/limpar_build.sh
```


