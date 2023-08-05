package org.pg4200.les05;

import java.security.Key;
import java.util.Objects;

public class TernaryTreeMap<K extends Comparable<K>, V> implements MyMapTreeBased<K , V>{

    protected class TreeNode {
        public K firstKey;
        public K secondKey;
        public V firstValue;
        public V secondValue;

        public TreeNode left;
        public TreeNode middle;
        public TreeNode right;
    }

    protected TreeNode root;

    protected int size;

    @Override
    public void put(K key, V value) {
        Objects.requireNonNull(key);
        root = put(key, value, root);
    }
    public TreeNode put(K key, V value, TreeNode subtreeRoot) {

        if(subtreeRoot ==null){
            TreeNode newNode = new TreeNode();
            newNode.firstKey = key;
            newNode.firstValue = value;
            size++;
            return newNode;
        }

        int compKeyToFirstKey = key.compareTo(subtreeRoot.firstKey);

        if(compKeyToFirstKey < 0){
            subtreeRoot.left = put(key, value, subtreeRoot.left);
        }else if(compKeyToFirstKey == 0){
            subtreeRoot.firstValue = value;
        }else if (compKeyToFirstKey > 0){
            if(subtreeRoot.secondKey == null){
                size++;
                subtreeRoot.secondKey = key;
                subtreeRoot.secondValue = value;
            }else{
                int compKeyToSecondKey = key.compareTo(subtreeRoot.secondKey);
                if(compKeyToSecondKey < 0){
                    subtreeRoot.middle = put(key, value, subtreeRoot.middle);
                } else if (compKeyToSecondKey == 0) {
                    subtreeRoot.secondValue = value;
                }else{
                    subtreeRoot.right = put(key,value, subtreeRoot.right);
                }

            }


        }
    return subtreeRoot;
    }

    @Override
    public void delete(K key) {
        Objects.requireNonNull(key);
        root = delete(key, root);
    }

    protected TreeNode delete(K key, TreeNode subtreeRoot){
        if(subtreeRoot == null){
            return null;
        }

        int compareKeyToFirstKey = key.compareTo(subtreeRoot.firstKey);
        if(compareKeyToFirstKey < 0){
            subtreeRoot.left = delete(key, subtreeRoot.left);
        }

        if(compareKeyToFirstKey == 0){
            size--;


        }

        if (compareKeyToFirstKey > 0) {
            int compareKeyToSecondKey = key.compareTo(subtreeRoot.secondKey);

            if(compareKeyToSecondKey < 0) {
                subtreeRoot.middle = delete(key, subtreeRoot.middle);
            }
        }





return null;



    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public int getMaxTreeDepth() {
        return 0;
    }
}
