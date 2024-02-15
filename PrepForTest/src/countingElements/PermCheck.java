package countingElements;

import java.util.HashSet;
import java.util.Set;

public class PermCheck {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{102, 101}));
    }

    public static int solution(int[] A) {
        int size = A.length;
        Set<Integer> all = new HashSet<>();
        for (int i : A) {
            if (i > A.length) {
                return 0;
            }
            all.add(i);
        }
        return all.size() == A.length ? 1 : 0;
    }
}
