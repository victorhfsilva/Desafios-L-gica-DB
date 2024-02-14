package exerc1;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {

    private static final Logger logger = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        logger.info("Insira o nome da Pessoa: ");
        String nome = scanner.nextLine();

        logger.info("Insira a idade da Pessoa: ");
        String idade = scanner.nextLine();

        try {
            int idadeInt = Integer.parseInt(idade);
            Pessoa pessoa = new Pessoa(nome, idadeInt);
            
            if (pessoa.isMaiorDeIdade()){
                logger.info("A pessoa de nome " + nome + " e maior de idade.");
            } else {
                logger.info("A pessoa de nome " + nome + " nao e maior de idade.");
            }

        } catch (NumberFormatException ex) {
            logger.log(Level.SEVERE, "Idade Invalida.", ex);
        } catch (ExcecaoParametroInvalido ex) {
            logger.log(Level.SEVERE, "Parametro Invalido: " + ex.getMessage(), ex);
        }finally {
            scanner.close();
        }

    }
}
