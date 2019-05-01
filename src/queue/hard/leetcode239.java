package queue.hard;

import java.util.*;

/**
 * Created by Hxg
 * Date: 2019/4/26
 * Time: 22:39
 * Version 1.0
 * Description : LeetCode
 */
public class leetcode239 {
    //优先队列
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums == null || nums.length < k || k == 0)
                return new int[0];
            int[] res = new int[nums.length - k + 1];
            Queue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return Integer.compare(o2, o1);
                }
            });
            for (int i = 0; i < k; i++) {
                queue.add(nums[i]);
            }
            res[0] = queue.peek();
            //移除头元素并添加
            for (int i = k; i < nums.length; i++) {
                queue.remove(nums[i - k]);
                queue.add(nums[i]);
                res[i - k + 1] = queue.peek();
            }
            return res;
        }
    }


    //双端队列
    class Solution1 {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums == null || nums.length < k || k == 0)
                return new int[0];
            int[] res = new int[nums.length - k + 1];
            Deque<Integer> deque = new LinkedList<>();
            for (int i = 0; i < nums.length; i++) {
                //在尾部添加元素，并保证左边元素都比尾部大
                while (!deque.isEmpty() && nums[deque.getLast()] < nums[i]) {
                    deque.removeLast();
                }
                deque.addLast(i);
                //在头部移除元素
                if (deque.getFirst() == i - k) {
                    deque.removeFirst();
                }
                //输出结果
                if (i >= k - 1) {
                    res[i - k + 1] = nums[deque.getFirst()];
                }
            }
            return res;
        }
    }
}
