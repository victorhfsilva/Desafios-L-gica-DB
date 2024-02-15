package exerc3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class JokenPoTest {
    
    @ParameterizedTest
    @CsvSource({
        "PEDRA, TESOURA, JOGADOR_VENCE",
        "TESOURA, PAPEL, JOGADOR_VENCE",
        "PAPEL, PEDRA, JOGADOR_VENCE",
        "PEDRA, PEDRA, EMPATE",
        "TESOURA, TESOURA, EMPATE",
        "PAPEL, PAPEL, EMPATE",
        "TESOURA, PEDRA, MAQUINA_VENCE",
        "PAPEL, TESOURA, MAQUINA_VENCE",
        "PEDRA, PAPEL, MAQUINA_VENCE"
    })
    void verificaDeterminarVencedor(String escolhaJogador, String escolhaMaquina, String expectedResultado) {
        Resultado resultado = JoKenPo.determinarVencedor(JoKenPo.valueOf(escolhaJogador), JoKenPo.valueOf(escolhaMaquina));
        assertEquals(expectedResultado, resultado.toString());
    }
}
