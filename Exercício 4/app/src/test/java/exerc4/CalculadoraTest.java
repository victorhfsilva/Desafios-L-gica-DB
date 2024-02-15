package exerc4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculadoraTest {
    @ParameterizedTest
    @CsvSource({
        "SOMA, 1, 2, 3",
        "SOMA, 1.12, 2.12, 3.24",
        "SOMA, -1, 2, 1",
        "SOMA, -1, -2, -3",
        "SUBTRACAO, 2, 1, 1",
        "SUBTRACAO, 2.12, 1.11, 1.01",
        "SUBTRACAO, 2, 3, -1",
        "SUBTRACAO, -1, -2, 1",
        "MULTIPLICACAO, 2, 3, 6",
        "MULTIPLICACAO, 2.5, 2.5, 6.25",
        "MULTIPLICACAO, -2, 3, -6",
        "MULTIPLICACAO, -1, -2, 2",
        "DIVISAO, 6, 3, 2",
        "DIVISAO, 6.6, 1.65, 4",
        "DIVISAO, -6.6, 1.65, -4",
        "DIVISAO, -6.6, -1.65, 4",
    })
    void verificaCalcular(Operacao operacao, double num1, double num2, double expectedResultado){
        double actualResultado = Calculadora.calcular(operacao, num1, num2);
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
}
