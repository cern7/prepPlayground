package prefixSum;

public class MinAvgTwoSlice {
    public static void main(String[] args) {
        int[] a = {4, 2, 2, 5, 1, 5, 8};

    }

    public static int solution(int[] A) {
        // will check the avg just for slices of 2 and 3 elements

        float min0 = Float.MAX_VALUE;
        int minIndex = 0;
        for (int i = 0; i < A.length - 2; i++) {
            float slice3 = (float) (A[i] + A[i + 1] + A[i + 2]) / 3;
            float slice2 = (float) (A[i] + A[i + 1]) / 2;
            if (min0 > slice3 || min0 > slice2) {
                min0 = Math.min(slice3, slice2);
                // keep the index of start of min slice
                minIndex = i;
            }
        }
        if (min0 >
                (float) (A[A.length - 1] + A[A.length - 2]) / 2) {
            // if last two elements avg is less than curr min
            // return the N-2 index
            return A.length - 2;
        }
        return minIndex;
    }
}
