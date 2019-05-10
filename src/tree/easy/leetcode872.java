package tree.easy;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hxg
 * Date: 2019/5/6
 * Time: 20:47
 * Version 1.0
 * Description : LeetCode
 */
public class leetcode872 {
    public void computeLeaves(TreeNode root, List<Integer> leaves) {
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
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();
        computeLeaves(root1, leaves1);
        computeLeaves(root2, leaves2);
        if (leaves1.size() == leaves2.size()) {
            for (int i = 0; i < leaves1.size(); i++) {
                if (leaves1.get(i) != leaves2.get(i)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}

