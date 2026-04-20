package edu.xyf.codetop;

import edu.xyf.codetop.struct.ListNode;

/**
 * @Author: Xuyifeng
 * @Description: 删除排序链表中的重复元素2
 * @Date: 2026/4/18 14:34
 */

public class Q35Leetcode82 {

    public ListNode deleteDuplicates(ListNode head) {
        // 将原链表分解为两条链表
        // 一条链表存放不重复的节点，另一条链表存放重复的节点
        // 运用虚拟头结点技巧，题目说了 node.val <= 100，所以用 101 作为虚拟头结点
        ListNode dummyUniq = new ListNode(101);
        ListNode dummyDup = new ListNode(101);

        ListNode pUniq = dummyUniq, pDup = dummyDup;
        ListNode p = head;
        while (p != null) {
            if ((p.next != null && p.val == p.next.val) || p.val == pDup.val) {
                // 发现重复节点，接到重复链表后面
                pDup.next = p;
                pDup = pDup.next;
            } else {
                // 不是重复节点，接到不重复链表后面
                pUniq.next = p;
                pUniq = pUniq.next;
            }

            p = p.next;
            // 将原链表和新链表断开
            pUniq.next = null;
            pDup.next = null;
        }

        return dummyUniq.next;
    }

}
