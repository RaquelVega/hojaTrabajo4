package adt.list;

/**
 * Interfaz genérica para el ADT Lista.
 * Define las operaciones básicas que cualquier implementación de lista debe soportar.
 * @param <T> Tipo genérico de los elementos de la lista.
 */
public interface IList<T> {
    /**
     * Agrega un elemento al inicio de la lista.
     * @param value Elemento a agregar.
     */
    void add(T value);

    /**
     * Elimina y retorna el elemento en la posición indicada.
     * @param index Posición del elemento a eliminar.
     * @return Elemento eliminado.
     */
    T remove(int index);

    /**
     * Obtiene el elemento en la posición indicada sin eliminarlo.
     * @param index Posición del elemento.
     * @return Elemento en la posición indicada.
     */
    T get(int index);

    /**
     * Retorna el número de elementos en la lista.
     * @return Tamaño de la lista.
     */
    int size();

    /**
     * Verifica si la lista está vacía.
     * @return true si la lista no tiene elementos.
     */
    boolean isEmpty();

    /**
     * Elimina todos los elementos de la lista.
     */
    void clear();
}