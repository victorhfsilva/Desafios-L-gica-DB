package exerc5;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {

    private static final Logger logger = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            logger.info("Insira um numero: ");
            int num = scanner.nextInt();
    
            String resultado = Calculadora.calcularTabuada(num);
            logger.info(resultado);

        } catch (InputMismatchException ex) {
            logger.log(Level.SEVERE, "Numero Invalido.", ex);
        }

    }
}
