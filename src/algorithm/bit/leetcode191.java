package algorithm.bit;

/**
 * Created by Hxg
 * Date: 2019/5/13
 * Time: 23:03
 * Version 1.0
 * Description : LeetCode
 */
public class leetcode191 {
    public class Solution {
        // 思路是利用位运算，首先需要判断是否是负数，如果是则将其右移1位变成首位为0
        // 常用位运算：
        //             x & x-1             得到最低位的1
        //             x = x & (x-1)       清零最低位的1
        //             x & 1 == 1 OR == 0  判断奇偶(x % 2 ==1)
        public int hammingWeight(int n) {
            int count = 0;
            if ((n & 1) == 1)
                count++;
            n = n >>> 1;
            while (n > 0) {
                n = n & (n - 1);
                count++;
            }
            return count;
        }
    }
}
