package stack.easy;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
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


    //大佬解法
    class Solution1 {
        public boolean IsValid(String s) {
            Stack<Character> stack = new Stack<>();
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

    class Solution2 {
        public boolean isValid(String s) {
            if (s.length() == 0)
                return true;
            Stack<Character> left = new Stack<>();
            for (Character c : s.toCharArray()) {
                if (c == '(' || c == '[' || c == '{')
                    left.push(c);
                else if (!left.empty() && leftOf(c) == left.peek())
                    left.pop();
                else
                    return false;
            }
            return left.empty();
        }

        Character leftOf(Character c) {
            if (c == '}')
                return '{';
            if (c == ')')
                return '(';
            return '[';
        }
    }
}
