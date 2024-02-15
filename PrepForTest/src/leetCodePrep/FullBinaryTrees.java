package leetCodePrep;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FullBinaryTrees {
    public static void main(String[] args) {
        System.out.println(allPossibleFBT(7));
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return String.format("%s", this.val);
        }
    }

    static HashMap<Integer, List<TreeNode>> hm = new HashMap<>();

    public static List<TreeNode> allPossibleFBT(int n) {
        if (n % 2 == 0) {
            return new ArrayList<>();
        }
        if (n == 1) {
            return List.of(new TreeNode(0));
        }
        if (hm.containsKey(n)) {
            return hm.get(n);
        }

        List<TreeNode> list = new ArrayList<>();
        for (int i = 1; i < n; i += 2) {
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(n - i - 1);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode newRoot = new TreeNode(0, l, r);
                    list.add(newRoot);
                }
            }
        }
        hm.put(n, list);
        return list;

    }

    public static List<TreeNode> allPossibleFBT_DP(int n) {
        if (n % 2 == 0) {
            return new ArrayList<>();
        }
        // create a list dp[n + 1] to store a list of root nodes
        // for all possible full binary tree
        // initialize each list to an empty list
        List<List<TreeNode>> dp = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            dp.add(new ArrayList<>());
        }

        // push a single node into dp[1] because with n = 1
        // we can have just a root node in the tree
        dp.get(1).add(new TreeNode(0));

        // outer loop corresponds to the total number of nodes
        for (int i = 3; i <= n; i += 2) {
            // inner loop corresponds to number of nodes in the left subtree
            for (int j = 1; j < i - 1; j += 2) {
                int rightSubTree = i - j - 1;

                for (TreeNode left : dp.get(i)) {
                    for (TreeNode right : dp.get(rightSubTree)) {
                        TreeNode root = new TreeNode(0, left, right);
                        dp.get(i).add(root);
                    }
                }

            }
        }
        return dp.get(n);
    }
}
