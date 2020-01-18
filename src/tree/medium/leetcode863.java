package tree.medium;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。
 *
 * 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。
 *
 *  
 *
 */
public class leetcode863 {
    class Solution {
        List<Integer> ans;
        TreeNode target;
        int K;

        public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
            ans = new ArrayList<>();
            this.target = target;
            this.K = K;
            dfs(root);
            return ans;
        }

        private int dfs(TreeNode root) {
            if (root == null)
                return -1;
            else if (root == target) {
                help(root, 0);
                return 1;
            } else {
                int l = dfs(root.left);
                int r = dfs(root.right);
                if (l != -1) {
                    if (l == K)
                        ans.add(root.val);
                    help(root.right, l + 1);
                    return l + 1;
                } else if (r != -1) {
                    if (r == K)
                        ans.add(root.val);
                    help(root.left, r + 1);
                    return r + 1;
                } else {
                    return -1;
                }
            }
        }

        public void help(TreeNode node, int dist) {
            if (node == null)
                return;
            if (dist == K)
                ans.add(node.val);
            else {
                help(node.left, dist + 1);
                help(node.right, dist + 1);
            }
        }
    }

}
