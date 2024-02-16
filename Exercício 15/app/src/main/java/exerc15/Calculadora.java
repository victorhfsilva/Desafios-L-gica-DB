package exerc15;

public class Calculadora {
    
    public static double calcular(Operacao operacao, double num1, double num2){
        if (operacao == null) {
            throw new IllegalArgumentException("Operacao matematica invalida.");
        }
        switch (operacao) {
            case SOMA:
                return somar(num1, num2);
            case SUBTRACAO:
                return subtrair(num1, num2);
            case MULTIPLICACAO:
                return multiplicar(num1, num2);
            case DIVISAO:
                return dividir(num1, num2);
            case POTENCIACAO:
                return elevar(num1, num2);
            default:
                throw new IllegalArgumentException("Operacao matematica invalida.");
        }
    }

    private static double somar(double num1, double num2) {
        return num1 + num2;
    }

    private static double subtrair(double num1, double num2) {
        return num1 - num2;
    }

    private static double multiplicar(double num1, double num2) {
        return num1 * num2;
    }

    private static double dividir(double num1, double num2) {
        if (num2 != 0) {
            return num1 / num2;
        } else {
            throw new ArithmeticException("Não é possível dividir por zero.");
        }
    }

    private static double elevar(double num1, double num2) {
        if (num2 >= 0) {
            return Math.pow(num1, num2);
        } else {
            throw new ArithmeticException("Não é possível dividir por zero.");
        }
        
    }
}
