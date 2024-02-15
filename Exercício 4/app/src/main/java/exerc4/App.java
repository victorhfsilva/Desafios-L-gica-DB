package exerc4;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {

    private static final Logger logger = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            logger.info("Insira um numero:");
            String num1Str = scanner.nextLine();
            double num1 = Double.parseDouble(num1Str);

            logger.info("Insira uma operacao");
            String valueOperacao = scanner.nextLine();
            Operacao operacao = Operacao.getByValue(valueOperacao);

            logger.info("Insira outro numero:");
            String num2Str = scanner.nextLine();
            double num2 = Double.parseDouble(num2Str);

            double resultado = Calculadora.calcular(operacao, num1, num2);
            logger.info("O resultado de " + num1 + valueOperacao + num2 + " eh " + resultado);

        } catch (InputMismatchException ex){
            logger.log(Level.SEVERE, "Input Invalido.", ex);
        } catch (ArithmeticException ex) {
            logger.log(Level.SEVERE, "Divisao por zero nao eh permitida.", ex);
        } catch (IllegalArgumentException ex) {
            logger.log(Level.SEVERE, "Operacao Invalida.", ex);
        } finally {
            scanner.close();
        }

    }
}
