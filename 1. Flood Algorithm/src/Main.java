import algorithms.FloodFillStack;
import algorithms.FloodFillQueue;
import utils.ImageProcessor;
import utils.AnimationManager;
import java.awt.image.BufferedImage;

/**
 * Classe principal que demonstra o funcionamento do algoritmo Flood Fill
 * usando tanto Pilha quanto Fila como estruturas de armazenamento.
 */
public class Main {
    
    public static void main(String[] args) {
        System.out.println("=== DEMONSTRAÇÃO DO ALGORITMO FLOOD FILL ===");
        System.out.println("Implementação usando Pilha e Fila próprias");
        System.out.println("Trabalho de Estrutura de Dados");
        System.out.println();
        
        // Configurações
        String inputImagePath = "images/input/test_image.png";
        String outputDir = "images/output";
        int imageWidth = 100;
        int imageHeight = 100;
        
        // Coordenadas do ponto inicial para o flood fill (área branca)
        int startX = 41;  // Ponto em área branca
        int startY = 60;  // Ponto em área branca
        
        // Nova cor (azul) para pintar os pixels brancos
        int newColor = ImageProcessor.rgbToInt(0, 0, 255);
        
        try {
            // 1. Criar ou carregar imagem de teste
            BufferedImage originalImage = createOrLoadTestImage(inputImagePath, imageWidth, imageHeight);
            if (originalImage == null) {
                System.err.println("Não foi possível criar/carregar a imagem de teste");
                return;
            }
            
            ImageProcessor.printImageInfo(originalImage);
            
            // 2. Demonstração com PILHA (Stack)
            System.out.println("\n=== EXECUÇÃO COM PILHA (STACK) ===");
            demonstrateStackFloodFill(originalImage, startX, startY, newColor, outputDir);
            
            // Aguarda um pouco antes da próxima demonstração
            Thread.sleep(1000);
            
            // 3. Recarregar a imagem original para a segunda demonstração
            BufferedImage originalImage2 = createOrLoadTestImage(inputImagePath, imageWidth, imageHeight);
            
            // 4. Demonstração com FILA (Queue)
            System.out.println("\n=== EXECUÇÃO COM FILA (QUEUE) ===");
            demonstrateQueueFloodFill(originalImage2, startX, startY, newColor, outputDir);
            
            System.out.println("\n=== DEMONSTRAÇÃO CONCLUÍDA ===");
            System.out.println("Verifique as imagens geradas no diretório: " + outputDir);
            
        } catch (Exception e) {
            System.err.println("Erro durante a execução: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * Cria ou carrega uma imagem de teste
     */
    private static BufferedImage createOrLoadTestImage(String imagePath, int width, int height) {
        System.out.println("Tentando carregar imagem: " + imagePath);
        
        // Primeiro tenta carregar a imagem existente
        BufferedImage image = ImageProcessor.loadImage(imagePath);
        
        if (image == null) {
            System.out.println("Imagem não encontrada, criando imagem de teste...");
            // Se não conseguir carregar, cria uma imagem de teste
            image = ImageProcessor.createTestImage(width, height);
            
            // Salva a imagem criada para futuras execuções
            if (image != null) {
                ImageProcessor.saveImage(image, imagePath);
            }
        }
        
        return image;
    }
    
    /**
     * Demonstra o flood fill usando Pilha
     */
    private static void demonstrateStackFloodFill(BufferedImage image, int startX, int startY, 
                                                  int newColor, String outputDir) {
        
        // Cria uma cópia da imagem para não alterar a original
        BufferedImage workingImage = ImageProcessor.copyImage(image);
        
        // Cria o gerenciador de animação
        AnimationManager animationManager = new AnimationManager(
            outputDir + "/stack_animation", 
            "stack_flood_fill", 
            5  // Captura a cada 5 pixels para reduzir o número de frames
        );
        
        // Salva o frame inicial
        animationManager.addFrame(workingImage);
        
        // Cria o algoritmo de flood fill com pilha
        FloodFillStack floodFillStack = new FloodFillStack(workingImage);
        
        // Define o listener para capturar a animação
        floodFillStack.setFloodFillListener(new FloodFillStack.FloodFillListener() {
            @Override
            public void onPixelPainted(int x, int y, BufferedImage currentImage) {
                animationManager.addFrame(currentImage);
            }
        });
        
        // Executa o flood fill
        long startTime = System.currentTimeMillis();
        floodFillStack.floodFill(startX, startY, newColor);
        long endTime = System.currentTimeMillis();
        
        // Salva a imagem final
        String stackOutputPath = outputDir + "/stack_result.png";
        ImageProcessor.saveImage(workingImage, stackOutputPath);
        
        // Salva os frames da animação
        animationManager.saveFirstAndLastFrame();
        
        // Informações sobre a execução
        System.out.println("Tempo de execução (Stack): " + (endTime - startTime) + " ms");
        animationManager.printAnimationInfo();
    }
    
    /**
     * Demonstra o flood fill usando Fila
     */
    private static void demonstrateQueueFloodFill(BufferedImage image, int startX, int startY, 
                                                  int newColor, String outputDir) {
        
        // Cria uma cópia da imagem para não alterar a original
        BufferedImage workingImage = ImageProcessor.copyImage(image);
        
        // Cria o gerenciador de animação
        AnimationManager animationManager = new AnimationManager(
            outputDir + "/queue_animation", 
            "queue_flood_fill", 
            5  // Captura a cada 5 pixels para reduzir o número de frames
        );
        
        // Salva o frame inicial
        animationManager.addFrame(workingImage);
        
        // Cria o algoritmo de flood fill com fila
        FloodFillQueue floodFillQueue = new FloodFillQueue(workingImage);
        
        // Define o listener para capturar a animação
        floodFillQueue.setFloodFillListener(new FloodFillQueue.FloodFillListener() {
            @Override
            public void onPixelPainted(int x, int y, BufferedImage currentImage) {
                animationManager.addFrame(currentImage);
            }
        });
        
        // Executa o flood fill
        long startTime = System.currentTimeMillis();
        floodFillQueue.floodFill(startX, startY, newColor);
        long endTime = System.currentTimeMillis();
        
        // Salva a imagem final
        String queueOutputPath = outputDir + "/queue_result.png";
        ImageProcessor.saveImage(workingImage, queueOutputPath);
        
        // Salva os frames da animação
        animationManager.saveFirstAndLastFrame();
        
        // Informações sobre a execução
        System.out.println("Tempo de execução (Queue): " + (endTime - startTime) + " ms");
        animationManager.printAnimationInfo();
    }
}