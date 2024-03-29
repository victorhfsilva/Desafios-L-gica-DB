package exerc1;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class PessoaTest {
    
    @Test
    void verificarSePessoaEhMaiorDeIdade() throws ExcecaoParametroInvalido {
        Pessoa pessoa = new Pessoa("Victor", 18);
        assertTrue(pessoa.isMaiorDeIdade());
    }

    @Test
    void verificarSePessoaEhMenorDeIdade() throws ExcecaoParametroInvalido {
        Pessoa pessoa = new Pessoa("Victor", 17);
        assertFalse(pessoa.isMaiorDeIdade());
    }

    @Test
    void verificarSeIdadeInvalidaLancaExcecao() throws ExcecaoParametroInvalido {
        
        assertThrows(ExcecaoParametroInvalido.class, () -> { 
           new Pessoa("Victor", -4);
        });
    }
}
