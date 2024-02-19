package exerc17;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArvoreTest {
    private Pessoa filho;
    private Pessoa mae;
    private Pessoa pai;
    private Pessoa avo1;
    private Pessoa avo2;
    private Pessoa avo3;
    private Pessoa bisAvo1;
    private Pessoa bisAvo2;
    private Pessoa bisAvo3;
    private Pessoa bisAvo4;
    private Pessoa bisAvo5;

    @BeforeEach
    void setup(){
        bisAvo1 = new Pessoa("Bisavô 1", 82, null, null);
        bisAvo2 = new Pessoa("Bisavô 2", 80, null, null);
        bisAvo3 = new Pessoa("Bisavó 3", 78, null, null);
        bisAvo4 = new Pessoa("Bisavó 4", 76, null, null);
        bisAvo5 = new Pessoa("Bisavó 5", 74, null, null);
        
        avo1 = new Pessoa("Avô 1", 60, bisAvo1, bisAvo3);
        avo2 = new Pessoa("Avó 2", 58, bisAvo2,  bisAvo4);
        avo3 = new Pessoa("Avô 3", 56, null,  bisAvo5);
        
        pai = new Pessoa("Pai", 40, avo1, avo2);
        mae = new Pessoa("Mãe", 38, avo3, null);
        
        filho = new Pessoa("Filho", 20, pai, mae);
    }

    @Test
    void testBuscarPor3Avos() {
        Arvore arvore = new Arvore(filho);
        List<Pessoa> nAvos = arvore.buscarPorRelativoDeHierarquiaN(3);
        
        assertTrue(nAvos.contains(bisAvo1));
        assertTrue(nAvos.contains(bisAvo2));
        assertTrue(nAvos.contains(bisAvo3));
        assertTrue(nAvos.contains(bisAvo4));
        assertTrue(nAvos.contains(bisAvo5));
        assertFalse(nAvos.contains(avo1));
        assertFalse(nAvos.contains(avo2));
        assertFalse(nAvos.contains(avo3));
        assertFalse(nAvos.contains(pai));
        assertFalse(nAvos.contains(mae));
        assertFalse(nAvos.contains(filho));

        assertEquals(5, nAvos.size()); // esperamos encontrar 7 pessoas até 3 níveis acima do filho
    }

    @Test
    void testBuscarPorNAvos() {
        Arvore arvore = new Arvore(filho);
        List<Pessoa> nAvos = arvore.buscarPorRelativoDeHierarquiaN(2);
        
        assertTrue(nAvos.contains(avo1));
        assertTrue(nAvos.contains(avo2));
        assertTrue(nAvos.contains(avo3));
        assertFalse(nAvos.contains(bisAvo1));
        assertFalse(nAvos.contains(bisAvo2));
        assertFalse(nAvos.contains(bisAvo3));
        assertFalse(nAvos.contains(bisAvo4));
        assertFalse(nAvos.contains(bisAvo5));
        assertFalse(nAvos.contains(pai));
        assertFalse(nAvos.contains(mae));
        assertFalse(nAvos.contains(filho));

        assertEquals(3, nAvos.size()); // esperamos encontrar 7 pessoas até 3 níveis acima do filho
    }
}
