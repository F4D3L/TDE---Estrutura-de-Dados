#!/bin/bash
echo "=== Compilando e Executando Algoritmo Flood Fill ==="
echo

# Criar diretórios necessários
mkdir -p bin
mkdir -p images/input
mkdir -p images/output

echo "Compilando arquivos Java..."
javac -d bin src/datastructures/*.java src/model/*.java src/utils/*.java src/algorithms/*.java src/Main.java

if [ $? -eq 0 ]; then
    echo "Compilação concluída com sucesso!"
    echo
    echo "Executando o programa..."
    echo
    java -cp bin Main
else
    echo "Erro na compilação!"
    exit 1
fi

echo
echo "Programa executado com sucesso!"