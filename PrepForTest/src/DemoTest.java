import java.util.HashSet;
import java.util.Set;

public class DemoTest {
    public static void main(String[] args) {

    }

    public static int solution(int[] A) {
        int size = A.length;
        if (size == 0) {
            return 1;
        }
        Set<Integer> map = new HashSet<>();
        for (int i = 0; i < size; i++) {
            map.add(A[i]);
        }

        for (int i = 1; i < size + 1; i++) {
            if (!map.contains(i)) {
                return i;
            }
        }
        return size + 1;
    }
}
