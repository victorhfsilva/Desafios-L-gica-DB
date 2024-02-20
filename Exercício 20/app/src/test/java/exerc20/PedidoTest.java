package exerc20;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PedidoTest {
    
    @InjectMocks
    private Pedido pedido = new Pedido();
    
    @Mock
    private Logger logger;

    @Mock
    private Scanner scanner;

    private Produto produto;

    @BeforeEach
    void setUp() {
        Estoque.inicializaEstoque();
        pedido.getListaDeItens().clear();
        produto = new Produto(1, "Produto", 10.0, 5);
    }

    @Test
    void testCalculaValorTotal() {
        pedido.adicionaItemNaLista(produto, 2);
        pedido.calculaValorTotal();
        assertEquals(20.0, pedido.getValorTotalDoPedido());
    }

    @Test
    void testAdicionaItemNaLista() {
        assertTrue(pedido.adicionaItemNaLista(produto, 3));
        assertEquals(3, pedido.getListaDeItens().get(0).getQuantidade());
        assertEquals(30.0, pedido.getValorTotalDoPedido());
    }

    @Test
    void testImprimePedido() {
        Item item1 = new Item(produto, 2);
        Item item2 = new Item(new Produto(2, "Produto B", 15.0, 8), 1);
        pedido.getListaDeItens().add(item1);
        pedido.getListaDeItens().add(item2);

        pedido.imprimePedido();
        
        verify(logger, atLeast(2)).info(anyString());
    }

    @Test
    void testImprimeValorTotal() {
        pedido.adicionaItemNaLista(produto, 3);
        pedido.imprimeValorTotal();

        verify(logger).info("Valor Total: 30.0");
    }

    
    @Test
    void testRecebeNomeDoTeclado() {
        when(scanner.nextLine()).thenReturn("Produto");
        String produtoNome = pedido.recebeNomeDoTeclado();
        verify(logger).info("Insira um produto.");
        assertEquals("Produto", produtoNome);
    }

    @Test
    void testRecebeQuantidadeDoTeclado() {
        when(scanner.nextLine()).thenReturn("5");
        int produtoId = pedido.recebeQuantidadeDoTeclado();
        verify(logger).info("Insira a quantidade do produto.");
        assertEquals(5, produtoId);
    }

    @Test
    void testAdicionaItem() {
        when(scanner.nextLine()).thenReturn("Produto", "5");
        assertTrue(Estoque.cadastraProduto(produto));

        pedido.adicionaItem();

        assertEquals(1, pedido.getListaDeItens().size());
        assertEquals(5, pedido.getListaDeItens().get(0).getQuantidade());
    }

    @Test
    void testAdicionaItemProdutoNaoExistente() {
        when(scanner.nextLine()).thenReturn("Produto Inexistente", "3");
        pedido.adicionaItem();

        verify(logger).log(eq(Level.SEVERE), eq("Este produto não existe no estoque."), any(NoSuchElementException.class));
        assertTrue(pedido.getListaDeItens().isEmpty());
    }

    @Test
    void testAdicionaItemQuantidadeMaiorQueEstoque() {
        when(scanner.nextLine()).thenReturn("Produto", "10");
        assertTrue(Estoque.cadastraProduto(produto));

        pedido.adicionaItem();

        verify(logger).log(eq(Level.SEVERE), eq("Não há estoque suficiente deste produto."));
        assertTrue(pedido.getListaDeItens().isEmpty());
    }
}
