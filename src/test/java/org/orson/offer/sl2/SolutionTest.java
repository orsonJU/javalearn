package org.orson.offer.sl2;

import org.junit.Test;

import java.util.ArrayList;

public class SolutionTest {


    @Test
    public void test() {

        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ListNode ln3 = new ListNode(3);
        ListNode ln4 = new ListNode(4);
        ListNode ln5 = new ListNode(5);

        ln1.next = ln2;
        ln2.next = ln3;
        ln3.next = ln4;
        ln4.next = ln5;

        Solution2 sl2 = new Solution2();
        ArrayList<Integer> result = sl2.printListFromTailToHead1(ln1);

        System.out.println(result);

    }
}
