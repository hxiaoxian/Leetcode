package count.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Hxg
 * Date: 2019/4/30
 * Time: 22:51
 * Version 1.0
 * Description : LeetCode
 */

public class leetcode169 {
    // 两层循环暴力  O(N^2)
    // Runtime: 1245 ms, faster than 5.07% of Java online submissions for Majority Element.
    class Solution {
        public int majorityElement(int[] nums) {
            for (int num : nums) {
                int count = 0;
                for (int elem : nums) {
                    if (elem == num) {
                        count += 1;
                    }
                }
                if (count > nums.length / 2) {
                    return num;
                }
            }
            return -1;
        }
    }

    // 使用Map计数   时间空间复杂度O(N)  边插入边判断
    // Runtime: 13 ms, faster than 34.49% of Java online submissions for Majority Element.
    // Memory Usage: 41.2 MB, less than 28.54% of Java online submissions for Majority Element.
    class Solution2 {
        public int majorityElement(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            int result = -1;
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
                if (map.get(nums[i]) > nums.length / 2) {
                    result = nums[i];
                    break;
                }
            }
            return result;
        }
    }

    // 使用Map计数   时间空间复杂度O(N)  插入后再判断
    // Runtime: 11 ms, faster than 40.64% of Java online submissions for Majority Element.
    // Memory Usage: 41.4 MB, less than 28.08% of Java online submissions for Majority Element.
    class Solution3 {
        public int majorityElement(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            int result = -1;
            int maxValue = 0;
            int maxKey = 0;
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() > maxValue) {
                    maxValue = entry.getValue();
                    maxKey = entry.getKey();
                }
            }
            return maxKey;
        }
    }


    // sort  O(NlogN)
    // Runtime: 1 ms, faster than 100.00% of Java online submissions for Majority Element.
    // Memory Usage: 43.3 MB, less than 22.74% of Java online submissions for Majority Element.
    class Solution4 {
        public int majorityElement(int[] nums) {
            Arrays.sort(nums);
            return nums[nums.length / 2];
        }
    }


    // 大佬版divide and conquer  时间复杂度O(NlogN)
    // Runtime: 1 ms, faster than 100.00% of Java online submissions for Majority Element.
    // Memory Usage: 42.8 MB, less than 25.76% of Java online submissions for Majority Element.
    class Solution5 {
        public int majorityElement(int[] nums) {
            return find(nums, 0, nums.length - 1);
        }

        public int find(int[] nums, int begin, int end) {
            if (begin == end)
                return nums[begin];
            else {
                int mid = (begin + end) / 2;
                // 分治
                int left = find(nums, begin, mid);
                int right = find(nums, mid + 1, end);
                // 左右两部分的众数相同 则这个数是这部分的众数
                if (left == right)
                    return left;
                else {
                    // 左右两部分的众数不相同 则这两个数都有可能是这部分的众数
                    // 那么遍历这个数组 看一下哪个数字的出现频率高
                    int countLeft = 0;
                    int countRight = 0;
                    for (int i = begin; i <= end; i++)
                        if (nums[i] == left)
                            countLeft++;
                        else if (nums[i] == right)
                            countRight++;

                    if (countLeft > countRight)
                        return left;
                    else
                        return right;
                }
            }
        }
    }
}
