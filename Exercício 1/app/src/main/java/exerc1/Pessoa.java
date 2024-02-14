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

    public Pessoa(String name, int idade) throws ExcecaoParametroInvalido {
        this.name = name;
        
        if (idade >= 0) {
            this.idade = idade;
        } else {
            throw new ExcecaoParametroInvalido("Idade " + idade + " eh menor que zero.");
        }
    }

}
