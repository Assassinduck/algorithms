package org.pg4200.les05;

import com.sun.source.tree.BinaryTree;

public class BinaryMain {

    public static void main(String[] args) {
        BinaryTreeLeftMaxDelete<Integer, Integer> binaryTree = new BinaryTreeLeftMaxDelete<>();


        binaryTree.put(100,1);

        binaryTree.put(75,2);

        binaryTree.put(65,4);
        binaryTree.put(85,5);


        binaryTree.put(60,8);
        binaryTree.put(70,9);

        binaryTree.put(80,10);
        binaryTree.put(95,11);

        binaryTree.put(125,3);

        binaryTree.put(115,6);
        binaryTree.put(150,7);

        binaryTree.put(110,12);
        binaryTree.put(120,13);
        binaryTree.put(135,14);
        binaryTree.put(175,15);

        binaryTree.delete(115);

        System.out.println(binaryTree.get(115));













    }
}
