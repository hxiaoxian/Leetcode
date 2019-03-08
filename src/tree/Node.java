package tree;

import java.util.List;

/**
 * Created by Hxg
 * Date: 2019/3/3
 * Time: 22:41
 * Version 1.0
 * Description : LeetCode
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;

    }

}
