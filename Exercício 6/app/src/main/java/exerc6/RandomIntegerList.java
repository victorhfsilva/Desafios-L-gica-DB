package exerc6;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomIntegerList {
    
    private RandomIntegerList(){

    }

    public static List<Integer> generateRandomList(int size, int maximumValue) throws InvalidParameterException{
        if (size <= 0) {
            throw new InvalidParameterException("Invalid size.");
        }
        if (maximumValue <= 0) {
            throw new InvalidParameterException("Invalid max value.");
        }
        ArrayList<Integer> list = new ArrayList<>();
        Random random = new Random();
        
        for(int i = 0; i < size; i++){
            list.add(random.nextInt(maximumValue + 1));
        }
        return list;
    }

    public static int getMaximumValue(List<Integer> list){
        return list.stream().reduce(Integer.MIN_VALUE, Integer::max);
    }

    public static int getMinimumValue(List<Integer> list){
        return list.stream().reduce(Integer.MAX_VALUE, Integer::min);
    }

    public static String convertListToString(List<Integer> list){
        int maximumValue = getMaximumValue(list);
        int minimumValue = getMinimumValue(list);

        List<String> listString = list.stream()
                                      .map(i -> {
                                          String str = String.valueOf(i);
                                          if (i == maximumValue) {
                                              str = "M" + str;
                                          }
                                          if (i == minimumValue) {
                                              str = "m" + str;
                                          }
                                          return str;
                                      })
                                      .toList();

        return String.join(" ", listString);
    }
}
