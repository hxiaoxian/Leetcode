package string.easy;

/**
 * Created by Hxg
 * Date: 2019/7/10
 * Time: 14:53
 * Version 1.0
 * Description : LeetCode
 */
public class leetcode771 {
    class Solution {
        public int numJewelsInStones(String J, String S) {
            int j = J.length();
            int s = S.length();
            if (J == null || S == null || j == 0 || s == 0)
                return 0;
            int count = 0;
            for (char c : S.toCharArray()) {
                if (J.indexOf(c) != -1) {
                    count++;
                }
            }
            return count;
        }
    }
}
