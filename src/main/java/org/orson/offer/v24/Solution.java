package org.orson.offer.v24;

import java.util.Stack;

//反转链表
public class Solution {

    public ListNode ReverseList(ListNode head) {

        if(head == null) {
            return null;
        }

        return reverse(head);

    }


    // 基于双指针
    public ListNode reverse(ListNode head) {
        ListNode low , high;

        low = head;
        high = head.next;
        low.next = null;

        ListNode temp = low;
        while(high != null) {
            temp = high;
            high = high.next;
            temp.next = low;
            low = temp;
        }
        return temp;
    }


    // 基于堆栈
    public ListNode reverse2(ListNode head) {
        Stack<ListNode> stack = new Stack<>();

        while(head != null) {
            stack.push(head);
            head = head.next;
        }


        ListNode newHead = null;
        if(!stack.isEmpty()) {
            newHead = stack.pop();
        }

        ListNode point = newHead;
        while(!stack.isEmpty()) {
            ListNode next = stack.pop();
            point.next = next;
            point = next;
        }

        // 防止闭环
        point.next = null;

        return newHead;
    }
}
