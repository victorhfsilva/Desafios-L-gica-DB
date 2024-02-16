package exerc15;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

 class OperacaoTest {

    @ParameterizedTest
    @CsvSource({
        "+, SOMA",
        "-, SUBTRACAO",
        "*, MULTIPLICACAO",
        "/, DIVISAO",
        "^, POTENCIACAO"
    })
    void verificarGetOperacaoByValue(String value, String expectedOperacao) {
        Operacao operacao = Operacao.getByValue(value);
        assertEquals(expectedOperacao, operacao.toString());
    }

    @Test
    void verificarGetOperacaoByWrongValue(){
        Operacao operacao = Operacao.getByValue("%");
        assertNull(operacao);
    }
    
}
