package exerc11;

import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

public class App {
    public static final Random random = new Random();
    public static final Logger logger = Logger.getLogger(App.class.getName());

    public static void main(String[] args) throws InvalidParameterException {
        int[] generatedRandomList = RandomIntArray.generateRandomArray(100, 100);
        String generatedRandomListString = RandomIntArray.convertArrayToString(generatedRandomList);

        logger.info("Generated Array \n" + generatedRandomListString);

        int[] sortedList = BubbleSort.sort(generatedRandomList);
        String sortedListString = RandomIntArray.convertArrayToString(sortedList);

        logger.info("Sorted Array \n" + sortedListString);
    }
}
