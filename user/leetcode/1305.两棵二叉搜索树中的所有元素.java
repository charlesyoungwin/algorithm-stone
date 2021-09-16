/*
 * @lc app=leetcode.cn id=1305 lang=java
 *
 * [1305] 两棵二叉搜索树中的所有元素
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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        traverse(root1, list1);
        List<Integer> list2 = new ArrayList<>();
        traverse(root2, list2);
        return mergeList(list1, list2);
    }

    private void traverse(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        traverse(root.left, list);
        list.add(root.val);
        traverse(root.right, list);
    }

    private List<Integer> mergeList(List<Integer> list1, List<Integer> list2) {
        List<Integer> res = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) < list2.get(j)) {
                res.add(list1.get(i));
                i++;
            } else {
                res.add(list2.get(j));
                j++;
            }
        }
        if (i == list1.size()) {
            while (j < list2.size()) {
                res.add(list2.get(j));
                j++;
            }
        }
        if (j == list2.size()) {
            while (i < list1.size()) {
                res.add(list1.get(i));
                i++;
            }
        }
        return res;
    }
}
// @lc code=end

