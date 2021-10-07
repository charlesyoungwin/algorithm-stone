import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=988 lang=java
 *
 * [988] 从叶结点开始的最小字符串
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

    private String res = "~";

    public String smallestFromLeaf(TreeNode root) {
        dfs(root, new StringBuilder());
        return res;
    }

    public void dfs(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        sb.append((char) (root.val + 'a'));
        if (root.left == null && root.right == null) {
            sb.reverse();
            String str = sb.toString();
            if (str.compareTo(res) < 0) {
                res = str;
            }
            sb.reverse();
        }
        dfs(root.left, sb);
        dfs(root.right, sb);
        sb.deleteCharAt(sb.length() - 1);
    }


}
// @lc code=end

