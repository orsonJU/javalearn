package org.orson.offer.sl13;


/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class Solution13 {

    /**
     * 当第一次遍历的时候，可以获得最高位的指针（总节点数）
     * 第二次遍历的时候，就可以最顶目标在最高位指针-k的位置
     * @param head
     * @param k
     * @return
     */
    public ListNode FindKthToTail(ListNode head,int k) {

        if(head == null || k == 0) {
            return null;
        }


        int l = 1, h = 1;
        ListNode first = head;
        while(first.next != null) {
            first = first.next;
            h++;
        }

        if(k == h) {
            return head;
        }

        if(k > h) {
            return null;
        }

        ListNode second = head;
        while(l < (h -k + 1)) {
            l++;
            second = second.next;
        }

        return second;

    }


    /**
     *
     * 利用固定区间的原理，当第一个指针走到第k个位置，第二个指针在第一个位置，这样就形成了一个大小为k的区间
     *
     * 当第一个指针和第二个指针一起往右移动，最终第一个指针到达最高位，第二个指针当位置就是目标节点。
     * @param head
     * @param k
     * @return
     */
    public ListNode FindKthToTail2(ListNode head,int k) {

        if(head == null || k == 0) {
            return null;
        }


        int l = 1, h = 1;
        ListNode lnode = head;
        ListNode hnode = head;
        while(hnode.next != null) {
            hnode = hnode.next;
            h++;
            if(h > k) {
                lnode = lnode.next;
            }
        }

        return k > h ? null : lnode;

    }

}
