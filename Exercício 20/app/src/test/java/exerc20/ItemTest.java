package exerc20;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class ItemTest {
    @Test
    void testGetValorDoItem() {
        Produto produto = new Produto(1, "Produto A", 10.0, 5);
        Item item = new Item(produto, 3);
        assertEquals(30.0, item.getValorDoItem());
    }

    @Test
    void testSetQuantidade() {
        Produto produto = new Produto(2, "Produto B", 15.0, 10);
        Item item = new Item(produto, 2);
        assertEquals(30.0, item.getValorDoItem());
        
        item.setQuantidade(4);
        assertEquals(60.0, item.getValorDoItem());
    }

    @Test
    void testSetProduto() {
        Produto produtoInicial = new Produto(3, "Produto C", 20.0, 8);
        Item item = new Item(produtoInicial, 2);
        assertEquals(40.0, item.getValorDoItem());

        Produto produtoNovo = new Produto(4, "Produto D", 25.0, 12);
        item.setProduto(produtoNovo);
        assertEquals(50.0, item.getValorDoItem());
    }

    @Test
    void testConstrutorComProdutoNulo() {
        assertThrows(IllegalArgumentException.class, () -> new Item(null, 2));
    }

    @Test
    void testConstrutorComQuantidadeZero() {
        Produto produto = new Produto(5, "Produto E", 30.0, 15);
        assertThrows(IllegalArgumentException.class, () -> new Item(produto, 0));
    }

    @Test
    void testConstrutorComQuantidadeNegativa() {
        Produto produto = new Produto(6, "Produto F", 35.0, 20);
        assertThrows(IllegalArgumentException.class, () -> new Item(produto, -1));
    }
}
