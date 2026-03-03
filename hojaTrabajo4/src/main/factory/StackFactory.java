package factory;

import adt.list.IList;
import adt.stack.IStack;
import adt.stack.StackArrayList;
import adt.stack.StackVector;
import adt.stack.StackList;

/**
 * Factory para crear instancias de IStack según el tipo indicado.
 * Patrón de diseño: Factory Method.
 */
public class StackFactory {

    /**
     * Crea una pila del tipo especificado.
     * @param type Tipo de pila: "arraylist", "vector" o "list".
     * @param listType Tipo de lista (solo aplica si type="list"): "singly" o "doubly".
     * @param <T> Tipo genérico.
     * @return Instancia de IStack.
     */
    public static <T> IStack<T> createStack(String type, String listType) {
        switch (type.toLowerCase()) {
            case "arraylist":
                return new StackArrayList<>();
            case "vector":
                return new StackVector<>();
            case "list":
            case "lista":
                IList<T> list = ListFactory.createList(listType);
                return new StackList<>(list);
            default:
                throw new IllegalArgumentException(
                    "Tipo de stack no soportado: " + type +
                    ". Use 'arraylist', 'vector' o 'list'."
                );
        }
    }
}