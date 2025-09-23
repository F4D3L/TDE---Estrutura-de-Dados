package datastructures;

import java.util.ArrayList;

/**
 * Implementação própria de uma Fila (Queue) usando ArrayList como base.
 * Esta implementação segue o princípio FIFO (First In, First Out).
 */
public class Queue<T> {
    private ArrayList<T> elements;
    
    /**
     * Construtor da fila
     */
    public Queue() {
        this.elements = new ArrayList<>();
    }
    
    /**
     * Adiciona um elemento no final da fila
     * @param element elemento a ser adicionado
     */
    public void enqueue(T element) {
        elements.add(element);
    }
    
    /**
     * Remove e retorna o primeiro elemento da fila
     * @return primeiro elemento da fila
     * @throws RuntimeException se a fila estiver vazia
     */
    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Fila vazia - não é possível fazer dequeue");
        }
        return elements.remove(0);
    }
    
    /**
     * Retorna o primeiro elemento da fila sem removê-lo
     * @return primeiro elemento da fila
     * @throws RuntimeException se a fila estiver vazia
     */
    public T front() {
        if (isEmpty()) {
            throw new RuntimeException("Fila vazia - não é possível acessar o front");
        }
        return elements.get(0);
    }
    
    /**
     * Verifica se a fila está vazia
     * @return true se a fila estiver vazia, false caso contrário
     */
    public boolean isEmpty() {
        return elements.isEmpty();
    }
    
    /**
     * Retorna o tamanho da fila
     * @return número de elementos na fila
     */
    public int size() {
        return elements.size();
    }
    
    /**
     * Remove todos os elementos da fila
     */
    public void clear() {
        elements.clear();
    }
}