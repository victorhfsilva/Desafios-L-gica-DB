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
class CarroAutomaticoTest {
    
    @InjectMocks
    private CarroAutomatico carroAutomatico = new CarroAutomatico(180);

    @Mock
    private Logger logger;

    @Test
    void testLigarComFreioPressionado() {
        carroAutomatico.pressionarFreio();
        carroAutomatico.ligar();
        assertTrue(carroAutomatico.isLigado());
        verify(logger).info("O(a) " + carroAutomatico.getClass().getSimpleName() + " foi ligado.");
    }

    @Test
    void testLigarComFreioDespressionado() {
        carroAutomatico.despressionarFreio();
        carroAutomatico.ligar();
        assertFalse(carroAutomatico.isLigado());
        verify(logger).warning("O carro não pode ser ligado com o freio despressionado.");
    }

    @Test
    void testPressionarFreio() {
        carroAutomatico.pressionarFreio();
        assertTrue(carroAutomatico.isFreioPressionado());
    }

    @Test
    void testDespressionarFreio() {
        carroAutomatico.pressionarFreio();
        assertTrue(carroAutomatico.isFreioPressionado());
        carroAutomatico.despressionarFreio();
        assertFalse(carroAutomatico.isFreioPressionado());
    }
}
