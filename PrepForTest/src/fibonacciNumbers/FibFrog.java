package fibonacciNumbers;

import java.util.Arrays;

public class FibFrog {
    public static void main(String[] args) {
        int[] a = {0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0};
        System.out.println(solution(a));
    }

    public static int solution(int[] A) {
        int[] arr = Arrays.copyOf(A, A.length + 1);
        arr[A.length] = 1;
        // compute fib numbers
        float[] fib = new float[100];
        fib[1] = 1;
        for (int i = 2; i < 100; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
            if (fib[i] > arr.length) break;
        }

        int[] reachSteps = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[(int) fib[i + 2] - 1] == 1) {
                reachSteps[(int) fib[i + 2] - 1] = 1;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0 || reachSteps[i] > 0) continue;

            int minI = -1;
            int minV = 100000;
            for (int j = 0; j < fib.length; j++) {
                int prevI = i - (int) fib[j];
                if (prevI < 0) break;
                if (reachSteps[prevI] > 0 && minV > reachSteps[prevI]) {
                    minV = reachSteps[prevI];
                    minI = prevI;
                }
            }
            if (minI != -1)
                reachSteps[i] = minV + 1;
        }
        if (reachSteps[arr.length - 1] > 0) {
            return reachSteps[arr.length - 1];
        }
        return -1;
    }
}
