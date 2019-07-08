package algorithm.dp;

/**
 * Created by Hxg
 * Date: 2019/7/6
 * Time: 22:51
 * Version 1.0
 * Description : LeetCode
 */
public class leetcode303 {
    class NumArray {

        private int[] data;

        public NumArray(int[] nums) {
            if (nums.length == 0) {
                data = null;
            } else {
                data = new int[nums.length + 1];
                data[0] = nums[0];
                for (int i = 1, j = nums.length; i < j; i++) {
                    data[i] = data[i - 1] + nums[i];
                }
            }
        }

        public int sumRange(int i, int j) {
            return data == null ? 0 : i == 0 ? data[j] : data[j] - data[i - 1];
        }
    }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
}
