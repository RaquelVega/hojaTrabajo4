import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

/**
 * Pruebas unitarias para la calculadora (conversión y evaluación).
 */
public class CalculatorTest {

    private Calculator calc;

    @Before
    public void setup() {
        // Inicialización básica (puedes cambiarla en cada test si necesitas otro tipo)
        calc = new Calculator("arraylist", "");
    }

    @Test
    public void testSimpleAddition() {
        assertEquals(30, calc.calculate("10+20"));
    }

    @Test
    public void testExpressionWithParentheses() {
        assertEquals(270, calc.calculate("(10+20)*9"));
    }

    @Test
    public void testPostfixConversion() {
        Calculator calcVector = new Calculator("vector", "");
        String postfix = calcVector.getPostfix("(10+20)*9");
        assertEquals("10 20 + 9 *", postfix);
    }

    @Test
    public void testWithStackListSingly() {
        Calculator calcList = new Calculator("list", "singly");
        assertEquals(270, calcList.calculate("(10+20)*9"));
    }

    @Test
    public void testWithStackListDoubly() {
        Calculator calcList = new Calculator("list", "doubly");
        assertEquals(270, calcList.calculate("(10+20)*9"));
    }

    @Test
    public void testComplexExpression() {
        // 3+4*2/(1-5)^2 = 3 (división entera)
        assertEquals(3, calc.calculate("3+4*2/(1-5)^2"));
    }

    @Test
    public void testSubtraction() {
        Calculator calcVector = new Calculator("vector", "");
        assertEquals(5, calcVector.calculate("10-5"));
    }

    @Test
    public void testMultiplication() {
        Calculator calcList = new Calculator("list", "doubly");
        assertEquals(50, calcList.calculate("5*10"));
    }

    @Test
    public void testDivision() {
        assertEquals(5, calc.calculate("10/2"));
    }

    @Test
    public void testNestedParentheses() {
        Calculator calcList = new Calculator("list", "singly");
        assertEquals(20, calcList.calculate("((2+3)*4)"));
    }
}