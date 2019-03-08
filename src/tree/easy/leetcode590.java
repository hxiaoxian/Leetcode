package tree.easy;

import tree.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Created by Hxg
 * Date: 2019/3/4
 * Time: 20:58
 * Version 1.0
 * Description : LeetCode
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

    //大佬用栈以时间换内存
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
