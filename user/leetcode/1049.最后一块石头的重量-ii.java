/*
 * @lc app=leetcode.cn id=1049 lang=java
 *
 * [1049] 最后一块石头的重量 II
 */

// @lc code=start
class Solution {
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int sum = 0;
        for (int num : stones) {
            sum += num;
        }
        int value = sum / 2;
        int[][] dp = new int[n + 1][value + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= value; j++) {
                if (j < stones[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                    continue;
                }
                dp[i][j] = Math.max(dp[i - 1][j], 
                        dp[i - 1][j - stones[i - 1]] + stones[i - 1]);
            }
        }
        return sum - dp[n][value] * 2;
    }
}
// @lc code=end

