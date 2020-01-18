package tree.medium;

import tree.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 给出一个满足下述规则的二叉树：
 * <p>
 * root.val == 0
 * 如果 treeNode.val == x 且 treeNode.left != null，那么 treeNode.left.val == 2 * x + 1
 * 如果 treeNode.val == x 且 treeNode.right != null，那么 treeNode.right.val == 2 * x + 2
 * 现在这个二叉树受到「污染」，所有的 treeNode.val 都变成了 -1。
 * <p>
 * 请你先还原二叉树，然后实现 FindElements 类：
 * <p>
 * FindElements(TreeNode* root) 用受污染的二叉树初始化对象，你需要先把它还原。
 * bool find(int target) 判断目标值 target 是否存在于还原后的二叉树中并返回结果。
 */
public class leetcode1261 {
    class FindElements {
        Set<Integer> set = new HashSet<>();

        public FindElements(TreeNode root) {
            root.val = 0;
            set.add(root.val);
            help(root);
        }

        private void help(TreeNode root) {
            if (root.left == null && root.right == null)
                return;
            if (root.left != null) {
                root.left.val = root.val * 2 + 1;
                set.add(root.left.val);
            }
            if (root.right != null) {
                root.right.val = root.val * 2 + 2;
                set.add(root.right.val);
            }
            if (root.left != null)
                help(root.left);
            if (root.right != null)
                help(root.right);
        }

        public boolean find(int target) {
            return set.contains(target);
        }
    }
}
