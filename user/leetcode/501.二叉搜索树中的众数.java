/*
 * @lc app=leetcode.cn id=501 lang=java
 *
 * [501] 二叉搜索树中的众数
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

    List<Integer> answer = new ArrayList<Integer>();
    int base, count, maxCount;

    public int[] findMode(TreeNode root) {
        dfs(root);
        int[] mode = new int[answer.size()];
        for (int i = 0; i < answer.size(); ++i) {
            mode[i] = answer.get(i);
        }
        return mode;
    }

    public void dfs(TreeNode o) {
        if (o == null) {
            return;
        }
        dfs(o.left);
        update(o.val);
        dfs(o.right);
    }

    public void update(int x) {
        if (x == base) {
            ++count;
        } else {
            count = 1;
            base = x;
        }
        if (count == maxCount) {
            answer.add(base);
        }
        if (count > maxCount) {
            maxCount = count;
            answer.clear();
            answer.add(base);
        }
    }

    // private int res = 1;
    // private int count = 1;
    // private int prev = -1;
    // private List<Integer> nums = new ArrayList<>();

    // public int[] findMode(TreeNode root) {
    //     traverse(root);
    //     int[] array = new int[nums.size()];
    //     for (int i = 0; i < nums.size(); i++) {
    //         array[i] = nums.get(i);
    //     }
    //     return array;
    // }

    // public void traverse(TreeNode root) {
    //     if (root == null) {
    //         return;
    //     }
    //     traverse(root.left);
    //     int val = root.val;
    //     if (prev == val) {
    //         count++;
    //     } else {
    //         count = 1;
    //         prev = val;
    //     }
    //     if (count == res) {
    //         nums.add(val);
    //     } 
    //     if (count > res) {
    //         res = count;
    //         nums.clear();
    //         nums.add(prev);
    //     }
    //     traverse(root.right);

    // }
}
// @lc code=end

