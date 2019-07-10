package array.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Hxg
 * Date: 2019/7/10
 * Time: 15:26
 * Version 1.0
 * Description : LeetCode
 */
public class leetcode260 {

    // Runtime: 5 ms, faster than 19.52% of Java online submissions for Single Number III.
    // Memory Usage: 37.1 MB, less than 98.71% of Java online submissions for Single Number III.
    class Solution {
        public int[] singleNumber(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            List<Integer> list = new ArrayList<>(2);
            int[] result = new int[2];
            for (int i = 0, j = nums.length; i < j; i++) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() == 1)
                    list.add(entry.getKey());
            }
            result[0] = list.get(0);
            result[1] = list.get(1);
            return result;
        }
    }

    // 大神位运算
    // Runtime: 1 ms, faster than 99.95% of Java online submissions for Single Number III.
    // Memory Usage: 38.6 MB, less than 96.12% of Java online submissions for Single Number III.
    class Solution2 {
        public int[] singleNumber(int[] nums) {
            int record = 0;
            for (int num : nums) {
                record ^= num;
            }
            record &= -record;
            int[] ans = {0, 0};
            for (int num : nums) {
                if ((num & record) == 0) {
                    ans[0] ^= num;
                } else {
                    ans[1] ^= num;
                }
            }
            return ans;
        }
    }
}
