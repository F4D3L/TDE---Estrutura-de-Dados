# 📚 TDEs - Estrutura de Dados

> **Repositório de Trabalhos Dirigidos Externos (TDEs)**  
> **Disciplina:** Resolução de Problemas Estruturados em Computação  
> **Curso:** Bacharelado em Engenharia de Software  
> **Professor:** Lisiane Reips  

---

## 📋 Sobre o Repositório

Este repositório contém todos os **Trabalhos Dirigidos Externos (TDEs)** desenvolvidos durante a disciplina de Estrutura de Dados. Cada projeto demonstra a implementação prática de conceitos fundamentais de estruturas de dados e algoritmos usando **Java** e **Programação Orientada a Objetos**.

---

## 🗂️ Estrutura do Repositório

```
📁 TDEs-Estrutura-de-Dados/
├── 📁 1. Flood Algorithm/          # TDE 1 - Algoritmo Flood Fill
│   ├── 📁 src/                     # Código fonte
│   ├── 📁 images/                  # Imagens de entrada e saída
│   ├── 📄 README.md               # Documentação específica
│   ├── 📄 run.bat                 # Script de execução (Windows)
│   └── 📄 run.sh                  # Script de execução (Linux/Mac)
├── 📁 2. Código Morse/            # TDE 2 - Tradutor Código Morse
│   ├── 📄 Main.java               # Interface principal
│   ├── 📄 ArvoreCodigoMorse.java  # Implementação da árvore
│   ├── � PopularArvore.java      # População e codificação
│   └── 📄 No.java                 # Nó da árvore binária
├── 📁 3. Hash Mapping/            # TDE 3 - Tabela Hash
│   ├── 📄 Main.java               # Interface principal
│   ├── 📄 TabelaHash.java         # Implementação da tabela hash
│   ├── 📄 No.java                 # Nó da lista encadeada
│   ├── 📄 female_names.txt        # Base de dados
│   └── 📄 README.md               # Documentação específica
└── 📄 README.md                   # Este arquivo
```

---

## 🚀 TDEs Implementados

### 🎨 **TDE 1: Algoritmo Flood Fill**
**Status:** ✅ Concluído  
**Conceitos:** Pilha, Fila, Algoritmos de Preenchimento  

#### 📖 Descrição
Implementação do algoritmo Flood Fill (preenchimento de inundação) usado em ferramentas como "balde" do Paint. O projeto demonstra a diferença entre estruturas **LIFO (Pilha)** e **FIFO (Fila)** no comportamento do algoritmo.

#### 🛠️ Tecnologias
- **Linguagem:** Java 8+
- **Estruturas:** Stack e Queue próprias
- **Processamento:** BufferedImage para manipulação de PNG
- **Paradigma:** Programação Orientada a Objetos

#### ⚡ Execução Rápida
```bash
cd "1. Flood Algorithm"
./run.bat  # Windows
./run.sh   # Linux/Mac
```

#### 🎯 Principais Funcionalidades
- ✅ Implementação própria de Pilha e Fila
- ✅ Algoritmo Flood Fill com ambas estruturas
- ✅ Processamento de imagens PNG
- ✅ Animação do processo de preenchimento
- ✅ Comparação visual entre Stack vs Queue

---

### 📡 **TDE 2: Tradutor de Código Morse**
**Status:** ✅ Concluído  
**Conceitos:** Árvore Binária, Árvore de Decisão, HashMap  

#### 📖 Descrição
Sistema interativo de tradução bidirecional entre texto e código Morse. Utiliza uma **árvore binária de decisão** para decodificação (onde `.` vai para esquerda e `-` para direita) e um **HashMap** para codificação rápida.

#### 🛠️ Tecnologias
- **Linguagem:** Java 8+
- **Estruturas:** Árvore Binária, HashMap, StringBuilder
- **Paradigma:** POO com Herança

#### ⚡ Execução Rápida
```bash
cd "2. Código Morse"
javac *.java
java Main
```

#### 🎯 Principais Funcionalidades
- ✅ Decodificação Morse → Texto usando árvore binária
- ✅ Codificação Texto → Morse usando HashMap
- ✅ Suporte a palavras e frases completas
- ✅ Interface de menu interativo
- ✅ Tratamento de espaços e separadores

