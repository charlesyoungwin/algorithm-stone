/*
 * @lc app=leetcode.cn id=1530 lang=java
 *
 * [1530] 好叶子节点对的数量
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

    private int res = 0;

    public int countPairs(TreeNode root, int distance) {
        dfs(root, distance);
        return res;
    }

    private List<Integer> dfs(TreeNode root, int distance) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        if (root.left == null && root.right == null) {
            list.add(1);
            return list;
        }
        List<Integer> left = dfs(root.left, distance);
        List<Integer> right = dfs(root.right, distance);
        for (int leftItem : left) {
            for (int rightItem : right) {
                if (leftItem + rightItem <= distance) {
                    res++;
                }
            }
        }
        for (int leftItem : left) {
            leftItem++;
            if (leftItem > distance) {
                continue;
            }
            list.add(leftItem);
        }
        for (int rightItem : right) {
            rightItem++;
            if (rightItem > distance) {
                continue;
            }
            list.add(rightItem);
        }
        return list;
    }
}
// @lc code=end

