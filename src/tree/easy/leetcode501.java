package tree.easy;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 *
 * 假定 BST 有如下定义：
 *
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 * 例如：
 * 给定 BST [1,null,2,2],
 *
 *    1
 *     \
 *      2
 *     /
 *    2
 * 返回[2].
 *
 * 提示：如果众数超过1个，不需考虑输出顺序
 *
 * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
 */
public class leetcode501 {
    class Solution {
        private int pre;
        private int count;
        private int max;

        public int[] findMode(TreeNode root) {
            if (root == null)
                return new int[0];
            List<Integer> list = new ArrayList<>();
            inOrder(root, list);
            int[] result = new int[list.size()];
            for (int i = 0; i < list.size(); i++)
                result[i] = list.get(i);
            return result;
        }

        private void inOrder(TreeNode root, List<Integer> list) {
            if (root == null)
                return;
            inOrder(root.left, list);
            if (pre == root.val)
                count++;
            else {
                pre = root.val;
                count = 1;
            }
            if (count >= max) {
                // 如果次数超最大则清空集合，否则直接添加出现最大次数相等的
                if (count > max)
                    list.clear();
                list.add(pre);
                max = count;
            }
            inOrder(root.right, list);
        }
    }
}
