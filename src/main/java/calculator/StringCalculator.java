package calculator;

import java.util.regex.Pattern;

public class StringCalculator {
    public static int sum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        String[] numbers = split(input);
        return sum(numbers);
    }

    /*
     문자열을 구분자 기준으로 분리한다.
     */
    private static String[] split(String input) {
        if (input.startsWith("//")) {
            int lineIndex = input.indexOf("\\n");
            if (lineIndex == -1) {
                throw new IllegalArgumentException("[ERROR] 잘못된 입력 형식입니다.");
            }

            String delimiter = input.substring(2, lineIndex);
            if (delimiter.isEmpty()) {
                throw new IllegalArgumentException("[ERROR] 구분자가 비어 있습니다.");
            }

            String numbersPart = input.substring(lineIndex + 2);
            if (numbersPart.isEmpty()) {
                throw new IllegalArgumentException("[ERROR] 숫자 부분이 비어있습니다.");
            }
            // 커스텀 + 기본 구분자 모두 허용
            return numbersPart.split(Pattern.quote(delimiter) + "|,|:");
        }
        return input.split("[,:]");
    }

    /*
    분리된 문자열 배열을 정수로 변환하여 합산한다.
     */
    private static int sum(String[] numbers) {
        int total = 0;

        for (String numStr : numbers) {
            if (numStr.isEmpty()) {
                throw new IllegalArgumentException("[ERROR] 잘못된 입력 형식입니다.");
            }

            try {
                int num = Integer.parseInt(numStr.trim());
                if (num <= 0) {
                    throw new IllegalArgumentException("[ERROR] 0또는 음수는 허용되지 않습니다: " + num);
                }
                total += num;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 숫자가 아닌 값이 포함되어 있습니다: " + numStr);
            }
        }
        return total;
    }
}