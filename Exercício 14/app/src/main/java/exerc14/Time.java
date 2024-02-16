package exerc14;

public class Time {
    
    public static int remainingSeconds(int seconds){
        return seconds % 60;
    }

    public static int remainingMinutes(int seconds){
        return seconds % 3600 / 60;
    }

    public static int secondsToHours(int seconds){
        return seconds / 3600;
    }

    public static String convertTime(int seconds){
        int hours = Time.secondsToHours(seconds);
        int remainingMinutes = Time.remainingMinutes(seconds);
        int remainingSeconds = Time.remainingSeconds(seconds);
        
        return hours + "h " + remainingMinutes + "m " + remainingSeconds + "s";
    }

}
