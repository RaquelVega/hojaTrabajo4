package calculator;

import adt.stack.IStack;

/**
 * Evalúa expresiones en formato postfix.
 */
public class PostfixEvaluator {
    private IStack<String> stack;

    public PostfixEvaluator(IStack<String> stack) {
        this.stack = stack;
    }

    /**
     * Evalúa una expresión postfix y retorna el resultado.
     * @param postfix Expresión en formato postfix, ej: "10 20 + 9 *"
     * @return Resultado de la evaluación.
     */
    public int evaluate(String postfix) {
        stack.clear();
        String[] tokens = postfix.trim().split("\\s+");

        for (String token : tokens) {
            if (token.isEmpty()) continue;

            if (isNumber(token)) {
                stack.push(token);
            } else if (isOperator(token)) {
                if (stack.size() < 2) {
                    throw new RuntimeException("Expresión postfix inválida: operandos insuficientes.");
                }
                int b = Integer.parseInt(stack.pop());
                int a = Integer.parseInt(stack.pop());
                int result = applyOperator(a, b, token);
                stack.push(String.valueOf(result));
            } else {
                throw new RuntimeException("Token no reconocido: " + token);
            }
        }

        if (stack.size() != 1) {
            throw new RuntimeException("Expresión postfix inválida: resultado incorrecto.");
        }

        return Integer.parseInt(stack.pop());
    }

    /**
     * Aplica un operador a dos operandos.
     */
    private int applyOperator(int a, int b, String op) {
        switch (op) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/":
                if (b == 0) {
                    throw new ArithmeticException("División por cero.");
                }
                return a / b;
            case "^": return (int) Math.pow(a, b);
            default:
                throw new RuntimeException("Operador no soportado: " + op);
        }
    }

    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") ||
               token.equals("*") || token.equals("/") || token.equals("^");
    }

    private boolean isNumber(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}