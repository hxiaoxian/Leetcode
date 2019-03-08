package list.easy;

import list.ListNode;

/**
 * Created by Hxg
 * Date: 2019/3/6
 * Time: 20:53
 * Version 1.0
 * Description : LeetCode
 */
public class leetcode21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode now = new ListNode(0); //头结点
        ListNode curr = now;
        while (l1 != null && l2 != null) {
            ListNode next = null;
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if (l1 == null)
            curr.next = l2;
        else
            curr.next = l1;
        return now.next;
    }

    //大佬的递归法
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l2.next, l1);
            return l2;
        }
    }
}
