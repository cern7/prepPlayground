package sorting;

public class NumberOfDiscIntersections {

    public static void main(String[] args) {
        int[] a = {1, 5, 2, 1, 4, 0};
        System.out.println(solution(a));
    }

    public static int solution(int[] A) {
        // Implement your solution here

        int size = A.length;
        if (size == 0) {
            return 0;
        }
        int[] diskStartPoint = new int[size];
        int[] diskEndPoint = new int[size];
        int[] startCounter = new int[size];
        int[] endCounter = new int[size];
        int[] cumStartCounter = new int[size];
        int[] cumEndCounter = new int[size];

        for (int i = 0; i < A.length; i++) {
            diskStartPoint[i] = Math.max(i - A[i], 0);
            diskEndPoint[i] = Math.min(size - 1, i + A[i]);
            startCounter[diskStartPoint[i]]++;
            endCounter[diskEndPoint[i]]++;
        }

        for (int i = 0; i < size; i++) {
            if (i == 0) {
                cumStartCounter[i] = startCounter[i];
                cumEndCounter[i] = endCounter[i];
            } else {
                cumStartCounter[i] = cumStartCounter[i - 1] + startCounter[i];
                cumEndCounter[i] = cumEndCounter[i - 1] + endCounter[i];
            }
        }
        int res = 0;
        for (int i = 0; i < size; i++) {
            res = res
                    + (cumStartCounter[i] - (i > 0 ? cumEndCounter[i - 1] : 0) - startCounter[i]) * startCounter[i]
                    + startCounter[i] * (startCounter[i] - 1) / 2;
        }
        if (res > 10_000_000) {
            return -1;
        }
        return res;
    }
}
