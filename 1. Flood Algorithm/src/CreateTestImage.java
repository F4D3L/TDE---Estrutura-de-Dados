import utils.ImageProcessor;
import java.awt.image.BufferedImage;

/**
 * Utilitário para criar imagens de exemplo para testar o algoritmo Flood Fill
 */
public class CreateTestImage {
    
    public static void main(String[] args) {
        // Criar diretório se não existir
        java.io.File dir = new java.io.File("images/input");
        if (!dir.exists()) {
            dir.mkdirs();
        }
        
        // Criar imagem simples
        BufferedImage simpleImage = ImageProcessor.createSimpleTestImage(50, 50);
        ImageProcessor.saveImage(simpleImage, "images/input/simple_test.png");
        
        // Criar imagem mais complexa
        BufferedImage complexImage = ImageProcessor.createTestImage(100, 100);
        ImageProcessor.saveImage(complexImage, "images/input/test_image.png");
        
        System.out.println("Imagens de teste criadas com sucesso!");
        System.out.println("- images/input/simple_test.png (50x50)");
        System.out.println("- images/input/test_image.png (100x100)");
    }
}