package tree.easy;

import tree.TreeNode;

/**
 *给定一个二叉树，计算整个树的坡度。
 *
 * 一个树的节点的坡度定义即为，该节点左子树的结点之和和右子树结点之和的差的绝对值。空结点的的坡度是0。
 *
 * 整个树的坡度就是其所有节点的坡度之和。
 *
 * 示例:
 *
 * 输入:
 *          1
 *        /   \
 *       2     3
 * 输出: 1
 * 解释:
 * 结点的坡度 2 : 0
 * 结点的坡度 3 : 0
 * 结点的坡度 1 : |2-3| = 1
 * 树的坡度 : 0 + 0 + 1 = 1
 *
 */
public class leetcode563 {
    class Solution {
        private int result;

        public int findTilt(TreeNode root) {
            help(root);
            return result;
        }

        private int help(TreeNode root) {
            if (root == null)
                return 0;
            int left = help(root.left);
            int right = help(root.right);
            result += Math.abs(left - right);
            return root.val + left + right;
        }
    }
}
