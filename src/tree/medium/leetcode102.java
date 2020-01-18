package tree.medium;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 */
public class leetcode102 {

    // 大佬版 先序DFS
    class Solution3 {
        private List<List<Integer>> ret = new ArrayList<>();

        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null)
                return ret;
            help(root, 0);
            return ret;
        }

        private void help(TreeNode root, int level) {
            if (level == ret.size()) {
                ret.add(new ArrayList<>());
            }
            ret.get(level).add(root.val);
            if (root.left != null)
                help(root.left, level + 1);
            if (root.right != null)
                help(root.right, level + 1);
        }
    }

    //BFS
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> List = new ArrayList<>();
            if (root == null)
                return List;
            Queue<TreeNode> queue = new LinkedList<>();
            int level;
            queue.add(root);
            while (!queue.isEmpty()) {
                level = queue.size();
                List<Integer> list = new ArrayList<>();
                while (level-- != 0) {
                    TreeNode node = queue.poll();
                    if (node.left != null)
                        queue.add(node.left);
                    if (node.right != null)
                        queue.add(node.right);
                    list.add(node.val);
                }
                List.add(list);
            }
            return List;
        }
    }


    //DFS  先建一个空的数组，按列添加元素，而不是按行添加元素，不同于BFS
    class Solution2 {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> List = new ArrayList<>();
            if (root == null)
                return List;
            dfs(List, root, 0);
            return List;
        }

        private void dfs(List<List<Integer>> List, TreeNode root, int level) {
            if (root == null)
                return;
            List<Integer> list;
            if (level == List.size()) {
                list = new ArrayList<>();
                list.add(root.val);
                List.add(list);
            } else {
                list = List.get(level);
                list.add(root.val);
            }
            dfs(List, root.left, level + 1);
            dfs(List, root.right, level + 1);
        }
    }

}
