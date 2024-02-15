package countingElements;

import java.util.HashSet;
import java.util.Set;

public class MissingInteger {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(solution(arr));
    }

    public static int solution(int[] A) {
        if (A.length == 0) {
            return 1;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            set.add(A[i]);
        }

        for (int i = 1; i < A.length + 1; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return A.length + 1;
    }

    static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
