import java.io.*;
import java.util.*;

public class Calculator {
    public static final Character ADD = '+';
    public static final Character SUBTRACT = '-';
    public static final Character MULTIPLY = '*';
    public static final Character DIVIDE = '/';

    private static BufferedReader br;
    private static StringTokenizer st;
    private static int result, operand;
    private static char operator;

    public static void main(String[] args) throws IOException {
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            st = new StringTokenizer(br.readLine());
        } catch (NullPointerException e) {
            System.out.println(e);
        }

        if (st.hasMoreTokens())
            result = stringToInteger(st.nextToken()); // 첫번째 수 받기

        while (st.hasMoreTokens()) {

            operator = stringToChar(st.nextToken());

            if (st.hasMoreTokens())
                operand = stringToInteger(st.nextToken());

            if (operator == ADD)
                result = add(result, operand);

            if (operator == SUBTRACT)
                result = subtract(result, operand);

            if (operator == MULTIPLY)
                result = multiply(result, operand);

            if (operator == DIVIDE)
                result = divide(result, operand);

            if (operator != ADD || operator != SUBTRACT || operator != MULTIPLY || operator != DIVIDE)
                throw new IllegalArgumentException("사칙연산 문자가 아닙니다");
        }

        System.out.println(result);

    }

    static int stringToInteger(String s) {
        return Integer.parseInt(s);
    }

    static char stringToChar(String s) {
        return s.charAt(0);
    }

    static int add(int a, int b) {
        return a + b;
    }

    static int subtract(int a, int b) {
        return a - b;
    }

    static int multiply(int a, int b) {
        return a * b;
    }

    static int divide(int a, int b) {
        return a / b;
    }
}