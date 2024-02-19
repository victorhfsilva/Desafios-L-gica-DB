package exerc19;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AgendaTest {

    private Agenda agenda;

    @BeforeEach
    void setUp() {
        agenda = new Agenda();
        agenda.adicionar(new Contato("João", "123456789"));
        agenda.adicionar(new Contato("Maria", "987654321"));
    }

    @Test
    void testGetContatos() {
        assertEquals(2, agenda.getContatos().size());
    }

    @Test
    void testGetByNome_ContatoExistente() throws EntidadeNaoEncontrada {
        Contato contato = agenda.getByNome("João");
        assertEquals("João", contato.getNome());
        assertEquals("123456789", contato.getNumero());
    }

    @Test
    void testGetByNome_ContatoNãoExistente() {
        assertThrows(EntidadeNaoEncontrada.class, () -> agenda.getByNome("Pedro"));
    }

    @Test
    void testGetByNumero_ContatoExistente() throws EntidadeNaoEncontrada {
        Contato contato = agenda.getByNumero("987654321");
        assertEquals("Maria", contato.getNome());
        assertEquals("987654321", contato.getNumero());
    }

    @Test
    void testGetByNumero_ContatoNaoExistente() {
        assertThrows(EntidadeNaoEncontrada.class, () -> agenda.getByNumero("555555555"));
    }

    @Test
    void testAdicionar() {
        Contato novoContato = new Contato("Carlos", "555555555");
        agenda.adicionar(novoContato);
        assertTrue(agenda.getContatos().contains(novoContato));
    }

    @Test
    void testGetIndex() {
        Contato contato1 = agenda.getContatos().get(0);
        Contato contato2 = agenda.getContatos().get(1);
        assertEquals(0, agenda.getIndex(contato1));
        assertEquals(1, agenda.getIndex(contato2));
    }

    @Test
    void testRemoverByContato() throws EntidadeNaoEncontrada {
        Contato contato = agenda.getByNome("João");
        agenda.remover(contato);
        assertFalse(agenda.getContatos().contains(contato));
    }

    @Test
    void testRemoverByIndex() throws EntidadeNaoEncontrada {
        agenda.remover(0);
        assertEquals(1, agenda.getContatos().size());
    }

    @Test
    void testEditar() throws EntidadeNaoEncontrada {
        Contato novoContato = new Contato("Pedro", "111111111");
        agenda.editar(0, novoContato);
        assertEquals(novoContato, agenda.getContatos().get(0));
    }

    @Test
    void testRemover_ContatoInexistente() {
        Contato contatoInexistente = new Contato("Pedro", "555555555");
        assertThrows(EntidadeNaoEncontrada.class, () -> agenda.remover(contatoInexistente));
    }

    @Test
    void testRemover_IndexInexistente() {
        assertThrows(EntidadeNaoEncontrada.class, () -> agenda.remover(5));
    }

    @Test
    void testEditar_IndexInexistente() {
        Contato novoContato = new Contato("José", "111111111");
        assertThrows(EntidadeNaoEncontrada.class, () -> agenda.editar(5, novoContato));
    }
}

