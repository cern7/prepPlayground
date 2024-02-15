package dynamicProgramming;

public class IsSubsequence {
    public static void main(String[] args) {
        System.out.println(new IsSubsequence().isSubsequence("abc", "afbfsc"));
    }

    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) {
            return false;
        }
        if (t.equals(s)) {
            return true;
        }
        if (t.isEmpty()) {
            return false;
        }
        if (s.isEmpty()) {
            return true;
        }

        int[] sSeq = new int[26];
        sSeq[t.charAt(0) - 'a']++;
        for (int i = 1; i < t.length(); i++) {
            char curr = t.charAt(i);
            char prev = t.charAt(i - 1);
            sSeq[curr - 'a'] = sSeq[prev - 'a'] + 1;
        }

        int posOfCharSinT = sSeq[s.charAt(0) - 'a'];
        if (posOfCharSinT == 0) {
            return false;
        }
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (sSeq[c - 'a'] == 0) {
                return false;
            }
            int posOfCharSinT_II = sSeq[c - 'a'];
            if (posOfCharSinT > posOfCharSinT_II) {
                return false;
            }
            posOfCharSinT = sSeq[c - 'a'];

        }
        return true;
    }


}
