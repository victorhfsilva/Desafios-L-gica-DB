package exerc16.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import java.time.LocalDateTime;
import java.util.ArrayList;
import exerc16.exceptions.EmprestimoInvalido;
import exerc16.exceptions.EntidadeNaoEncontrada;
import exerc16.repositories.EmprestimosRepositorio;
import exerc16.repositories.PessoasRepositorio;
import exerc16.repositories.Repositorios;

@ExtendWith(MockitoExtension.class)
class PessoaTest {
    
    private Pessoa pessoa;
    
    private Livro livro;
    
    @Mock
    private Repositorios repositorios;
    
    @Mock
    private PessoasRepositorio pessoasRepositorio;

    @Mock
    EmprestimosRepositorio emprestimosRepositorio;

    @BeforeEach
    void setUp() {
        pessoa = new Pessoa("Nome da Pessoa", new ArrayList<>());
        livro = new Livro("Nome do Livro", pessoa);
        repositorios = Mockito.mock(Repositorios.class);

    }

    @Test
    void adicionarLivroTest() {
        pessoa.adicionarLivro(livro);
        assertTrue(pessoa.getLivros().contains(livro));
    }

    @Test
    void removerLivroTest() {
        pessoa.adicionarLivro(livro);
        pessoa.removerLivro(livro);
        assertFalse(pessoa.getLivros().contains(livro));
    }

    @Test
    void emprestarLivroTest() {
        Pessoa outraPessoa = new Pessoa("Outro Nome", new ArrayList<>());

        when(repositorios.getPessoasRepositorio()).thenReturn(pessoasRepositorio);
        when(repositorios.getEmprestimosRepositorio()).thenReturn(emprestimosRepositorio);
        when(pessoasRepositorio.contains(eq(outraPessoa))).thenReturn(true);

        pessoa.adicionarLivro(livro);
        pessoa.emprestarLivro(livro, outraPessoa, repositorios);
        assertFalse(pessoa.getLivros().contains(livro));
        assertTrue(outraPessoa.getLivros().contains(livro));
    }

    @Test
    void devolverLivroTest() throws EmprestimoInvalido, EntidadeNaoEncontrada {
        Pessoa outraPessoa = new Pessoa("Outro Nome", new ArrayList<>());
        Emprestimo emprestimo = new Emprestimo(livro, outraPessoa, LocalDateTime.now());

        when(repositorios.getPessoasRepositorio()).thenReturn(pessoasRepositorio);
        when(repositorios.getEmprestimosRepositorio()).thenReturn(emprestimosRepositorio);
        when(pessoasRepositorio.contains(eq(outraPessoa))).thenReturn(true);
        when(pessoasRepositorio.contains(eq(pessoa))).thenReturn(true);
        when(emprestimosRepositorio.getEmprestimo(eq(livro))).thenReturn(emprestimo);

        pessoa.adicionarLivro(livro);
        pessoa.emprestarLivro(livro, outraPessoa, repositorios);
        assertFalse(pessoa.getLivros().contains(livro));
        assertTrue(outraPessoa.getLivros().contains(livro));

        outraPessoa.devolverLivro(livro, repositorios);
        assertTrue(pessoa.getLivros().contains(livro));
        assertFalse(outraPessoa.getLivros().contains(livro));
    }
}
