package tree.easy;

import tree.TreeNode;

/**
 * Created by Hxg
 * Date: 2019/3/3
 * Time: 17:20
 * Version 1.0
 * Description : LeetCode
 */
public class leetcode617 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;

    }
}
