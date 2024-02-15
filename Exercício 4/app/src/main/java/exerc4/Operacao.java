package exerc4;

public enum Operacao {
    SOMA("+"),
    SUBTRACAO("-"),
    MULTIPLICACAO("*"),
    DIVISAO("/");

    private String value;

    Operacao(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Operacao getByValue(String value){
        for (Operacao o: Operacao.values()){
            if (o.getValue().equals(value)){
                return o;
            }
        }
        return null;
    }
}
