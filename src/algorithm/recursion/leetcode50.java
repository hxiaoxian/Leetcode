package algorithm.recursion;

/**
 * Created by Hxg
 * Date: 2019/4/29
 * Time: 0:07
 * Version 1.0
 * Description : LeetCode
 */
public class leetcode50 {

    //调用函数 O(1)
    class Solution {
        public double myPow(double x, int n) {
            return Math.pow(x, n);
        }
    }

    //暴力，Time Limit Exceeded
    class Solution2 {
        public double myPow(double x, int n) {
            if (n == 0)
                return 1;
            double sum = x;
            if (n < 0) {
                for (int i = 1; i < -n; i++) {
                    sum = sum * x;
                }
                return 1 / sum;
            }
            for (int i = 1; i < n; i++) {
                sum = sum * x;
            }
            return sum;
        }
    }

    //递归分治 O(logN)
    class Solution3 {
        public double pow(double x, int n) {
            if (n == 0)
                return 1;
            if (n < 0) {
                n = -n;
                x = 1 / x;
            }
            return (n % 2 == 1) ? x * pow(x * x, n / 2) : pow(x * x, n / 2);
        }
    }

    //位运算 + 循环
    class Solution4 {
        public double pow(double x, int n) {
            if (n == 0)
                return 1;
            if (n < 0) {
                n = -n;
                x = 1 / x;
            }
            double sum = 1;
            while (n > 0) {
                if ((n & 1) == 1)
                    sum *= x;
                x *= x;
                n >>= 1;
            }
            return sum;
        }
    }
}
