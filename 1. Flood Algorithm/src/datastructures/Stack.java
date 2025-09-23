package datastructures;

import java.util.ArrayList;

/**
 * Implementação própria de uma Pilha (Stack) usando ArrayList como base.
 * Esta implementação segue o princípio LIFO (Last In, First Out).
 */
public class Stack<T> {
    private ArrayList<T> elements;
    
    /**
     * Construtor da pilha
     */
    public Stack() {
        this.elements = new ArrayList<>();
    }
    
    /**
     * Adiciona um elemento no topo da pilha
     * @param element elemento a ser adicionado
     */
    public void push(T element) {
        elements.add(element);
    }
    
    /**
     * Remove e retorna o elemento do topo da pilha
     * @return elemento do topo da pilha
     * @throws RuntimeException se a pilha estiver vazia
     */
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Pilha vazia - não é possível fazer pop");
        }
        return elements.remove(elements.size() - 1);
    }
    
    /**
     * Retorna o elemento do topo da pilha sem removê-lo
     * @return elemento do topo da pilha
     * @throws RuntimeException se a pilha estiver vazia
     */
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Pilha vazia - não é possível fazer peek");
        }
        return elements.get(elements.size() - 1);
    }
    
    /**
     * Verifica se a pilha está vazia
     * @return true se a pilha estiver vazia, false caso contrário
     */
    public boolean isEmpty() {
        return elements.isEmpty();
    }
    
    /**
     * Retorna o tamanho da pilha
     * @return número de elementos na pilha
     */
    public int size() {
        return elements.size();
    }
    
    /**
     * Remove todos os elementos da pilha
     */
    public void clear() {
        elements.clear();
    }
}