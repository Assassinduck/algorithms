package org.pg4200.les03.sort.myOwnSort;

import org.pg4200.les03.sort.MySort;

public class InsertionAttemt implements MySort {

	@Override
	public <T extends Comparable<T>> void sort(T[] array) {
		
	if(array == null){
	throw new RuntimeException();
	}




	for (int i = 1; i < array.length; i++) {
		for(int j = i-1; j>= 0; j--){
			if(array[j].compareTo(array[j+1]) > 0){
			T temp = array[j+1];
			
			}
		
		}
		

	}


	}

	private void swap(){

	}
	
}
