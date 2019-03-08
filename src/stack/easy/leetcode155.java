package stack.easy;

import java.util.Stack;

/**
 * Created by Hxg
 * Date: 2019/3/8
 * Time: 13:56
 * Version 1.0
 * Description : LeetCode
 */
public class leetcode155 {
    Stack<Integer> stack = new Stack<>();
    int min = Integer.MAX_VALUE;

    public void push(int x) {
        if (x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        if (stack.peek() == min) {
            stack.pop();
            min = stack.pop();
        } else {
            stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
