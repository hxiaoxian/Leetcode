package queue.easy;

import java.util.PriorityQueue;

/**
 * Created by Hxg
 * Date: 2019/4/26
 * Time: 21:30
 * Version 1.0
 * Description : LeetCode
 */
public class leetcode703 {
    class KthLargest {
        final PriorityQueue<Integer> queue;
        final int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            queue = new PriorityQueue<>(k);
            for (int num : nums) {
                add(num);
            }
        }

        public int add(int val) {
            if (queue.size() < k) {
                queue.offer(val);
            } else if (queue.peek() < val) {
                queue.poll();
                queue.offer(val);
            }
            return queue.peek();
        }
    }
}
