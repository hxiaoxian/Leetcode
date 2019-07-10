package array.easy;

/**
 * Created by Hxg
 * Date: 2019/7/10
 * Time: 14:57
 * Version 1.0
 * Description : LeetCode
 */
public class leetcode136 {
    class Solution {
        public int singleNumber(int[] nums) {
            int n = nums.length;
            int result = 0;
            for (int i = 0; i < n; ++i) {
                result ^= nums[i];
            }
            return result;
        }
    }
}
