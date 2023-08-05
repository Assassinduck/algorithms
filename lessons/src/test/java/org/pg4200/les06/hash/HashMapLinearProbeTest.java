package org.pg4200.les06.hash;

public class HashMapLinearProbeTest extends MyHashMapTestTemplate {
    @Override
    protected <K, V> MyHashMap<K, V> getInstance() {
        return new MyHashMapLinearProbe<K,V>();
    }
}
