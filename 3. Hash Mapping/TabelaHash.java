/**
 * Implementação de uma Tabela Hash para armazenar nomes femininos
 * Utiliza encadeamento (lista ligada) para tratamento de colisões
 */
public class TabelaHash {
    private No[] tabela;
    private int tamanho;
    private int quantidadeElementos;
    
    /**
     * Construtor da Tabela Hash
     * @param tamanho O tamanho da tabela hash (número de buckets)
     */
    public TabelaHash(int tamanho) {
        this.tamanho = tamanho;
        this.tabela = new No[tamanho];
        this.quantidadeElementos = 0;
    }
    
    /**
     * Função hash que calcula o índice para um nome
     * Utiliza o método da divisão: soma dos valores ASCII dos caracteres % tamanho
     * @param nome O nome a ser hasheado
     * @return O índice calculado na tabela
     */
    private int funcaoHash(String nome) {
        int soma = 0;
        // Soma os valores ASCII de cada caractere do nome
        for (int i = 0; i < nome.length(); i++) {
            soma += nome.charAt(i);
        }
        // Retorna o resto da divisão pelo tamanho da tabela
        return soma % tamanho;
    }
    
    /**
     * Insere um nome na tabela hash
     * @param nome O nome a ser inserido
     * @return true se inserido com sucesso, false se já existe
     */
    public boolean inserir(String nome) {
        // Verifica se o nome já existe
        if (buscar(nome)) {
            return false;
        }
        
        // Calcula o índice usando a função hash
        int indice = funcaoHash(nome);
        
        // Cria um novo nó com o nome
        No novoNo = new No(nome);
        
        // Se a posição está vazia, insere diretamente
        if (tabela[indice] == null) {
            tabela[indice] = novoNo;
        } else {
            // Caso contrário, adiciona no início da lista (tratamento de colisão)
            novoNo.setProximo(tabela[indice]);
            tabela[indice] = novoNo;
        }
        
        quantidadeElementos++;
        return true;
    }
    
    /**
     * Busca um nome na tabela hash
     * @param nome O nome a ser buscado
     * @return true se encontrado, false caso contrário
     */
    public boolean buscar(String nome) {
        int indice = funcaoHash(nome);
        No atual = tabela[indice];
        
        // Percorre a lista encadeada na posição do índice
        while (atual != null) {
            if (atual.getNome().equalsIgnoreCase(nome)) {
                return true;
            }
            atual = atual.getProximo();
        }
        
        return false;
    }
    
    /**
     * Remove um nome da tabela hash
     * @param nome O nome a ser removido
     * @return true se removido com sucesso, false se não encontrado
     */
    public boolean remover(String nome) {
        int indice = funcaoHash(nome);
        No atual = tabela[indice];
        No anterior = null;
        
        // Percorre a lista procurando o nome
        while (atual != null) {
            if (atual.getNome().equalsIgnoreCase(nome)) {
                // Se é o primeiro nó da lista
                if (anterior == null) {
                    tabela[indice] = atual.getProximo();
                } else {
                    // Remove o nó do meio ou fim da lista
                    anterior.setProximo(atual.getProximo());
                }
                quantidadeElementos--;
                return true;
            }
            anterior = atual;
            atual = atual.getProximo();
        }
        
        return false;
    }
    
    /**
     * Exibe estatísticas sobre a tabela hash
     * Mostra a distribuição dos nomes, colisões e fator de carga
     */
    public void exibirEstatisticas() {
        System.out.println("\n========== ESTATÍSTICAS DA TABELA HASH ==========");
        System.out.println("Tamanho da tabela: " + tamanho);
        System.out.println("Quantidade de elementos: " + quantidadeElementos);
        System.out.println("Fator de carga: " + String.format("%.2f", (double) quantidadeElementos / tamanho));
        
        int posicoesOcupadas = 0;
        int maiorLista = 0;
        int totalColisoes = 0;
        
        // Percorre a tabela coletando estatísticas
        for (int i = 0; i < tamanho; i++) {
            if (tabela[i] != null) {
                posicoesOcupadas++;
                int tamanhoLista = contarNos(tabela[i]);
                
                if (tamanhoLista > maiorLista) {
                    maiorLista = tamanhoLista;
                }
                
                // Colisões = tamanho da lista - 1
                if (tamanhoLista > 1) {
                    totalColisoes += (tamanhoLista - 1);
                }
            }
        }
        
        System.out.println("Posições ocupadas: " + posicoesOcupadas + " (" + 
                          String.format("%.2f%%", (double) posicoesOcupadas * 100 / tamanho) + ")");
        System.out.println("Total de colisões: " + totalColisoes);
        System.out.println("Maior lista encadeada: " + maiorLista + " elementos");
        System.out.println("=================================================\n");
    }
    
    /**
     * Conta o número de nós em uma lista encadeada
     * @param inicio O nó inicial da lista
     * @return O número de nós
     */
    private int contarNos(No inicio) {
        int count = 0;
        No atual = inicio;
        while (atual != null) {
            count++;
            atual = atual.getProximo();
        }
        return count;
    }
    
    /**
     * Exibe o conteúdo da tabela hash com detalhes
     */
    public void exibirTabela() {
        System.out.println("\n========== CONTEÚDO DA TABELA HASH ==========");
        for (int i = 0; i < tamanho; i++) {
            System.out.print("Índice " + i + ": ");
            if (tabela[i] == null) {
                System.out.println("vazio");
            } else {
                No atual = tabela[i];
                while (atual != null) {
                    System.out.print(atual.getNome());
                    if (atual.getProximo() != null) {
                        System.out.print(" -> ");
                    }
                    atual = atual.getProximo();
                }
                System.out.println();
            }
        }
        System.out.println("=============================================\n");
    }
    
    /**
     * Exibe apenas as posições ocupadas da tabela (mais compacto)
     */
    public void exibirPosicoesOcupadas() {
        System.out.println("\n========== POSIÇÕES OCUPADAS ==========");
        int count = 0;
        for (int i = 0; i < tamanho; i++) {
            if (tabela[i] != null) {
                count++;
                System.out.print("Índice " + i + " [" + contarNos(tabela[i]) + " elemento(s)]: ");
                No atual = tabela[i];
                while (atual != null) {
                    System.out.print(atual.getNome());
                    if (atual.getProximo() != null) {
                        System.out.print(" -> ");
                    }
                    atual = atual.getProximo();
                }
                System.out.println();
            }
        }
        System.out.println("Total: " + count + " posições ocupadas");
        System.out.println("========================================\n");
    }
    
    /**
     * Retorna o número de elementos na tabela
     * @return Quantidade de elementos
     */
    public int getQuantidadeElementos() {
        return quantidadeElementos;
    }
}
