package exerc20;

import java.util.Objects;

public class Item {
    private Produto produto;

    private int quantidade;

    private double valorDoItem;

    public Item(Produto produto, int quantidade) {
        if (produto == null) {
            throw new IllegalArgumentException("O produto não deve ser nulo.");
        }
        if (quantidade <= 0){
            throw new IllegalArgumentException("A quantidade deve ser maior que zero.");
        }
        this.produto = produto;
        this.quantidade = quantidade;
        this.valorDoItem = quantidade*produto.getPreco();
    }

    public void defineValorTotal() {
        valorDoItem = quantidade*produto.getPreco();
    }

    public Produto getProduto() {
        return this.produto;
    }

    public void setProduto(Produto produto) {
        if (produto == null) {
            throw new IllegalArgumentException("O produto não deve ser nulo.");
        }
        this.produto = produto;
        defineValorTotal();
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(int quantidade) {
        if (quantidade <= 0){
            throw new IllegalArgumentException("A quantidade deve ser maior que zero.");
        }
        this.quantidade = quantidade;
        defineValorTotal();
    }

    public double getValorDoItem() {
        return this.valorDoItem;
    }

    public void setValorDoItem(double valorDoItem) {
        this.valorDoItem = valorDoItem;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Item)) {
            return false;
        }
        Item item = (Item) o;
        return Objects.equals(produto, item.produto) && quantidade == item.quantidade && valorDoItem == item.valorDoItem;
    }

    @Override
    public int hashCode() {
        return Objects.hash(produto, quantidade, valorDoItem);
    }

    @Override
    public String toString() {
        return "{" +
            " produto='" + getProduto().getNome() + "'" +
            " preço='" + getProduto().getPreco() + "'" +
            ", quantidade='" + getQuantidade() + "'" +
            ", valorDoItem='" + getValorDoItem() + "'" +
            "}";
    }
    
}
