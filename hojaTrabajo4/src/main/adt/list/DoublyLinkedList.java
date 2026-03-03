package adt.list;

/**
 * Implementación de lista doblemente encadenada.
 * Cada nodo tiene referencia al siguiente y al anterior.
 * @param <T> Tipo genérico de los elementos.
 */
public class DoublyLinkedList<T> extends AbstractList<T> {
    private DNode<T> head;
    private DNode<T> tail;

    public DoublyLinkedList() {
        super();
        this.head = null;
        this.tail = null;
    }

    @Override
    public void add(T value) {
        DNode<T> newNode = new DNode<>(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        }
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
            if (head != null) {
                head.setPrev(null);
            } else {
                tail = null;
            }
        } else {
            DNode<T> current = head;
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
            removed = current.getData();
            if (current.getPrev() != null) {
                current.getPrev().setNext(current.getNext());
            }
            if (current.getNext() != null) {
                current.getNext().setPrev(current.getPrev());
            } else {
                tail = current.getPrev();
            }
        }
        count--;
        return removed;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + index);
        }
        DNode<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getData();
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        count = 0;
    }
}