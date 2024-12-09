package src.main.java;

import java.util.Scanner;

public class ExpressionEvaluator{

    /**
     * Recursive method to evaluate the given mathematical expression.
     * Handles floating-point numbers and invalid expressions.
     *
     * @param expression the input expression as a string
     * @return the result of the evaluation
     */
    public static double evaluateExpression(String expression) {
        try {
            return parseExpression(expression.replaceAll("\\s", ""), 0, expression.length() - 1);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            return Double.NaN; // Return NaN to indicate an error
        }
    }

    /**
     * Helper method to evaluate a sub-expression.
     * Handles floating-point numbers and operator precedence.
     *
     * @param expression the input expression without spaces
     * @param start      the starting index of the sub-expression
     * @param end        the ending index of the sub-expression
     * @return the result of the sub-expression
     */
    private static double parseExpression(String expression, int start, int end) {
        int lastOperator = -1;
        int balance = 0; // To handle parentheses

        for (int i = start; i <= end; i++) {
            char current = expression.charAt(i);

            // Track parentheses to find the top-level operator
            if (current == '(') {
                balance++;
            } else if (current == ')') {
                balance--;
            } else if (balance == 0 && (current == '+' || current == '-')) {
                lastOperator = i; // Addition and subtraction have lowest precedence
            } else if (balance == 0 && lastOperator == -1 && (current == '*' || current == '/')) {
                lastOperator = i; // Multiplication and division have higher precedence
            }
        }

        // If parentheses surround the expression, evaluate inside
        if (expression.charAt(start) == '(' && expression.charAt(end) == ')' && balance == 0) {
            return parseExpression(expression, start + 1, end - 1);
        }

        // If an operator is found, divide and conquer
        if (lastOperator != -1) {
            char operator = expression.charAt(lastOperator);
            double left = parseExpression(expression, start, lastOperator - 1);
            double right = parseExpression(expression, lastOperator + 1, end);
            return calculate(left, right, operator);
        }

        // No operator found; parse the number (handling both integers and floating-point)
        return parseNumber(expression, start, end);
    }

    /**
     * Parses a number, supporting both integers and floating-point numbers.
     *
     * @param expression the expression string
     * @param start      the starting index of the number
     * @param end        the ending index of the number
     * @return the parsed number (as a double)
     */
    private static double parseNumber(String expression, int start, int end) {
        try {
            return Double.parseDouble(expression.substring(start, end + 1));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid number: " + expression.substring(start, end + 1));
        }
    }

    /**
     * Performs a calculation based on the operator.
     * 
     * @param left     the left operand
     * @param right    the right operand
     * @param operator the operator (+, -, *, /)
     * @return the result of the calculation
     */
    public static double calculate(double left, double right, char operator) {
        if (operator == '+') {
            return left + right;
        } else if (operator == '-') {
            return left - right;
        } else if (operator == '*') {
            return left * right;
        } else if (operator == '/') {
            if (right != 0) {
                return left / right;
            } else {
                throw new ArithmeticException("Division by zero");
            }
        } else {
            throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
    

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a mathematical expression: ");
        String expression = scanner.nextLine();

        double result = evaluateExpression(expression);
        if (!Double.isNaN(result)) {
            System.out.println("Result: " + result);
        }
        scanner.close();
    }
}