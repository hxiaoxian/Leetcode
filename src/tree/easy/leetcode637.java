package tree.easy;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *给定一个非空二叉树, 返回一个由每层节点平均值组成的数组.
 *
 * 示例 1:
 *
 * 输入:
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 输出: [3, 14.5, 11]
 * 解释:
 * 第0层的平均值是 3,  第1层是 14.5, 第2层是 11. 因此返回 [3, 14.5, 11].
 * 注意：
 *
 * 节点值的范围在32位有符号整数范围内。
 */
public class leetcode637 {
    class Solution {
        public List<Double> averageOfLevels(TreeNode root) {
            List<Double> result = new ArrayList<>();
            if (root == null)
                return new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            Double s;
            int num;
            while (!queue.isEmpty()) {
                int count = queue.size();
                num = count;
                s = 0.0;
                while (count-- > 0) {
                    TreeNode t = queue.poll();
                    s += t.val;
                    if (t.left != null)
                        queue.add(t.left);
                    if (t.right != null)
                        queue.add(t.right);
                }
                result.add(s / num);
            }
            return result;
        }
    }

}
