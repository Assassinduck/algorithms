package org.pg4200.les05;

public class BinaryTreeLeftMaxDeleteTest extends MyMapBinarySearchTreeTest {
    @Override
    protected <K extends Comparable<K>, V> BinaryTreeLeftMaxDelete<K, V> getTreeInstance() {
        return new BinaryTreeLeftMaxDelete<K,V>();
    }


}
