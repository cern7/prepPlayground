package assessment;

import java.util.*;

public class Robot {
    public static void main(String[] args) {
        String a = "<vvv>>^^^<";
        System.out.println(solution0(a));
    }

    public static boolean solution0(String moves) {
        int x = 0;
        int y = 0;
        Map<String, Integer> points = new LinkedHashMap<>();
        for (char move : moves.toCharArray()) {
            String position = x + "," + y;
            points.put(position,
                    points.getOrDefault(position, 0) + 1);
            switch (move) {
                case '^':
                    y++;
                    break;
                case 'v':
                    y--;
                    break;
                case '<':
                    x--;
                    break;
                case '>':
                    x++;
                    break;
            }
        }
        String finalPosition = x + "," + y;
        if (points.getOrDefault(finalPosition, 0) != 1) {
            return false;
        }
        // check if all points, excluding
        // the starting position, are visited twice
        for (Map.Entry<String, Integer> entry : points.entrySet()) {
            if (!entry.getKey().equals("0,0")
                    && entry.getValue() != 2) {
                return false;
            }
        }
        return true;
    }

    public boolean solution(String moves) {
        int up = 0;
        int down = 0;
        int left = 0;
        int right = 0;
        if (moves.length() < 2) {
            return false;
        }
        for (char c : moves.toCharArray()) {

            if (c == '^') up++;

            else if (c == 'v') down++;

            else if (c == '<') left++;

            else if (c == '>') right++;


            if (up > 0 && up == down
                    && left > 0 && left == right) {
                return true;
            }
        }
        return false;
    }
}
