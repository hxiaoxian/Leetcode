package tree.easy;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 请考虑一颗二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
 *
 *
 *
 * 举个例子，如上图所示，给定一颗叶值序列为 (6, 7, 4, 9, 8) 的树。
 *
 * 如果有两颗二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。
 *
 * 如果给定的两个头结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。
 *
 */
public class leetcode872 {
    class Solution {
        private void computeLeaves(TreeNode root, List<Integer> leaves) {
            if (root.left == null && root.right == null) {
                leaves.add(root.val);
            } else {
                if (root.left != null) {
                    computeLeaves(root.left, leaves);
                }
                if (root.right != null) {
                    computeLeaves(root.right, leaves);
                }
            }
        }

        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            List<Integer> list1 = new ArrayList<>();
            List<Integer> lsit2 = new ArrayList<>();
            computeLeaves(root1, list1);
            computeLeaves(root2, lsit2);
            return list1.equals(lsit2);
        }
    }
}

