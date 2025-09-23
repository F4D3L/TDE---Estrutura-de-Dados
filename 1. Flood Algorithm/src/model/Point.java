package model;

/**
 * Classe que representa um ponto (coordenada) na imagem
 * com posições x e y.
 */
public class Point {
    private int x;
    private int y;
    
    /**
     * Construtor do ponto
     * @param x coordenada x (horizontal)
     * @param y coordenada y (vertical)
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    /**
     * Retorna a coordenada x
     * @return coordenada x
     */
    public int getX() {
        return x;
    }
    
    /**
     * Retorna a coordenada y
     * @return coordenada y
     */
    public int getY() {
        return y;
    }
    
    /**
     * Define a coordenada x
     * @param x nova coordenada x
     */
    public void setX(int x) {
        this.x = x;
    }
    
    /**
     * Define a coordenada y
     * @param y nova coordenada y
     */
    public void setY(int y) {
        this.y = y;
    }
    
    /**
     * Verifica se dois pontos são iguais
     * @param obj objeto a ser comparado
     * @return true se os pontos forem iguais, false caso contrário
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Point point = (Point) obj;
        return x == point.x && y == point.y;
    }
    
    /**
     * Retorna uma representação em string do ponto
     * @return string no formato "(x, y)"
     */
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}