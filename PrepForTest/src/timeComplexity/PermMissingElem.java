package timeComplexity;

public class PermMissingElem {
    public static void main(String[] args) {
        int[] a = {2};
        System.out.println(solution(a));
    }

    public static int solution(int[] A) {
        int size = A.length;
        if (size == 0) {
            return 1;
        }
        if (size == 1) {
            return A[0] > 1 ? A[0] - 1 : A[0] + 1;
        }
        boolean[] map = new boolean[size + 2];
        for (int i : A) {
            map[i] = true;
        }
        for (int i = 1; i < map.length; i++) {
            if (!map[i]) {
                return i;
            }
        }
        return 0;
    }
}
