package exerc1;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class PessoaTest {
    
    @Test
    void verificarSePessoaEhMaiorDeIdade() {
        Pessoa pessoa = new Pessoa("Victor", 18);
        assertTrue(pessoa.isMaiorDeIdade());
    }

    @Test
    void verificarSePessoaEhMenorDeIdade() {
        Pessoa pessoa = new Pessoa("Victor", 17);
        assertFalse(pessoa.isMaiorDeIdade());
    }
}
