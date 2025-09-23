package utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;

/**
 * Classe utilitária para carregar, processar e salvar imagens PNG.
 * Inclui funcionalidades para criar imagens de exemplo e animações.
 */
public class ImageProcessor {
    
    /**
     * Carrega uma imagem PNG de um arquivo
     * @param filePath caminho para o arquivo da imagem
     * @return BufferedImage carregada ou null em caso de erro
     */
    public static BufferedImage loadImage(String filePath) {
        try {
            File imageFile = new File(filePath);
            if (!imageFile.exists()) {
                System.err.println("Arquivo não encontrado: " + filePath);
                return null;
            }
            
            BufferedImage image = ImageIO.read(imageFile);
            System.out.println("Imagem carregada com sucesso: " + filePath);
            System.out.println("Dimensões: " + image.getWidth() + "x" + image.getHeight());
            return image;
            
        } catch (IOException e) {
            System.err.println("Erro ao carregar imagem: " + e.getMessage());
            return null;
        }
    }
    
    /**
     * Salva uma imagem PNG em um arquivo
     * @param image imagem a ser salva
     * @param filePath caminho onde salvar a imagem
     * @return true se a imagem foi salva com sucesso, false caso contrário
     */
    public static boolean saveImage(BufferedImage image, String filePath) {
        try {
            File outputFile = new File(filePath);
            
            // Cria os diretórios pai se não existirem
            File parentDir = outputFile.getParentFile();
            if (parentDir != null && !parentDir.exists()) {
                parentDir.mkdirs();
            }
            
            boolean result = ImageIO.write(image, "PNG", outputFile);
            if (result) {
                System.out.println("Imagem salva com sucesso: " + filePath);
            } else {
                System.err.println("Erro ao salvar imagem: " + filePath);
            }
            return result;
            
        } catch (IOException e) {
            System.err.println("Erro ao salvar imagem: " + e.getMessage());
            return false;
        }
    }
    
    /**
     * Cria uma cópia de uma imagem
     * @param original imagem original
     * @return cópia da imagem
     */
    public static BufferedImage copyImage(BufferedImage original) {
        BufferedImage copy = new BufferedImage(
            original.getWidth(), 
            original.getHeight(), 
            original.getType()
        );
        
        Graphics2D g2d = copy.createGraphics();
        g2d.drawImage(original, 0, 0, null);
        g2d.dispose();
        
        return copy;
    }
    
    /**
     * Cria uma imagem de exemplo simples para testar o algoritmo
     * @param width largura da imagem
     * @param height altura da imagem
     * @return BufferedImage com padrão de teste
     */
    public static BufferedImage createTestImage(int width, int height) {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = image.createGraphics();
        
        // Preenche o fundo com branco
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, width, height);
        
        // Desenha uma linha diagonal preta
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new java.awt.BasicStroke(2));
        g2d.drawLine(0, 0, width - 1, height - 1);
        
        // Desenha uma linha horizontal
        g2d.drawLine(0, height / 2, width - 1, height / 2);
        
        // Desenha uma linha vertical
        g2d.drawLine(width / 2, 0, width / 2, height - 1);
        
        // Desenha um retângulo
        g2d.drawRect(width / 4, height / 4, width / 2, height / 2);
        
        g2d.dispose();
        
        System.out.println("Imagem de teste criada: " + width + "x" + height);
        return image;
    }
    
    /**
     * Cria uma imagem simples com apenas fundo branco e borda preta
     * @param width largura da imagem
     * @param height altura da imagem
     * @return BufferedImage simples para teste
     */
    public static BufferedImage createSimpleTestImage(int width, int height) {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = image.createGraphics();
        
        // Preenche o fundo com branco
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, width, height);
        
        // Desenha apenas uma borda preta
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new java.awt.BasicStroke(1));
        g2d.drawRect(0, 0, width - 1, height - 1);
        
        g2d.dispose();
        
        System.out.println("Imagem simples criada: " + width + "x" + height);
        return image;
    }
    
    /**
     * Converte uma cor RGB para inteiro
     * @param red componente vermelha (0-255)
     * @param green componente verde (0-255)
     * @param blue componente azul (0-255)
     * @return valor RGB como inteiro
     */
    public static int rgbToInt(int red, int green, int blue) {
        return new Color(red, green, blue).getRGB();
    }
    
    /**
     * Retorna informações sobre uma imagem
     * @param image imagem a ser analisada
     */
    public static void printImageInfo(BufferedImage image) {
        if (image == null) {
            System.out.println("Imagem é null");
            return;
        }
        
        System.out.println("=== Informações da Imagem ===");
        System.out.println("Largura: " + image.getWidth());
        System.out.println("Altura: " + image.getHeight());
        System.out.println("Tipo: " + image.getType());
        
        // Mostra as cores dos cantos
        int topLeft = image.getRGB(0, 0);
        int topRight = image.getRGB(image.getWidth() - 1, 0);
        int bottomLeft = image.getRGB(0, image.getHeight() - 1);
        int bottomRight = image.getRGB(image.getWidth() - 1, image.getHeight() - 1);
        
        System.out.println("Cor superior esquerda: " + colorToString(topLeft));
        System.out.println("Cor superior direita: " + colorToString(topRight));
        System.out.println("Cor inferior esquerda: " + colorToString(bottomLeft));
        System.out.println("Cor inferior direita: " + colorToString(bottomRight));
        System.out.println("=============================");
    }
    
    /**
     * Converte uma cor RGB para string legível
     * @param rgb valor RGB da cor
     * @return string representando a cor
     */
    private static String colorToString(int rgb) {
        Color color = new Color(rgb);
        return String.format("RGB(%d, %d, %d)", color.getRed(), color.getGreen(), color.getBlue());
    }
}