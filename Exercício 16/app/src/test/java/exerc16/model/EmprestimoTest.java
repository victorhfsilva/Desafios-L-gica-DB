package exerc16.model;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import exerc16.exceptions.EmprestimoInvalido;
import java.util.ArrayList;
import java.time.LocalDateTime;

class EmprestimoTest {

    @Test
    void criarEmprestimo_DonoDoLivroComoResponsavel_DeveLancarEmprestimoInvalido() {
        Livro livro = new Livro("Livro 1", new Pessoa("Dono do Livro", new ArrayList<>()));
        Pessoa responsavel = livro.getDono();
        LocalDateTime dataHora = LocalDateTime.now();
        
        assertThrows(EmprestimoInvalido.class, () -> {
            new Emprestimo(livro, responsavel, dataHora);
        });
    }

    @Test
    void alterarLivro_DonoDoLivroComoResponsavel_DeveLancarEmprestimoInvalido() throws EmprestimoInvalido {
        Pessoa dono = new Pessoa("Dono do Livro", new ArrayList<>());
        Pessoa responsavel = new Pessoa("Responsavel", new ArrayList<>());

        Livro livro1 = new Livro("Livro 1", dono);
        Livro livro2 = new Livro("Livro 2", responsavel);

        Emprestimo emprestimo = new Emprestimo(livro1, responsavel, LocalDateTime.now());
  
        assertThrows(EmprestimoInvalido.class, () -> {
            emprestimo.setLivro(livro2);
        });
    }
}

