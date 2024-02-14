package exerc1;

import lombok.*;

@Getter
@Setter
public class Pessoa {
    
    private String name;
    private int idade;

    public boolean isMaiorDeIdade() {
        return idade >= 18;
    }

    public Pessoa(String name, int idade) {
        this.name = name;
        this.idade = idade;
    }

}
