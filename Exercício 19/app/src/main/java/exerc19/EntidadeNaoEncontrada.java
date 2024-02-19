package exerc19;

public class EntidadeNaoEncontrada extends Exception {
    
    private String message;

    public EntidadeNaoEncontrada(String message) {
        super(message);
    }

    public String getMessage() {
        return this.message;
    }

}
