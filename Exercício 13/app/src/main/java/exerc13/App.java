package exerc13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {

    public static final Logger logger = Logger.getLogger(App.class.getName());
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = "";

        logger.info("Insira o nome do aluno.");
        String nome = scanner.nextLine();
        Aluno aluno = new Aluno(nome);

        while(true) {
            logger.info("Insira uma nota do aluno ou precione q para continuar.");
            input = scanner.nextLine();
            if (input.equals("q")) break;
            
            try {
                double nota = Double.parseDouble(input);
                aluno.insertNota(nota);
            } catch (NumberFormatException ex) {
                logger.log(Level.WARNING, "Input Invalido.", ex);
            } catch (ExcecaoParametroInvalido ex) {
                logger.log(Level.WARNING, "Nota Invalido.", ex);
            }
        }

        double media = aluno.getMedia();
        Status status = aluno.getStatus();
        
        logger.info("O Aluno " + nome + " foi " + status + " com media " + media);

    }
}
