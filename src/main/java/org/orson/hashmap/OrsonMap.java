package org.orson.hashmap;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class OrsonMap<K, V> implements Map<K, V> {


    public static final int DEFAULT_SIZE = 8;

    OrsonNode<K, V>[] nodes;

    int size = 0;

    public OrsonMap() {
        nodes  = new OrsonNode[DEFAULT_SIZE];

    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size > 0 ? false : true;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public V get(Object key) {
        int hash = key.hashCode();

        int slot = Math.abs(hash%nodes.length);

        OrsonNode<K, V> node = nodes[slot];

        V value = null;
        while (node != null) {
            if(node.key.equals(key)) {
                value = node.value;
                break;
            }
            node = node.next;
        }

        return value;
    }

    @Override
    public V put(K key, V value) {

        int hash = key.hashCode();

        int slot = Math.abs(hash%nodes.length);


        OrsonNode<K, V> node = nodes[slot];

        if(node == null) {
            nodes[slot] = new OrsonNode<>(key, value);
            size++;
            return value;
        }

        OrsonNode<K, V> point = node;
        while(node != null) {
            if(node.key.equals(key)) {
                OrsonNode<K, V> temp = new OrsonNode<>(key, value);
                temp.next = node.next;
                nodes[slot] = temp;
                // break
                break;
            }
            point = node;
            node = node.next;
        }

        if(node == null) {
            point.next = new OrsonNode<>(key, value);
        }

        return value;
    }

    @Override
    public V remove(Object key) {

        int hash = key.hashCode();

        int slot = Math.abs(hash%nodes.length);

        OrsonNode<K, V> node = nodes[slot];


        if(node == null) {
            return null;
        }


        V value = null;
        if(node.key.equals(key)) {
            nodes[slot] = node.next;
            node.next = null;
            node = null;
        }else {
            OrsonNode<K, V> point;

            do {
                point = node;
                node = node.next;

                if(node.key.equals(key)) {
                    break;
                }

            }while(node.next != null);

            point.next = node.next;
            value = node.value;
        }

        return value;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {

        if(size == 0) {
            nodes  = new OrsonNode[DEFAULT_SIZE];
        }else {
            nodes  = new OrsonNode[size];
        }
    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }


    @Override
    public String toString() {
        return "OrsonMap{" +
                "nodes=" + Arrays.toString(nodes) +
                '}';
    }
}
