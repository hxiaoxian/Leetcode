package algorithm.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hxg
 * Date: 2019/5/1
 * Time: 14:53
 * Version 1.0
 * Description : LeetCode
 */
public class leetcode22 {
    // 递归 O(2^2N) 全局搜索
    // Runtime: 1 ms, faster than 96.44% of Java online submissions for Generate Parentheses.
    // Memory Usage: 38.1 MB, less than 28.24% of Java online submissions for Generate Parentheses.
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> list = new ArrayList<>();
            generateAll(new char[2 * n], 0, list);
            return list;
        }

        public void generateAll(char[] current, int pos, List<String> list) {
            if (pos == current.length) {
                if (valid(current))
                    list.add(new String(current));
            } else {
                current[pos] = '(';
                generateAll(current, pos + 1, list);
                current[pos] = ')';
                generateAll(current, pos + 1, list);
            }
        }

        public boolean valid(char[] current) {
            int balance = 0;
            for (char c : current) {
                if (c == '(') {
                    balance++;
                } else {
                    balance--;
                }
                if (balance < 0)
                    return false;
            }
            return balance == 0;
        }
    }

    // 在上面基础上加上剪枝 局部不合法即不再递归，O(2^N)，使用left_used、right_used
    // Runtime: 1 ms, faster than 96.44% of Java online submissions for Generate Parentheses.
    // Memory Usage: 37.8 MB, less than 79.07% of Java online submissions for Generate Parentheses.
    class Solution2 {
        public List<String> generateParenthesis(int n) {
            List<String> list = new ArrayList<>();
            generateOne("", list, n, n);
            return list;
        }

        public void generateOne(String s, List<String> list, int left, int right) {
            if (left == 0 && right == 0) {
                list.add(s);
                return;
            }
            if (left > 0) {
                generateOne(s + "(", list, left - 1, right);
            }
            if (right > left) {
                generateOne(s + ")", list, left, right - 1);
            }
        }
    }
    // 同2
    // Runtime: 1 ms, faster than 96.44% of Java online submissions for Generate Parentheses.
    // Memory Usage: 38 MB, less than 34.22% of Java online submissions for Generate Parentheses.
    class Solution3 {
        private List<String> list = new ArrayList<>();

        public List<String> generateParenthesis(int n) {
            generateOne(0, 0, n, "");
            return list;
        }

        public void generateOne(int left, int right, int n, String s) {
            if (left == n && right == n) {
                list.add(s);
                return;
            }
            if (left < n) {
                generateOne(left + 1, right, n, s + "(");
            }
            if (left > right && right < n) {
                generateOne(left, right + 1, n, s + ")");
            }
        }
    }

}
