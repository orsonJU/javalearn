package org.orson.hashmap;

public class OrsonNode<K, V> {

    K key;
    V value;

    OrsonNode<K, V> next;


    public OrsonNode(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public OrsonNode<K, V> getNext() {
        return next;
    }

    public void setNext(OrsonNode<K, V> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "OrsonNode{" +
                "key=" + key +
                ", value=" + value +
                ", next=" + next +
                '}';
    }
}
