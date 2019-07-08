package array.easy;

import java.util.Arrays;

/**
 * Created by Hxg
 * Date: 2019/7/7
 * Time: 16:39
 * Version 1.0
 * Description : LeetCode
 */
public class leetcode977 {
    class Solution {
        public int[] sortedSquares(int[] A) {
            for (int i = 0, j = A.length; i < j; ++i) {
                A[i] = A[i] * A[i];
            }
            Arrays.sort(A);
            return A;
        }
    }
}

