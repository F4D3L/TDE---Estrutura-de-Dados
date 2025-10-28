public class ArvoreCodigoMorse {
    
    private No raiz;

    public ArvoreCodigoMorse() {
        raiz = new No(null);

    }

    public void inserir(String letra, String codigoMorse) {
        No noAtual = this.raiz;


        for (int i = 0; i < codigoMorse.length(); i++){

            char c = codigoMorse.charAt(i);

            if (c == '.') {
                if (noAtual.getEsquerda() == null) {
                    noAtual.setEsquerda(new No(null));
                }
                noAtual = noAtual.getEsquerda();
            } else if (c == '-') {
                if (noAtual.getDireita() == null) {
                    noAtual.setDireita(new No(null));
                }
                noAtual = noAtual.getDireita();
            }
        }

        noAtual.setLetra(letra);

    }

        private String traduzirCodigo(String codigoMorse) {
        No noAtual = this.raiz;

        for (int i = 0; i < codigoMorse.length(); i++) {
            char c = codigoMorse.charAt(i);

            if (c == '.') {
                noAtual = noAtual.getEsquerda();
            } else if (c == '-') {
                noAtual = noAtual.getDireita();
            }

            if (noAtual == null) {
                return null; // Código Morse inválido
            }
        }

        return noAtual.getLetra();
    }

public String traduzirMensagem (String mensagemMorse) {
        StringBuilder fraseTraduzida = new StringBuilder();

        // 1. Separa a mensagem em PALAVRAS Morse (delimitador " / ")
        String[] palavrasMorse = mensagemMorse.split(" / ");

        // 2. Itera sobre cada palavra em Morse
        // (Ex: ".--. ..- -.-." e depois ".--. .-.")
        for (String palavraMorse : palavrasMorse) {
            
            // 3. Separa a palavra Morse em LETRAS Morse (delimitador " ")
            String[] codigosLetras = palavraMorse.split(" ");
            
            // 4. Itera sobre cada código de letra
            for (String codigo : codigosLetras) {
                // Ignora strings vazias (caso haja espaços duplos)
                if (codigo.isEmpty()) continue; 

                String letra = traduzirCodigo(codigo);
                if (letra != null) {
                    fraseTraduzida.append(letra);
                } else {
                    fraseTraduzida.append("?"); // Símbolo para código desconhecido
                }
            }
            
            // 5. Após traduzir uma palavra inteira, adiciona um espaço
            fraseTraduzida.append(" ");
        }

        // 6. Retorna a frase final, removendo o último espaço
        return fraseTraduzida.toString().trim();
    }


}
