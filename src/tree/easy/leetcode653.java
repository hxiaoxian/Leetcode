package tree.easy;

import tree.TreeNode;

import java.util.HashSet;

/**
 *给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 *
 * 案例 1:
 * 输入:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 9
 * 输出: True
 *  
 *
 * 案例 2:
 * 输入:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 28
 * 输出: False
 *
 */
public class leetcode653 {
    // hashSet 空间O（N）
    class Solution {
        HashSet<Integer> set = new HashSet<>();

        public boolean findTarget(TreeNode root, int k) {
            return pre(root, k);
        }

        public boolean pre(TreeNode root, int k) {
            if (root == null)
                return false;
            if (set.contains(k - root.val))
                return true;
            set.add(root.val);
            return pre(root.left, k) || pre(root.right, k);
        }
    }
}
