````markdown
# Como configurar o VS Code para usar Copilot Chat com instructions e prompts

## 1) Instruções do repositório
Crie um arquivo `.github/copilot-instructions.md` no seu repositório. O Copilot Chat lê automaticamente quando você estiver nesse projeto. Para checar, envie qualquer pergunta no Chat e abra “References”: o arquivo deve aparecer lá.

> Fonte: GitHub Docs

## 2) Instruction files (escopos e autoaplicação)
Use arquivos `*.instructions.md` para regras reaproveitáveis por arquivo/pasta. Coloque-os em `.github/instructions/` e use front matter para autoaplicar por glob:

```yaml
---
applyTo: "**"   # aplica em tudo (ou refine: **/*.java,**/*.yml)
---
```

Minhas regras de estilo, DDD e testes...

Crie/gerencie pelo Chat → “Configure Chat” → “Instructions” → “New instruction file”, ou via comando “Chat: New Instructions File.”

> Fonte: Visual Studio Code

## 3) Prompt files (reutilizáveis, executáveis)
Para prompts de análise/refatoração, use `.prompt.md` em `.github/prompts/`. Eles rodam direto do arquivo, ou você chama pelo nome com “/” no chat. Exemplo mínimo:

```markdown
---
mode: agent
description: "Analisar SOLID/DDD e gerar backlog JSON"
---
Use o arquivo #analysis.json como fonte.
Gerar saída apenas em JSON válido (schema/analysis.schema.json).
```

Crie pelo Chat → “Configure Chat” → “Prompt Files” → “New prompt file”, ou “Chat: New Prompt File”. Execute por “Chat: Run Prompt”, pelo botão ▶ do editor, ou digitando `/nome-do-prompt` no chat.

> Fonte: Visual Studio Code

## 4) Ajustes no settings.json do VS Code (workspace)
Abra Command Palette → “Preferences: Open Workspace Settings (JSON)” e adicione:

```jsonc
{
	// habilita prompt/instruction files
	"chat.promptFiles": true,
	"chat.promptFilesLocations": { ".github/prompts": true },
	"chat.instructionsFilesLocations": { ".github/instructions": true },

	// usa instruções do repo no Copilot Chat
	"github.copilot.chat.codeGeneration.useInstructionFiles": true,

	// melhora busca no código com #codebase
	"github.copilot.chat.codesearch.enabled": true
}
```

> Essas chaves são as oficiais para ligar prompts/instructions e apontar pastas.
> Fonte: Visual Studio Code

## 5) Como dar contexto no Chat (sem drama)
- Mencione arquivos/pastas/símbolos com `#` no prompt: `#UserController.java`, `#codebase`, `#changes`. Ative code search para `#codebase`.
- Adicione arquivos por “Add Context” ou arraste para o Chat. Se o arquivo for grande, o VS Code envia o outline em vez do conteúdo.

> Fonte: Visual Studio Code

## 6) Verificar se está tudo ligado
Instruções do repo são combinadas ao seu prompt automaticamente quando você estiver naquele repo; confira nas “References” da resposta do Chat.

> Fonte: GitHub Docs

## 7) Onde colocar o que você já tem
- Seu `copilot-instructions.md` atualizado: mova para `.github/copilot-instructions.md`. Ele passa a valer para o Copilot Chat nesse repo.
- Seus prompts prontos (análise/refatoração/autopilot): salve como `.prompt.md` em `.github/prompts/`. Rode via `/nome-do-prompt` ou “Run Prompt.”
- Suas regras detalhadas por linguagem/camada: quebre em `*.instructions.md` por tema em `.github/instructions/` e use `applyTo` para limitar escopo.

> Fonte: Visual Studio Code

## 8) Bônus útil
Você pode definir instruções específicas via Settings (ex.: review, commit message). Dá para apontar para arquivos do repo. Útil para padronizar descrição de PR e revisão.

> Fonte: Visual Studio Code

Pronto. Com isso seu Copilot para de improvisar e passa a seguir suas regras e prompts como se estivesse pagando aluguel. Quando quiser, amarre seus prompts ao “/” do chat com nomes padronizados e versions (`.prompt.md`), e feche o ciclo com schemas para validar a saída.

````
