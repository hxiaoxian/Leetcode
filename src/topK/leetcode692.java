package topK;

import java.util.*;

/**
 * Created by Hxg
 * Date: 2019/7/14
 * Time: 20:16
 * Version 1.0
 * Description : LeetCode
 */
public class leetcode692 {
    class Solution {
        public List<String> topKFrequent(String[] words, int k) {
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0, j = words.length; i < j; i++) {
                map.put(words[i], map.getOrDefault(words[i], 0) + 1);
            }
            PriorityQueue<String> queue = new PriorityQueue<>(new Comparator<String>() {
                @Override
                public int compare(String str1, String str2) {
                    if (map.get(str1) == map.get(str2)) {
                        return str1.compareTo(str2);
                    }
                    return map.get(str2) - map.get(str1);
                }
            });
            queue.addAll(map.keySet());
            List<String> list = new ArrayList<>();
            while (k-- > 0) {
                list.add(queue.poll());
            }
            return list;
        }
    }
}
