package array.easy;

/**
 * Created by Hxg
 * Date: 2019/7/9
 * Time: 9:23
 * Version 1.0
 * Description : LeetCode
 */
public class leetcode283 {
    class Solution {
        public void moveZeroes(int[] nums) {
            if (nums.length == 0 || nums == null)
                return;
            for (int i = 0, j = 0, k = nums.length; i < k; ++i) {
                if (nums[i] != 0) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    ++j;
                }
            }
        }
    }
}
