package adt.stack;

import adt.list.IList;

/**
 * Implementación de pila usando una lista (IList).
 * Soporta tanto lista simplemente encadenada como doblemente encadenada,
 * ya que depende de la interfaz IList (Patrón Strategy).
 * @param <T> Tipo genérico de los elementos.
 */
public class StackList<T> extends AbstractStack<T> {
    private IList<T> list;

    /**
     * Constructor que recibe una implementación de IList.
     * @param list Implementación de lista a usar internamente.
     */
    public StackList(IList<T> list) {
        this.list = list;
    }

    @Override
    public void push(T value) {
        // Agrega al inicio de la lista (índice 0 = tope de la pila)
        list.add(value);
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("La pila está vacía.");
        }
        // Elimina del inicio (índice 0 = tope de la pila)
        return list.remove(0);
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("La pila está vacía.");
        }
        return list.get(0);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public void clear() {
        list.clear();
    }
}
