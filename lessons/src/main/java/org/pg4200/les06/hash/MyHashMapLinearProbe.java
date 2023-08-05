package org.pg4200.les06.hash;

import java.lang.reflect.Array;
import java.util.Objects;

public class MyHashMapLinearProbe<K,V> implements MyHashMap<K,V>{

    private class Entry{
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int size;

    private final int M = 29;

    private final Entry[] data = (Entry[]) Array.newInstance(Entry.class, M);

    @Override
    public void put(K key, V value) {

        Objects.requireNonNull(key);

        int index = index(key);

        if(data[index] == null){
            data[index] = new Entry(key, value);
            size++;
            return;
        }


        for (int i = index + 1; i < data.length; i++) {
            if(data[i] == null){
                data[i] = new Entry(key, value);
                size++;
                return;
            }
        }


        for (int i = 0; i < index ; i++) {
            if(data[i] == null){
                data[i] = new Entry(key, value);
                size++;
            }
        }

        throw new Error("No space in Hashmap");

    }

    private int index(K key){
        int positiveHash = key.hashCode() & 0x7f_ff_ff_ff;
        return positiveHash % M;
    }



    @Override
    public void delete(K key) {

        Objects.requireNonNull(key);

        int index = index(key);

        if (data[index] == null) {
            return;
        }

        /*for (Entry datum : data) {
            if (datum.hashCode() == data[index].hashCode()) {
                data[index].key = null;
                return;
            }

        }*/

        if(data[index - 1].hashCode() == data[index].hashCode() || data[index + 1].hashCode() == data[index].hashCode()){
            data[index].key = null;
            return;
        }

        data[index] = null;
    }

    @Override
    public V get(K key) {
        Objects.requireNonNull(key);

        int index = index(key);

        if(data[index] == null){
            return null;
        }

        return data[index].value;

    }

    @Override
    public int size() {
        return size;
    }
}
