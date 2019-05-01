package queue.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Hxg
 * Date: 2019/4/26
 * Time: 20:37
 * Version 1.0
 * Description : LeetCode
 */
public class leetcode225 {
    class MyStack {

        private Queue<Integer> queue = new LinkedList<>();

        /**
         * Initialize your data structure here.
         */
        public MyStack() {

        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            queue.add(x);
            for (int i = 1; i < queue.size(); i++) {
                queue.add(queue.remove());
            }
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            return queue.poll();
        }

        /**
         * Get the top element.
         */
        public int top() {
            return queue.element();
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return queue.isEmpty();
        }
    }

}
