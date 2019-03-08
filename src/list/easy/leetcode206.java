package list.easy;

import list.ListNode;

/**
 * Created by Hxg
 * Date: 2019/3/6
 * Time: 19:52
 * Version 1.0
 * Description : LeetCode
 */
public class leetcode206 {
    public ListNode reverseList(ListNode head) {
        ListNode p = head;
        ListNode q = null;
        while(p != null){
            ListNode next = p.next;
            p.next = q;
            q = p;
            p = next;

        }
        return q;
    }
}
