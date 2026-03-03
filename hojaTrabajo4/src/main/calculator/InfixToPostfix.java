package calculator;

import adt.stack.IStack;

/**
 * Convierte expresiones infix a postfix usando el algoritmo Shunting-Yard.
 */
public class InfixToPostfix {
    private IStack<String> stack;

    public InfixToPostfix(IStack<String> stack) {
        this.stack = stack;
    }

    /**
     * Convierte una expresión infix a postfix.
     * @param infix Expresión en formato infix, ej: "(10+20)*9"
     * @return Expresión en formato postfix, ej: "10 20 + 9 *"
     */
    public String convert(String infix) {
        StringBuilder postfix = new StringBuilder();
        stack.clear();

        // Tokenizar la expresión
        String[] tokens = tokenize(infix);

        for (String token : tokens) {
            if (token.isEmpty()) continue;

            if (isNumber(token)) {
                // Si es un número, agregar directamente al resultado
                if (postfix.length() > 0) {
                    postfix.append(" ");
                }
                postfix.append(token);
            } else if (token.equals("(")) {
                stack.push(token);
            } else if (token.equals(")")) {
                // Sacar operadores hasta encontrar "("
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    postfix.append(" ").append(stack.pop());
                }
                if (!stack.isEmpty()) {
                    stack.pop(); // Eliminar el "("
                }
            } else if (isOperator(token)) {
                // Sacar operadores con mayor o igual precedencia
                while (!stack.isEmpty() && !stack.peek().equals("(")
                        && precedence(stack.peek()) >= precedence(token)) {
                    postfix.append(" ").append(stack.pop());
                }
                stack.push(token);
            }
        }

        // Sacar los operadores restantes
        while (!stack.isEmpty()) {
            postfix.append(" ").append(stack.pop());
        }

        return postfix.toString();
    }

    /**
     * Tokeniza la expresión infix separando números, operadores y paréntesis.
     */
    private String[] tokenize(String infix) {
        // Insertar espacios alrededor de operadores y paréntesis
        String spaced = infix.replaceAll("([+\\-*/()^])", " $1 ");
        // Limpiar espacios múltiples
        spaced = spaced.trim().replaceAll("\\s+", " ");
        return spaced.split(" ");
    }

    /**
     * Retorna la precedencia de un operador.
     */
    private int precedence(String op) {
        switch (op) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            case "^":
                return 3;
            default:
                return 0;
        }
    }

    /**
     * Verifica si un token es un operador.
     */
    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") ||
               token.equals("*") || token.equals("/") || token.equals("^");
    }

    /**
     * Verifica si un token es un número.
     */
    private boolean isNumber(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}