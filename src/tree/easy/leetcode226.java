package tree.easy;

import tree.TreeNode;

/**
 * Created by Hxg
 * Date: 2019/5/6
 * Time: 20:55
 * Version 1.0
 * Description : LeetCode
 */
public class leetcode226 {
    class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null)
                return root;
            TreeNode temp = root.left;
            root.left = invertTree(root.right);
            root.right = invertTree(temp);
            return root;
        }
    }
}
