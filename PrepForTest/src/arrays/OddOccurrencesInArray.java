package arrays;

public class OddOccurrencesInArray {
    public static void main(String[] args) {
        System.out.println(
                new OddOccurrencesInArray()
                        .solution(
                                new int[]{
                                        9, 7, 9, 3, 9, 3, 9}));
    }

    public int solution(int[] A) {
        if (A.length == 1) {
            return A[0];
        }
        int result = 0;
        // the XOR of two identical numbers is 0
        // XOR with 0 is the number itself
        for (int i : A) {
            result ^= i;
            System.out.println(Integer.toBinaryString(result) + "=" + result);
        }
        return result;
    }
}
