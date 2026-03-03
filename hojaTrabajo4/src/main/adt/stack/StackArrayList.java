package adt.stack;

import java.util.ArrayList;

/**
 * Implementación de pila usando ArrayList de Java.
 * @param <T> Tipo genérico de los elementos.
 */
public class StackArrayList<T> extends AbstractStack<T> {
    private ArrayList<T> data;

    public StackArrayList() {
        this.data = new ArrayList<>();
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