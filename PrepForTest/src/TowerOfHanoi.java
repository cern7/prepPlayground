public class TowerOfHanoi {
    public static void main(String[] args) {
        toh(5, 1, 2, 3);
    }

    public static void toh(int n, int a, int b, int c) {
        if (n > 0) {
            toh(n - 1, a, c, b);
            System.out.printf("move disc %d from %d to %d\n", n, a, c);
            toh(n - 1, b, a, c);
        }
    }

}
