package exerc6;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RandomIntegerListTest {
    
    @ParameterizedTest
    @CsvSource({
        "1000, 1000",
        "100, 1000",
        "10, 100",
        "1, 10"
    })
    void verifyIfAllValuesAreValid(int size, int maximumValue) throws InvalidParameterException {
        List<Integer> randomList = RandomIntegerList.generateRandomList(size, maximumValue);
        
        randomList.forEach(i -> {
            assertTrue(i >= 0 && i <= maximumValue);
        });
    }

    @Test
    void testGetMaximumValue() {
        List<Integer> numbers = List.of(3, 7, 2, 9, 5);
        int max = RandomIntegerList.getMaximumValue(numbers);
        assertEquals(9, max);
    }

    @Test
    void testGetMinimumValue() {
        List<Integer> numbers = List.of(3, 7, 2, 9, 5);
        int min = RandomIntegerList.getMinimumValue(numbers);
        assertEquals(2, min);
    }

    @Test
    void testConvertListToString() {
        List<Integer> numbers = List.of(3, 7, 2, 9, 5);
        String convertedList = RandomIntegerList.convertListToString(numbers);
        assertEquals("3 7 m2 M9 5", convertedList);
    }

    @Test
    void verifyIfInvalidSizeThrowsException() throws InvalidParameterException {
        assertThrows(InvalidParameterException.class, () -> {
            RandomIntegerList.generateRandomList(0, 10);
        });
    }

    @Test
    void verifyIfInvalidMaximumValueThrowsException() throws InvalidParameterException {
        assertThrows(InvalidParameterException.class, () -> {
            RandomIntegerList.generateRandomList(10, 0);
        });
    }
}
