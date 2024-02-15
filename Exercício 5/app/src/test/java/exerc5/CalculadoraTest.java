package exerc5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculadoraTest {
    @ParameterizedTest
    @CsvSource({
        "SOMA, 1, 2, 3",
        "SOMA, -1, 2, 1",
        "SOMA, -1, -2, -3",
        "SUBTRACAO, 2, 1, 1",
        "SUBTRACAO, 2, 3, -1",
        "SUBTRACAO, -1, -2, 1",
        "MULTIPLICACAO, 2, 3, 6",
        "MULTIPLICACAO, -2, 3, -6",
        "MULTIPLICACAO, -1, -2, 2",
        "DIVISAO, 6, 3, 2",
        "DIVISAO, -6, 2, -3",
        "DIVISAO, -6, -2, 3",
    })

    void verificaCalcular(Operacao operacao, int num1, int num2, int expectedResultado){
        int actualResultado = Calculadora.calcular(operacao, num1, num2);
        assertEquals(expectedResultado, actualResultado);
    }

    @Test
    void verificarCalcularThrowsArithmeticException(){
        assertThrows(ArithmeticException.class, () -> {
            Calculadora.calcular(Operacao.DIVISAO, 2, 0);
        });
    }

    @Test
    void verificarCalcularThrowsIllegalArgumentException(){
        assertThrows(IllegalArgumentException.class, () -> {
            Calculadora.calcular(null, 2, 2);
        });
    }

    @Test
    void testCalcularTabuada() {
        String expectedTabuada = "\n" +
                                "2 x 1 = 2\n" +
                                "2 x 2 = 4\n" +
                                "2 x 3 = 6\n" +
                                "2 x 4 = 8\n" +
                                "2 x 5 = 10\n" +
                                "2 x 6 = 12\n" +
                                "2 x 7 = 14\n" +
                                "2 x 8 = 16\n" +
                                "2 x 9 = 18\n" +
                                "2 x 10 = 20\n";
        assertEquals(expectedTabuada, Calculadora.calcularTabuada(2));
    }

}
