package org.pg4200.ex04;

import org.pg4200.les03.sort.MySort;
import org.pg4200.les04.sort.OptimizedMergeSort;

public class MixedSort implements MySort {
    @Override
    public <T extends Comparable<T>> void sort(T[] array) {
        OptimizedMergeSort mergeSort = new OptimizedMergeSort();
        mergeSort.sort(array);
        System.out.println("done");
        return;
    }
}
