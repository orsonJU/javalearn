package org.orson.offer.sl24;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution24 {

    Map<Integer, RandomListNode> nodeSet = new HashMap<>();

    public RandomListNode Clone(RandomListNode pHead) {

        if(pHead == null) {
            return null;
        }

        int head = pHead.label;
        RandomListNode point = pHead;



        while(pHead.next != null) {
            RandomListNode node = new RandomListNode(pHead.label);
            nodeSet.put(pHead.label, node);

            RandomListNode random = new RandomListNode(pHead.random.label);
            nodeSet.put(random.label, random);

            pHead = pHead.next;
        }


        return null;
    }

}
