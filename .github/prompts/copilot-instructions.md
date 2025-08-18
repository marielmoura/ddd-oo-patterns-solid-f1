# Instruções de Padrões do Repositório

Diretrizes para geração de código, exemplos e documentação neste repositório (domínio F1), garantindo consistência, qualidade e alinhamento a DDD e SOLID.

## 1) Linguagem, Nomeação e Estilo

### 1.1 Princípios
- Consistência > preferência individual.
- DDD: termos de negócio (linguagem ubíqua) podem ficar na Português Brasileiro (sem acentos).
- Interoperabilidade: contratos externos (APIs, DB, eventos de integração) em inglês.
- Sem acentos/ç em identificadores (código, pacotes, DB).

### 1.2 Decisão por categoria

| Categoria                                | Idioma recomendado | Observações                                                                                   |
|------------------------------------------|--------------------|-----------------------------------------------------------------------------------------------|
| UI / e-mails / PDFs / push               | Português Brasileiro      | Usar i18n (mensagens externas via catálogo).                                                  |
| Mensagens de erro ao usuário             | Português Brasileiro      | Texto traduzido via i18n; códigos de erro em inglês e estáveis.                               |
| Código – domínio (DDD)                   | Português Brasileiro      | Classes/atributos/métodos de domínio (sem acentos).                                           |
| Código – camadas técnicas (infra/app)    | Inglês             | controller, service, repository, config, adapters, ports.                                     |
| APIs públicas/entre times                | Inglês             | Paths, payloads, nomes de campos, headers, parâmetros.                                        |
| Eventos de integração (entre serviços)   | Inglês             | Nome do evento, tópico/stream, schema versionado (.v1).                                       |
| Banco de dados                           | Inglês             | Tabelas/colunas snake_case; sem acentos.                                                      |
| Env/config/flags                         | Inglês             | Ex.: OBJECTIVES_MODE, OBS_MAX_LENGTH.                                                         |
| Logs & métricas (keys/labels)            | Inglês             | Conteúdo livre; se público/global, prefira inglês.                                            |
| Documentação pública / OSS / commits     | Português Brasileiro             | Repositório privado e time local: pode ser nativo, mas padronize.                             |

### 1.3 Convenções de nomenclatura e casing

- Java (código local de exemplo neste repo):
  - Classes/Enums: PascalCase (ex.: PlanoPitStop)
  - Métodos/variáveis/atributos: camelCase (ex.: calcularTempoTotal)
  - Constantes: UPPER_SNAKE_CASE (ex.: TEMPO_MINIMO_BOX)
  - Sem packages nos exemplos locais (compatível com scripts). Em projetos reais, seguir camadas e idiomas por categoria.

- APIs públicas (JSON):
  - Inglês; campos em camelCase (ex.: pitStopPlan, penaltySeconds); versões em path/header.

- Eventos de integração:
  - Inglês; nome do evento e campos em camelCase; schema versionado (ex.: .v1) e compatibilidade explícita.
  - Tópicos/streams: minúsculas; evite underscores; use hífens ou pontos de forma consistente (ex.: f1.pitstop-plans.v1 ou f1.pitstop-plans). Documente o padrão escolhido.

- Banco de dados:
  - Inglês; snake_case para tabelas e colunas (ex.: pit_stop_plan, penalty_seconds); sem acentos/ç.

### 1.4 Mensagens e exceções
- Mensagens para usuário: Português Brasileiro via i18n; códigos de erro estáveis em inglês.
- Exceções internas do domínio: mensagens em inglês (preferido) para facilitar interoperabilidade e logs; se exibidas ao usuário, passar por i18n.

### 1.5 Exemplos rápidos (correto vs. incorreto)

- Java (domínio):
  - Correto: `class PlanoPitStop { ... }`, método `calcularTempoTotal()`, constante `TEMPO_MINIMO_BOX`
  - Incorreto: `class Plano_Pit_Stop {}`, método `Calcular_tempo_total()`, constante `TempoMinimoBox`

