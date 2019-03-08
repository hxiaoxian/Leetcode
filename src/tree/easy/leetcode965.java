package tree.easy;

import tree.TreeNode;

/**
 * Created by Hxg
 * Date: 2019/3/3
 * Time: 21:13
 * Version 1.0
 * Description : LeetCode
 */
public class leetcode965 {
    public boolean isUnivalTree(TreeNode root) {
        if (root == null)
            return true;
        if (root.left != null && root.val != root.left.val)
            return false;
        if (root.right != null && root.val != root.right.val)
            return false;
        return isUnivalTree(root.left) && isUnivalTree(root.right);
    }
}
