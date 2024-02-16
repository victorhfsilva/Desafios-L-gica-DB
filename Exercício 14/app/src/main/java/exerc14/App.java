package exerc14;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {

    public static final Logger logger = Logger.getLogger(App.class.getName());

    public static int readSeconds(){
        Scanner scanner = new Scanner(System.in);
        int seconds;

        while (true) {
            logger.info("Insira a quantidade de segundos.");
            String secondsString = scanner.nextLine();
            try {
                seconds = Integer.parseInt(secondsString);
                break;
            } catch (NumberFormatException ex) {
                logger.log(Level.SEVERE, "Input Invalido.", ex);
            }
        }
        scanner.close();
        return seconds;
    }

    public static void main(String[] args) {
        int seconds = readSeconds();
        String time = Time.convertTime(seconds);

        logger.info("A quantidade inserida de segundos equivale a " + time);
    }
}
