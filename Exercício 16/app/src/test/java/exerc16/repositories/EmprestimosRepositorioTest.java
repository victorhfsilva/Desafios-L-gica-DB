package exerc16.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import exerc16.exceptions.EmprestimoInvalido;
import exerc16.exceptions.EntidadeNaoEncontrada;
import exerc16.model.Emprestimo;
import exerc16.model.Livro;
import exerc16.model.Pessoa;
import java.util.List;
import java.time.LocalDateTime;

class EmprestimosRepositorioTest {
    private EmprestimosRepositorio repositorio;
    
    private Livro livro1;
    private Livro livro2;
    private Pessoa pessoa1;
    private Pessoa pessoa2;

    @BeforeEach
    void setUp() {
        repositorio = new EmprestimosRepositorio();

        pessoa1 = new Pessoa("João", List.of());
        pessoa2 = new Pessoa("Maria", List.of());

        livro1 = new Livro("Livro 1", pessoa1);
        livro2 = new Livro("Livro 2", pessoa2);

        pessoa1.adicionarLivro(livro1);
        pessoa2.adicionarLivro(livro2);
    }

    @Test
    void testAdicionar() throws EmprestimoInvalido {
        Emprestimo emprestimo = new Emprestimo(livro2, pessoa1, LocalDateTime.now());
        repositorio.adicionar(emprestimo);
        assertTrue(repositorio.contains(emprestimo));
    }

    @Test
    void testEditar() throws EmprestimoInvalido {
        Emprestimo emprestimoExistente = new Emprestimo(livro2, pessoa1, LocalDateTime.now());
        Emprestimo emprestimoNovo = new Emprestimo(livro2, pessoa1, LocalDateTime.of(2023, 6, 12, 12, 34, 36, 12));
        
        repositorio.adicionar(emprestimoExistente);
        repositorio.editar(0, emprestimoNovo);
        
        assertTrue(repositorio.contains(emprestimoNovo));
        assertFalse(repositorio.contains(emprestimoExistente));
    }

    @Test
    void testRemover() throws EmprestimoInvalido, EntidadeNaoEncontrada {
        Emprestimo emprestimo = new Emprestimo(livro2, pessoa1, LocalDateTime.now());
        repositorio.adicionar(emprestimo);
        repositorio.remover(emprestimo);
        assertFalse(repositorio.contains(emprestimo));
    }

    @Test
    void testGetIndex() throws EmprestimoInvalido {
        Emprestimo emprestimo = new Emprestimo(livro2, pessoa1, LocalDateTime.now());
        repositorio.adicionar(emprestimo);
        assertEquals(0, repositorio.getIndex(emprestimo));
    }

    @Test
    void getEmprestimo_DeveRetornarEmprestimoCorreto() throws EmprestimoInvalido, EntidadeNaoEncontrada {
        Emprestimo emprestimo = new Emprestimo(livro2, pessoa1, LocalDateTime.now());
        repositorio.adicionar(emprestimo);
        assertEquals(emprestimo, repositorio.getEmprestimo(livro2));
    }

    @Test
    void getEmprestimo_QuandoNaoEncontrado_DeveLancarExcecao() {
        assertThrows(EntidadeNaoEncontrada.class, () -> repositorio.getEmprestimo(livro1));
    }

    @Test
    void contains_DeveRetornarTrueSeContemEmprestimo() throws EmprestimoInvalido {
        Emprestimo emprestimo = new Emprestimo(livro2, pessoa1, LocalDateTime.now());
        repositorio.adicionar(emprestimo);
        assertTrue(repositorio.contains(emprestimo));
    }

    @Test
    void contains_DeveRetornarFalseSeNaoContemEmprestimo() throws EmprestimoInvalido {
        Emprestimo emprestimo = new Emprestimo(livro2, pessoa1, LocalDateTime.now());
        assertFalse(repositorio.contains(emprestimo));
    }
}

