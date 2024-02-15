package leetCodePrep;

public class SubstringWithoutRepeatingC {
    public static void main(String[] args) {
        System.out.println(lusIII("geeksforgeeks"));
    }

    public static int lus(String str) {
        int n = str.length();

        int result = 0;
        for (int i = 0; i < n; i++) {
            boolean[] map = new boolean[256];
            for (int j = i; j < n; j++) {
                if (map[str.charAt(j)]) break;
                else {
                    result = Math.max(result, j - i + 1);
                    map[str.charAt(j)] = true;
                }
            }
            map[str.charAt(i)] = false;
        }
        return result;
    }

    public static boolean isValid(String s, int mid) {
        int[] count = new int[256];
        boolean found = false;
        int distinct = 0;
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
            if (count[s.charAt(i)] == 1) {
                distinct++;
            }
            if (i >= mid) {
                count[s.charAt(i - mid)]--;
                if (count[s.charAt(i - mid)] == 0) {
                    distinct--;
                }
            }
            if (i >= mid - 1 && distinct == mid) {
                found = true;
            }
        }
        return found;
    }

    public static int lusII(String str) {
        int size = str.length();
        int answer = Integer.MAX_VALUE;
        int l = 1;
        int h = size;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (isValid(str, mid)) {
                answer = mid;
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return answer;
    }

    public static int lusIII(String str) {
        if (str.length() == 0) {
            return 0;
        }
        if (str.length() == 1) {
            return 1;
        }
        int l = 0;
        int r = 0;
        boolean[] map = new boolean[256];
        int ans = 0;

        while (r < str.length()) {
            if (map[str.charAt(r)]) {
                while (map[str.charAt(r)]) {
                    map[str.charAt(l)] = false;
                    l++;
                }
            }
            map[str.charAt(r)] = true;
            ans = Math.max(ans, r - l + 1);
            r++;
        }
        return ans;
    }
}
