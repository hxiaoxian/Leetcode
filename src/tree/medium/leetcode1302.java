package tree.medium;

import tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你一棵二叉树，请你返回层数最深的叶子节点的和。
 */
public class leetcode1302 {
    class Solution {
        public int deepestLeavesSum(TreeNode root) {
            int result = 0;
            int sum = 0;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                sum = 0;
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    sum += node.val;
                    if (node.left != null)
                        queue.add(node.left);
                    if (node.right != null)
                        queue.add(node.right);
                }
                result = sum;
            }
            return result;
        }
    }
}
