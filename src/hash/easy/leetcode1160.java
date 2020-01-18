package hash.easy;



import java.util.HashMap;

/**
 * Created by Hxg
 * Date: 2019/9/17
 * Time: 21:25
 * Version 1.0
 * Description : LeetCode
 */
//  Runtime: 27 ms, faster than 29.57% of Java online submissions for Find Words That Can Be Formed by Characters.
//  Memory Usage: 38.2 MB, less than 100.00% of Java online submissions for Find Words That Can Be Formed by Characters.
public class leetcode1160 {
    class Solution {
        public int countCharacters(String[] words, String chars) {
            HashMap<Character, Integer> map = new HashMap();
            int length = 0;
            for (Character c : chars.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            HashMap<Character, Integer> same;
            for (String str : words) {
                same = (HashMap<Character, Integer>) map.clone();
                Boolean flag = true;
                for (Character s : str.toCharArray()) {
                    if (same.get(s) == null || same.get(s) <= 0) {
                        flag = false;
                        break;
                    } else {
                        same.put(s, same.get(s) - 1);
                    }
                }
                if (flag) {
                    length += str.length();
                }
            }
            return length;
        }
    }

    // 大佬做法：字符串转数字
    // Runtime: 2 ms, faster than 100.00% of Java online submissions for Find Words That Can Be Formed by Characters.
    // Memory Usage: 38 MB, less than 100.00% of Java online submissions for Find Words That Can Be Formed by Characters.
    class Solution2 {
        public int countCharacters(String[] words, String chars) {
            int[] form = new int[26];
            for(char ch : chars.toCharArray())
                form[ch - 'a']++;
            int count = 0;
            for(String w : words)
                if(isFormed(w, form))
                    count += w.length();
            return count;
        }
        private boolean isFormed(String word, int[] form) {
            int[] usage = new int[26];
            for(char ch : word.toCharArray()) {
                usage[ch - 'a']++;
                if(usage[ch - 'a'] > form[ch - 'a'])
                    return false;
            }
            return true;
        }
    }


}
