package org.pg4200.les03.sort.myOwnSort;

import java.util.Comparator;

import org.pg4200.les03.sort.OptimizedBubbleSort;
  

public class OpBMain {


public static void main(String[] args) {
	

	OptimizedBubbleSort sort = new OptimizedBubbleSort();

	Integer[] array = {2,3,5,8,0,1};
		Integer[] array2 = {2,3,5,8,0,1};

					//2, 3, 5, 0, 8, 1
					//2, 3, 5, 0, 1, 8


	Comparator<Integer> comArr = new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			if(o1.compareTo(o2) > 0){
				return 1;
			}else if(o1.compareTo(o2) < 0){
				return -1;
			}else{
				return 0;
			}
			
		}
		
	};

		System.out.println(sort.sort(array, comArr, true ));

		System.out.println(sort.sort(array2, comArr, false ));




}
	
}
