package org.orson.offer.sl15;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class Solution15 {

    public ListNode Merge(ListNode list1,ListNode list2) {
        //两个链表任何一方为null时，返回另外一方
        if(list1 == null) {
            return list2;
        }else if(list2 == null) {
            return list1;
        }

        /**
         * 获得第一个最小当开始节点，当节点大小出现相同，永远优先链接第一个链表
         * 如：{1,3,4,5,7}和{1,2,4,6}，则优先选择第一个链表中的'1'。
         */
        ListNode head = list1.val <= list2.val ? list1 : list2;


        ListNode m = null;
        while(list1 != null && list2 != null) {
            /**
             * 比较两个链表节点的大小，可以得知list1和list2中最小者
             * 将m移动到最小者的下一个节点，然后最小者指向较大者，并移动到m位置。
             */
            if(list1.val <= list2.val) {
                m = list1.next;
                list1.next = list2;
                list1 = m;
            }else {
                m = list2.next;
                list2.next = list1;
                list2 = m;
            }
        }
        return head;
    }
}
