package tree.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 */
public class leetcode429 {
    // 先序版本 DFS
    class Solution {
        List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> levelOrder(Node root) {
            if (root == null)
                return result;
            help(root, 0);
            return result;
        }

        private void help(Node root, int level) {
            if (level == result.size()) {
                result.add(new ArrayList<>());
            }
            result.get(level).add(root.val);
            if (root.children != null) {
                for (Node node : root.children) {
                    help(node, level + 1);
                }
            }
        }

    }
}


class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};