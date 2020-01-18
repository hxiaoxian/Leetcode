package tree.easy;

import tree.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 *
 * 例如，给定一个 3叉树 :
 *
 *
 *
 *
 *
 *
 *
 * 返回其后序遍历: [5,6,3,2,4,1].
 */
public class leetcode590 {
    List<Integer> list = new ArrayList<>();

    class SolutionOne {
        public List<Integer> postorder(Node root) {
            if (root == null)
                return list;
            for (Node node : root.children)
                postorder(node);
            list.add(root.val);
            return list;

        }
    }

    //栈
    class SolutionTwo {
        public List<Integer> postorder(Node root) {
            List<Integer> list = new ArrayList<>();
            Stack<Node> stack = new Stack<>();
            if (root == null)
                return list;
            stack.add(root);
            while (!stack.isEmpty()) {
                root = stack.pop();
                list.add(root.val);
                for (Node node : root.children) {
                    stack.add(node);
                }
            }
            Collections.reverse(list);
            return list;
        }
    }
}
