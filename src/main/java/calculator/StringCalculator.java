package calculator;

public class StringCalculator {
    public static int sum(String input){
        if(input == null) {
            return 0;
        }
        String[] numbers = split(input);
        return sum(numbers);
    }

    private static String[] split(String input){
        return input.split(",|:");
    }


    private static int sum(String[] numbers){
        int total = 0;
        return total;
    }
}