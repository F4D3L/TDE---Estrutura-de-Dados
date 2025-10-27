# Sistema de Gerenciamento de Nomes Femininos - Hash Mapping

## 📋 Descrição do Projeto

Este projeto implementa uma **Tabela Hash** com tratamento de colisões por **encadeamento (lista ligada)** para armazenar e gerenciar nomes femininos. O sistema lê os nomes de um arquivo de texto e permite realizar operações de inserção, busca e remoção, além de exibir estatísticas sobre a distribuição dos dados.

## 🎯 Objetivos

- Implementar uma estrutura de dados Tabela Hash em Java
- Utilizar função hash baseada na soma dos valores ASCII
- Tratar colisões usando listas encadeadas
- Carregar dados de arquivo externo
- Fornecer interface interativa para o usuário
- Apresentar estatísticas sobre a distribuição dos dados

## 📁 Estrutura do Projeto

```
3. Hash Mapping/
├── No.java              # Classe para nós da lista encadeada
├── TabelaHash.java      # Implementação da tabela hash
├── Main.java            # Classe principal com menu interativo
├── female_names.txt     # Arquivo com nomes femininos
└── README.md           # Este arquivo
```

## 🔧 Funcionalidades

### Classe No
- Representa um nó na lista encadeada
- Armazena um nome e referência para o próximo nó
- Utilizado para tratamento de colisões

### Classe TabelaHash
- **Função Hash**: Calcula índice baseado na soma dos valores ASCII
- **Inserir**: Adiciona novo nome (verifica duplicatas)
- **Buscar**: Localiza nome na tabela
- **Remover**: Remove nome da tabela
- **Estatísticas**: Exibe métricas sobre a distribuição
  - Fator de carga
  - Número de colisões
  - Posições ocupadas
  - Maior lista encadeada

### Classe Main
- Interface de menu interativo
- Carregamento automático do arquivo
- Operações de gerenciamento
- Visualização de dados

## 🚀 Como Executar

### Compilar:
```bash
javac *.java
```

### Executar:
```bash
java Main
```

## 📊 Exemplo de Uso

```
===============================================
  SISTEMA DE GERENCIAMENTO DE NOMES FEMININOS
  Utilizando Tabela Hash com Encadeamento
===============================================

Carregando nomes do arquivo female_names.txt...
Total de nomes carregados: 5001

========== ESTATÍSTICAS DA TABELA HASH ==========
Tamanho da tabela: 100
Quantidade de elementos: 5001
Fator de carga: 50.01
Posições ocupadas: 100 (100.00%)
Total de colisões: 4901
Maior lista encadeada: 67 elementos
=================================================

========== MENU ==========
1. Buscar nome
2. Inserir nome
3. Remover nome
4. Exibir estatísticas
5. Exibir posições ocupadas
6. Exibir tabela completa
0. Sair
==========================
```

## 🔍 Conceitos Implementados

### Função Hash
```java
soma dos valores ASCII % tamanho da tabela
```
- Simples e eficiente
- Boa distribuição para strings
- Complexidade O(n) onde n = comprimento do nome

### Tratamento de Colisões
- **Encadeamento (Chaining)**: Lista ligada em cada posição
- Vantagens:
  - Fácil implementação
  - Não há limite de elementos
  - Performance estável

### Complexidade
- **Busca/Inserção/Remoção**: 
  - Caso médio: O(1 + α) onde α = fator de carga
  - Pior caso: O(n) quando todos em uma lista

## 📈 Estatísticas

O sistema calcula e exibe:
- **Fator de carga**: Razão entre elementos e tamanho da tabela
- **Taxa de ocupação**: Percentual de posições preenchidas
- **Colisões**: Número total de elementos que colidiram
- **Distribuição**: Tamanho das listas encadeadas

## 🎓 Conceitos de Estrutura de Dados

### Tabela Hash
- Estrutura de acesso direto
- Mapeamento chave → valor
- Acesso em tempo constante (médio)

### Lista Encadeada
- Estrutura dinâmica
- Inserção eficiente
- Flexível para colisões

## 📝 Observações

- O tamanho da tabela (100) pode ser ajustado conforme necessidade
- Tamanhos primos geralmente resultam em melhor distribuição
- O arquivo deve estar no mesmo diretório do programa
- Nomes são case-insensitive nas operações

## 🛠️ Possíveis Melhorias

1. Implementar função hash mais sofisticada (método da multiplicação, hash universal)
2. Redimensionamento dinâmico da tabela
3. Diferentes estratégias de resolução de colisões (endereçamento aberto)
4. Persistência de dados (salvar alterações no arquivo)
5. Interface gráfica (GUI)
6. Testes unitários

## 👨‍💻 Autor

Desenvolvido como exercício acadêmico de Estrutura de Dados
Tema: Hash Mapping (TDE-03-1)

## 📄 Licença

Uso acadêmico e educacional
