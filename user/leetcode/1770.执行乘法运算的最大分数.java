/*
 * @lc app=leetcode.cn id=1770 lang=java
 *
 * [1770] 执行乘法运算的最大分数
 */

// @lc code=start
class Solution {

    public int maximumScore(int[] nums, int[] multipliers) {
        int n = nums.length;
        int m = multipliers.length;
        // 左边取i个，右边取j个
        int[][] dp = new int[m + 1][m + 1];
        for (int i = 1; i <= m; i++) {
            dp[0][i] = dp[0][i - 1] + nums[n - i] * multipliers[i - 1];
            dp[i][0] = dp[i - 1][0] + nums[i - 1] * multipliers[i - 1];
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= m - i; j++) {
                int index = i + j - 1;
                dp[i][j] = Math.max(dp[i - 1][j] + nums[i - 1] * multipliers[index], 
                    dp[i][j - 1] + nums[n - j] * multipliers[index]);
            }
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i <= m; i++) {
            res = Math.max(res, dp[i][m - i]);
        }
        return res;
    }
}
// @lc code=end

