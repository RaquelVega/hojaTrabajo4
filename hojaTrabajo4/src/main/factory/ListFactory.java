package factory;

import adt.list.IList;
import adt.list.SinglyLinkedList;
import adt.list.DoublyLinkedList;

/**
 * Factory para crear instancias de IList según el tipo indicado.
 * Patrón de diseño: Factory Method.
 */
public class ListFactory {

    /**
     * Crea una lista del tipo especificado.
     * @param type Tipo de lista: "singly" o "doubly".
     * @param <T> Tipo genérico.
     * @return Instancia de IList.
     */
    public static <T> IList<T> createList(String type) {
        switch (type.toLowerCase()) {
            case "singly":
            case "simplemente encadenada":
                return new SinglyLinkedList<>();
            case "doubly":
            case "doblemente encadenada":
                return new DoublyLinkedList<>();
            default:
                throw new IllegalArgumentException(
                    "Tipo de lista no soportado: " + type +
                    ". Use 'singly' o 'doubly'."
                );
        }
    }
}