package tree.easy;

import tree.TreeNode;

/**
 * Created by Hxg
 * Date: 2019/5/6
 * Time: 19:58
 * Version 1.0
 * Description : LeetCode
 */
public class leetcode938 {
    class Solution {
        public int rangeSumBST(TreeNode root, int L, int R) {
            if (root == null)
                return 0;
            if (root.val < L)
                return rangeSumBST(root.right, L, R);
            if (root.val > R)
                return rangeSumBST(root.left, L, R);
            return root.val + rangeSumBST(root.right, L, R) + rangeSumBST(root.left, L, R);
        }
    }
}
