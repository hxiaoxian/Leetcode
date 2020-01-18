package tree.medium;

import tree.TreeNode;

/**
 * 解法：递归
 * 临界条件：最近公共祖先为根节点
 *      根节点是空节点
 *      根节点是q节点
 *      根节点是p节点
 * 根据临界条件
 *  此题相当于查找以 root 为根节点的树上是否有p节点或者q节点
 *      有，返回p节点或q节点
 *      无，返回null
 * 求解
 *  从左右子树分别进行递归，即查找左右子树上是否有p节点或者q节点
 *      左右子树均无p节点或q节点
 *      左子树找到，右子树没有找到，返回左子树的查找结果
 *      右子树找到，左子树没有找到，返回右子树的查找结果
 *      左、右子树均能找到
 *          说明此时的p节点和q节点在当前root节点两侧，返回root节点
 *
 */
public class leetcode236 {
    //递归查找
    class Solution {
        TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || root == p || root == q)
                return root;
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if (left != null && right != null)
                return root;
            if (left != null)
                return left;
            if (right != null)
                return right;
            return null;
        }
    }
}
