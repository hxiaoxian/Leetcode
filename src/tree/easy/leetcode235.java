package tree.easy;

import tree.TreeNode;

/**
 * Created by Hxg
 * Date: 2019/4/28
 * Time: 22:48
 * Version 1.0
 * Description : LeetCode
 */
public class leetcode235 {
    //利用二叉搜索树的性质进行递归
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root.val < p.val && root.val < q.val) {
                return lowestCommonAncestor(root.right, p, q);
            }
            if (root.val > p.val && root.val > q.val) {
                return lowestCommonAncestor(root.left, p, q);
            }
            return root;
        }
    }
}
