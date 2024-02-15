
package exerc10;

import java.util.logging.Logger;

public class App {

    public static final Logger logger = Logger.getLogger(App.class.getName());
    
    public static void main(String[] args) throws InvalidParameterException {
        double[][] matriz = {
            {1.0, 2.0, 3.0},
            {4.0, 5.0, 6.0},
            {7.0, 8.0, 9.0}
        };
        double sum = Matriz.somaDiagonal(matriz);
        
        logger.info("Soma: " + sum);
    }
}
