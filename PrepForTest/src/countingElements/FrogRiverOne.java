package countingElements;

import java.util.HashSet;
import java.util.Set;

public class FrogRiverOne {
    public static void main(String[] args) {
        int[] arr = {1, 3, 1, 3, 2, 1, 3};
        System.out.println(solution(3, arr));
    }

    public static int solution(int X, int[] A) {

        int size = A.length;
        boolean[] map = new boolean[X + 1];
        int counter = X;
        for (int time = 0; time < size; time++) {
            if (!map[A[time]]) {
                map[A[time]] = true;
                counter--;
            }
            if (counter == 0) {
                return time;
            }
        }
        return -1;
    }

    public static int solution1(int X, int[] A) {

        Set<Integer> pos = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            pos.add(A[i]);
            if (pos.size() == X) {
                return i;
            }
        }
        return -1;
    }

}
