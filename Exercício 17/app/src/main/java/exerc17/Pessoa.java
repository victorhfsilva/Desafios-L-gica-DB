package exerc17;

public class Pessoa {
    
    private String nome;
    private int idade;
    private Pessoa mae;
    private Pessoa pai;


    public Pessoa(String nome, int idade, Pessoa mae, Pessoa pai) {
        this.nome = nome;
        this.idade = idade;
        this.mae = mae;
        this.pai = pai;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return this.idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Pessoa getMae() {
        return this.mae;
    }

    public void setMae(Pessoa mae) {
        this.mae = mae;
    }

    public Pessoa getPai() {
        return this.pai;
    }

    public void setPai(Pessoa pai) {
        this.pai = pai;
    }
}
