package tree.medium;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hxg
 * Date: 2019/7/7
 * Time: 15:07
 * Version 1.0
 * Description : LeetCode
 */
public class leetcode94 {
    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            helper(root, res);
            return res;
        }

        public void helper(TreeNode root, List<Integer> res) {
            if (root != null) {
                if (root.left != null) {
                    helper(root.left, res);
                }
                res.add(root.val);
                if (root.right != null) {
                    helper(root.right, res);
                }
            }
        }

    }
}
