package exerc2;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {

    private static final Logger logger = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        logger.info("Insira o nome do Produto: ");
        String nome = scanner.nextLine();

        logger.info("Insira o Preco do Produto: ");
        String preco = scanner.nextLine();

        logger.info("Insira a Quantidade do Produto: ");
        String quantidade = scanner.nextLine();

        try {
            double precoDouble = Double.parseDouble(preco);
            int quantidadeInt = Integer.parseInt(quantidade);
            
            Produto produto = new Produto(nome, precoDouble, quantidadeInt);
            double precoTotal = produto.getPrecoTotal();

            logger.info("O valor total do produto " + nome + " eh " + precoTotal);

        } catch (NumberFormatException ex) {

            logger.log(Level.SEVERE, "Input Invalido.", ex);

        } catch (ExcecaoParametroInvalido ex) {

            logger.log(Level.SEVERE, "Parametro Invalido: " + ex.getMessage(), ex);
            
        } finally {
            scanner.close();
        }
    }
}
