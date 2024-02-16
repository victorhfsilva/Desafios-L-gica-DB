package exerc12;

import java.util.Random;
import java.util.logging.Logger;

public class App {

    public static final Random random = new Random();
    public static final Logger logger = Logger.getLogger(App.class.getName());

    public static void main(String[] args) throws InvalidParameterException {
        int[] generatedRandomArray1 = RandomIntArray.generateRandomArray(50, 100);
        String generatedRandomArrayString1 = RandomIntArray.convertArrayToString(generatedRandomArray1);

        logger.info("Generated Array 1 \n" + generatedRandomArrayString1);

        int[] sortedArray1 = BubbleSort.sort(generatedRandomArray1);
        String sortedArrayString1 = RandomIntArray.convertArrayToString(sortedArray1);

        logger.info("Sorted Array 1 \n" + sortedArrayString1);

        int[] generatedRandomArray2 = RandomIntArray.generateRandomArray(50, 100);
        String generatedRandomArrayString2 = RandomIntArray.convertArrayToString(generatedRandomArray2);

        logger.info("Generated Array 2 \n" + generatedRandomArrayString2);

        int[] sortedArray2 = BubbleSort.sort(generatedRandomArray2);
        String sortedArrayString2 = RandomIntArray.convertArrayToString(sortedArray2);

        logger.info("Sorted Array 2 \n" + sortedArrayString2);

        int[] concatenatedArray = RandomIntArray.concatenate(sortedArray1, sortedArray2);
        String concatenatedArrayString = RandomIntArray.convertArrayToString(concatenatedArray);

        logger.info("Concataneted Array \n" + concatenatedArrayString);

        int[] sortedConcatenatedArray = BubbleSort.sort(concatenatedArray);
        String sortedConcatenatedArrayString = RandomIntArray.convertArrayToString(sortedConcatenatedArray);

        logger.info("Sorted Concataneted Array \n" + sortedConcatenatedArrayString);
    }
}
