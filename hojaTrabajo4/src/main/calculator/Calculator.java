package calculator;

import adt.stack.IStack;
import factory.StackFactory;

/**
 * Clase principal de la calculadora.
 * Coordina la conversión infix->postfix y la evaluación.
 */
public class Calculator {
    private InfixToPostfix converter;
    private PostfixEvaluator evaluator;

    /**
     * Constructor que crea la calculadora con el tipo de stack indicado.
     * @param stackType Tipo de stack: "arraylist", "vector" o "list".
     * @param listType Tipo de lista (solo si stackType="list"): "singly" o "doubly".
     */
    public Calculator(String stackType, String listType) {
        IStack<String> stack1 = StackFactory.createStack(stackType, listType);
        IStack<String> stack2 = StackFactory.createStack(stackType, listType);
        this.converter = new InfixToPostfix(stack1);
        this.evaluator = new PostfixEvaluator(stack2);
    }

    /**
     * Calcula el resultado de una expresión infix.
     * @param infixExpression Expresión infix.
     * @return Resultado numérico.
     */
    public int calculate(String infixExpression) {
        String postfix = converter.convert(infixExpression);
        return evaluator.evaluate(postfix);
    }

    /**
     * Convierte una expresión infix a postfix.
     * @param infixExpression Expresión infix.
     * @return Expresión postfix.
     */
    public String getPostfix(String infixExpression) {
        return converter.convert(infixExpression);
    }
}