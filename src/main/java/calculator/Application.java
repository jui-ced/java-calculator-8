package calculator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        int result = StringCalculator.sum(input);
        System.out.println("결과 : " + result);

    }
}
