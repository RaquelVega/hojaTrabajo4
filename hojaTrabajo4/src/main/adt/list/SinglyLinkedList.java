package adt.list;

/**
 * Implementación de lista simplemente encadenada.
 * Los elementos se agregan y acceden desde el inicio (head).
 * @param <T> Tipo genérico de los elementos.
 */
public class SinglyLinkedList<T> extends AbstractList<T> {
    private Node<T> head;

    public SinglyLinkedList() {
        super();
        this.head = null;
    }

    @Override
    public void add(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.setNext(head);
        head = newNode;
        count++;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + index);
        }
        T removed;
        if (index == 0) {
            removed = head.getData();
            head = head.getNext();
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            removed = current.getNext().getData();
            current.setNext(current.getNext().getNext());
        }
        count--;
        return removed;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + index);
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getData();
    }

    @Override
    public void clear() {
        head = null;
        count = 0;
    }
}