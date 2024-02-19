package exerc18;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MotoPartidaPedalTest {

    @InjectMocks
    private MotoPartidaPedal motoPartidaPedal = new MotoPartidaPedal(200);

    @Mock
    private Logger logger;

    @Test
    void testLigarComAceleradorPuxado() {
        motoPartidaPedal.puxarAcelerador();
        motoPartidaPedal.ligar();
        assertTrue(motoPartidaPedal.isLigado());
        verify(logger).info("O(a) " + motoPartidaPedal.getClass().getSimpleName() + " foi ligado.");
    }

    @Test
    void testLigarSemAceleradorPuxado() {
        motoPartidaPedal.despuxarAcelerador();
        motoPartidaPedal.ligar();
        assertFalse(motoPartidaPedal.isLigado());
        verify(logger).warning("A moto não pode ser ligada sem antes puxar o acelerador.");
    }

    @Test
    void testPuxarAcelerador() {
        motoPartidaPedal.puxarAcelerador();
        assertTrue(motoPartidaPedal.isAceleradorPuxado());
    }

    @Test
    void testDespuxarAcelerador() {
        motoPartidaPedal.puxarAcelerador();
        assertTrue(motoPartidaPedal.isAceleradorPuxado());
        motoPartidaPedal.despuxarAcelerador();
        assertFalse(motoPartidaPedal.isAceleradorPuxado());
    }
}

