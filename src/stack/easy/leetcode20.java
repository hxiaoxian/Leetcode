package stack.easy;

import java.util.Stack;

/**
 * Created by Hxg
 * Date: 2019/3/7
 * Time: 20:03
 * Version 1.0
 * Description : LeetCode
 */
public class leetcode20 {
    //用栈匹配
    class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<Character>();
            for (Character a : s.toCharArray()) {
                if (a == '(' || a == '[' || a == '{') {
                    stack.push(a);
                } else if (a == ')' || a == '}' || a == ']') {
                    if (stack.isEmpty())
                        return false;
                    Character b = stack.peek();
                    if ((a == ')' && b == '(') || (a == '}' && b == '{') || (a == ']' && b == '[')) {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
            if (stack.isEmpty())
                return true;
            return false;
        }
    }

    //时间过长
    class Solution2 {
        public boolean isValid(String s) {
            int length;
            do {
                length = s.length();
                s = s.replace("()", "").replace("{}", "").replace("[]", "");
            } while (length != s.length());
            return s.length() == 0;
        }
    }

    //大佬解法
    class Solution3 {
        public boolean IsValid(String s) {
            Stack<Character> stack = new Stack<Character>();
            for (char c : s.toCharArray()) {
                if (c == '(')
                    stack.push(')');
                else if (c == '{')
                    stack.push('}');
                else if (c == '[')
                    stack.push(']');
                else if (stack.isEmpty() || stack.pop() != c)
                    return false;
            }
            return stack.isEmpty();
        }
    }
}
