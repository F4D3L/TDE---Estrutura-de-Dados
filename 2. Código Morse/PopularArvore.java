import java.util.HashMap;
import java.util.Map;

public class PopularArvore extends ArvoreCodigoMorse {

    private Map<String, String> mapaParaCodificar;

    public PopularArvore() {
        super();

        this.mapaParaCodificar = new HashMap<>();

        popular();
    }

    private void adicionarLetra(String letra, String codigoMorse) {
        super.inserir(letra, codigoMorse);
        this.mapaParaCodificar.put(letra, codigoMorse);
    }

    private void popular() {
        adicionarLetra("A", ".-");
        adicionarLetra("B", "-...");
        adicionarLetra("C", "-.-.");
        adicionarLetra("D", "-..");
        adicionarLetra("E", ".");
        adicionarLetra("F", "..-.");
        adicionarLetra("G", "--.");
        adicionarLetra("H", "....");
        adicionarLetra("I", "..");
        adicionarLetra("J", ".---");
        adicionarLetra("K", "-.-");
        adicionarLetra("L", ".-..");
        adicionarLetra("M", "--");
        adicionarLetra("N", "-.");
        adicionarLetra("O", "---");
        adicionarLetra("P", ".--.");
        adicionarLetra("Q", "--.-");
        adicionarLetra("R", ".-.");
        adicionarLetra("S", "...");
        adicionarLetra("T", "-");
        adicionarLetra("U", "..-");
        adicionarLetra("V", "...-");
        adicionarLetra("W", ".--");
        adicionarLetra("X", "-..-");
        adicionarLetra("Y", "-.--");
        adicionarLetra("Z", "--..");

    }

public String codificar(String frase) {
        StringBuilder morseResultado = new StringBuilder();
        
        // Converte a palavra para maiúsculas para garantir a busca no mapa
        String fraseUpper = frase.toUpperCase();

        // 5. Itera por cada caractere da palavra
        for (int i = 0; i < fraseUpper.length(); i++) {
            // Pega o caractere da vez
            char caractere = fraseUpper.charAt(i);

            // 6. VERIFICA SE É ESPAÇO (separador de palavras)
            if (caractere == ' ') {
                // Se for um espaço, adiciona o separador de palavra Morse
                // Usamos " / " (com espaços) para manter o formato
                morseResultado.append(" / ");

            } else {
                // 7. SE FOR LETRA, faz a busca normal
                String letra = String.valueOf(caractere);
                String codigo = this.mapaParaCodificar.get(letra);

                if (codigo != null) {
                    morseResultado.append(codigo);
                } else {
                    morseResultado.append("?"); // Caractere desconhecido (pontuação, etc.)
                }

                // 8. Adiciona um espaço (separador de LETRAS)
                // Nota: Também adiciona um espaço após a última letra de uma palavra,
                // que é o que queremos antes do " / ".
                morseResultado.append(" ");
            }
        }

        // Retorna a string final, removendo espaços desnecessários no início ou fim
        return morseResultado.toString().trim();
    }





    
}
