package src.test.java;
import src.main.java.ExpressionEvaluator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import src.main.java.ExpressionEvaluator;

public class ExpressionEvaluatorTest {

    // Test for simple addition and subtraction
    @Test
    public void testSimpleAdditionAndSubtraction() {
        assertEquals(8, ExpressionEvaluator.evaluateExpression("3+5"));
        assertEquals(0, ExpressionEvaluator.evaluateExpression("10-10"));
        assertEquals(-3, ExpressionEvaluator.evaluateExpression("3-6"));
    }

    // Test for multiplication and division
    @Test
    public void testMultiplicationAndDivision() {
        assertEquals(2, ExpressionEvaluator.evaluateExpression("6/3"));
        assertEquals(2.5, ExpressionEvaluator.evaluateExpression("5/2"));
    }

    // Test for mixed operators (handling precedence)
    @Test
    public void testMixedOperators() {
        assertEquals(13.0, ExpressionEvaluator.evaluateExpression("3+5*2"));
        assertEquals(11.0, ExpressionEvaluator.evaluateExpression("10+5/5"));
        assertEquals(8.0, ExpressionEvaluator.evaluateExpression("2+3*2"));
    }

    // Test for parentheses
    @Test
    public void testParentheses() {
        assertEquals(16, ExpressionEvaluator.evaluateExpression("(3+5)*2"));
        assertEquals(16, ExpressionEvaluator.evaluateExpression("2*(3+5)"));
        assertEquals(13.0, ExpressionEvaluator.evaluateExpression("3+(5*2)"));
    }




}
