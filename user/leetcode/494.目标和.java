/*
 * @lc app=leetcode.cn id=494 lang=java
 *
 * [494] 目标和
 */

// @lc code=start
class Solution {

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int diff = sum - target;
        if (diff < 0 || diff % 2 != 0) {
            return 0;
        }
        int n = nums.length;
        int neg = diff / 2;
        int[][] dp = new int[n + 1][neg + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= neg; j++) {
                if (j < nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                    continue;
                } 
                dp[i][j] = dp[i - 1][j] + dp[i][j - nums[i - 1]];
            }
        }
        return dp[n][neg];       
    }

}
// @lc code=end

