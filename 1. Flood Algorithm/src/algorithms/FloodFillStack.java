package algorithms;

import datastructures.Stack;
import model.Point;
import java.awt.image.BufferedImage;
import java.awt.Color;

/**
 * Implementação do algoritmo Flood Fill utilizando uma Pilha (Stack).
 * O algoritmo utiliza o princípio LIFO (Last In, First Out).
 */
public class FloodFillStack {
    private BufferedImage image;
    private int originalColor;
    private int newColor;
    private int width;
    private int height;
    private Stack<Point> stack;
    private FloodFillListener listener;
    
    /**
     * Interface para notificar sobre cada pixel pintado (para animação)
     */
    public interface FloodFillListener {
        void onPixelPainted(int x, int y, BufferedImage currentImage);
    }
    
    /**
     * Construtor do FloodFill com Stack
     * @param image imagem a ser processada
     */
    public FloodFillStack(BufferedImage image) {
        this.image = image;
        this.width = image.getWidth();
        this.height = image.getHeight();
        this.stack = new Stack<>();
    }
    
    /**
     * Define o listener para receber notificações de pixels pintados
     * @param listener objeto que implementa FloodFillListener
     */
    public void setFloodFillListener(FloodFillListener listener) {
        this.listener = listener;
    }
    
    /**
     * Executa o algoritmo Flood Fill usando pilha
     * @param startX coordenada x inicial
     * @param startY coordenada y inicial
     * @param newColor nova cor para preencher (RGB)
     */
    public void floodFill(int startX, int startY, int newColor) {
        // Verifica se o ponto inicial está dentro dos limites da imagem
        if (!isValidPoint(startX, startY)) {
            System.out.println("Ponto inicial inválido: (" + startX + ", " + startY + ")");
            return;
        }
        
        this.originalColor = image.getRGB(startX, startY);
        this.newColor = newColor;
        
        // Se a cor original já é igual à nova cor, não há nada para fazer
        if (originalColor == newColor) {
            System.out.println("Cor original já é igual à nova cor. Nenhuma alteração necessária.");
            return;
        }
        
        // Adiciona o ponto inicial na pilha
        stack.push(new Point(startX, startY));
        
        System.out.println("Iniciando Flood Fill com Stack...");
        System.out.println("Ponto inicial: (" + startX + ", " + startY + ")");
        System.out.println("Cor original: " + colorToString(originalColor));
        System.out.println("Nova cor: " + colorToString(newColor));
        
        int pixelsProcessed = 0;
        
        // Loop principal do algoritmo
        while (!stack.isEmpty()) {
            Point currentPoint = stack.pop();
            int x = currentPoint.getX();
            int y = currentPoint.getY();
            
            // Verifica se o ponto é válido e se tem a cor original
            if (isValidPoint(x, y) && image.getRGB(x, y) == originalColor) {
                // Pinta o pixel com a nova cor
                image.setRGB(x, y, newColor);
                pixelsProcessed++;
                
                // Notifica o listener (para animação)
                if (listener != null) {
                    listener.onPixelPainted(x, y, image);
                }
                
                // Adiciona os 4 vizinhos na pilha (cima, baixo, esquerda, direita)
                stack.push(new Point(x, y - 1)); // cima
                stack.push(new Point(x, y + 1)); // baixo
                stack.push(new Point(x - 1, y)); // esquerda
                stack.push(new Point(x + 1, y)); // direita
            }
        }
        
        System.out.println("Flood Fill com Stack concluído!");
        System.out.println("Pixels processados: " + pixelsProcessed);
    }
    
    /**
     * Verifica se um ponto está dentro dos limites da imagem
     * @param x coordenada x
     * @param y coordenada y
     * @return true se o ponto estiver dentro dos limites, false caso contrário
     */
    private boolean isValidPoint(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }
    
    /**
     * Converte uma cor RGB para string legível
     * @param rgb valor RGB da cor
     * @return string representando a cor
     */
    private String colorToString(int rgb) {
        Color color = new Color(rgb);
        return String.format("RGB(%d, %d, %d)", color.getRed(), color.getGreen(), color.getBlue());
    }
    
    /**
     * Retorna a imagem processada
     * @return BufferedImage com as alterações aplicadas
     */
    public BufferedImage getImage() {
        return image;
    }
}