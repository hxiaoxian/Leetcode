package algorithm.dp;

/**
 * Created by Hxg
 * Date: 2019/5/9
 * Time: 23:27
 * Version 1.0
 * Description : LeetCode
 */
public class leetcode121 {
    class Solution {
        public int maxProfit(int[] prices) {
            int profit = 0;
            int max = 0;
            for (int i = 1, n = prices.length; i < n; i++) {
                max = Math.max(0, max += prices[i] - prices[i - 1]);
                profit = Math.max(max, profit);
            }
            return profit;
        }
    }
}
