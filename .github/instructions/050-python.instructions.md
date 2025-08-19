---
applyTo: "**/*.py"
---

# Python Instructions (domínio e serviços)

- Estilo: PEP8; type hints obrigatórios em código novo.
- Domínio puro sem frameworks; use protocolos/abstrações (typing.Protocol) para DIP.
- Separar camadas: domínio, aplicação, infraestrutura.
- Testes: pytest com AAA; cobertura ≥ 80% nos arquivos tocados.
- Logging sem PII; configs via env; não commitar segredos.
- Versão de APIs/eventos em inglês e versionadas quando quebrar compat.

ALLOW_EDIT: src/**, tests/**, pyproject.toml, requirements*.txt
DENY_EDIT: .venv/**, **/__pycache__/**, build/**, dist/**, **/.vscode/**
