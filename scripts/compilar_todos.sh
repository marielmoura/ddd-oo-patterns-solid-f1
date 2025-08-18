#!/usr/bin/env bash
set -euo pipefail

# Compila todos os exemplos Java por diretório, evitando problemas com espaços/acentos
# Uso:
#   bash scripts/compilar_todos.sh

ROOT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")"/.. && pwd)"
cd "$ROOT_DIR"

echo "Iniciando compilação por diretório (Java)..."

# Coleta diretórios com arquivos .java, de forma robusta (NUL-safe), e ordena/unique
mapfile -t DIRS < <(
  while IFS= read -r -d '' f; do
    dirname "$f"
  done < <(find . -type f -name '*.java' -print0) | sort -u
)

for d in "${DIRS[@]}"; do
  echo "Compilando: $d"
  (
    cd "$d"
    # Compila apenas os .java do diretório atual
    ls *.java >/dev/null 2>&1 || { echo "(sem .java)"; exit 0; }
    javac *.java
  )
done

echo "COMPILACAO_OK"
