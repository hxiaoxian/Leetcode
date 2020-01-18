package tree.easy;

import tree.TreeNode;

/**
 * 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。
 * 这条路径可以经过也可以不经过根节点。
 * <p>
 * 注意：两个节点之间的路径长度由它们之间的边数表示。
 * 示例 1:
 * 输入:
 * <p>
 * 5
 * / \
 * 4   5
 * / \   \
 * 1   1   5
 * 输出:
 * 2
 * <p>
 * 示例 2:
 * 输入:
 * <p>
 * 1
 * / \
 * 4   5
 * / \   \
 * 4   4   5
 * 输出:
 * 2
 */
public class leetcode687 {
    class Solution {
        int res = 0;

        public int longestUnivaluePath(TreeNode root) {
            help(root);
            return res;
        }

        private int help(TreeNode root) {
            if (root == null)
                return 0;
            int left = help(root.left);
            int right = help(root.right);
            left = (root.left != null && root.left.val == root.val) ? left + 1 : 0;
            right = (root.right != null && root.right.val == root.val) ? right + 1 : 0;
            res = Math.max(res, left + right);
            return Math.max(left, right);
        }
    }
}
