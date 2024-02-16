package exerc11;

import java.util.Random;

public class RandomIntArray {
    
    private RandomIntArray(){

    }

    public static int[] generateRandomArray(int size, int maximumValue) throws InvalidParameterException {
        if (size <= 0) {
            throw new InvalidParameterException("Invalid size.");
        }
        if (maximumValue <= 0) {
            throw new InvalidParameterException("Invalid max value.");
        }

        int[] list = new int[size];
        Random random = new Random();
        
        for (int i = 0; i < size; i++) {
            list[i] = random.nextInt(maximumValue + 1);
        }
        return list;
    }

    
    public static String convertArrayToString(int[] list){
        String[] listString = new String[list.length];
        
        for (int i = 0; i < list.length; i++) {
            listString[i] = String.valueOf(list[i]);
        }

        return String.join(" ", listString);
    }
}
