package exerc3;

import java.util.Random;

public enum JoKenPo {
    PEDRA,
    PAPEL,
    TESOURA;

    private static final Random random = new Random();

    public static JoKenPo sortear() {
        JoKenPo[] valores = JoKenPo.values();
        return valores[random.nextInt(valores.length)];
    }

    public static Resultado determinarVencedor(JoKenPo jogador, JoKenPo maquina) {
        if (jogador == maquina) {
            return Resultado.EMPATE;
        } else if ((jogador == PEDRA && maquina == TESOURA) ||
                   (jogador == PAPEL && maquina == PEDRA) ||
                   (jogador == TESOURA && maquina == PAPEL)) {
            return Resultado.JOGADOR_VENCE;
        } else {
            return Resultado.MAQUINA_VENCE;
        }
    }

}
