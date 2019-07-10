package array.medium;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by Hxg
 * Date: 2019/7/10
 * Time: 15:11
 * Version 1.0
 * Description : LeetCode
 */
public class leetcode137 {

    // Runtime: 5 ms, faster than 25.68% of Java online submissions for Single Number II.
    // Memory Usage: 38.1 MB, less than 83.12% of Java online submissions for Single Number II.
    class Solution {
        public int singleNumber(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0, j = nums.length; i < j; i++) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() == 1)
                    return entry.getKey();
            }
            return -1;
        }
    }

    // 大神异或解法
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Single Number II.
    // Memory Usage: 36.7 MB, less than 99.36% of Java online submissions for Single Number II.
    class Solution2 {
        public int singleNumber(int[] A) {
            int ones = 0, twos = 0;
            for (int i = 0; i < A.length; i++) {
                ones = (ones ^ A[i]) & ~twos;
                twos = (twos ^ A[i]) & ~ones;
            }
            return ones;
        }
    }

}
