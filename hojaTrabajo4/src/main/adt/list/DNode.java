package adt.list;

/**
 * Nodo para lista doblemente encadenada.
 * @param <T> Tipo genérico del dato almacenado.
 */
public class DNode<T> {
    private T data;
    private DNode<T> next;
    private DNode<T> prev;

    public DNode(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public DNode<T> getNext() {
        return next;
    }

    public void setNext(DNode<T> next) {
        this.next = next;
    }

    public DNode<T> getPrev() {
        return prev;
    }

    public void setPrev(DNode<T> prev) {
        this.prev = prev;
    }
} 