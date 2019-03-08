package list.easy;

import list.ListNode;

/**
 * Created by Hxg
 * Date: 2019/3/6
 * Time: 21:07
 * Version 1.0
 * Description : LeetCode
 */
public class leetcode876 {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
