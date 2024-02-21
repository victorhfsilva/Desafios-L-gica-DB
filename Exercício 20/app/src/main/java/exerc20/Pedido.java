package exerc20;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
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
        return nomeDoProduto;
    }

    public int recebeQuantidadeDoTeclado() {
        logger.info("Insira a quantidade do produto.");
        String quantidadeDoProduto = scanner.nextLine();
        return Integer.parseInt(quantidadeDoProduto);
    }

    public void adicionaItem() {
        String nome = recebeNomeDoTeclado();
        int quantidade = recebeQuantidadeDoTeclado();
        try {
            Produto produto = Estoque.encontraProduto(nome);
            if (Estoque.temEstoqueOuNao(produto, quantidade)) {
                adicionaItemNaLista(produto, quantidade);
                Estoque.darBaixaEmEstoque(nome, quantidade);
            } else {
                logger.log(Level.SEVERE, "Não há estoque suficiente deste produto.");
            }
        } catch (NoSuchElementException ex){
            logger.log(Level.SEVERE, "Este produto não existe no estoque.", ex);
        }
    }

    public double calcularTroco(double valorRecebido){
        if (valorRecebido >= valorTotalDoPedido){
            return valorRecebido - valorTotalDoPedido;
        }
        throw new IllegalArgumentException("O valor recebido deve ser maior ou igual ao valor do pedido.");
    }

    public List<Map<Integer,Integer>> calcularNumeroMinimoDeCedulas(double valorRecebido){
        Map<Integer, Integer> mapaDeNotas = new LinkedHashMap<>();
        mapaDeNotas.put(200, 0);
        mapaDeNotas.put(100, 0);
        mapaDeNotas.put(50, 0);
        mapaDeNotas.put(20, 0);
        mapaDeNotas.put(10, 0);
        mapaDeNotas.put(5, 0);
        mapaDeNotas.put(2, 0);

        Map<Integer, Integer> mapaDeMoedas = new LinkedHashMap<>();
        mapaDeMoedas.put(100, 0);
        mapaDeMoedas.put(50, 0);
        mapaDeMoedas.put(25, 0);
        mapaDeMoedas.put(10, 0);
        mapaDeMoedas.put(5, 0);
        mapaDeMoedas.put(1, 0);
                
        double troco = calcularTroco(valorRecebido);

        int trocoInt = (int) Math.floor(troco);
        double restoCentavos = (troco - trocoInt)*100;
        int centavos = (int) Math.ceil(restoCentavos);
        
        calcularCedulas(mapaDeNotas, trocoInt);
        calcularCedulas(mapaDeMoedas, centavos);

        return List.of(mapaDeNotas, mapaDeMoedas);
    }

    private void calcularCedulas(Map<Integer, Integer> mapaDeCedulas, int troco) {
        for (Map.Entry<Integer, Integer> entry : mapaDeCedulas.entrySet()) {
            int chave = entry.getKey();
            int valor = entry.getValue();
            if (troco / chave > 0) {
                valor = troco / chave;
                troco = troco % chave;
            }
            mapaDeCedulas.put(chave, valor);
        }
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
