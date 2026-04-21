package edu.xyf.labuladong.train.list;

import edu.xyf.codetop.struct.ListNode;

import java.util.Stack;

/**
 * @Author: Xuyifeng
 * @Description: 两数相加2
 * @Date: 2026/4/20 21:29
 */

public class Leetcode445Solution1 {

    // 不反转链表
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 把链表元素转入栈中
        Stack<Integer> stack1 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        Stack<Integer> stack2 = new Stack<>();
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        ListNode dummy = new ListNode(-1);
        int carry = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int val = carry;
            if (!stack1.isEmpty()) {
                val += stack1.pop();
            }
            if (!stack2.isEmpty()) {
                val += stack2.pop();
            }
            carry = val / 10;
            val = val % 10;
            ListNode newNode = new ListNode(val);
            newNode.next = dummy.next;
            dummy.next = newNode;
        }
        if (carry != 0) {
            ListNode newNode = new ListNode(carry);
            newNode.next = dummy.next;
            dummy.next = newNode;
        }
        return dummy.next;
    }

}
