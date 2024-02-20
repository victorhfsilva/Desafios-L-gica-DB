package exerc20;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class ProdutoTest {
        @Test
    void testConstrutorComPrecoZero() {
        assertThrows(IllegalArgumentException.class, () -> new Produto(1, "Produto A", 0.0, 5));
    }

    @Test
    void testConstrutorComPrecoNegativo() {
        assertThrows(IllegalArgumentException.class, () -> new Produto(2, "Produto B", -10.0, 10));
    }

    @Test
    void testConstrutorComQuantidadeEmEstoqueNegativa() {
        assertThrows(IllegalArgumentException.class, () -> new Produto(3, "Produto C", 15.0, -5));
    }

    @Test
    void testSetPrecoNegativo() {
        Produto produto = new Produto(4, "Produto D", 20.0, 15);
        assertThrows(IllegalArgumentException.class, () -> produto.setPreco(-25.0));
    }

    @Test
    void testSetPrecoZero() {
        Produto produto = new Produto(5, "Produto E", 30.0, 20);
        assertThrows(IllegalArgumentException.class, () -> produto.setPreco(0.0));
    }

    @Test
    void testSetQuantidadeEmEstoqueNegativa() {
        Produto produto = new Produto(6, "Produto F", 35.0, 25);
        assertThrows(IllegalArgumentException.class, () -> produto.setQuantidadeEmEstoque(-30));
    }
}
