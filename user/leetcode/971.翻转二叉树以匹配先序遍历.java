import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=971 lang=java
 *
 * [971] 翻转二叉树以匹配先序遍历
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

    private List<Integer> flipped;
    private int index;
    private int[] voyage;

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        flipped = new ArrayList<>();
        index = 0;
        this.voyage = voyage;
        dfs(root);
        if (!flipped.isEmpty() && flipped.get(0) == -1) {
            flipped.clear();
            flipped.add(-1);
        }
        return flipped;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.val != voyage[index++]) {
            flipped.clear();
            flipped.add(-1);
            return;
        }
        if (index < voyage.length && root.left != null && root.left.val != voyage[index]) {
            flipped.add(root.val);
            dfs(root.right);
            dfs(root.left);
        } else {
            dfs(root.left);
            dfs(root.right);
        }
    }
}
// @lc code=end

