package assessment;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class StringTransform {
    public static void main(String[] args) {
        System.out.println(solution("1343", "1343"));

    }

    public static int sol1(String S, String T) {
        int n = S.length();
        int[] dp = new int[n + 1];

        for (int i = n - 2; i >= 0; i--) {
            int diff = T.charAt(i) - S.charAt(i);
            if (diff < 0) {
                diff += 10;
            }

            dp[i] = diff + dp[i + 1];
        }

        return (dp[0] >= 0) ? dp[0] : -1;

    }

    private static String updateString(String str, int index, int increment) {
        char[] chars = str.toCharArray();
        for (int i = 0; i <= 1; i++) {
            int digit = chars[index + i] - '0';
            digit = (digit + increment) % 10;
            chars[index + i] = (char) (digit + '0');
        }
        return new String(chars);
    }

    public static int solution(String S, String T) {
        // Implement your solution here
        int N = S.length();
        if (N < 1) {
            return -1;
        }
        if (S.equals(T)) {
            return 0;
        }
        int[] chars = new int[S.length()];

        for (int i = 0; i < chars.length; i++) {
            chars[i] = Character.getNumericValue(S.charAt(i));
        }
        int counter = 0;

        for (int i = 0; i < N - 1; i++) {
            int currDiff = Character.getNumericValue(T.charAt(i)) - chars[i];
            if (currDiff == 0) {
                continue;
            }
            if (currDiff < 0) {
                currDiff += 10;
            }
            chars[i] = (chars[i] + currDiff) % 10;
            chars[i + 1] = (chars[i + 1] + currDiff) % 10;
            counter += currDiff;
        }
        if (Character.getNumericValue(T.charAt(N - 1)) != chars[N - 1]) {
            return -1;
        }
        return counter;
    }


}
