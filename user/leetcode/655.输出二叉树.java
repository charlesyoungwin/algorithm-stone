import java.util.ArrayList;
import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=655 lang=java
 *
 * [655] 输出二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<String>> printTree(TreeNode root) {
        int height = getHeight(root);
        String[][] res = new String[height][(1 << height) - 1];
        for (String[] arr : res) {
            Arrays.fill(arr, "");
        }
        fill(res, root, 0, 0, res[0].length);
        List<List<String>> ans = new ArrayList<>();
        for (String[] arr : res) {
            ans.add(Arrays.asList(arr));
        }
        return ans;
    }

    public void fill(String[][] res, TreeNode root, int i, 
        int left, int right) {
        if (root == null) {
            return;
        }
        int mid = (left + right) / 2;
        res[i][mid] = root.val + "";
        fill(res, root.left, i + 1, left, mid);
        fill(res, root.right, i + 1, mid + 1, right);
    }

    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
}
// @lc code=end

