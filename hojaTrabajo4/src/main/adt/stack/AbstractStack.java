package adt.stack;

/**
 * Clase abstracta que implementa parcialmente la interfaz IStack.
 * Proporciona implementación común para isEmpty().
 * @param <T> Tipo genérico de los elementos de la pila.
 */
public abstract class AbstractStack<T> implements IStack<T> {

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
}