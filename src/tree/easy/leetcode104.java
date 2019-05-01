package tree.easy;

import tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Hxg
 * Date: 2019/4/30
 * Time: 14:59
 * Version 1.0
 * Description : LeetCode
 */
public class leetcode104 {

    //DFS+分治+递归 O(N)
    class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null)
                return 0;
            return 1 + Math.max(maxDepth(root.right), maxDepth(root.left));
        }
    }

    //DFS O(N)
    class Solution2 {
        public int maxDepth(TreeNode root) {
            if (root == null)
                return 0;
            int left = 0, right = 0;
            if (root.left != null)
                left = maxDepth(root.left);
            if (root.right != null)
                right = maxDepth(root.right);
            return Math.max(left, right) + 1;
        }
    }

    //DFS O(N)
    class Solution3 {
        public int maxDepth(TreeNode root) {
            if (root == null)
                return 0;
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left, right) + 1;
        }
    }

    //BFS O(N)
    class Solution4 {
        public int maxDepth(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            if (root == null)
                return 0;
            int depth = 0, level;
            queue.add(root);
            while (!queue.isEmpty()) {
                level = queue.size();
                while (level-- != 0) {
                    TreeNode node = queue.poll();
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
