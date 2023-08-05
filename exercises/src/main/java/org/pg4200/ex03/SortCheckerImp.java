package org.pg4200.ex03;

import java.util.Arrays;
import java.util.Comparator;

import org.pg4200.les03.sort.OptimizedBubbleSort;

public class SortCheckerImp implements SortChecker {

	@Override
	public <T extends Comparable<T>> boolean isSortedCopy(T[] original, T[] sorted) {
		


		if(original == null && sorted == null){
			return true;
		}

		if(original == null || sorted == null){
		return false;
		}

		if(original.length == 0 && sorted.length == 0){
			return true;
		}

		
		Integer lengthOfArrayComparison = original.length - sorted.length;
		if(lengthOfArrayComparison < 0 || lengthOfArrayComparison > 0){
			return false;
		}

		boolean originalContainsNull = false;

		for (int i = 0; i < original.length; i++) {
			if(original[i] == null){
				originalContainsNull = true;
			}
		}

		if(originalContainsNull){
			return false;
		}

		boolean sortedContainsNull = false;

		for (int i = 0; i < sorted.length; i++) {
			if(sorted[i] == null){
				sortedContainsNull = true;
			}
		}

		if(sortedContainsNull){
			return false;
		}
		

		OptimizedBubbleSort sort = new OptimizedBubbleSort();

		T[] originalNowSorted = sort.sort(original, true);

		System.out.println("original: " +  Arrays.toString(original) + " \n" + "Sorted: "+ Arrays.toString(sorted) +"\n" + "Sorted version of original: " + Arrays.toString(originalNowSorted) );

		if(Arrays.equals(sorted, originalNowSorted ) == false){
			return false;
		}else{
			return true;
		}
		


	}
	
}
