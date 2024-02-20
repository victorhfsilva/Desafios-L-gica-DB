package exerc20;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.NoSuchElementException;
import java.util.logging.Logger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EstoqueTest {
    
    private Produto produto;

    @BeforeEach
    void setUp() {
        Estoque.inicializaEstoque();
        produto = new Produto(1, "Produto", 10.0, 5);
        Estoque.cadastraProduto(produto);
    }

    @Test
    void testEncontraProdutoPorNome() {
        assertEquals(produto, Estoque.encontraProduto("Produto"));
    }

    @Test
    void testEncontraProdutoPorId() {
        assertEquals(produto, Estoque.encontraProduto(1));
    }

    @Test
    void testEncontraProdutoPorNomeInexistente() {
        assertThrows(NoSuchElementException.class, () -> Estoque.encontraProduto("Produto Inexistente"));
    }

    @Test
    void testEncontraProdutoPorIdInexistente() {
        assertThrows(NoSuchElementException.class, () -> Estoque.encontraProduto(999));
    }

    @Test
    void testCadastraProduto() {
        Produto novoProduto = new Produto(2, "Novo Produto", 15.0, 3);
        assertTrue(Estoque.cadastraProduto(novoProduto));
    }

    @Test
    void testCadastraProdutoExistente() {
        assertFalse(Estoque.cadastraProduto(produto));
    }

    @Test
    void testDarBaixaEmEstoquePorNome() {
        assertTrue(Estoque.darBaixaEmEstoque("Produto", 2));
        assertEquals(3, Estoque.getQuantidadeAtualEmEstoque(produto));
    }

    @Test
    void testDarBaixaEmEstoquePorId() {
        assertTrue(Estoque.darBaixaEmEstoque(1, 2));
        assertEquals(3, Estoque.getQuantidadeAtualEmEstoque(produto));
    }

    @Test
    void testDarBaixaEmEstoqueQuantidadeMaiorQueEstoque() {
        assertThrows(IllegalArgumentException.class, () -> Estoque.darBaixaEmEstoque("Produto", 10));
    }

    @Test
    void testGetPosicaoAtualDoProdutoNaLista() {
        assertEquals(0, Estoque.getPosicaoAtualDoProdutoNaLista(produto));
    }

    @Test
    void testGetQuantidadeAtualEmEstoque() {
        assertEquals(5, Estoque.getQuantidadeAtualEmEstoque(produto));
    }

    @Test
    void testTemEstoqueOuNaoComQuantidadeSuficiente() {
        assertTrue(Estoque.temEstoqueOuNao(produto, 3));
    }

    @Test
    void testTemEstoqueOuNaoComQuantidadeInsuficiente() {
        assertFalse(Estoque.temEstoqueOuNao(produto, 10));
    }

    @Test
    void testImprimeCatalogDoEstoque() {
        Logger logger = mock(Logger.class);
        Estoque.logger = logger;
        Estoque.imprimeCatalogDoEstoque();
        verify(logger).info(produto.toString());
    }
}
