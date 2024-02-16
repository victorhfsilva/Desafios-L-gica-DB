package exerc16.exceptions;

import lombok.Getter;

@Getter
public class EntidadeNaoEncontrada extends Exception {
    
    private String message;

    public EntidadeNaoEncontrada(String message) {
        super(message);
    }

}
