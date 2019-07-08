package tree.easy;

import tree.TreeNode;

/**
 * Created by Hxg
 * Date: 2019/7/7
 * Time: 15:29
 * Version 1.0
 * Description : LeetCode
 */
public class leetcode538 {
    class Solution {
        private int sum = 0;

        public TreeNode convertBST(TreeNode root) {
            if (root != null) {
                convertBST(root.right);
                sum += root.val;
                root.val = sum;
                convertBST(root.left);
            }
            return root;
        }
    }
}
