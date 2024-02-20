package exerc20;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class Pedido {
    
    private List<Item> listaDeItens = new ArrayList<>();
    private double valorTotalDoPedido = 0;

    protected Logger logger = Logger.getLogger(Pedido.class.getName());
    protected Scanner scanner = new Scanner(System.in);

    public void calculaValorTotal() {
        valorTotalDoPedido = listaDeItens.stream()
                                .mapToDouble(Item::getValorDoItem).sum();
    }

    public boolean adicionaItemNaLista(Produto produto, int quantidade) {
        Item novoItem = new Item(produto, quantidade);
        if (listaDeItens.add(novoItem)) {
            calculaValorTotal();
            return true;
        }
        return false;
    }

    public void imprimePedido() {
        listaDeItens.forEach(i -> logger.info(i.toString()));
    }

    public void imprimeValorTotal() {
        logger.info("Valor Total: " + valorTotalDoPedido);
    }

    public String recebeNomeDoTeclado() {
        logger.info("Insira um produto.");
        String nomeDoProduto = scanner.nextLine();
        scanner.close();
        return nomeDoProduto;
    }

    public int recebeQuantidadeDoTeclado() {
        logger.info("Insira a quantidade do produto.");
        String quantidadeDoProduto = scanner.nextLine();
        scanner.close();
        return Integer.parseInt(quantidadeDoProduto);
    }

    public void adicionaItem() {

    }

    public void limparCarrinho() {
        listaDeItens.clear();
    }


    public List<Item> getListaDeItens() {
        return this.listaDeItens;
    }

    public void setListaDeItens(List<Item> listaDeItens) {
        this.listaDeItens = listaDeItens;
    }

    public double getValorTotalDoPedido() {
        return this.valorTotalDoPedido;
    }

    public void setValorTotalDoPedido(double valorTotalDoPedido) {
        this.valorTotalDoPedido = valorTotalDoPedido;
    }

}
