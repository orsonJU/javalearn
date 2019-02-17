package org.orson.offer.sl14;

/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class Solution14 {

    /**
     *
     * 当需要用到多余2个当标识位时候，中间当标识位往往就是判断条件。
     *
     * 仔细想想，下一个节点为空，也是节点，所以就存在一种情况为当节点为空。
     * @param head
     * @return
     */
    public ListNode ReverseList(ListNode head) {
        if(head == null) {
            return null;
        }

        ListNode low = null;
        ListNode high = null;

        while(head != null) {
            high = head.next;
            head.next = low;
            low = head;
            head = high;
        }

        return low;
    }
}
