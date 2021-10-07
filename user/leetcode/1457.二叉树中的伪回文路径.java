import java.util.HashSet;
import java.util.LinkedList;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=1457 lang=java
 *
 * [1457] 二叉树中的伪回文路径
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

    private int[] cnt = new int[10];

    private int res = 0;

    public int pseudoPalindromicPaths (TreeNode root) {
        
        dfs(root);
        return res;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        int val = root.val;
        cnt[val]++;
        if (root.left == null && root.right == null) {
            if (check(cnt)) {
                res++;
            }
        } 
        dfs(root.left);
        dfs(root.right);
        cnt[val]--;
    }

    public boolean check(int[] cnt) {
        int even = 0;
        for (int item : cnt) {
            if (item % 2 == 1) {
                even++;
            }
        }
        if (even <= 1) {
            return true;
        } else {
            return false;
        }
    }
}
// @lc code=end

