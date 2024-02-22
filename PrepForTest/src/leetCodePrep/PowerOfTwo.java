package leetCodePrep;

public class PowerOfTwo {
    public static void main(String[] args) {
        int n = -21474;
        System.out.println(Integer.MIN_VALUE);
        System.out.println(new PowerOfTwo().isPowerOfTwo(n));
    }

    public boolean isPowerOfTwo(int n) {
        if (n < 1) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }
}
