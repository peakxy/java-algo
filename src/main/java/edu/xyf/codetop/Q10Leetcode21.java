package edu.xyf.codetop;

import edu.xyf.codetop.struct.ListNode;

/**
 * @Author: Xuyifeng
 * @Description: 合并两个有序链表
 * @Date: 2026/4/11 15:32
 */

public class Q10Leetcode21 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1, null);
        ListNode cur = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if (list1 != null) {
            cur.next = list1;
        }
        if (list2 != null) {
            cur.next = list2;
        }
        return dummy.next;
    }

}
