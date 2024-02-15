package prefixSum;

public class CountDiv {
    public static void main(String[] args) {
        System.out.println(solution(25, 70, 10));
    }

    public static int solution(int A, int B, int K) {
        // Implement your solution here
        int bDivK = B / K;
        int aDivK = A / K;
        int divisibleByK = bDivK - aDivK;

        if (A % K == 0) {
            divisibleByK++;
        }
        return divisibleByK;
    }
}
