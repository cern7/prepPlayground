package sorting;

import java.util.HashSet;
import java.util.Set;

public class Distinct {
    public static void main(String[] args) {
        int[] a = {2, 1, 1, 2, 3, 1};
        System.out.println(solution(a));
    }

    public static int solution(int[] A) {
        // Implement your solution here
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            if (set.contains(A[i])) {
                continue;
            }
            set.add(A[i]);
        }
        return set.size();
    }
}
