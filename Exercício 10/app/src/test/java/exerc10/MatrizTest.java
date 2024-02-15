package exerc10;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class MatrizTest {
    
    @Test
    void verificarSomaDiagonalEmMatrix3x3() throws InvalidParameterException {
        double[][] matriz = {
            {1.0, 2.0, 3.0},
            {4.0, 5.0, 6.0},
            {7.0, 8.0, 9.0}
        };
        double expectedSum = 15.0;
        double actualSum = Matriz.somaDiagonal(matriz);
        assertEquals(expectedSum, actualSum);
    }

    @Test
    void verificarSomaDiagonalEmMatrix4x4() throws InvalidParameterException {
        double[][] matriz = {
            {1.0, 2.0, 3.0, 4.0},
            {5.0, 6.0, 7.0, 8.0},
            {9.0, 10.0, 11.0, 12.0},
            {13.0, 14.0, 15.0, 16.0}
        };
        double expectedSum = 34.0;
        double actualSum = Matriz.somaDiagonal(matriz);
        assertEquals(expectedSum, actualSum);
    }

    @Test
    void verficarSomaDiagonalEmMatrizRetangular() {
        double[][] matriz = {
            {1.0, 2.0},
            {3.0, 4.0},
            {6.0, 7.0}
        };
        assertThrows(InvalidParameterException.class, () -> Matriz.somaDiagonal(matriz));
    }
}
