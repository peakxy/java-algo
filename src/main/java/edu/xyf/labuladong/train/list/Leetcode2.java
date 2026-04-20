package edu.xyf.labuladong.train.list;

import edu.xyf.codetop.struct.ListNode;

/**
 * @Author: Xuyifeng
 * @Description: 两数相加
 * @Date: 2026/4/18 16:50
 */

public class Leetcode2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1, null);
        ListNode cur = dummyHead;
        int carry = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            cur = cur.next = new ListNode(carry % 10);
            carry /= 10;
        }
        if (carry != 0) {
            cur.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

}
