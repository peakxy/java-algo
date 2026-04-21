package edu.xyf.labuladong.train.list;

import edu.xyf.codetop.struct.ListNode;

/**
 * @Author: Xuyifeng
 * @Description: 两两交换链表中的节点
 * @Date: 2026/4/20 22:12
 */

public class Leetcode24 {

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode node0 = dummy;
        ListNode node1 = dummy.next;
        while (node1 != null && node1.next != null) {
            ListNode node2 = node1.next;
            ListNode node3 = node2.next;

            node0.next = node2; // 0 -> 2
            node2.next = node1; // 2 -> 1
            node1.next = node3; // 1 -> 3

            node0 = node1; // 下一轮交换，0 是 1
            node1 = node3; // 下一轮交换，1 是 3
        }
        return dummy.next;
    }

}
