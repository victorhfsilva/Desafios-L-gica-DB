package exerc20;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Scanner;
import java.util.logging.Logger;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MenuTest {

    @InjectMocks
    private Menu menu = new Menu();;

    @Mock
    private Scanner scanner;

    @Mock
    private Logger logger;

    @Mock
    private Pedido pedido;

    private static Produto produto = new Produto(1, "Produto", 10.0, 5);

    @BeforeAll
    static void setUp() {
        Estoque.inicializaEstoque();
        Estoque.cadastraProduto(produto);
    }

    @Test
    void testControlaMenu_ImprimeEstoque() {
        Estoque.logger = logger;
        when(scanner.nextLine()).thenReturn("e");
        menu.controlaMenu();
        verify(logger).info("[p] Adiciona Pedido | [e] Imprime Estoque");
        verify(logger).info(produto.toString());
    }

    @Test
    void testControlaMenu_AdicionaPedido() {
        when(scanner.nextLine()).thenReturn("p");
        menu.controlaMenu();
        verify(logger).info("[p] Adiciona Pedido | [e] Imprime Estoque");
        verify(pedido).adicionaItem();
    }

    @Test
    void testControlaMenu_OpcaoInvalida() {
        when(scanner.nextLine()).thenReturn("x");
        menu.controlaMenu();
        verify(logger).info("[p] Adiciona Pedido | [e] Imprime Estoque");
        verify(logger).warning("Opção inválida!");
    }
}