package exerc20;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.logging.Logger;

public class Estoque {

    private static int id = 1;
    private static List<Produto> listaDeProdutos;

    protected static Logger logger = Logger.getLogger(Pedido.class.getName());

    public static void inicializaEstoque() {
        listaDeProdutos = new ArrayList<>();
    }

    public static Produto encontraProduto(String nome) {
        Optional<Produto> produto = listaDeProdutos.stream().filter(i -> i.getNome().equals(nome)).findFirst();
        if (produto.isPresent()) {
            return produto.get();
        } else {
            throw new NoSuchElementException("O produto " + nome + " não se encontra no estoque.");
        }
    }

    public static Produto encontraProduto(int id) {
        Optional<Produto> produto = listaDeProdutos.stream().filter(i -> i.getId() == id).findFirst();
        if (produto.isPresent()) {
            return produto.get();
        } else {
            throw new NoSuchElementException("O produto de id " + id + " não se encontra no estoque.");
        }
    }

    public static boolean cadastraProduto(Produto produto){
        boolean containsNome = !listaDeProdutos
                                .stream()
                                .filter(i -> i.getNome().equals(produto.getNome()))
                                .toList().isEmpty();

        boolean containsId = !listaDeProdutos
                                .stream()
                                .filter(i -> i.getId() == produto.getId())
                                .toList().isEmpty();

        if (containsId || containsNome){
            return false;
        }
        return listaDeProdutos.add(produto);
    }

    public static void imprimeCatalogDoEstoque(){
        listaDeProdutos.forEach(i -> logger.info(i.toString()));
    }

    public static boolean darBaixaEmEstoque(String nome, int quantidadeParaDarBaixa) {
        Produto produto = encontraProduto(nome);
        int quantidadeEmEstoque = produto.getQuantidadeEmEstoque();
        if (quantidadeEmEstoque < quantidadeParaDarBaixa) {
            throw new IllegalArgumentException("A quantidade para dar baixa é maior que a quantidade em estoque.");
        } else {
           produto.setQuantidadeEmEstoque(quantidadeEmEstoque - quantidadeParaDarBaixa);
           return true;
        }
    }

    public static boolean darBaixaEmEstoque(int id, int quantidadeParaDarBaixa) {
        Produto produto = encontraProduto(id);
        int quantidadeEmEstoque = produto.getQuantidadeEmEstoque();
        if (quantidadeEmEstoque < quantidadeParaDarBaixa) {
            throw new IllegalArgumentException("A quantidade para dar baixa é maior que a quantidade em estoque.");
        } else {
           produto.setQuantidadeEmEstoque(quantidadeEmEstoque - quantidadeParaDarBaixa);
           return true;
        }
    }

    public static int getPosicaoAtualDoProdutoNaLista(Produto produto){
        return listaDeProdutos.indexOf(produto);
    }

    public static int getQuantidadeAtualEmEstoque(Produto produto){
        int index = getPosicaoAtualDoProdutoNaLista(produto);
        if (index != -1){
            return listaDeProdutos.get(index).getQuantidadeEmEstoque();
        }
        return 0;
    }

    public static boolean temEstoqueOuNao(Produto produto, int quantidadeParaDarBaixa){
        int index = getPosicaoAtualDoProdutoNaLista(produto);
        if (index != -1){
            return listaDeProdutos.get(index).getQuantidadeEmEstoque() >= quantidadeParaDarBaixa;
        }
        return false;
    }
}
