package array.easy;

/**
 * Created by Hxg
 * Date: 2019/7/7
 * Time: 16:19
 * Version 1.0
 * Description : LeetCode
 */
public class leetcode905 {
    class Solution {
        public int[] sortArrayByParity(int[] A) {
            int index = 0;
            for (int i = 0, j = A.length; i < j; ++i) {
                if (A[i] % 2 == 0) {
                    int temp = A[index];
                    A[index] = A[i];
                    A[i] = temp;
                    index++;
                }
            }
            return A;
        }
    }
}
