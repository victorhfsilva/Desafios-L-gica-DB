package exerc3;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {

    private static final Logger logger = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        logger.info("Escolha uma opcao (pedra, papel ou tesoura): ");
        String escolha = scanner.nextLine().toUpperCase();
        try {
            JoKenPo escolhaJogador = JoKenPo.valueOf(escolha);
            
            JoKenPo escolhaMaquina = JoKenPo.sortear();
            logger.info("A maquina jogou " + escolhaMaquina.toString().toLowerCase());
            
            Resultado resultado = JoKenPo.determinarVencedor(escolhaJogador, escolhaMaquina);
            printResultados(resultado);
        
        } catch (IllegalArgumentException ex) {
            logger.log(Level.SEVERE, "Opcao invalida.", ex);
        }
    }

    private static void printResultados(Resultado resultado) {
        switch (resultado) {
            case EMPATE:
                logger.info("Empate!");
                break;
            case JOGADOR_VENCE:
                logger.info("O jogador venceu!");
                break;
            case MAQUINA_VENCE:
                logger.info("A maquina venceu!");
                break;
        }
    }

}
