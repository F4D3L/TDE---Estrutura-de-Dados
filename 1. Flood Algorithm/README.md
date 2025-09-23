# Algoritmo Flood Fill - Implementação com Pilha e Fila

Este projeto implementa o algoritmo Flood Fill usando estruturas de dados próprias (Pilha e Fila) conforme especificado no trabalho de Estrutura de Dados.

## Estrutura do Projeto

```
src/
├── algorithms/
│   ├── FloodFillStack.java    # Implementação usando Pilha
│   └── FloodFillQueue.java    # Implementação usando Fila
├── datastructures/
│   ├── Stack.java             # Implementação própria de Pilha
│   └── Queue.java             # Implementação própria de Fila
├── model/
│   └── Point.java             # Classe para representar coordenadas
├── utils/
│   ├── ImageProcessor.java    # Processamento de imagens PNG
│   └── AnimationManager.java  # Gerenciador de animação
└── Main.java                  # Classe principal de demonstração
```

## Funcionalidades

### ✅ Requisitos Atendidos

1. **Pilha Própria (1.5 pts)**: Implementação completa em `datastructures/Stack.java`
2. **Fila Própria (1.5 pts)**: Implementação completa em `datastructures/Queue.java`
3. **Algoritmos Corretos (3.0 pts)**: Flood Fill implementado corretamente usando ambas as estruturas
4. **POO (2.0 pts)**: Código modularizado em classes com responsabilidades bem definidas
5. **Funcionamento (2.0 pts)**: Programa completo e funcional conforme especificações

### Características do Algoritmo

- **Entrada**: Imagem PNG com cores sólidas
- **Saída**: Imagem processada + frames de animação
- **Estruturas**: Pilha (LIFO) e Fila (FIFO) próprias
- **Animação**: Salvamento de frames durante o processo
- **Verificações**: Limites da imagem e validação de cores

## Como Compilar e Executar

### Requisitos
- Java 8 ou superior
- Sistema operacional: Windows/Linux/Mac

### Compilação
```bash
# Navegar para o diretório do projeto
cd "c:\Users\Guilherme\OneDrive - SPRO CONSULTORIA E INFORMATICA LTDA\Área de Trabalho\Pessoal\TDE - Estrutura de dados\1. Flood Algorithm"

# Compilar todos os arquivos Java
javac -d bin src\**\*.java src\*.java

# Executar o programa
java -cp bin Main
```

### Execução Automática
Execute o arquivo `run.bat` (Windows) ou `run.sh` (Linux/Mac) para compilar e executar automaticamente.

## Funcionamento

### 1. Carregamento da Imagem
- O programa tenta carregar uma imagem de `images/input/test_image.png`
- Se não encontrar, cria uma imagem de teste automaticamente

### 2. Processamento com Pilha
- Utiliza a estrutura LIFO (Last In, First Out)
- Processa os pixels de forma mais "profunda" primeiro
- Salva o resultado em `images/output/stack_result.png`

### 3. Processamento com Fila
- Utiliza a estrutura FIFO (First In, First Out)
- Processa os pixels de forma mais "ampla" primeiro
- Salva o resultado em `images/output/queue_result.png`

### 4. Animação
- Frames inicial e final são salvos automaticamente
- Possibilidade de salvar todos os frames intermediários

## Diferenças entre Pilha e Fila

### Stack (Pilha - LIFO)
- **Comportamento**: Processa o último pixel adicionado primeiro
- **Padrão**: Tende a seguir um caminho mais "profundo" antes de expandir
- **Resultado**: Preenchimento mais concentrado em direções específicas

### Queue (Fila - FIFO)
- **Comportamento**: Processa o primeiro pixel adicionado primeiro
- **Padrão**: Expande uniformemente em todas as direções
- **Resultado**: Preenchimento mais homogêneo e concêntrico

## Estruturas de Dados Implementadas

### Stack (Pilha)
```java
- push(element)    // Adiciona no topo
- pop()           // Remove do topo
- peek()          // Visualiza o topo
- isEmpty()       // Verifica se está vazia
- size()          // Retorna o tamanho
```

### Queue (Fila)
```java
- enqueue(element) // Adiciona no final
- dequeue()        // Remove do início
- front()          // Visualiza o primeiro
- isEmpty()        // Verifica se está vazia
- size()           // Retorna o tamanho
```

## Saídas do Programa

### Imagens Geradas
- `images/output/stack_result.png` - Resultado usando Pilha
- `images/output/queue_result.png` - Resultado usando Fila
- `images/output/stack_animation/` - Frames da animação com Pilha
- `images/output/queue_animation/` - Frames da animação com Fila

### Console
- Informações detalhadas sobre o processamento
- Tempos de execução
- Estatísticas dos pixels processados
- Status das operações de arquivo

## Observações Técnicas

1. **Validação de Limites**: Todos os acessos à matriz são validados
2. **Verificação de Cores**: Apenas pixels da cor original são processados
3. **Prevenção de Loops**: Pixels já processados não são reprocessados
4. **Gerenciamento de Memória**: Uso eficiente das estruturas de dados
5. **Tratamento de Erros**: Validações robustas de entrada

## Autores

- Guilherme Celli Fadel
- Disciplina: Resolução de Problemas Estruturados em Computação
- Professor: Lisiane Reips
- Curso: Bacharelado em Engenharia de Software

## Licença

Este projeto foi desenvolvido exclusivamente para fins acadêmicos.
