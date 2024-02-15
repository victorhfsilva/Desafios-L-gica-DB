package exerc5;

public class Calculadora {
    public static int calcular(Operacao operacao, int num1, int num2){
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

    public static String calcularTabuada(int num) {
        StringBuilder resultadoTabuada = new StringBuilder();
        resultadoTabuada.append("\n");
        for (int i = 1; i <= 10; i++) {
            int resultado = Calculadora.calcular(Operacao.MULTIPLICACAO, num, i);
            resultadoTabuada.append(num).append(" x ").append(i).append(" = ").append(resultado).append("\n");
        }
        return resultadoTabuada.toString();
    }
}
