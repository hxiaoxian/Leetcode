package stack.easy;

import java.util.Stack;

/**
 * Created by Hxg
 * Date: 2019/4/21
 * Time: 21:31
 * Version 1.0
 * Description : LeetCode
 */
public class leetcode844 {
    class Solution {
        public boolean backspaceCompare(String S, String T) {
            return buildString(S).equals(buildString(T));
        }

        private String buildString(String str) {
            Stack<Character> stack = new Stack<>();
            for (char ch : str.toCharArray()) {
                if (ch != '#') {
                    stack.push(ch);
                } else if (stack.size() != 0) {
                    stack.pop();
                }
            }

            return String.valueOf(stack);
        }
    }


}
