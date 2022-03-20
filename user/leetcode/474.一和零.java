/*
 * @lc app=leetcode.cn id=474 lang=java
 *
 * [474] 一和零
 */

// @lc code=start
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][][] dp = new int[len + 1][m + 1][n + 1];
        for (int i = 1; i <= len; i++) {
            String str = strs[i - 1];
            int zeroCount = getCount(str, '0');
            int oneCount = getCount(str, '1');
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    if (j < zeroCount || k < oneCount) {
                        dp[i][j][k] = dp[i - 1][j][k];
                        continue;
                    }
                    dp[i][j][k] = Math.max(dp[i - 1][j][k], 
                            dp[i - 1][j - zeroCount][k - oneCount] + 1);
                }
            }
        }
        return dp[len][m][n];
    }

    private int getCount(String str, char c) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                count++;
            }
        }
        return count;
    }
}
// @lc code=end

