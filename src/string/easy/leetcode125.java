package string.easy;

/**
 * Created by Hxg
 * Date: 2019/7/11
 * Time: 14:40
 * Version 1.0
 * Description : LeetCode
 */
public class leetcode125 {
    class Solution {
        public boolean isPalindrome(String s) {
            if (s == null || s.length() == 0 || s.length() == 1)
                return true;
            int left = 0;
            int right = s.length() - 1;
            s = s.toLowerCase();
            while (left < right) {
                if (!Character.isLetterOrDigit(s.charAt(left))) {
                    left++;
                } else if (!Character.isLetterOrDigit(s.charAt(right))) {
                    right--;
                } else if (s.charAt(left) != s.charAt(right)) {
                    return false;
                } else {
                    left++;
                    right--;
                }
            }
            return true;
        }
    }
}
