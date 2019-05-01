package string.easy;

/**
 * Created by Hxg
 * Date: 2019/4/21
 * Time: 21:25
 * Version 1.0
 * Description : LeetCode
 */
public class leetcode844 {
    class Solution {
        public boolean backspaceCompare(String S, String T) {
            return buildString(S).equals(buildString(T));
        }

        private String buildString(String str) {
            StringBuilder sb = new StringBuilder();
            for (char ch : str.toCharArray()) {
                if (ch != '#') {
                    sb.append(ch);
                } else if (sb.length() != 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            }

            return sb.toString();
        }
    }

}
