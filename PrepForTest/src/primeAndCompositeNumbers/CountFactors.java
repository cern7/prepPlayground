package primeAndCompositeNumbers;

import java.util.Arrays;

public class CountFactors {
    public static void main(String[] args) {
        System.out.println(solution(Integer.MAX_VALUE));
    }

    public static int solution(int N) {
        // Implement your solution here
        int res = 0;
//        int i = 1;
//        while (i * i < N) {
//            if (N % i == 0) {
//                res += 2;
//                i++;
//            }
//            if (i * i == N) {
//                res++;
//            }
//        }
//        return res;
        try {
            for (int i = 1; i * i <= N; i++) {
                if (N % i == 0) {
                    res++;
                }
            }

        } catch (ArithmeticException e) {
            e.getCause();
        }
        return N == (Math.sqrt(N) * Math.sqrt(N)) ?
                res * 2 - 1 : res * 2;
    }
}
