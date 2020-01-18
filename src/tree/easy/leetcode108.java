package tree.easy;

import tree.TreeNode;

/**
 *将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 */
public class leetcode108 {
    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            if (nums == null || nums.length <= 0)
                return null;
            return help(nums, 0, nums.length - 1);
        }

        private TreeNode help(int[] nums, int start, int end) {
            if (start > end)
                return null;
            int min = (start + end) >> 1;
            TreeNode root = new TreeNode(nums[min]);
            root.left = help(nums, start, min - 1);
            root.right = help(nums, min + 1, end);
            return root;
        }
    }
}
