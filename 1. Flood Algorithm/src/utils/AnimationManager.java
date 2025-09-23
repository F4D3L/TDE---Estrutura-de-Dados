package utils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por gerenciar a animação do processo de Flood Fill.
 * Armazena frames da animação e os salva como imagens sequenciais.
 */
public class AnimationManager {
    private List<BufferedImage> frames;
    private String outputDirectory;
    private String baseFileName;
    private int frameInterval;
    private int currentFrame;
    
    /**
     * Construtor do gerenciador de animação
     * @param outputDirectory diretório onde salvar os frames
     * @param baseFileName nome base dos arquivos de frame
     * @param frameInterval intervalo entre capturas de frames (1 = todo pixel, 5 = a cada 5 pixels)
     */
    public AnimationManager(String outputDirectory, String baseFileName, int frameInterval) {
        this.frames = new ArrayList<>();
        this.outputDirectory = outputDirectory;
        this.baseFileName = baseFileName;
        this.frameInterval = frameInterval;
        this.currentFrame = 0;
    }
    
    /**
     * Construtor simplificado com intervalo padrão de 1
     * @param outputDirectory diretório onde salvar os frames
     * @param baseFileName nome base dos arquivos de frame
     */
    public AnimationManager(String outputDirectory, String baseFileName) {
        this(outputDirectory, baseFileName, 1);
    }
    
    /**
     * Adiciona um frame à animação
     * @param image imagem atual do processo
     */
    public void addFrame(BufferedImage image) {
        if (currentFrame % frameInterval == 0) {
            // Cria uma cópia da imagem para evitar problemas de referência
            BufferedImage frameCopy = ImageProcessor.copyImage(image);
            frames.add(frameCopy);
        }
        currentFrame++;
    }
    
    /**
     * Salva todos os frames da animação como imagens PNG numeradas
     * @return true se todos os frames foram salvos com sucesso
     */
    public boolean saveAllFrames() {
        System.out.println("Salvando " + frames.size() + " frames da animação...");
        
        // Cria o diretório de saída se não existir
        java.io.File dir = new java.io.File(outputDirectory);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        
        boolean success = true;
        for (int i = 0; i < frames.size(); i++) {
            String fileName = String.format("%s_frame_%04d.png", baseFileName, i);
            String filePath = outputDirectory + java.io.File.separator + fileName;
            
            if (!ImageProcessor.saveImage(frames.get(i), filePath)) {
                success = false;
                System.err.println("Erro ao salvar frame " + i);
            }
        }
        
        if (success) {
            System.out.println("Animação salva com sucesso em: " + outputDirectory);
            System.out.println("Total de frames: " + frames.size());
        }
        
        return success;
    }
    
    /**
     * Salva apenas o primeiro e último frame
     * @return true se ambos os frames foram salvos com sucesso
     */
    public boolean saveFirstAndLastFrame() {
        if (frames.isEmpty()) {
            System.out.println("Nenhum frame para salvar");
            return false;
        }
        
        // Cria o diretório de saída se não existir
        java.io.File dir = new java.io.File(outputDirectory);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        
        boolean success = true;
        
        // Salva o primeiro frame
        String firstFramePath = outputDirectory + java.io.File.separator + baseFileName + "_inicial.png";
        if (!ImageProcessor.saveImage(frames.get(0), firstFramePath)) {
            success = false;
        }
        
        // Salva o último frame
        String lastFramePath = outputDirectory + java.io.File.separator + baseFileName + "_final.png";
        BufferedImage lastFrame = frames.get(frames.size() - 1);
        if (!ImageProcessor.saveImage(lastFrame, lastFramePath)) {
            success = false;
        }
        
        if (success) {
            System.out.println("Frames inicial e final salvos em: " + outputDirectory);
        }
        
        return success;
    }
    
    /**
     * Limpa todos os frames da memória
     */
    public void clearFrames() {
        frames.clear();
        currentFrame = 0;
        System.out.println("Frames da animação limpos da memória");
    }
    
    /**
     * Retorna o número total de frames capturados
     * @return número de frames
     */
    public int getFrameCount() {
        return frames.size();
    }
    
    /**
     * Retorna informações sobre a animação
     */
    public void printAnimationInfo() {
        System.out.println("=== Informações da Animação ===");
        System.out.println("Frames capturados: " + frames.size());
        System.out.println("Intervalo de captura: " + frameInterval);
        System.out.println("Diretório de saída: " + outputDirectory);
        System.out.println("Nome base: " + baseFileName);
        System.out.println("===============================");
    }
    
    /**
     * Define um novo intervalo de frames
     * @param interval novo intervalo
     */
    public void setFrameInterval(int interval) {
        this.frameInterval = Math.max(1, interval);
    }
    
    /**
     * Retorna o intervalo atual de frames
     * @return intervalo de frames
     */
    public int getFrameInterval() {
        return frameInterval;
    }
}