#### 📊 Como Funciona
- **Decodificação:** Navega pela árvore seguindo `.` (esquerda) e `-` (direita)
- **Codificação:** Busca direta no HashMap para conversão instantânea
- **Separadores:** Espaço entre letras, ` / ` entre palavras

---

### 🗂️ **TDE 3: Sistema de Gerenciamento com Tabela Hash**
**Status:** ✅ Concluído  
**Conceitos:** Tabela Hash, Encadeamento, Função Hash, Lista Ligada  

#### 📖 Descrição
Sistema de gerenciamento de nomes femininos utilizando **Tabela Hash com encadeamento** (chaining) para tratamento de colisões. Carrega 5000+ nomes de arquivo e oferece operações CRUD completas com análise estatística detalhada da distribuição de dados.

#### 🛠️ Tecnologias
- **Linguagem:** Java 8+
- **Estruturas:** Tabela Hash, Lista Encadeada
- **I/O:** Leitura de arquivo texto
- **Paradigma:** Programação Orientada a Objetos

#### ⚡ Execução Rápida
```bash
cd "3. Hash Mapping"
javac *.java
java Main
```

#### 🎯 Principais Funcionalidades
- ✅ Tabela Hash com função hash customizada (soma ASCII)
- ✅ Tratamento de colisões por encadeamento
- ✅ Operações: Inserir, Buscar, Remover
- ✅ Carregamento automático de 5000+ nomes
- ✅ Estatísticas detalhadas (fator de carga, colisões, distribuição)
- ✅ Interface de menu interativo

#### 📊 Análise de Performance
- **Função Hash:** Soma de valores ASCII mod tamanho da tabela
- **Complexidade Média:** O(1 + α) onde α = fator de carga
- **Tratamento:** Lista encadeada em cada bucket
- **Estatísticas:** Fator de carga ~50.01, 100% de ocupação

---

## 📊 Estatísticas do Repositório

| Métrica | Valor |
|---------|-------|
| 📁 **TDEs Concluídos** | 3 |
| 📝 **Linhas de Código** | ~2500+ |
| 🏗️ **Classes Implementadas** | 16+ |
| 🧪 **Estruturas de Dados** | Stack, Queue, Árvore Binária, HashMap, Tabela Hash, Lista Encadeada |

---

## 🛠️ Tecnologias Utilizadas

### Linguagens
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)

