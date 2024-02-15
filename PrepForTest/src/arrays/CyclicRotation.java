package arrays;

public class CyclicRotation {
    public static void main(String[] args) {
        new CyclicRotation().solution(new int[]{3, 8, 9, 7, 6}, 3);
    }


    public int[] solution(int[] A, int K) {
        if (K == 0) {
            return A;
        }
        int size = A.length;
        if(size <2){
            return A;
        }
        K %= size;
        System.out.println("original:");
        print(A);
        reverse(A, 0, size - 1);
        reverse(A, 0, K - 1);
        reverse(A, K, size - 1);

        print(A);
        return A;
    }

    public void reverse(int[] arr, int left, int right) {
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }


    static void print(int[] A) {
        for (int a : A) {
            System.out.print(a + " ");
        }
        System.out.println();
    }
}
