package tree.easy;

import tree.TreeNode;


/**
 * Created by Hxg
 * Date: 2019/3/3
 * Time: 21:24
 * Version 1.0
 * Description : LeetCode
 */
public class leetcode700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null)
            return root;
        if (root.val == val)
            return root;
        return root.val < val ? searchBST(root.right, val) : searchBST(root.left, val);

    }
}
