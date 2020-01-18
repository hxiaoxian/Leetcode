package tree.easy;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 */
public class leetcode257 {
    class Solution {
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> result = new ArrayList<>();
            if (root == null)
                return result;
            help(result, "", root);
            return result;
        }

        private void help(List<String> result, String str, TreeNode root) {
            if (root == null)
                return;
            if (root.left == null && root.right == null) {
                result.add(str + root.val);
                return;
            } else {
                if (root.left != null)
                    help(result, str + root.val + "->", root.left);
                if (root.right != null)
                    help(result, str + root.val + "->", root.right);
            }
        }
    }

}
