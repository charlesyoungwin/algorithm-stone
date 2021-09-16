import java.util.*;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int key = target - num;
            if (map.containsKey(key)) {
                return new int[]{i, map.get(key)};
            }
            map.put(num, i);
        }
        return new int[]{-1, -1};
    }
}
// @lc code=end

