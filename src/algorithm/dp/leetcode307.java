package algorithm.dp;

import java.util.Arrays;

/**
 * Created by Hxg
 * Date: 2019/7/6
 * Time: 23:12
 * Version 1.0
 * Description : LeetCode
 */
public class leetcode307 {
    class NumArray {
        private int[] data;
        private int[] temp;

        public NumArray(int[] nums) {
            if (nums.length == 0) {
                data = null;
                temp = null;
            } else {
                temp = Arrays.copyOf(nums, nums.length);
                data = new int[nums.length + 1];
                data[0] = nums[0];
                for (int i = 1, j = nums.length; i < j; i++) {
                    data[i] = data[i - 1] + nums[i];
                }
            }
        }

        public void update(int i, int val) {
            for (int j = i; j < data.length - 1; j++)
                data[j] -= (temp[i] - val);
            temp[i] = val;
        }

        public int sumRange(int i, int j) {
            return data == null ? 0 : i == 0 ? data[j] : data[j] - data[i - 1];
        }
    }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
}