### Ferramentas
![VS Code](https://img.shields.io/badge/VS_Code-007ACC?style=for-the-badge&logo=visual-studio-code&logoColor=white)
![Git](https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=git&logoColor=white)
![GitHub](https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=github&logoColor=white)

### Conceitos Aplicados
- **Estruturas de Dados:** Pilha, Fila, Árvore Binária, Tabela Hash, Lista Encadeada, Arrays Dinâmicos
- **Algoritmos:** Flood Fill, Busca em Largura/Profundidade, Função Hash, Travessia de Árvore
- **POO:** Encapsulamento, Herança, Modularização, Interfaces
- **Manipulação de Dados:** Leitura/Escrita de imagens PNG, Processamento de arquivos texto, I/O

---

## 📚 Conceitos de Estrutura de Dados Abordados

### ✅ **Já Implementados**
- **Stack (Pilha)** - LIFO (Last In, First Out)
- **Queue (Fila)** - FIFO (First In, First Out)
- **Árvore Binária** - Estrutura hierárquica para decisões
- **Tabela Hash** - Acesso direto com função hash
- **Lista Encadeada** - Estrutura dinâmica para colisões
- **HashMap** - Mapeamento chave-valor para busca O(1)
- **Algoritmos de Travessia** - DFS-like, BFS-like, Árvore de Decisão

### 🔄 **Próximos Tópicos**
- **A definir**


---

## 🎯 Objetivos de Aprendizado

Este repositório demonstra progressão nos seguintes conceitos:

### 🧠 **Estruturas de Dados**
- Compreensão profunda de Stack, Queue, Árvore Binária e Tabela Hash
- Implementação própria vs uso de bibliotecas
- Análise de complexidade temporal e espacial
- Tratamento de colisões e otimizações

### 🔧 **Programação**
- Princípios de POO aplicados corretamente
- Herança e composição de classes
- Modularização e responsabilidades bem definidas
- Tratamento de erros e casos excepcionais

### 🎨 **Algoritmos**
- Algoritmos de preenchimento e travessia
- Função hash e distribuição de dados
- Comparação de diferentes abordagens
- Otimização e análise de eficiência

---

## 📖 Como Navegar

### 🔍 **Para Professores/Avaliadores**
1. **Visualização Rápida:** Cada TDE tem seu próprio README detalhado
2. **Execução Imediata:** Scripts automatizados em cada pasta
3. **Código Limpo:** Estrutura modular e bem documentada

### 👨‍💻 **Para Estudantes**
1. **Estudo de Referência:** Código comentado e explicado
2. **Execução de Testes:** Exemplos funcionais completos
3. **Evolução Gradual:** Complexidade crescente entre TDEs

### 🚀 **Para Entusiastas**
1. **Implementações Próprias:** Sem dependências externas
2. **Visualizações:** Saídas gráficas
3. **Comparações:** Diferentes abordagens para mesmo problema

---

## 📝 Convenções do Repositório

### 📁 **Estrutura de Pastas**
```
X. Nome do TDE/
├── src/                    # Código fonte Java
├── docs/                   # Documentação adicional
├── examples/               # Exemplos de entrada/saída
├── README.md              # Documentação específica
└── run.{bat|sh}           # Scripts de execução
```

### 🏷️ **Convenções de Nomenclatura**
- **Classes:** PascalCase (`FloodFillStack`)
- **Métodos:** camelCase (`floodFill`)
- **Constantes:** UPPER_CASE (`MAX_SIZE`)
- **Pacotes:** lowercase (`datastructures`)

### 📋 **Commits**
- `feat:` Nova funcionalidade
- `fix:` Correção de bug
- `docs:` Atualização de documentação
- `refactor:` Refatoração de código

---

## 📊 Cronograma de Desenvolvimento

| TDE | Título | Status | Conceitos |
|-----|--------|--------|-----------|
| 1️⃣ | **Flood Fill Algorithm** | ✅ Concluído | Stack, Queue, Algoritmos de Preenchimento |
| 2️⃣ | **Tradutor Código Morse** | ✅ Concluído | Árvore Binária, HashMap, Árvore de Decisão |
| 3️⃣ | **Hash Mapping** | ✅ Concluído | Tabela Hash, Lista Encadeada, Função Hash |

---

## 🤝 Contribuição e Contato

### 📧 **Contato Acadêmico**
- **Disciplina:** Resolução de Problemas Estruturados em Computação
- **Instituição:** Pontifícia Universidade Católica do Paraná
- **Período:** 2025.2

### ⚠️ **Nota Importante**
Este repositório contém trabalhos acadêmicos desenvolvidos exclusivamente para fins educacionais. O código está disponível para:
- ✅ **Referência e estudo**
- ✅ **Compreensão de conceitos**
- ❌ **Não para cópia direta em trabalhos acadêmicos**

### 🔗 **Links Úteis**
- [Documentação Java](https://docs.oracle.com/javase/8/docs/)
- [Visualgo - Estruturas de Dados](https://visualgo.net/)
- [GeeksforGeeks - Algorithms](https://www.geeksforgeeks.org/)

---

## 📈 Evolução do Conhecimento

### 🎯 **Metas Alcançadas**
- [x] Implementação própria de estruturas básicas (Stack, Queue)
- [x] Algoritmos de preenchimento e travessia
- [x] Processamento de imagens
- [x] Comparação de abordagens (Stack vs Queue)
- [x] Implementação de Árvore Binária de Decisão
- [x] Sistema de codificação/decodificação bidirecional
- [x] Tabela Hash com tratamento de colisões
- [x] Análise estatística de distribuição de dados
- [x] Interface interativa com menu de opções

### 🚀 **Próximos Passos**
- Explorar estruturas avançadas (AVL, B-Tree, etc.)
- Implementar algoritmos de ordenação
- Grafos e algoritmos de caminho mínimo

---

## 📜 Licença

Este projeto está sob licença acadêmica - desenvolvido exclusivamente para fins educacionais na disciplina de Estrutura de Dados do curso
de Engenharia de Software - PUCPR.

---


