package tree.easy;

import tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 *给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * 说明:
 *
 * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 */
public class leetcode101 {

    // 递归
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null)
                return true;
            return helper(root.left, root.right);
        }

        public boolean helper(TreeNode node1, TreeNode node2) {
            if (node1 == null && node2 == null)
                return true;
            if (node1 == null || node2 == null)
                return false;
            if (node1.val != node2.val)
                return false;
            return helper(node1.left, node2.right) && helper(node1.right, node2.left);
        }
    }

    // 迭代
    class Solution1 {
        public boolean isSymmetric(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode node1 = queue.poll();
                TreeNode node2 = queue.poll();
                if (node1 == null && node2 == null)
                    continue;
                if (node1 == null || node2 == null)
                    return false;
                if (node1.val != node2.val)
                    return false;
                queue.add(node1.left);
                queue.add(node2.right);
                queue.add(node1.right);
                queue.add(node2.left);
            }
            return true;
        }
    }
}
