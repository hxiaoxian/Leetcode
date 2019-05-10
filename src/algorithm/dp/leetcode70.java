package algorithm.dp;

/**
 * Created by Hxg
 * Date: 2019/5/7
 * Time: 20:19
 * Version 1.0
 * Description : LeetCode
 */
public class leetcode70 {
    class Solution {
        public int climbStairs(int n) {
            if (n == 1)
                return 1;
            if (n == 2)
                return 2;
            int[] nums = new int[100];
            nums[0] = 1;
            nums[1] = 2;
            for (int i = 2; i < n; i++) {
                nums[i] = nums[i - 1] + nums[i - 2];
            }
            return nums[n - 1];
        }
    }
}
