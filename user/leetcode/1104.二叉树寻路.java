/*
 * @lc app=leetcode.cn id=1104 lang=java
 *
 * [1104] 二叉树寻路
 */

// @lc code=start
class Solution {

    public List<Integer> pathInZigZagTree(int label) {
        int row = 1;
        int rowStart = 1;
        while (rowStart * 2 <= label) {
            row++;
            rowStart *= 2;
        }
        List<Integer> path = new ArrayList<>();
        path.add(label);
        while (row > 1) {
            label = (1 << row - 1) + (1 << row) - 1 - label;
            label /= 2;
            path.add(label);
            row--; 
        }
        Collections.reverse(path);
        return path;
    }

    public List<Integer> pathInZigZagTree2(int label) {
        int row = 1;
        int rowStart = 1;
        while (rowStart * 2 <= label) {
            row++;
            rowStart *= 2;
        }
        if (row % 2 == 0) {
            label = getReverse(label, row);
        }
        List<Integer> path = new ArrayList<>();
        while (row > 0) {
            if (row % 2 == 0) {
                path.add(getReverse(label, row));
            } else {
                path.add(label);
            }
            row--;
            label >>= 1;
        }
        Collections.reverse(path);
        return path;
    }

    public int getReverse(int label, int row) {
        return (1 << row - 1) + (1 << row) - 1 - label; 
    }
}
// @lc code=end

