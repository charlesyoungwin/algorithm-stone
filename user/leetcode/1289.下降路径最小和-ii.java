/*
 * @lc app=leetcode.cn id=1289 lang=java
 *
 * [1289] 下降路径最小和  II
 */

// @lc code=start
class Solution {

    // O(n^2)
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int firstSum = 0, firstPos = -1, secondSum = 0;
        for (int i = 0; i < n; i++) {
            int fs = Integer.MAX_VALUE, fp = -1, ss = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                int curSum = (firstPos != j ? firstSum : secondSum) + grid[i][j];
                if (curSum < fs) {
                    ss = fs;
                    fs = curSum;
                    fp = j;
                } else if (curSum < ss) {
                    ss = curSum;
                }
            }
            firstSum = fs;
            firstPos = fp;
            secondSum = ss;
        }
        return firstSum;
    }

    // O(n^3)
    public int minFallingPathSum2(int[][] grid) {
        int n = grid.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = grid[0][i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int prevMin = Integer.MAX_VALUE;
                for (int k = 0; k < n; k++) {
                    if (k == j) {
                        continue;
                    }
                    prevMin = Math.min(dp[i - 1][k], prevMin);
                }
                dp[i][j] = prevMin + grid[i][j];
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.min(res, dp[n - 1][i]);
        }
        return res;
    }
}
// @lc code=end

