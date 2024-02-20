package exerc20;
import java.util.Objects;

public class Produto {
    private int id;
    private String nome;
    private double preco;
    private int quantidadeEmEstoque;


    public Produto(int id, String nome, double preco, int quantidadeEmEstoque) {
        if (preco <= 0.0) {
            throw new IllegalArgumentException("O preço deve ser maior que zero.");
        } 
        if (quantidadeEmEstoque < 0) {
            throw new IllegalArgumentException("A quantidade em estoque deve ser positiva.");
        }

        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return this.preco;
    }

    public void setPreco(double preco) {
        if (preco <= 0.0) {
            throw new IllegalArgumentException("O preço deve ser positivo");
        } 
        this.preco = preco;
    }

    public int getQuantidadeEmEstoque() {
        return this.quantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        if (quantidadeEmEstoque < 0) {
            throw new IllegalArgumentException("A quantidade em estoque deve ser positiva.");
        }
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nome='" + getNome() + "'" +
            ", preco='" + getPreco() + "'" +
            ", quantidadeEmEstoque='" + getQuantidadeEmEstoque() + "'" +
            "}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Produto)) {
            return false;
        }
        Produto produto = (Produto) o;
        return id == produto.id && Objects.equals(nome, produto.nome) && preco == produto.preco && quantidadeEmEstoque == produto.quantidadeEmEstoque;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, preco, quantidadeEmEstoque);
    }
    
}
