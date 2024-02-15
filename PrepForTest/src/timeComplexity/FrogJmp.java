package timeComplexity;

public class FrogJmp {
    public static void main(String[] args) {
        new FrogJmp().solution(1, 5, 2);
    }

    public int solution(int X, int Y, int D) {

        if (X >= Y) {
            return 0;
        }

        int jumps = (Y - X) / D;
        if (jumps * D + X < Y) {
            jumps++;
        }
        System.out.println(jumps);
        return jumps;
    }
}
