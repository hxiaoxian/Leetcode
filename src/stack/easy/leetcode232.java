package stack.easy;

import java.util.Stack;

/**
 * Created by Hxg
 * Date: 2019/4/21
 * Time: 20:54
 * Version 1.0
 * Description : LeetCode
 */
public class leetcode232 {
    class MyQueue {

        Stack<Integer> inStack = new Stack<>();
        Stack<Integer> outStack = new Stack<>();

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {

        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            while (!outStack.isEmpty()) {
                inStack.push(outStack.pop());
            }
            inStack.push(x);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
            return outStack.pop();
        }

        /**
         * Get the front element.
         */
        public int peek() {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
            return outStack.peek();
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return inStack.isEmpty() && outStack.isEmpty();
        }
    }

}
