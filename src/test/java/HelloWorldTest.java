package src.test.java;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import src.main.java.HelloWorld;

public class HelloWorldTest {

    // Test case for the convertToNum method
    @Test
    public void testConvertToNum() {
        // Test the conversion of character '0'
        int result = HelloWorld.convertToNum('0');
        assertEquals(0, result, "The conversion of '0' should return 0.");

        // Test the conversion of character '5'
        result = HelloWorld.convertToNum('5');
        assertEquals(5, result, "The conversion of '5' should return 5.");

        // Test the conversion of character '9'
        result = HelloWorld.convertToNum('9');
        assertEquals(9, result, "The conversion of '9' should return 9.");
    }

    // Test case for the task3 method
    @Test
    public void testTask3() {
        // Test case where digits are "9463"
        int result = HelloWorld.task3("9463");
        assertEquals(22, result, "The sum of the digits 9 + 4 + 6 + 3 should be 22.");

        // Test case where digits are "12345"
        result = HelloWorld.task3("12345");
        assertEquals(15, result, "The sum of the digits 1 + 2 + 3 + 4 + 5 should be 15.");

        // Test case with a single digit "7"
        result = HelloWorld.task3("7");
        assertEquals(7, result, "The sum of the digits 7 should be 7.");

        // Test case with all zero digits "0000"
        result = HelloWorld.task3("0000");
        assertEquals(0, result, "The sum of the digits 0 + 0 + 0 + 0 should be 0.");

        // Test case with an empty string ""
        result = HelloWorld.task3("");
        assertEquals(0, result, "The sum of an empty string should be 0.");
    }
}
