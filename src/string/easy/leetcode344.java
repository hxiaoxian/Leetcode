package string.easy;

/**
 * Created by Hxg
 * Date: 2019/7/9
 * Time: 9:31
 * Version 1.0
 * Description : LeetCode
 */
public class leetcode344 {
     class Solution {
        public  String reverseString(String s) {
            char[] ch = s.toCharArray();
            int halfLength = s.length() / 2;
            char temp;
            for (int i = 0; i < halfLength; i++) {
                temp = ch[s.length() - 1 - i];
                ch[s.length() - 1 - i] = ch[i];
                ch[i] = temp;
            }
            return new String(ch);
        }
    }
}
