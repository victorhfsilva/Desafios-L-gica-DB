package exerc2;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Produto {

    private String name;
    private double preco;
    private int quantidade; 
    

    public Produto(String name, double preco, int quantidade) throws ExcecaoParametroInvalido {
        this.name = name;

        if (preco > 0) {
            this.preco = preco;
        } else {
            throw new ExcecaoParametroInvalido("Preco " + preco + " eh menor ou igual a 0");
        }

        if (quantidade > 0) {
            this.quantidade = quantidade;
        } else {
            throw new ExcecaoParametroInvalido("Quantidade " + quantidade + " eh menor ou igual a1 0");
        }
    }

    public double getPrecoTotal() throws ExcecaoParametroInvalido {
        return preco*quantidade*(1 - getDesconto());
    }

    private double getDesconto() throws ExcecaoParametroInvalido {
        if (quantidade <= 10) {
            return 0.0;
        } else if (quantidade >= 11 && quantidade <= 20){
            return 0.1;
        } else if (quantidade >= 21 && quantidade <= 50 ){
            return 0.2;
        } else if (quantidade > 50) {
            return 0.25;
        } else {
            throw new ExcecaoParametroInvalido("Quantidade " + quantidade + " Inválida");
        }
    }
}
