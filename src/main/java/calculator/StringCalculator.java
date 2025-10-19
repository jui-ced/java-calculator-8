package calculator;

public class StringCalculator {
    public static int sum(String input){
        if(input == null || input.isEmpty()) {
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
            return numbersPart.split(java.util.regex.Pattern.quote(delimiter) + "|,|:");
        }
        return input.split(",|:");
    }

    private static int sum(String[] numbers){
        int total = 0;

        for(String numStr : numbers) {
            if(numStr.isEmpty()){
                throw new IllegalArgumentException("빈 문자열 입니다.");
            }
            int num = Integer.parseInt(numStr);

            if(num<0){
                throw new IllegalArgumentException("음수는 허용되지 않습니다.");
            }
            total += num;
        }
        return total;
    }
}