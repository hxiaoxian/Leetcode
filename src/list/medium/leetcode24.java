package list.medium;

import list.ListNode;

/**
 * Created by Hxg
 * Date: 2019/4/26
 * Time: 17:51
 * Version 1.0
 * Description : LeetCode
 */
public class leetcode24 {
    class Solution {
        public ListNode swapPairs(ListNode head) {
            ListNode node = head;
            ListNode parent = new ListNode(0);
            parent.next = head;
            head = parent;
            while (node != null && node.next != null) {
                ListNode temp = node.next;
                node.next = node.next.next;
                temp.next = node;
                parent.next = temp;
                parent = node;
                node = node.next;
            }
            return head.next;
        }
    }

    //大佬的递归法
    class Solution2 {
        public ListNode swapPairs(ListNode head) {
            if ((head == null) || (head.next == null))
                return head;
            ListNode n = head.next;
            head.next = swapPairs(head.next.next);
            n.next = head;
            return n;
        }
    }
}
