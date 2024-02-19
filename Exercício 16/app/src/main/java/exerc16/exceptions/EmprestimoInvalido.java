package exerc16.exceptions;

public class EmprestimoInvalido extends Exception {
    
    private String message;

    public EmprestimoInvalido(String message) {
        super(message);
    }

}