import java.io.*;
import java.util.*;

public class Calculator {
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

        while(st.hasMoreTokens()) {

            operator = stringToChar(st.nextToken());

            if (st.hasMoreTokens())
                operand = stringToInteger(st.nextToken());

            if (operator == '+')
                result = add(result, operand);

            if (operator == '-')
                result = subtract(result, operand);

            if (operator == '*')
                result = multiply(result, operand);

            if (operator == '/')
                result = divide(result, operand);
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