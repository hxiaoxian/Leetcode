package algorithm.dp;

/**
 * Created by Hxg
 * Date: 2019/9/11
 * Time: 21:43
 * Version 1.0
 * Description : LeetCode
 */
public class leetcode338 {
    class Solution {
        public int[] countBits(int num) {
            int[] result = new int[num + 1];
            result[0] = 0;
            int pow = 1;
            for (int i = 1, t = 0; i <= num; i++, t++) {
                // 2的n次幂
                if (i == pow) {
                    pow *= 2;
                    t = 0;
                }
                result[i] = result[t] + 1;
            }
            return result;
        }
    }
}
