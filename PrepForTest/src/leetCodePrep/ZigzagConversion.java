package leetCodePrep;

import java.util.Arrays;

public class ZigzagConversion {
    public static void main(String[] args) {
        System.out.println(convert("Constantin", 35));
    }

    public static String convert(String s, int numRows) {
        if (s.isEmpty()) {
            return "";
        }
        if (s.length() == 1 || numRows == 1) {
            return s;
        }

        String[] res = new String[Math.min(numRows, s.length())];
        boolean switchDirection = false;
        StringBuilder sb = new StringBuilder();
        int row = 0;
        for (int i = 0; i < s.length(); i++) {
            res[row] = res[row] != null ? res[row] + s.charAt(i) : "" + s.charAt(i);
            if (row == 0 || row == numRows - 1) {
                switchDirection = !switchDirection;
            }
            row += switchDirection ? 1 : -1;
        }

        for (String st : res) {
            sb.append(st);
        }
        return sb.toString();
    }
}
