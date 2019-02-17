package org.orson.offer.sl15;

import org.junit.Test;

public class Solution15Test {

    @Test
    public void test() {

        Solution15 sl = new Solution15();

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(7);


        ListNode l6 = new ListNode(2);
        ListNode l7 = new ListNode(4);
        ListNode l8 = new ListNode(6);


        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        l6.next = l7;
        l7.next = l8;


        ListNode merge = sl.Merge(l1, l6);

        while(merge != null) {
            System.out.println(merge.val);
            merge = merge.next;
        }
    }
}
