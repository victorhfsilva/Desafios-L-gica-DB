package exerc16.model;

import java.time.LocalDateTime;

import exerc16.exceptions.EmprestimoInvalido;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class Emprestimo {
    
    private Livro livro;
    private Pessoa responsavel;
    private LocalDateTime dateTime;

    public Emprestimo(Livro livro, Pessoa responsavel, LocalDateTime dateTime) throws EmprestimoInvalido {
        if (responsavel.equals(livro.getDono())){
            throw new EmprestimoInvalido("O responsável é o dono do livro.");
        }

        this.livro = livro;
        this.responsavel = responsavel;
        this.dateTime = dateTime;
    }

    public Livro getLivro() {
        return this.livro;
    }

    public void setLivro(Livro livro) throws EmprestimoInvalido {
        if (responsavel.equals(livro.getDono())){
            throw new EmprestimoInvalido("O responsável é o dono do livro.");
        }
        this.livro = livro;
    }

    public Pessoa getResponsavel() {
        return this.responsavel;
    }

    public void setResponsavel(Pessoa responsavel) {
        this.responsavel = responsavel;
    }

    public LocalDateTime getDateTime() {
        return this.dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

}
