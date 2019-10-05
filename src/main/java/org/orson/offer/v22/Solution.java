package org.orson.offer.v22;

import java.util.List;
import java.util.Stack;

// 链表中倒数第k个结点
public class Solution {




    public ListNode FindKthToTail(ListNode head,int k) {
        if(head == null || k == 0) {
            return null;
        }

        return this.search(head, k);
    }

    // 基于循环实现
    private ListNode search(ListNode head, int k) {
        ListNode point = head;
        int len = 0;
        while(point != null) {
            point = point.next;
            len++;
        }

        // 边界测试
        if(len < k) {
            return null;
        }

        int target = len - k;
        point = head;
        while(target > 0 && point != null) {
            point = point.next;
            target--;
        }

        return point;
    }

    // 基于堆栈完成
    private ListNode search2(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<>();

        while(head != null) {
            stack.push(head);
            head = head.next;
        }

        if(stack.size() < k) {
            return null;
        }

        ListNode point = null;
        while(k > 0 && stack.peek() != null) {
            point = stack.pop();
            k--;
        }
        return point;
    }


    // 基于动态窗口是实现
    private ListNode search3(ListNode head, int k) {
        ListNode high = head;
        while(k > 0 && high != null) {
            high = high.next;
            k--;
        }

        if(k > 0) {
            return null;
        }

        ListNode low = head;
        while(high != null) {
            high = high.next;
            low = low.next;
        }

        return low;
    }
}
