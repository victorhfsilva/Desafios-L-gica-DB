package exerc19;
import java.util.Objects;

public class Contato {
    private String nome;
    private String numero;

    public Contato() {
    }

    public Contato(String nome, String numero) {
        this.nome = nome;
        this.numero = numero;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

}
