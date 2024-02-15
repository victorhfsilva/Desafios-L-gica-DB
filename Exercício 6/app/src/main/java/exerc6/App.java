package exerc6;

import java.util.List;
import java.util.logging.Logger;

public class App {

    public static final Logger logger = Logger.getLogger(App.class.getName());
    public static void main(String[] args) {
        List<Integer> randomList = RandomIntegerList.generateRandomList(10, 100);
        String randomListString = RandomIntegerList.convertListToString(randomList);
        logger.info(randomListString);
    }
}
