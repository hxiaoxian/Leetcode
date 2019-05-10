package algorithm.dp;

/**
 * Created by Hxg
 * Date: 2019/5/10
 * Time: 11:19
 * Version 1.0
 * Description : LeetCode
 */
public class leetcode122 {
    // 贪心
    class Solution {
        public int maxProfit(int[] prices) {
            int profit = 0;
            for (int i = 1; i < prices.length; i++)
                if (prices[i] - prices[i - 1] > 0) {
                    profit += prices[i] - prices[i - 1];
                }
            return profit;
        }
    }

    // DP
    class Solution2 {
        public int maxProfit(int[] prices) {
            if (prices.length <= 1)
                return 0;

            int n = prices.length;
            int[] buy = new int[n];
            int[] sell = new int[n];

            buy[0] = 0 - prices[0];
            sell[0] = 0;
            for (int i = 1; i < n; i++) {
                buy[i] = Math.max(buy[i - 1], sell[i - 1] - prices[i]);
                sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
            }
            return sell[n - 1];
        }
    }

}
