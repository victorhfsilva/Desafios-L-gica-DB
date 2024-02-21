package exerc20;

import java.io.Closeable;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Logger;

public class Menu implements Closeable {
    
    protected Logger logger = Logger.getLogger(Menu.class.toString());
    protected Scanner scanner = new Scanner(System.in);
    protected Pedido pedido = new Pedido();
    
    public void controlaMenu() {
        logger.info("[p] Adiciona Pedido | [e] Imprime Estoque");
        String opcao = scanner.nextLine();
        switchCase(opcao);
    }

    public void mostraEstoque() {
        Estoque.imprimeCatalogDoEstoque();
    }

    public void switchCase(String opcao) {
        switch (opcao) {
            case "p":
                pedido.adicionaItem();
                break;
            case "e":
                mostraEstoque();
                break;
            default:
                logger.warning("Opção inválida!");
                break;
        }
    }
    
    @Override
    public void close() throws IOException {
        scanner.close();
    }
}
