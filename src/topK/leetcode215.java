package topK;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Hxg
 * Date: 2019/7/14
 * Time: 17:35
 * Version 1.0
 * Description : LeetCode
 */
public class leetcode215 {
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    if (o1 > o2)
                        return -1;
                    else if (o1 < o2)
                        return 1;
                    else
                        return 0;
                }
            });
            for (int num : nums) {
                queue.add(num);
            }
            while (k-- > 1) {
                queue.poll();
            }
            return queue.peek();
        }
    }
}
