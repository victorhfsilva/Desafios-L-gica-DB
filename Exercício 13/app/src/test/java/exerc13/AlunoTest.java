package exerc13;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class AlunoTest {

    @Test
    void verificaCriacaoAlunoValido() {
        List<Double> notas = Arrays.asList(8.0, 9.0, 7.5);
        assertDoesNotThrow(() -> new Aluno("João", notas));
    }

    @Test
    void VerificaCriacaoAlunoNotaSuperiorA10() {
        List<Double> notas = Arrays.asList(8.0, 9.0, 11.0);
        assertThrows(ExcecaoParametroInvalido.class, () -> new Aluno("Maria", notas));
    }

    @Test
    void VerificaCriacaoAlunoNotaInferiorA0() {
        List<Double> notas = Arrays.asList(8.0, -1.0, 2.0);
        assertThrows(ExcecaoParametroInvalido.class, () -> new Aluno("Maria", notas));
    }

    @Test
    void VerificaInsercaoNotaSuperiorA10() throws ExcecaoParametroInvalido {
        Aluno aluno = new Aluno("João");
        assertThrows(ExcecaoParametroInvalido.class, () -> aluno.insertNota(10.1));
    }

    @Test
    void VerificaIsercaoNotaInferiorA0() {
        Aluno aluno = new Aluno("João");
        assertThrows(ExcecaoParametroInvalido.class, () -> aluno.insertNota(-0.1));
    }

    @Test
    void testMediaAprovado() throws ExcecaoParametroInvalido {
        List<Double> notas = Arrays.asList(8.0, 10.0, 9.0);
        Aluno aluno = new Aluno("João", notas);
        assertEquals(9.0, aluno.getMedia());
        assertEquals(Status.APROVADO, aluno.getStatus());
    }

    @Test
    void testMediaVerificacaoSuplementar() throws ExcecaoParametroInvalido {
        List<Double> notas = Arrays.asList(4.0, 2.0, 6.0);
        Aluno aluno = new Aluno("Maria", notas);
        assertEquals(4.0, aluno.getMedia());
        assertEquals(Status.VERIFICACAO_SUPLEMENTAR, aluno.getStatus());
    }

    @Test
    void testMediaReprovado() throws ExcecaoParametroInvalido {
        List<Double> notas = Arrays.asList(2.0, 3.0, 4.0);
        Aluno aluno = new Aluno("Pedro", notas);
        assertEquals(3.0, aluno.getMedia());
        assertEquals(Status.REPROVADO, aluno.getStatus());
    }
}