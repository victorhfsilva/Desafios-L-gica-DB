package exerc2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ProdutoTest {
    
    @ParameterizedTest
    @CsvSource({
            "10, 10.0",
            "20, 18.0",
            "50, 40.0",
            "51, 38.25"
    })
    void verificaCalculoPrecoTotal(int quantidade, double expectedPreco) throws ExcecaoParametroInvalido {
        Produto produto = new Produto("produto 1", 1.0, quantidade);
        double actualPreco = produto.getPrecoTotal();
        assertEquals(expectedPreco, actualPreco);
    }

    @Test
    void verificarSePrecoInvalidaLancaExcecao() throws ExcecaoParametroInvalido {
        
        assertThrows(ExcecaoParametroInvalido.class, () -> { 
           new Produto("Produto", -4.0, 0);
        });
    }

    @Test
    void verificarSeQuantidadeInvalidaLancaExcecao() throws ExcecaoParametroInvalido {
        
        assertThrows(ExcecaoParametroInvalido.class, () -> { 
           new Produto("Produto", 4.0, 0);
        });
    }
}
