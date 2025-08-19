---
id: bootstrap-python-fastapi
mode: agent
applyTo: "src/main/**"
description: "Bootstrap de módulo Python (src/tests, pytest/cov) com opção FastAPI"
output: "changeset"
schemas:
  - "../schema/changeset.schema.json"
---

Objetivo: criar a estrutura mínima de um módulo Python com layout `src/` e testes `tests/`, configurando pytest e cobertura; opcionalmente, quando `fastapi=true`, incluir esqueleto de aplicação FastAPI com um endpoint `/ping` e teste de rota.

Contexto:
- Saída obrigatória em JSON `changeset` válido por `schema/changeset.schema.json`.
- Restrições: PEP8, type hints, domínio sem frameworks; DIP via `typing.Protocol` quando útil.
- Allow/Deny: respeitar guias do repo. Não tocar em `.venv/**`, `**/__pycache__/**`, `build/**`, `dist/**`, `**/.vscode/**`.

Requisitos (checklist):
- [ ] Criar `pyproject.toml` com `setuptools` (build-system) e configuração de pytest/cobertura.
- [ ] Criar `src/{{package}}/__init__.py` e `src/{{package}}/health.py` com `def ping() -> str: return "pong"`.
- [ ] Criar `tests/test_health.py` com testes AAA (fluxo feliz + borda simples).
- [ ] Incluir `tool.pytest.ini_options` para descoberta em `src/` e `tool.coverage.run` + `report` com fail-under ≥ 80 para arquivos tocados.
- [ ] Nenhuma dependência externa obrigatória além de pytest/pytest-cov (dev).
- [ ] Logs sem PII.
- [ ] Se `fastapi=true`: adicionar dependência `fastapi` e `uvicorn` (dev), criar `src/{{package}}/app.py` com rota `/ping`, e `tests/test_app.py` com teste via `TestClient`.

Saída esperada:
- Um único bloco JSON `changeset` contendo arquivos completos, caminhos relativos, sem editar pastas `DENY_EDIT`.
- Campo `notes` deve incluir comandos para rodar testes e medir cobertura.

Guardrails:
- Não inventar paths fora de `src/**` e `tests/**` e arquivos de configuração na raiz do projeto.
- Sem libs extras sem justificativa.
- Código e nomes em inglês.

Critérios de aceite:
- `pytest -q` passa.
- Cobertura ≥ 80% nos arquivos tocados.
- Se `fastapi=true`, rota `/ping` responde 200 com body `{"status":"ok"}` ou "pong".

Assunções padrão (se não informado pelo usuário):
- `package = "app"`.

...
