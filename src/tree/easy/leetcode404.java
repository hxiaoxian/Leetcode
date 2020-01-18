package tree.easy;

import tree.TreeNode;

/**
 *计算给定二叉树的所有左叶子之和。
 *
 * 示例：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 *
 */
public class leetcode404 {
    class Solution {
        private int sum;

        public int sumOfLeftLeaves(TreeNode root) {
            help(root, 1);
            return sum;
        }

        private void help(TreeNode root, int flag) {
            if (root == null)
                return;
            if (flag == 0 && root.left == null && root.right == null)
                sum += root.val;
            help(root.left, 0);
            help(root.right, 1);
        }
    }
}
