package tree.easy;

import tree.TreeNode;

/**
 * Created by Hxg
 * Date: 2019/7/7
 * Time: 15:59
 * Version 1.0
 * Description : LeetCode
 */
public class leetcode543 {
    class Solution {
        private int max;

        public int diameterOfBinaryTree(TreeNode root) {
            count(root);
            return max;
        }

        public int count(TreeNode root) {
            if (root == null)
                return 0;
            int left = count(root.left);
            int right = count(root.right);
            max = Math.max(max, left + right);
            return Math.max(left, right) + 1;
        }
    }
}
