package exerc9;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

class FibonacciTest {

    @Test
    void testCalcularSequencia() {
        List<Integer> expectedSequence = List.of(0, 1, 1, 2, 3, 5, 8, 13, 21, 34);
        List<Integer> actualSequence = Fibonacci.calcularSequencia(34);
        assertIterableEquals(expectedSequence, actualSequence);
    }

    @Test
    void testCalcularSequenciaString() {
        String expectedSequenceString = "0 1 1 2 3 5 8 13 21 34";
        String actualSequenceString = Fibonacci.calcularSequenciaString(34);
        assertEquals(expectedSequenceString, actualSequenceString);
    }

}
