/*
 * @lc app=leetcode.cn id=638 lang=java
 *
 * [638] 大礼包
 */

// @lc code=start
class Solution {

    private Map<List<Integer>, Integer> memo = new HashMap<>();

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        List<List<Integer>> filterSpecial = new ArrayList<>();
        int n = price.size();
        for (List<Integer> sp : special) {
            int totalPrice = 0;
            int totalCount = 0;
            for (int i = 0; i < n; i++) {
                totalCount += sp.get(i);
                totalPrice += sp.get(i) * price.get(i);
            }
            if (totalCount > 0 && totalPrice > sp.get(n)) {
                filterSpecial.add(sp);
            }
        }
        return dfs(price, filterSpecial, needs);

    }

    public int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        if (memo.containsKey(needs)) {
            return memo.get(needs);
        }
        int n = price.size();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += needs.get(i) * price.get(i);
        }
        int minPrice = sum;
        for (List<Integer> sp : special) {
            List<Integer> nextNeeds = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (needs.get(i) >= sp.get(i)) {
                    nextNeeds.add(needs.get(i) - sp.get(i));
                } else {
                    break;
                }
            }
            if (nextNeeds.size() == n) {
                int val = sp.get(n);
                minPrice = Math.min(minPrice, val + dfs(price, special, nextNeeds));
            }   
        } 
        memo.put(needs, minPrice);   
        return minPrice;
    }
}
// @lc code=end

