package exerc20;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Scanner;
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
        pedido.getListaDeItens().clear();
        produto = new Produto(1, "Produto A", 10.0, 5);
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
}
