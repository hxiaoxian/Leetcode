package tree.medium;

import tree.TreeNode;

/**
 * Created by Hxg
 * Date: 2019/4/28
 * Time: 22:57
 * Version 1.0
 * Description : LeetCode
 */
public class leetcode98 {
    //递归使用上下界
    class Solution {
        public boolean isValidBST(TreeNode root) {
            return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        public boolean isValid(TreeNode root, long min, long max) {
            if (root == null)
                return true;
            if (root.val <= min || root.val >= max)
                return false;
            return isValid(root.left, min, root.val) &&
                    isValid(root.right, root.val, max);
        }
    }


    // 中序遍历这棵树，并保存前驱节点至prev中
    class Solution2 {
        TreeNode prev = null;

        public boolean isValidBST(TreeNode root) {
            if (root != null) {
                if (!isValidBST(root.left)) {
                    return false;
                }
                if (prev != null && prev.val >= root.val) {
                    return false;
                }
                prev = root;
                return isValidBST(root.right);
            }
            return true;
        }
    }
}
