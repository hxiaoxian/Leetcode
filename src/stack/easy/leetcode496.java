package stack.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by Hxg
 * Date: 2019/4/21
 * Time: 22:06
 * Version 1.0
 * Description : LeetCode
 */
public class leetcode496 {
    class Solution {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            Stack<Integer> stack = new Stack<>();
            Map<Integer, Integer> map = new HashMap<>();
            int[] res = new int[nums1.length];
            for (int num : nums2) {
                while (!stack.isEmpty() && num > stack.peek()) {
                    map.put(stack.pop(), num);
                }
                stack.push(num);
            }
            while (!stack.isEmpty()) {
                map.put(stack.pop(), -1);
            }
            for (int i = 0; i < res.length; i++) {
                res[i] = map.get(nums1[i]);
            }
            return res;
        }
    }
}
