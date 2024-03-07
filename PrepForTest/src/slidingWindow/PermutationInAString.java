package slidingWindow;

import java.util.Arrays;

public class PermutationInAString {
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        System.out.println(checkInclusion(s1, s2));
    }

    public static boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }
        int[] m1 = new int[26];
        int[] m2 = new int[26];

        for (char c : s1.toCharArray()) {
            m1[c - 'a']++;
        }

        int left = 0;
        int right = 0;
        while (right < s2.length()) {
            m2[s2.charAt(right) - 'a']++;
            if (right - left + 1 > s1.length()) {
                m2[s2.charAt(left) - 'a']--;
                left++;
            }
            if (right - left + 1 == s1.length()
                    && Arrays.equals(m1, m2)) {
                return true;
            }

            right++;
        }

        return false;
    }
}
