package edu.xyf.codetop;

import edu.xyf.codetop.struct.ListNode;

import java.util.PriorityQueue;

/**
 * @Author: Xuyifeng
 * @Description: 合并 K 个升序链表
 * @Date: 2026/4/16 09:47
 */

public class Q26Leetcode23 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (a, b) -> (a.val - b.val));
        for (ListNode head : lists) {
            if (head != null) {
                pq.offer(head);
            }
        }

        while (!pq.isEmpty()) {
            ListNode listNode = pq.poll();
            if (listNode.next != null) {
                pq.offer(listNode.next);
            }
            cur.next = listNode;
            cur = cur.next;
        }
        return dummy.next;
    }

}
