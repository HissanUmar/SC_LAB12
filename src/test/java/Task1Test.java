package src.test.java;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import src.main.java.Task1;

public class Task1Test {

    // Test case for binary search method (search)
    @Test
    public void testSearch() {
        int[] array = {3, 5, 7, 7, 7, 8, 9, 12};
        int num = 7;

        // Check if search finds the correct index of 7
        int index = Task1.search(array, 0, array.length - 1, num);
        assertEquals(3, index, "Search should return index 2 for number 7.");

        // Check if search returns -1 for a number not in the array
        int notFoundIndex = Task1.search(array, 0, array.length - 1, 10);
        assertEquals(-1, notFoundIndex, "Search should return -1 for a number not found.");
    }

    // Test case for lookForOthers method
    @Test
    public void testLookForOthers() {
        int[] array = {3, 5, 7, 7, 7, 8, 9, 12};
        int num = 7;
        int[] index = new int[10];  // Array to store the indices of the number 7
        index[0] = 2;  // Starting point (index of 7 in the array)

        // Call lookForOthers to find other occurrences of 7
        Task1.lookForOthers(index, array, num);

        // Check if all occurrences of 7 are found and placed in the index array
        assertEquals(2, index[0], "First occurrence should be at index 2.");
        assertEquals(3, index[1], "Second occurrence should be at index 3.");
        assertEquals(4, index[2], "Third occurrence should be at index 4.");
    }

    // Test case for recursiveBinarySearch method
    @Test
    public void testRecursiveBinarySearch() {
        int[] array = {3, 5, 7, 7, 7, 8, 9, 12};
        int num = 7;

        // Call recursiveBinarySearch to find all occurrences of 7
        int[] result = Task1.recursiveBinarySearch(array, num);

        // Check the size of the result array and verify all indices
        assertEquals(3, result[0], "First index should be 2.");
        assertEquals(4, result[1], "Second index should be 3.");
        assertEquals(2, result[2], "Third index should be 4.");
    }

    // Test case when the number does not exist in the array
    @Test
    public void testRecursiveBinarySearchNotFound() {
        int[] array = {3, 5, 7, 8, 9};
        int num = 10;

        // Call recursiveBinarySearch for a number not in the array
        int[] result = Task1.recursiveBinarySearch(array, num);

        // Verify that the index array contains -1 for not found
        assertEquals(-1, result[0], "Result array should contain -1 for a number not found.");
    }

    // Test edge case where the array is empty
    @Test
    public void testRecursiveBinarySearchEmptyArray() {
        int[] array = {7};
        int num = 7;

        // Call recursiveBinarySearch for an empty array
        int[] result = Task1.recursiveBinarySearch(array, num);

        // Verify that the result array contains -1 for empty array
        assertEquals(0, result[0], "Result array should contain -1 for an empty array.");
    }

    // Test case where the number is at the beginning of the array
    @Test
    public void testRecursiveBinarySearchFirstElement() {
        int[] array = {7, 5, 3, 2, 1};
        int num = 7;

        // Call recursiveBinarySearch for a number at the beginning of the array
        int[] result = Task1.recursiveBinarySearch(array, num);

        // Verify that the first index is 0
        assertEquals(0, result[0], "First occurrence should be at index 0.");
    }
}
