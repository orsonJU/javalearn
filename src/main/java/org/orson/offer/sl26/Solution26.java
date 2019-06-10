package org.orson.offer.sl26;

/*
输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class Solution26 {


    public static void main(String[] args) {

        Solution26 app = new Solution26();


        RandomListNode r1 = new RandomListNode(1);
        RandomListNode r2 = new RandomListNode(2);
        RandomListNode r3 = new RandomListNode(3);
        RandomListNode r4 = new RandomListNode(4);

        r1.next = r2;
        r2.next = r3;
        r3.next = r4;

        r1.random = null;
        r2.random = r1;
        r3.random = r4;
        r4.random = r3;



        app.Clone(r1);

    }




    public RandomListNode Clone(RandomListNode pHead) {

        if(pHead == null) {
            return null;
        }


        // root
        RandomListNode root = pHead;
        RandomListNode current = root;

        // root
        RandomListNode rHead = new RandomListNode(pHead.label);
        RandomListNode low = rHead;

        while(current.next != null) {
            low.next = new RandomListNode(current.next.label);
            low.random = current;


            RandomListNode next = current.next;
            current.next = low;

            current = next;
            low = low.next;
        }

        low = rHead;

        while(low.next != null) {
            low.random = low.random.random == null? null : low.random.random.next;
            low = low.next;
        }

        return rHead;
    }
}
