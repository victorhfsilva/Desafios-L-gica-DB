package exerc16.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exerc16.exceptions.EntidadeNaoEncontrada;
import exerc16.model.Pessoa;

class PessoasRepositorioTest {
    
    private PessoasRepositorio repositorio;
    private Pessoa pessoa1;
    private Pessoa pessoa2;

    @BeforeEach
    void setUp() {
        repositorio = new PessoasRepositorio();
        pessoa1 = new Pessoa("João", List.of());
        pessoa2 = new Pessoa("Maria", List.of());
    }

    @Test
    void testAdicionar() {
        repositorio.adicionar(pessoa1);
        assertTrue(repositorio.contains(pessoa1));
    }

    @Test
    void testEditar() {
        repositorio.adicionar(pessoa1);
        repositorio.editar(0, pessoa2);
        assertTrue(repositorio.contains(pessoa2));
        assertFalse(repositorio.contains(pessoa1));
    }

    @Test
    void testRemover() throws EntidadeNaoEncontrada {
        repositorio.adicionar(pessoa1);
        repositorio.remover(pessoa1);
        assertFalse(repositorio.contains(pessoa1));
    }

    @Test
    void testGetIndex() {
        repositorio.adicionar(pessoa1);
        assertEquals(0, repositorio.getIndex(pessoa1));
    }

    @Test
    void testContains() {
        repositorio.adicionar(pessoa1);
        assertTrue(repositorio.contains(pessoa1));
        assertFalse(repositorio.contains(pessoa2));
    }
}
