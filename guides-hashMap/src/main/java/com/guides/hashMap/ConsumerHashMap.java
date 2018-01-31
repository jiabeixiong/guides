package com.guides.hashMap;

import java.util.Arrays;

public class ConsumerHashMap<K, V> implements ConsumerMap<K, V> {

    private int size;

    private int DEFAULT_SIZE = 16;

    static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private Entry<K, V>[] entries = new Entry[DEFAULT_SIZE];

    @Override
    public V get(K k) {
        if (k == null) {
            return null;
        }
        int hashCode = k.hashCode();
        int index = hashCode % DEFAULT_SIZE;
        Entry<K, V> entry = entries[index];
        if (entry == null) {
            return null;
        }

        Entry<K, V> exsitNode = getExsitNode(k, entry);


        if (exsitNode == null) {
            return null;
        }

        return exsitNode.getV();
    }

    @Override
    public V put(K k, V v) {
        if (k == null) {
            throw new RuntimeException(" key is null ! ");
        }

        /**
         * hash扩容
         */
        if (size >= DEFAULT_LOAD_FACTOR * DEFAULT_SIZE) {


            resize();


        }

        int hashCode = k.hashCode();

        int index = hashCode % DEFAULT_SIZE;

        Entry entry = entries[index];

        if (entry == null) {
            entry = new Entry(k, v, null);
            entries[index] = entry;
            size++;
            return v;
        }

        //如果存在  需要比较key是否相等
        Entry exsitNode = getExsitNode(k, entry);

        if (exsitNode != null) {
            exsitNode.setV(v);
            return v;
        }

        Entry lastNode = getLastNode(entry);

        entry = new Entry(k, v, null);
        lastNode.setNext(entry);
        size++;

        return v;
    }

    private void resize() {

        Entry[] tempEntrys = Arrays.copyOf(entries,entries.length);
        int i = size();
        DEFAULT_SIZE = DEFAULT_SIZE << 1;
        entries = new Entry[DEFAULT_SIZE];

        for (Entry<K,V> e : tempEntrys) {
            if(e != null){
                put(e.getK(),e.getV());
                while(e.getNext() != null){
                        e = e.getNext();
                        put(e.getK(),e.getV());
                }
            }
        }

        size = i;

    }

    private Entry getLastNode(Entry entry) {
        Entry lastEntry = entry;
        if (entry.getNext() != null) {
            lastEntry = getLastNode(entry.getNext());
        }

        return lastEntry;
    }

    private Entry getExsitNode(K k, Entry entry) {

        if (k.equals(entry.getK())) {
            return entry;
        }

        while (entry.getNext() != null) {
            entry = entry.getNext();
            if (k.equals(entry.getK())) {
                return entry;
            }
        }
        return null;
    }


    @Override
    public int size() {
        return size;
    }


    class Entry<K, V> {

        private K k;

        private V v;

        private Entry next;

        public Entry(K k, V v, Entry next) {
            this.k = k;
            this.v = v;
            this.next = next;
        }

        public K getK() {
            return k;
        }

        public void setK(K k) {
            this.k = k;
        }

        public V getV() {
            return v;
        }

        public void setV(V v) {
            this.v = v;
        }

        public Entry getNext() {
            return next;
        }

        public void setNext(Entry next) {
            this.next = next;
        }
    }


}
