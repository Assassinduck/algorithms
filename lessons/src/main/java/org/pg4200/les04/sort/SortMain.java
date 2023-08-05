package org.pg4200.les04.sort;

public class SortMain {


public static void main(String[] args) {
	OptimizedMergeSort sort = new OptimizedMergeSort();

	Integer[] unsorted = {3,2,1,6,9,8,2,3,4};
	
	sort.sort(unsorted);
}
	
}
