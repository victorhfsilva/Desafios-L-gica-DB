package exerc20;

public class App {
    
    public static void main(String[] args) {
        Produto produto = new Produto(1, "Produto", 10.0, 5);
        Estoque.inicializaEstoque();
        Estoque.cadastraProduto(produto);    
        Menu menu = new Menu();
        menu.controlaMenu();
    }
}
