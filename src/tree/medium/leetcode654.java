package tree.medium;

import tree.TreeNode;

/**
 * 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
 * <p>
 * 二叉树的根是数组中的最大元素。
 * 左子树是通过数组中最大值左边部分构造出的最大二叉树。
 * 右子树是通过数组中最大值右边部分构造出的最大二叉树。
 * 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
 */
public class leetcode654 {
    class Solution {
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            if (nums.length == 0 || nums == null)
                return null;
            return help(nums, 0, nums.length - 1);
        }

        private TreeNode help(int[] nums, int l, int r) {
            if (l > r)
                return null;
            int index = index(nums, l, r);
            TreeNode root = new TreeNode(nums[index]);
            root.left = help(nums, l, index - 1);
            root.right = help(nums, index + 1, r);
            return root;
        }

        private int index(int[] nums, int left, int right) {
            int max = Integer.MIN_VALUE;
            int result = 0;
            for (int i = left; i <= right; i++) {
                if (nums[i] > max) {
                    result = i;
                    max = nums[i];
                }
            }
            return result;
        }
    }
}
