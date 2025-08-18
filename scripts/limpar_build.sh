#!/usr/bin/env bash
set -euo pipefail

# Remove artefatos de build simples (Java .class)
# Uso:
#   bash scripts/limpar_build.sh

ROOT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")"/.. && pwd)"
cd "$ROOT_DIR"

BEFORE=$(find . -type f -name '*.class' | wc -l | tr -d ' ')
find . -type f -name '*.class' -delete
AFTER=$(find . -type f -name '*.class' | wc -l | tr -d ' ')

REMOVED=$((BEFORE-AFTER))
echo "Removidos $REMOVED arquivos .class (restantes: $AFTER)"
