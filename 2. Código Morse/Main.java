import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        // 1. Criamos a árvore e o scanner UMA VEZ, fora do loop.
        PopularArvore arvoreMorse = new PopularArvore();
        Scanner scanner = new Scanner(System.in);

        // 2. Iniciamos o loop infinito do menu.
        while (true) {
            
            // 3. Exibimos as opções para o usuário.
            System.out.println("\n--- Tradutor de Codigo Morse ---");
            System.out.println("1: Decodificar (Morse -> Palavra)");
            System.out.println("2: Codificar (Palavra -> Morse)");
            System.out.println("0: Sair");
            System.out.print("Escolha uma opcao: ");

            // 4. Lemos a escolha do usuário.
            String escolha = scanner.nextLine();

            // 5. Usamos um switch (ou if/else) para decidir o que fazer.
            switch (escolha) {
                case "1":
                    // Lógica para Decodificar
                    System.out.println("Digite a mensagem em Morse (letras separadas por espaco):");
                    String mensagemMorse = scanner.nextLine();
                    String palavraTraduzida = arvoreMorse.traduzirMensagem(mensagemMorse);
                    System.out.println("Mensagem traduzida: " + palavraTraduzida);
                    break;

                case "2":
                    // Lógica para Codificar
                    System.out.println("Digite uma palavra para codificar (ex: JAVA):");
                    String palavra = scanner.nextLine();
                    String morseTraduzido = arvoreMorse.codificar(palavra);
                    System.out.println("Codigo Morse: " + morseTraduzido);
                    break;
                

                case "0":
                    // Lógica para Sair
                    System.out.println("Encerrando o programa...");
                    scanner.close(); // Fechamos o scanner
                    return; // Sai do método main e encerra o programa

                default:
                    // Se o usuário digitar algo inválido
                    System.out.println("Opcao invalida! Por favor, digite 0, 1 ou 2");
                    break;
            }

        }
    }
}