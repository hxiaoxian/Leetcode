package tree.easy;

import tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Hxg
 * Date: 2019/4/30
 * Time: 16:15
 * Version 1.0
 * Description : LeetCode
 */
public class leetcode111 {
    //DFS O(N)
    class Solution {
        public int minDepth(TreeNode root) {
            if (root == null)
                return 0;
            int left = minDepth(root.left);
            int right = minDepth(root.right);
            return (left == 0 | right == 0) ? left + right + 1 : Math.min(left, right) + 1;
        }
    }

    //BFS O(N)
    class Solution2 {
        public int minDepth(TreeNode root) {
            if (root == null)
                return 0;
            Queue<TreeNode> queue = new LinkedList<>();
            int depth = 1, level;
            queue.add(root);
            while (!queue.isEmpty()) {
                level = queue.size();
                while (level-- != 0) {
                    TreeNode node = queue.poll();
                    // 相比leetcode104求二叉树的最大深度，加多了叶子节点的判断
                    if (node.left == null && node.right == null) {
                        return depth;
                    }
                    if (node.left != null)
                        queue.add(node.left);
                    if (node.right != null)
                        queue.add(node.right);
                }
                depth++;
            }
            return depth;
        }
    }
}
