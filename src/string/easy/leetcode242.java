package string.easy;

import java.util.Arrays;

/**
 * Created by Hxg
 * Date: 2019/4/27
 * Time: 12:47
 * Version 1.0
 * Description : LeetCode
 */
public class leetcode242 {
    //利用排序
    class Solution {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length())
                return false;
            char[] one = s.toCharArray();
            char[] two = t.toCharArray();
            Arrays.sort(one);
            Arrays.sort(two);
            return Arrays.equals(one, two);
        }
    }

    //利用数组hash计数
    class Solution2 {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length())
                return false;
            int[] num = new int[26];
            for (int i = 0; i < s.length(); i++) {
                num[s.charAt(i) - 'a']++;
            }
            for (int i = 0; i < t.length(); i++) {
                num[t.charAt(i) - 'a']--;
            }
            for (int i : num) {
                if (i != 0) {
                    return false;
                }
            }
            return true;
        }
    }

}
