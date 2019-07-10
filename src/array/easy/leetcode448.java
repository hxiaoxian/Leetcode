package array.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hxg
 * Date: 2019/7/9
 * Time: 23:28
 * Version 1.0
 * Description : LeetCode
 */
public class leetcode448 {
    class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            List<Integer> result = new ArrayList<>();
            int n = nums.length;
            int a[] = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                a[i] = 0;
            }
            for (int i = 0; i < n; i++) {
                a[nums[i]]++;
            }
            for (int i = 1; i <= n; i++) {
                if (a[i] == 0) {
                    result.add(i);
                }
            }
            return result;
        }
    }
}
