package tree.medium;

import tree.TreeNode;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 假设一个二叉搜索树具有如下特征：
 * <p>
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 * 输入:
 * 2
 * / \
 * 1   3
 * 输出: true
 * <p>
 * 示例 2:
 * 输入:
 * 5
 * / \
 * 1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 */
public class leetcode98 {
    //递归使用上下界
    class Solution {
        public boolean isValidBST(TreeNode root) {
            return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        private boolean isValid(TreeNode root, long min, long max) {
            if (root == null)
                return true;
            if (root.val <= min || root.val >= max)
                return false;
            return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
        }
    }


    // 中序遍历这棵树，并保存前驱节点至prev中
    class Solution2 {
        TreeNode prev = null;

        public boolean isValidBST(TreeNode root) {
            if (root == null)
                return true;
            if (root.left != null) {
                boolean flag = isValidBST(root.left);
                if (!flag)
                    return false;
            }
            if (prev != null && prev.val >= root.val)
                return false;
            prev = root;
            if (root.right != null)
                return isValidBST(root.right);
            return true;
        }
    }
}
