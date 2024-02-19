package exerc18;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AutomovelTest {
    private Automovel automovel;

    @BeforeEach
    void setUp() {
        automovel = new Automovel(4, 200);
    }

    @Test
    void testLigar() {
        assertFalse(automovel.isLigado());
        automovel.ligar();
        assertTrue(automovel.isLigado());
    }

    @Test
    void testDesligar() {
        automovel.ligar();
        assertTrue(automovel.isLigado());
        automovel.desligar();
        assertFalse(automovel.isLigado());
    }
}
