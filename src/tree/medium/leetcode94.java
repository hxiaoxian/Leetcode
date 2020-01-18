package tree.medium;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的中序遍历。
 */
public class leetcode94 {
    // 递归
    class Solution {
        List<Integer> list = new ArrayList<>();

        public List<Integer> inorderTraversal(TreeNode root) {
            if (root == null)
                return list;
            if (root.left != null)
                inorderTraversal(root.left);
            list.add(root.val);
            if (root.right != null)
                inorderTraversal(root.right);
            return list;
        }
    }

    // 非递归
    class Solution1 {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            while (root != null || !stack.isEmpty()) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }
            return list;
        }
    }


}
