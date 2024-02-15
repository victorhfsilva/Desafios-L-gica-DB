
package exerc7;

import java.util.logging.Logger;

public class App {

    public static final Logger logger = Logger.getLogger(App.class.getName());
    public static void main(String[] args) {
        logger.info(Fibonacci.calcularSequenciaString(9));
    }
}
