package exerc11;

import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

public class App {
    public static final Random random = new Random();
    public static final Logger logger = Logger.getLogger(App.class.getName());

    public static void main(String[] args) throws InvalidParameterException {
        int[] generatedRandomList = RandomIntegerList.generateRandomList(100, 100);
        String generatedRandomListString = RandomIntegerList.convertListToString(generatedRandomList);

        logger.info("Generated List \n" + generatedRandomListString);

        int[] sortedList = BubbleSort.sort(generatedRandomList);
        String sortedListString = RandomIntegerList.convertListToString(sortedList);

        logger.info("Sorted List \n" + sortedListString);
    }
}
