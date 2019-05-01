package tree.medium;

import tree.TreeNode;

/**
 * Created by Hxg
 * Date: 2019/4/28
 * Time: 22:46
 * Version 1.0
 * Description : LeetCode
 */
public class leetcode236 {
    //递归查找
    class Solution {
        TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            // 如果root为空则返回空，为p则返回p，为q则返回q
            if (root == null || root == p || root == q)
                return root;
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            return left == null ? right : right == null ? left : root;
        }
    }
}
