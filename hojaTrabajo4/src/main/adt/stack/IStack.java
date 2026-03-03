package adt.stack;

/**
 * Interfaz genérica para el ADT Pila (Stack).
 * Define las operaciones básicas de una pila.
 * @param <T> Tipo genérico de los elementos de la pila.
 */
public interface IStack<T> {
    /**
     * Agrega un elemento al tope de la pila.
     * @param value Elemento a agregar.
     */
    void push(T value);

    /**
     * Elimina y retorna el elemento del tope de la pila.
     * @return Elemento del tope.
     */
    T pop();

    /**
     * Retorna el elemento del tope sin eliminarlo.
     * @return Elemento del tope.
     */
    T peek();

    /**
     * Verifica si la pila está vacía.
     * @return true si la pila no tiene elementos.
     */
    boolean isEmpty();

    /**
     * Retorna el número de elementos en la pila.
     * @return Tamaño de la pila.
     */
    int size();

    /**
     * Elimina todos los elementos de la pila.
     */
    void clear();
}