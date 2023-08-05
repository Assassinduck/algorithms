package org.pg4200.ex03;

import java.sql.Array;
import java.util.Arrays;
import java.util.Comparator;

public class OptimizedBubbleSort {

	public <T> int sort(T[] array, Comparator<T> comparator, boolean optimized){


	int compared = 0;

	if(array == null){
	return 0;
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
	System.out.println("i: " + i);
		int j = i + 1;
				compared++;
				System.out.println("compared: " + compared);

		if(comparator.compare(array[i], array[j]) > 0){
			

			T temp = array[i];
			array[i] = array[j];
			array[j] = temp;
			swapped = true;
			lastSwap = i;
			
			System.out.println("swapped");
			System.out.println("swapped " + array[i] + " and " + array[j]);
			System.out.println("new array is " + Arrays.toString(array));

			System.out.println();
		}

	}
	System.out.println("the last index swapped is: " + lastSwap);
	System.out.println("The item there is: " + array[lastSwap]);
	System.out.println("new end is " + (lastSwap));


	}

	
	




	return compared;
}


	
}
