package exerc4;

public class Calculadora {
    public static double calcular(Operacao operacao, double num1, double num2){
        if (operacao == null) {
            throw new IllegalArgumentException("Operacao matematica invalida.");
        }
        switch (operacao) {
            case SOMA:
                return num1 + num2;
            case SUBTRACAO:
                return num1 - num2;
            case MULTIPLICACAO:
                return num1 * num2;
            case DIVISAO:
                if (num2 != 0) {
                    return num1 / num2;
                } else {
                    throw new ArithmeticException("Não é possível dividir por zero.");
                }
            default:
                throw new IllegalArgumentException("Operacao matematica invalida.");
        }
    }
}
