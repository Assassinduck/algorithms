package org.pg4200.les05;

import java.util.Objects;

public class BinaryTreeLeftMaxDelete<K extends Comparable<K>, V> extends MyMapBinarySearchTree<K,V> {


    @Override
    public void delete(K key) {
        Objects.requireNonNull(key);
        root = delete(key, root);
    }
    protected TreeNode delete(K key, TreeNode subtreeRoot){
        if (subtreeRoot == null) {
            /*
                This will happen when the key is not found, and we try a
                recursion on a null node.
                In this case, the new root of a null substree is still a null
                subtree, and we can return itself directly (ie null)
             */
            return null;
        }

        int compareKey = key.compareTo(subtreeRoot.key);

        if(compareKey < 0){
            subtreeRoot.left = delete(key, subtreeRoot.left);
            return subtreeRoot;
        }

        if(compareKey > 0){
            subtreeRoot.right = delete(key, subtreeRoot.right);
        }

        size--;

        // we are now at the node we want to delete

        if(subtreeRoot.left == null){
            return subtreeRoot.right;
        }

        if(subtreeRoot.right == null){
            return subtreeRoot.left;
        }




        TreeNode tmp = subtreeRoot;
        subtreeRoot = max(tmp.left);
        subtreeRoot.left = deleteMax(tmp.left);
        subtreeRoot.right = tmp.right;

    return subtreeRoot;


    }


    private TreeNode max(TreeNode subtreeRoot){
        if(subtreeRoot.right == null){
            return subtreeRoot;
        }

        return max(subtreeRoot.right);

    }

    private TreeNode deleteMax(TreeNode subtreeRoot){
        if(subtreeRoot.right == null){
            return subtreeRoot.left;
        }

        subtreeRoot.right = deleteMax(subtreeRoot.right);

        return subtreeRoot;
    }



}
