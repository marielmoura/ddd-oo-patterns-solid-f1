# Prompts do Repositório

Índice dos prompts para acelerar a criação de artefatos alinhados a DDD/SOLID e ao estilo deste repo.

## Instruções para Assistentes (Copilot/LLMs)

- `refactoring/copilot-instructions.md` — Convenções gerais, formato de respostas (`changeset`), guardrails e critérios de aceite. Requer validação contra `schema/changeset.schema.json` (na raiz).

## Geração de Artefatos (Domínio/Aplicação)

- `novo_agregado.md` — Gera um Agregado de Domínio com VO/entidade interna, invariantes e repositório.
- `novo_value_object.md` — Define um Value Object imutável com invariantes e testes mínimos.
- `novo_evento_dominio.md` — Define um Evento de Domínio imutável, pronto para listeners.
- `novo_repositorio.md` — Interface de Repositório orientada ao domínio (DIP).
- `novo_servico_dominio.md` — Serviço de Domínio para orquestrar múltiplas entidades/VOs.
- `novo_caso_uso_aplicacao.md` — Caso de Uso (Aplicação) com comando/resultado e fluxo feliz + bordas.
- `novo_builder_teste.md` — Builder de Teste para dados padrão e variações fluentes.

Observação: Nestes prompts geradores, use nomes de domínio em português e mantenha o domínio sem frameworks. Para código do repositório e APIs públicas, siga as regras do arquivo `refactoring/copilot-instructions.md` (em inglês).

## Análise e Refactoring Autônomo

- `refactoring/projects_analysis.md` — Gera uma análise técnica completa do projeto e salva `analysis.json`/`analysis.md` (com `content_hash`).
- `refactoring/projects_refactoring.md` — Converte os achados do `analysis.json` em um backlog e executa correções em batches, produzindo `backlog.json` e `progress.json` válidos por schema.

### Schemas (canônicos)

- `refactoring/schema/analysis.schema.json` — valida `analysis.json`.
- `refactoring/schema/backlog.schema.json` — valida `backlog.json`.
- `refactoring/schema/progress.schema.json` — valida `progress.json`.

Opcional: há suporte a espelhar schemas na raiz do repo para ferramentas externas. Já existe `schema/changeset.schema.json` (raiz) para validar respostas no formato `changeset` referenciado por `refactoring/copilot-instructions.md`.
