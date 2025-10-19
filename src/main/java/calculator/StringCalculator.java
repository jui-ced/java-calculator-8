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
        if(input.startsWith("//")){
            int lineIndex = input.indexOf("\\n");
            String delimiter = input.substring(2, lineIndex);
            String numbersPart = input.substring(lineIndex+2);
            return numbersPart.split(delimiter);
        }
        return input.split(",|:");
    }

    private static int sum(String[] numbers){
        int total = 0;

        for(String numStr : numbers) {
            int num = Integer.parseInt(numStr);
            total += num;
        }
        return total;
    }
}