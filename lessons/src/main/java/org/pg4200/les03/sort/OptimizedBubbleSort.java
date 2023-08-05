package org.pg4200.les03.sort;

import java.sql.Array;
import java.util.Arrays;
import java.util.Comparator;

public class OptimizedBubbleSort {


	public <T extends Comparable<T>> T[] sort(T[] array, boolean optimized){
	
	Comparator<T> arrayComp = new Comparator<T>() {

		@Override
		public int compare(T o1, T o2) {
			if(o1.compareTo(o2) > 0){
			return 1;
			}
			if(o1.compareTo(o2) < 0){
			return -1;
			}
			return 0;
		}
		
	};

	 return	sort(array, arrayComp, optimized);
	}


	public <T> T[] sort(T[] array, Comparator<T> comparator, boolean optimized){

	int compared = 0;

	if(array == null){
	return null;
	}


	boolean swapped  = true;
        int lastSwap = array.length-1;

	while(swapped){


	int limit = array.length - 1;
		swapped = false;


	if(optimized){
	limit = lastSwap;
	}


	for (int i = 0; i < limit; i++) {
		int j = i + 1;
				compared++;

		if(comparator.compare(array[i], array[j]) > 0){
			

			T temp = array[i];
			array[i] = array[j];
			array[j] = temp;
			swapped = true;
			lastSwap = i;

		}

	}



	}

	
	




	return array;
}


	
}
