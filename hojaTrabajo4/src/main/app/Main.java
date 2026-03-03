package app;
import calculator.Calculator;
import calculator.FileReader;
import java.util.Scanner;

/**
 * Clase principal del programa.
 * Lee una expresión infix de datos.txt, la convierte a postfix y la evalúa.
 * Permite al usuario elegir la implementación de stack y lista.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("==============================================");
        System.out.println("  Calculadora de Expresiones Infix -> Postfix");
        System.out.println("==============================================");
        System.out.println();

        // Selección de implementación de Stack
        System.out.println("Seleccione la implementación del Stack:");
        System.out.println("1. ArrayList");
        System.out.println("2. Vector");
        System.out.println("3. Lista");
        System.out.print("Opción: ");
        int stackOption = scanner.nextInt();
        scanner.nextLine(); // Consumir salto de línea

        String stackType;
        String listType = "";

        switch (stackOption) {
            case 1:
                stackType = "arraylist";
                break;
            case 2:
                stackType = "vector";
                break;
            case 3:
                stackType = "list";
                // Si se elige lista, preguntar el tipo de lista
                System.out.println();
                System.out.println("Seleccione la implementación de la Lista:");
                System.out.println("1. Simplemente encadenada");
                System.out.println("2. Doblemente encadenada");
                System.out.print("Opción: ");
                int listOption = scanner.nextInt();
                scanner.nextLine();
                listType = (listOption == 1) ? "singly" : "doubly";
                break;
            default:
                System.out.println("Opción no válida. Usando ArrayList por defecto.");
                stackType = "arraylist";
        }

        // Leer expresión del archivo
        String filename = "datos.txt";
        System.out.println();
        System.out.println("Leyendo expresión del archivo: " + filename);

        try {
            String infixExpression = FileReader.readExpression(filename);
            System.out.println("Expresión infix: " + infixExpression);

            // Crear calculadora con la implementación seleccionada
            Calculator calculator = new Calculator(stackType, listType);

            // Convertir a postfix
            String postfix = calculator.getPostfix(infixExpression);
            System.out.println("Expresión postfix: " + postfix);

            // Evaluar
            int result = calculator.calculate(infixExpression);
            System.out.println("Resultado: " + result);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println();
        System.out.println("==============================================");
        scanner.close();
    }
}