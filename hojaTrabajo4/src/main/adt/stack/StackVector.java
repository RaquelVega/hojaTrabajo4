package adt.stack;

import java.util.Vector;

/**
 * Implementación de pila usando Vector de Java.
 * @param <T> Tipo genérico de los elementos.
 */
public class StackVector<T> extends AbstractStack<T> {
    private Vector<T> data;

    public StackVector() {
        this.data = new Vector<>();
    }

    @Override
    public void push(T value) {
        data.add(value);
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("La pila está vacía.");
        }
        return data.remove(data.size() - 1);
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("La pila está vacía.");
        }
        return data.get(data.size() - 1);
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public void clear() {
        data.clear();
    }
}