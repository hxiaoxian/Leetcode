package tree.medium;

import tree.TreeNode;

/**
 * Created by Hxg
 * Date: 2019/5/5
 * Time: 14:21
 * Version 1.0
 * Description : LeetCode
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
            pre = root.val = pre + root.val;
            if (root.left != null)
                bstToGst(root.left);
            return root;
        }
    }
}
