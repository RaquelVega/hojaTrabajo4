package adt.list;

/**
 * Clase abstracta que implementa parcialmente la interfaz IList.
 * Proporciona implementaciones comunes para isEmpty() y mantiene un contador de elementos.
 * @param <T> Tipo genérico de los elementos de la lista.
 */
public abstract class AbstractList<T> implements IList<T> {
    /** Contador de elementos en la lista. */
    protected int count;

    public AbstractList() {
        this.count = 0;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }
}