package tree.easy;

import tree.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Created by Hxg
 * Date: 2019/3/3
 * Time: 22:41
 * Version 1.0
 * Description : LeetCode
 */
public class leetcode589 {
    List<Integer> list = new ArrayList<>();

    public List<Integer> preorder(Node root) {

        if (root == null)
            return list;
        list.add(root.val);
        for (Node node : root.children) {
            preorder(node);
        }
        return list;
    }
}