- API (JSON):
  - Correto:
    ```json
    { "penaltySeconds": 5, "pitStopPlan": { } }
    ```
  - Incorreto:
    ```json
    { "penalidade_segundos": 5, "pit_stop_plan": { } }
    ```

- Evento de integração (Kafka):
  - Correto: tópico `f1.pitstop-plans.v1`, evento `PitStopPlanned`, campos camelCase
  - Incorreto: tópico `F1_PITSTOP_PLANS`, campos `snake_case`

- Banco de dados:
  - Correto: tabela `pit_stop_plan`, coluna `penalty_seconds`
  - Incorreto: tabela `PitStopPlan`, coluna `penalidadeSegundos` ou com acento

---

## 2) Arquitetura e DDD

- Camadas:
  - Domínio: Entidades, Agregados, VOs, Serviços de Domínio, Repositórios (interfaces).
  - Aplicação: Casos de uso; orquestra o domínio; DTOs.
  - Infraestrutura: Persistência, mensageria, APIs externas; implementa interfaces do domínio.
  - Interface (UI/API): Controllers REST, UI, CLI.
- O domínio não conhece frameworks; usar Injeção de Dependências via interfaces (evitar Service Locator).
- Modelo de Domínio Rico: invariantes no próprio agregado/entidade; prefira Tell, Don’t Ask; use Value Objects.

---

## 3) SOLID e Padrões

- Aplicar SRP, OCP, LSP, ISP, DIP.
- Usar padrões (Factory, Strategy, Observer/Eventos, Specification, etc.) para isolar variações e regras.

---

## 4) Qualidade, Testes e Documentação

- Métodos curtos; nomes claros; remover duplicação; manter estilo consistente.
- Testes (AAA) focados em comportamento; Builders para cenários complexos; alta cobertura nas regras críticas.
- Atualizar READMEs locais ao criar exemplos; adicionar Javadoc em APIs públicas quando fizer sentido.

---

## 5) Formato Padrão de Respostas (para assistentes/geradores)

- Objetivo breve + checklist de requisitos cobertos.
- Contrato enxuto (quando pertinente):
  - Entradas, Saídas, Regras/Invariantes, Erros esperados.
- Casos de borda (3–5 relevantes: nulos/vazios, limites, concorrência, permissões, tempo).
- Entregáveis prontos para uso:
  - Arquivos fonte completos e autocontidos; exemplos compiláveis neste repo.
  - Testes mínimos (fluxo feliz + 1–2 bordas) quando alterar comportamento público.
  - README curto explicando o que é, como executar e limitações.

---

## 6) Guardrails de Saída

- Respeitar a matriz de idioma por categoria (seção de Linguagem) e as convenções de nomenclatura/casing.
- Não introduzir dependências externas sem justificativa; se necessário, documentar impacto e alternativas.
- Em Java local aqui, evitar packages e anotações de frameworks.
- Respeitar a estrutura de pastas e scripts existentes.
- Para alterações em múltiplos arquivos, fornecer lista de arquivos e o propósito de cada um.
 - Não incluir segredos/PII em exemplos (mascarar tokens, CPFs, chaves).
 - Não inventar endpoints/esquemas/tópicos; validar contra arquivos do repo e convenções definidas.

---

## 7) Checklist Final (antes de concluir uma entrega)

- [ ] Linguagem e casing aderentes à tabela/convenções.
- [ ] Requisitos cobertos (mapear cada requisito → status).
- [ ] Invariantes e validações implementadas no domínio.
- [ ] Dependências via interfaces (DIP).
- [ ] Exemplos/testes executam nos scripts do repo.
- [ ] Documentação/README atualizado.
- [ ] Versionamento/compatibilidade de APIs/eventos conferidos (ex.: .v1, retrocompatibilidade).

---

## 8) Critérios de Aceite – exemplos

- Domínio livre de frameworks; regras encapsuladas nas entidades/agregados.
- Repositórios como interfaces com métodos orientados ao negócio.
- Serviços de Domínio sem detalhes técnicos; orquestram entidades/VOs.
- Testes em AAA; cenários críticos cobertos.

---

## 9) Observações

- Preferir DI a Service Locator.
- Seguir a organização por pastas descrita no README principal.

---