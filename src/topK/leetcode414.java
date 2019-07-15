package topK;


import java.util.TreeSet;

/**
 * Created by Hxg
 * Date: 2019/7/14
 * Time: 21:00
 * Version 1.0
 * Description : LeetCode
 */
public class leetcode414 {

    class Solution {
        public int thirdMax(int[] nums) {
            if (nums.length == 1)
                return nums[0];
            if (nums.length == 2)
                return nums[0] > nums[1] ? nums[0] : nums[1];
            TreeSet<Integer> set = new TreeSet<>();
            for (int i = 0; i < nums.length; i++) {
                set.add(nums[i]);
            }
            if (set.size() < 3)
                return set.last();
            set.pollLast();
            set.pollLast();
            return set.last();
        }
    }




}
