package leetCodePrep;

public class FindTownJudge {
    public static void main(String[] args) {
        int n = 4;
        int[][] t = {
                {1, 3},
                {1, 4},
                {2, 3},
                {2, 4},
                {4, 3}
        };
        System.out.println(new FindTownJudge().findJudge(n, t));
    }

    public int findJudge(int n, int[][] trust) {
        // 1. judge trusts nobody
        // 2. everybody trusts the judge
        if (trust.length == 0) {
            if (n < 2) {
                return 1;
            } else {
                return -1;
            }
        }

        if (trust.length == 1) {
            return trust[0][1];
        }
        int[] sourceNode = new int[n];
        int[] destinationNode = new int[n];
        for (int i = 0; i < trust.length; i++) {
            sourceNode[trust[i][0] - 1]++;
            destinationNode[trust[i][1] - 1]++;
        }

        for (int i = 0; i < n; i++) {
            if (sourceNode[i] == 0 && destinationNode[i] == n - 1) {
                return i + 1;
            }
        }

        return -1;
    }
}
