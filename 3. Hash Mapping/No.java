/**
 * Classe que representa um nó na lista encadeada para tratamento de colisões
 * Cada nó contém um nome e uma referência para o próximo nó
 */
public class No {
    private String nome;
    private No proximo;
    
    /**
     * Construtor do nó
     * @param nome O nome a ser armazenado no nó
     */
    public No(String nome) {
        this.nome = nome;
        this.proximo = null;
    }
    
    /**
     * Obtém o nome armazenado no nó
     * @return O nome
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * Define o nome do nó
     * @param nome O nome a ser definido
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    /**
     * Obtém a referência para o próximo nó
     * @return O próximo nó
     */
    public No getProximo() {
        return proximo;
    }
    
    /**
     * Define o próximo nó na lista
     * @param proximo O próximo nó
     */
    public void setProximo(No proximo) {
        this.proximo = proximo;
    }
    
    @Override
    public String toString() {
        return nome;
    }
}
