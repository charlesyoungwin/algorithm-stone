/*
 * @lc app=leetcode.cn id=213 lang=java
 *
 * [213] 打家劫舍 II
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(robLine(nums, 1, nums.length), 
            robLine(nums, 0, nums.length - 1));
    }

    public int robLine(int[] nums, int start, int end) {
        if (start + 1 == end) {
            return nums[start];
        }
        int first = nums[start];
        int second = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i < end; i++) {
            int temp  = second;
            second = Math.max(second, first + nums[i]);
            first = temp;
        }
        return second;
    } 
}
// @lc code=end

