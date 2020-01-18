package tree.medium;

import tree.TreeNode;

/**
 * 给出二叉搜索树的根节点，该二叉树的节点值各不相同，修改二叉树，使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
 * <p>
 * 提醒一下，二叉搜索树满足下列约束条件：
 * <p>
 * 节点的左子树仅包含键小于节点键的节点。
 * 节点的右子树仅包含键大于节点键的节点。
 * 左右子树也必须是二叉搜索树。
 */
public class leetcode1038 {
    class Solution {
        public TreeNode bstToGst(TreeNode root) {
            if (root == null)
                return null;
            getGst(root, 0);
            return root;
        }

        int getGst(TreeNode root, int acc) {
            if (root == null)
                return acc;
            int right = getGst(root.right, acc);
            root.val += right;
            int left = getGst(root.left, root.val);
            return left;
        }
    }

    //大佬版
    class Solution2 {
        int pre = 0;

        public TreeNode bstToGst(TreeNode root) {
            if (root.right != null)
                bstToGst(root.right);
            root.val = pre + root.val;
            pre = root.val;
            if (root.left != null)
                bstToGst(root.left);
            return root;
        }
    }
}
