/*
 * @lc app=leetcode.cn id=1130 lang=java
 *
 * [1130] 叶值的最小代价生成树
 */

// @lc code=start
class Solution {
    public int mctFromLeafValues(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = i == j ? 0 : Integer.MAX_VALUE;
            }
        }
        int[][] max = new int[n][n];
        for (int j = 0; j < n; j++) {
            for (int i = j; i >= 0; i--) {
                max[i][j] = i == j ? arr[i] : Math.max(max[i + 1][j], arr[i]);
            }
        }
        for (int j = 0; j < n; j++) {
            for (int i = j; i >= 0; i--) {
                for (int k = i; k < j; k++) {
                    int val = max[i][k] * max[k + 1][j];
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + val);
                }
            }
        }
        return dp[0][n - 1];
    }
}
// @lc code=end

