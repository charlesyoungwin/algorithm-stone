/*
 * @lc app=leetcode.cn id=377 lang=java
 *
 * [377] 组合总和 Ⅳ
 */

// @lc code=start
class Solution {
    public int combinationSum4(int[] nums, int target) {
        int len = target;
        int[][] dp = new int[len + 1][target + 1];
        dp[0][0] = 1;
        int ans = 0;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j <= target; j++) {
                for (int u : nums) {
                    if (j >= u) {
                        dp[i][j] += dp[i - 1][j - u];
                    }
                }
            }
            ans += dp[i][target];
        }
        return ans;
    }
}
// @lc code=end

