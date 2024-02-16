package exerc11;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class BubbleSortTest {
    
    @Test
    void testSort() {
        int[] arr = {5, 1, 4, 2, 8};
        int[] sortedArr = {1, 2, 4, 5, 8};
        BubbleSort.sort(arr);
        assertArrayEquals(sortedArr, arr);
    }

    @Test
    void testSortAlreadySortedArray() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] sortedArr = {1, 2, 3, 4, 5};
        BubbleSort.sort(arr);
        assertArrayEquals(sortedArr, arr);
    }

    @Test
    void testSortArrayWithDuplicateElements() {
        int[] arr = {5, 1, 4, 2, 8, 2, 4, 2, 1, 5};
        int[] sortedArr = {1, 1, 2, 2, 2, 4, 4, 5, 5, 8};
        BubbleSort.sort(arr);
        assertArrayEquals(sortedArr, arr);
    }
}
