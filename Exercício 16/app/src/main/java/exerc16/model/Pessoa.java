package exerc16.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;

import exerc16.exceptions.EmprestimoInvalido;
import exerc16.exceptions.EntidadeNaoEncontrada;
import exerc16.repositories.Repositorios;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString(exclude = "livros")
@EqualsAndHashCode(exclude = "livros")
public class Pessoa {
    
    private String nome;
    private List<Livro> livros;

    private static final Logger logger = Logger.getLogger(Pessoa.class.getName());

    public void adicionarLivro(Livro livro){
        livros.add(livro);
    }

    public void removerLivro(Livro livro){
            livros.remove(livro);
    }

    public void emprestarLivro(Livro livro, Pessoa pessoa, Repositorios repositorios){
        if (livros.contains(livro) &&
            livro.getDono().equals(this) &&
            repositorios.getPessoasRepositorio().contains(pessoa)
        ){
            try {
                this.removerLivro(livro);
                pessoa.adicionarLivro(livro);
                Emprestimo emprestimo = new Emprestimo(livro, pessoa, LocalDateTime.now());
                repositorios.getEmprestimosRepositorio().adicionar(emprestimo);
                logger.info("O livro foi emprestado com sucesso.");
            } catch (EmprestimoInvalido ex) {
                logger.log(Level.SEVERE, "O dono do livro não pode emprestar um livro para si mesmo.", ex);
            }

        } else {
            logger.warning("Não foi possível emprestar o livro.");
        }
    }

    public void devolverLivro(Livro livro, Repositorios repositorios){
        Pessoa dono = livro.getDono();

        if (livros.contains(livro) && 
            !livro.getDono().equals(this) &&
            repositorios.getPessoasRepositorio().contains(dono)
        ){
            try {
                this.removerLivro(livro);
                dono.adicionarLivro(livro);
                Emprestimo emprestimo = repositorios.getEmprestimosRepositorio().getEmprestimo(livro);
                repositorios.getEmprestimosRepositorio().remover(emprestimo);
                logger.info("O livro foi devolvido com sucesso.");
            } catch(EntidadeNaoEncontrada ex) {
                logger.log(Level.WARNING, "Não foi possível devolver o livro.", ex);
            }
        }
    }

    public Pessoa(String nome, List<Livro> livros) {
        this.nome = nome;
        this.livros = new ArrayList<>(livros);
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Livro> getLivros() {
        return this.livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

}
