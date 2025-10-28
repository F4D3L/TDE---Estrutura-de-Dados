public class No {

    private No direita;
    private No esquerda;
    private String letra;

    public No(String letra) {
        this.letra = letra;
        this.direita = null;
        this.esquerda = null;
    }

    public No getDireita() {
        return direita;
    }

    public No getEsquerda() {
        return esquerda;
    }

    public void setDireita(No direita) {
        this.direita = direita;
    }

    public void setEsquerda(No esquerda) {
        this.esquerda = esquerda;
    }
    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }


}