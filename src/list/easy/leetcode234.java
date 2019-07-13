package list.easy;

import list.ListNode;

/**
 * Created by Hxg
 * Date: 2019/7/11
 * Time: 9:30
 * Version 1.0
 * Description : LeetCode
 */
public class leetcode234 {
    class Solution {
        public boolean isPalindrome(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;
            ListNode temp = null;
            ListNode left = null;
            while (fast != null && fast.next != null) {
                temp = slow;
                slow = slow.next;
                fast = fast.next.next;
                temp.next = left;
                left = temp;
            }
            if (fast != null)
                slow = slow.next;
            while (left != null && slow != null) {
                if (left.val != slow.val)
                    return false;
                left = left.next;
                slow = slow.next;
            }
            return true;
        }
    }
}
