package exerc16.model;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class Livro {

    private String nome;
    private Pessoa dono;
    
    public Livro(String nome, Pessoa dono) {
        this.nome = nome;
        this.dono = dono;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pessoa getDono() {
        return this.dono;
    }

    public void setDono(Pessoa dono) {
        this.dono = dono;
    }
   
}
