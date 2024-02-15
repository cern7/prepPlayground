package prefixSum;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GenomicRangeQuery {
    public static void main(String[] args) {
        String S = "CAGCCTA";
        int[] P = {2, 5, 0};
        int[] Q = {4, 5, 6};
        print(solution(S, P, Q));
    }

    static void print(int[] A) {
        for (int a : A) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    static void print(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


    public static int[] solution(String S, int[] P, int[] Q) {
        int[][] prefixSums = new int[3][S.length() + 1];
        int[] res = new int[P.length];
        // if char is at index i => 1 else 0
        int a = 0;
        int c = 0;
        int g = 0;
        for (int i = 0; i < S.length(); i++) {

            if (S.charAt(i) == 'A') a++;
            else if (S.charAt(i) == 'C') c++;
            else if (S.charAt(i) == 'G') g++;
            prefixSums[0][i + 1] = a;
            prefixSums[1][i + 1] = c;
            prefixSums[2][i + 1] = g;
        }
        for (int i = 0; i < P.length; i++) {
            int left = P[i];
            int right = Q[i] + 1;
            int temp = 4;
            for (int j = 0; j < 3; j++) {
                if (prefixSums[j][right] - prefixSums[j][left] > 0) {
                    temp = j + 1;
                    break;
                }
            }
            res[i] = temp;
        }
        return res;
    }

//    public static int[] solution(String S, int[] P, int[] Q) {
//        // Implement your solution here
//        int[] res = new int[P.length];
//        Map<Integer, Nucleotides> map = IntStream.range(0, S.length())
//                .boxed()
//                .collect(Collectors.toMap(
//                        Function.identity(),
//                        i -> Nucleotides.valueOf(String.valueOf(S.charAt(i)))
//                ));
//        System.out.println(map);
//        for (int i = 0; i < P.length; i++) {
//            int left = P[i];
//            int right = Q[i];
//            int min = 5;
//            for (int j = left; j <= right; j++) {
//                min = Math.min(min, map.get(j).getImpactFactor());
//            }
//            res[i] = min;
//        }
//        return res;
//    }
}
