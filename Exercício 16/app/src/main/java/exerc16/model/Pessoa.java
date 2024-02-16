package exerc16.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import exerc16.exceptions.EntidadeNaoEncontrada;
import exerc16.repositories.PessoasRepositorio;
import exerc16.repositories.Repositorios;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
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
        if (livro.getDono().equals(this)){
            livros.remove(livro);
        }
    }

    public void emprestarLivro(Livro livro, Pessoa pessoa, Repositorios repositorios){
        if (livros.contains(livro) &&
            livro.getDono().equals(this) &&
            repositorios.pessoasRepositorio.contains(pessoa)
        ){
            this.removerLivro(livro);
            pessoa.adicionarLivro(livro);
            Emprestimo emprestimo = new Emprestimo(livro, pessoa, LocalDateTime.now());
            repositorios.emprestimosRepositorio.adicionar(emprestimo);
            logger.info("O livro foi emprestado com sucesso.");
        } else {
            logger.warning("Não foi possível emprestar o livro.");
        }
    }

    public void devolverLivro(Livro livro, Repositorios repositorios){
        Pessoa dono = livro.getDono();

        if (livros.contains(livro) && 
            !livro.getDono().equals(this) &&
            repositorios.pessoasRepositorio.contains(dono)
        ){
            try {
                this.removerLivro(livro);
                dono.adicionarLivro(livro);
                Emprestimo emprestimo = repositorios.emprestimosRepositorio.getEmprestimo(livro);
                repositorios.emprestimosRepositorio.remover(emprestimo);
                logger.info("O livro foi devolvido com sucesso.");
            } catch(EntidadeNaoEncontrada ex) {
                logger.log(Level.WARNING, "Não foi possível devolver o livro.", ex);
            }
        }
    }
}
