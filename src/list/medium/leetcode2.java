package list.medium;

import list.ListNode;

/**
 * Created by Hxg
 * Date: 2019/7/7
 * Time: 14:39
 * Version 1.0
 * Description : LeetCode
 */
public class leetcode2 {
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode now = new ListNode(0); //头结点
            ListNode d = now;
            int sum = 0;
            while (l1 != null || l2 != null) {
                sum /= 10;
                if (l1 != null) {
                    sum += l1.val;
                    l1 = l1.next;
                }
                if (l2 != null) {
                    sum += l2.val;
                    l2 = l2.next;
                }
                ListNode temp = new ListNode(sum % 10);
                d.next = temp;
                d = d.next;
            }
            if (sum / 10 == 1)
                d.next = new ListNode(1);
            return now.next;
        }
    }

}
