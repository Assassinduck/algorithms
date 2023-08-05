package org.pg4200.ex03;

public class ImpMain {

public static void main(String[] args) {
	SortCheckerImp sortImp = new SortCheckerImp();

	   Integer[] original = {1,2,2};
        Integer[] sorted = {1,1,2};

	System.out.println(sortImp.isSortedCopy(original, sorted));




}
	
}
