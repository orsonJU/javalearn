package org.orson.offer.sl26;

public class RandomListNode {

    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;

    }

    @Override
    public String toString() {
        return String.valueOf(label);
    }
}
