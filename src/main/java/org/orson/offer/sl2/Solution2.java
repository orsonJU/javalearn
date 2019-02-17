package org.orson.offer.sl2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 */
public class Solution2 {

    /**
     * 因为给定都链表只有找到下一个都方法
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        ArrayDeque<Integer> deque = new ArrayDeque<>();

        int val = listNode.val;
        deque.push(val);
        ListNode cur = listNode;
        ListNode next = null;
        while((next = cur.next) != null) {
            deque.push(next.val);
            cur = next;
        }


        ArrayList<Integer> result = new ArrayList<>();
        while(deque.peek() != null) {
            result.add(deque.poll());
        }

        return result;
    }

    /**
     * 不允许用Deque
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {

        ArrayList<Integer> in = new ArrayList<>();
        ArrayList<Integer> out = new ArrayList<>();

        ListNode cur = listNode;

        if(cur == null) {
            return out;
        }

        do{
            in.add(cur.val);
            cur = cur.next;
        }while(cur != null);

        for(int i = in.size() - 1; i >= 0 ; i--) {
            out.add(in.get(i));
        }

        return out;
    }

    /**
     * 使用递归
     *
     * 缺点是，需要一个成员变量，而不是一个局部变量
     * @param listNode
     * @return
     */
    ArrayList<Integer> rs3 = new ArrayList<>();
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        if(listNode != null) {
            this.printListFromTailToHead2(listNode.next);
            rs3.add(listNode.val);
        }

        return rs3;
    }

}
