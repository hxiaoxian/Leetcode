package algorithm.dp;

/**
 * Created by Hxg
 * Date: 2019/5/8
 * Time: 17:23
 * Version 1.0
 * Description : LeetCode
 */
public class leetcode198 {
    class Solution {
        public int rob(int[] nums) {
            int n = nums.length;
            if (n == 1)
                return nums[0];
            if (n == 2)
                return Math.max(nums[0], nums[1]);
            // 二维dp数组，两个状态，偷与不偷
            int[][] dp = new int[n + 1][2];
            for (int i = 1; i <= n; i++) {
                dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][0]);
                dp[i][1] = dp[i - 1][0] + nums[i - 1];
            }
            return Math.max(dp[n][0], dp[n][1]);
        }
    }
}
