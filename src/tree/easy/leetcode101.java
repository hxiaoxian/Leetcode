package tree.easy;

import tree.TreeNode;

/**
 * Created by Hxg
 * Date: 2019/5/9
 * Time: 23:19
 * Version 1.0
 * Description : LeetCode
 */
public class leetcode101 {
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null)
                return true;
            return helper(root.left, root.right);
        }

        public boolean helper(TreeNode node1, TreeNode node2) {
            if (node1 == null || node2 == null)
                return node1 == node2;
            if (node1.val != node2.val)
                return false;
            return helper(node1.left, node2.right) && helper(node1.right, node2.left);
        }

    }
}
