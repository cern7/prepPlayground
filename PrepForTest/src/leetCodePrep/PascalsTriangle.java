package leetCodePrep;

import java.util.*;
import java.util.stream.Collectors;

public class PascalsTriangle {
    public static void main(String[] args) {
        System.out.println(getRow(30));
    }

    public static List<Integer> getRow(int rowIndex) {
        int[] list = new int[rowIndex + 1];
        list[0] = 1;
        list[rowIndex] = 1;
        int j = 1;
        long res = 1;
        for (int i = 1; i <= rowIndex / 2; i++) {
            res = res * (rowIndex - i + 1);
            res /= i;
            list[j] = (int)res;
            list[rowIndex - j] = (int)res;
            j++;
        }
        return Arrays.stream(list).boxed().collect(Collectors.toList());
    }
}
