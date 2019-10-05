package org.orson.offer.v25;

public class Solution {


    public ListNode Merge(ListNode list1,ListNode list2) {

        if(list1 == null) {
            return list2;
        }

        if(list2 == null) {
            return list1;
        }

        return merge(list1, list2);
    }


    //基于指针实现
    public ListNode merge(ListNode list1, ListNode list2) {
        ListNode head = list1.val < list2.val ? list1 : list2;

        ListNode p1 = list1, p2 = list2;
        while(list1 != null && list2 != null) {
            // 判断大小
            if(list1.val < list2.val) {
                list1 = list1.next;
                p1.next = p2;
                p1 = list1;
            }else {
                list2 = list2.next;
                p2.next = p1;
                p2 = list2;
            }
        }

        return head;
    }

    // 基于递归实现
}
