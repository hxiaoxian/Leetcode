package array.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Hxg
 * Date: 2019/4/27
 * Time: 14:38
 * Version 1.0
 * Description : LeetCode
 */
public class leetcode1 {
    //O(N^2)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] == target - nums[j])
                        return new int[]{i, j};
                }
            }
            return null;
        }
    }

    //map，先放再查
    class Solution2 {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], i);
            }
            // 需判断是否是同个索引
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i) {
                    return new int[]{i, map.get(target - nums[i])};
                }
            }
            return null;
        }
    }

    //map，边查边放
    class Solution3 {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int index = target - nums[i];
                if (map.containsKey(index) && map.get(index) != i) {
                    return new int[]{map.get(index), i};
                }
                map.put(nums[i], i);
            }
            return null;
        }
    }
}
