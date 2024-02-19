package exerc18;

import static org.mockito.Mockito.verify;

import java.util.logging.Logger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GuinchoTest {

    @InjectMocks
    private Guincho guincho = new Guincho(140);
    
    @Mock
    private Carro carro;

    @Mock
    private Logger logger;

    @Test
    void testCarregar() {
        guincho.carregar(carro);
        verify(logger).info("O Guincho esta carregando o(a) " + carro.getClass().getName() +".");
    }
}
