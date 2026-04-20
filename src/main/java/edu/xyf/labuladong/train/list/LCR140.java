package edu.xyf.labuladong.train.list;

import edu.xyf.codetop.struct.ListNode;

/**
 * @Author: Xuyifeng
 * @Description: 训练计划2
 * @Date: 2026/4/18 16:27
 */

public class LCR140 {

    public ListNode trainingPlan(ListNode head, int cnt) {
        ListNode slow, fast;
        slow = head;
        fast = head;
        for (int i = 0; i < cnt; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

}
