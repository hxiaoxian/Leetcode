package tree.easy;

import tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最小深度  2.
 *
 */
public class leetcode111 {
    //DFS O(N)
    class Solution {
        public int minDepth(TreeNode root) {
            if (root == null)
                return 0;
            if (root.left == null && root.right == null)
                return 1;
            int left = minDepth(root.left);
            int right = minDepth(root.right);
            if (root.left == null || root.right == null)
                return left + right + 1;
            return Math.min(left, right) + 1;
        }
    }

    //BFS O(N)
    class Solution2 {
        public int minDepth(TreeNode root) {
            if (root == null)
                return 0;
            Queue<TreeNode> queue = new LinkedList<>();
            int depth = 1, size;
            queue.add(root);
            while (!queue.isEmpty()) {
                size = queue.size();
                while (size-- != 0) {
                    TreeNode node = queue.poll();
                    // 相比leetcode104求二叉树的最大深度，加多了叶子节点的判断
                    if (node.left == null && node.right == null) {
                        return depth;
                    }
                    if (node.left != null)
                        queue.add(node.left);
                    if (node.right != null)
                        queue.add(node.right);
                }
                depth++;
            }
            return depth;
        }
    }
}
