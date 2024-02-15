package exerc10;

import exerc10.InvalidParameterException;

public class Matriz {
    
    private Matriz(){

    }

    public static double somaDiagonal(double[][] matriz) throws InvalidParameterException{
        if (matriz.length != matriz[0].length){
            throw new InvalidParameterException("A matriz não é quadrada.");
        }

        double sum = 0;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (i == j) {
                    sum += matriz[i][j];
                }
            }
        }
        
        return sum;
    }
}
