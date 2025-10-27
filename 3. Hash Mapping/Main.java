import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Classe principal para demonstração da Tabela Hash
 * Implementa o sistema de gerenciamento de nomes femininos usando Hash Mapping
 */
public class Main {
    
    /**
     * Carrega os nomes do arquivo para a tabela hash
     * @param nomeArquivo O caminho do arquivo
     * @param tabela A tabela hash onde os nomes serão inseridos
     * @return O número de nomes carregados com sucesso
     */
    public static int carregarNomesDoArquivo(String nomeArquivo, TabelaHash tabela) {
        int nomesCarregados = 0;
        
        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            
            System.out.println("Carregando nomes do arquivo " + nomeArquivo + "...");
            
            // Lê cada linha do arquivo
            while ((linha = br.readLine()) != null) {
                linha = linha.trim(); // Remove espaços em branco
                
                // Ignora linhas vazias
                if (!linha.isEmpty()) {
                    // Insere o nome na tabela hash
                    if (tabela.inserir(linha)) {
                        nomesCarregados++;
                    }
                }
            }
            
            System.out.println("Total de nomes carregados: " + nomesCarregados);
            
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        
        return nomesCarregados;
    }
    
    /**
     * Exibe o menu de opções para o usuário
     */
    public static void exibirMenu() {
        System.out.println("\n========== MENU ==========");
        System.out.println("1. Buscar nome");
        System.out.println("2. Inserir nome");
        System.out.println("3. Remover nome");
        System.out.println("4. Exibir estatísticas");
        System.out.println("5. Exibir posições ocupadas");
        System.out.println("6. Exibir tabela completa");
        System.out.println("0. Sair");
        System.out.println("==========================");
        System.out.print("Escolha uma opção: ");
    }
    
    /**
     * Método principal que executa o programa
     */
    public static void main(String[] args) {
        // Cria uma tabela hash com tamanho 100 (ajustável conforme necessidade)
        final int TAMANHO_TABELA = 100;
        TabelaHash tabela = new TabelaHash(TAMANHO_TABELA);
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("===============================================");
        System.out.println("  SISTEMA DE GERENCIAMENTO DE NOMES FEMININOS");
        System.out.println("  Utilizando Tabela Hash com Encadeamento");
        System.out.println("===============================================\n");
        
        // Carrega os nomes do arquivo
        String caminhoArquivo = "female_names.txt";
        int nomesCarregados = carregarNomesDoArquivo(caminhoArquivo, tabela);
        
        if (nomesCarregados == 0) {
            System.out.println("Nenhum nome foi carregado. Encerrando o programa.");
            scanner.close();
            return;
        }
        
        // Exibe estatísticas iniciais
        tabela.exibirEstatisticas();
        
        // Loop do menu principal
        boolean continuar = true;
        while (continuar) {
            exibirMenu();
            
            try {
                int opcao = scanner.nextInt();
                scanner.nextLine(); // Limpa o buffer
                
                switch (opcao) {
                    case 1:
                        // Buscar nome
                        System.out.print("\nDigite o nome a buscar: ");
                        String nomeBuscar = scanner.nextLine().trim();
                        
                        if (tabela.buscar(nomeBuscar)) {
                            System.out.println("✓ Nome '" + nomeBuscar + "' encontrado na tabela!");
                        } else {
                            System.out.println("✗ Nome '" + nomeBuscar + "' não encontrado na tabela.");
                        }
                        break;
                        
                    case 2:
                        // Inserir nome
                        System.out.print("\nDigite o nome a inserir: ");
                        String nomeInserir = scanner.nextLine().trim();
                        
                        if (nomeInserir.isEmpty()) {
                            System.out.println("Nome inválido!");
                        } else if (tabela.inserir(nomeInserir)) {
                            System.out.println("✓ Nome '" + nomeInserir + "' inserido com sucesso!");
                        } else {
                            System.out.println("✗ Nome '" + nomeInserir + "' já existe na tabela.");
                        }
                        break;
                        
                    case 3:
                        // Remover nome
                        System.out.print("\nDigite o nome a remover: ");
                        String nomeRemover = scanner.nextLine().trim();
                        
                        if (tabela.remover(nomeRemover)) {
                            System.out.println("✓ Nome '" + nomeRemover + "' removido com sucesso!");
                        } else {
                            System.out.println("✗ Nome '" + nomeRemover + "' não encontrado na tabela.");
                        }
                        break;
                        
                    case 4:
                        // Exibir estatísticas
                        tabela.exibirEstatisticas();
                        break;
                        
                    case 5:
                        // Exibir posições ocupadas
                        tabela.exibirPosicoesOcupadas();
                        break;
                        
                    case 6:
                        // Exibir tabela completa
                        System.out.print("\nTem certeza? A tabela pode ser grande. (S/N): ");
                        String confirmacao = scanner.nextLine().trim().toUpperCase();
                        
                        if (confirmacao.equals("S")) {
                            tabela.exibirTabela();
                        }
                        break;
                        
                    case 0:
                        // Sair
                        System.out.println("\nEncerrando o programa...");
                        System.out.println("Obrigado por usar o sistema!");
                        continuar = false;
                        break;
                        
                    default:
                        System.out.println("\nOpção inválida! Tente novamente.");
                }
                
            } catch (Exception e) {
                System.out.println("\nErro: Entrada inválida! Tente novamente.");
                scanner.nextLine(); // Limpa o buffer em caso de erro
            }
        }
        
        scanner.close();
    }
}
