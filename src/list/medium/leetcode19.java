package list.medium;

import list.ListNode;

/**
 * Created by Hxg
 * Date: 2019/3/6
 * Time: 23:18
 * Version 1.0
 * Description : LeetCode
 */
public class leetcode19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode h1 = head, h2 = head;
        while (n-- > 0)
            h2 = h2.next;
        if (h2 == null)
            return head.next;
        h2 = h2.next;
        while (h2 != null) {
            h1 = h1.next;
            h2 = h2.next;
        }
        h1.next = h1.next.next;
        return head;
    }

    //大佬解法
    public ListNode removeNthFromEnd2(ListNode head, int n) {

        ListNode start = new ListNode(0);
        ListNode slow = start, fast = start;
        slow.next = head;

        //Move fast in front so that the gap between slow and fast becomes n
        for (int i = 1; i <= n + 1; i++) {
            fast = fast.next;
        }
        //Move fast to the end, maintaining the gap
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        //Skip the desired node
        slow.next = slow.next.next;
        return start.next;
    }
}
