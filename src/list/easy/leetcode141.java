package list.easy;

import list.ListNode;

/**
 * Created by Hxg
 * Date: 2019/3/6
 * Time: 20:37
 * Version 1.0
 * Description : LeetCode
 */
public class leetcode141 {
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        ListNode p = head;
        ListNode q = head.next;
        while (head.next != null && q.next != null && q.next.next != null) {
            p = p.next;
            q = q.next.next;
            if (p == q)
                return true;
        }
        return false;
    }
}
