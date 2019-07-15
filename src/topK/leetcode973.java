package topK;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Hxg
 * Date: 2019/7/14
 * Time: 21:48
 * Version 1.0
 * Description : LeetCode
 */
public class leetcode973 {
    class Solution {
        public int[][] kClosest(int[][] points, int k) {
            PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] p1, int[] p2) {
                    return p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1];
                }
            });
            for (int[] point : points) {
                queue.add(point);
            }
            int[][] result = new int[k][2];
            // You may return the answer in any order.
            while (k > 0) {
                result[--k] = queue.poll();
            }
            return result;
        }
    }

}
