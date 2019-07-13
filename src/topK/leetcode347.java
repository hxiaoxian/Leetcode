package topK;

import java.util.*;

/**
 * Created by Hxg
 * Date: 2019/7/13
 * Time: 14:41
 * Version 1.0
 * Description : LeetCode
 */
public class leetcode347 {
    class Solution {
        public List<Integer> topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0, j = nums.length; i < j; i++) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
            TreeMap<Integer, List<Integer>> treeMap = new TreeMap();
            for (int num : map.keySet()) {
                int key = map.get(num);
                if (!treeMap.containsKey(key)) {
                    treeMap.put(key, new ArrayList<>());
                }
                treeMap.get(key).add(num);
            }
            List<Integer> list = new ArrayList<>();
            while (list.size() < k) {
                Map.Entry<Integer, List<Integer>> entry = treeMap.pollLastEntry();
                list.addAll(entry.getValue());
            }
            return list;
        }
    }

}
