package prefixSum;

public class PassingCars {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{0, 1, 0, 1, 1}));
    }

    public static int solution(int[] A) {
        int maxValue = 1_000_000_000;
        int counter = 0;
        int zeroCounter = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                zeroCounter++;
            } else if (A[i] == 1) {
                counter += zeroCounter;
                if (counter > maxValue) {
                    return -1;
                }
            }
        }
        return counter;
    }
}
