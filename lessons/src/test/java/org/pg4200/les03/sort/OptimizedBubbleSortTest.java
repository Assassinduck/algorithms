package org.pg4200.les03.sort;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Comparator;

import org.junit.jupiter.api.Test;
import org.pg4200.les03.sort.Song;

public class OptimizedBubbleSortTest {

	Comparator<Integer> comArrInt = new Comparator<Integer>() {

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

		Comparator<String> comArrString = new Comparator<String>() {

		@Override
		public int compare(String o1, String o2) {
			if(o1.compareTo(o2) > 0){
				return 1;
			}else if(o1.compareTo(o2) < 0){
				return -1;
			}else{
				return 0;
			}
			
		}
		
	};


	@Test
	 public void testBubbleSort(){
	 String[] array = {"c", "b", "a", "d", "e", "f"};
	 	 String[] array2 = {"c", "b", "a", "d", "e", "f"};



	 	// OptimizedBubbleSort sort = new OptimizedBubbleSort();

		// int optiSort = sort.sort(array, comArrString, true);
		// System.out.println("done");
		// int unoptiSort = sort.sort(array2, comArrString, false);
		// System.out.println("done");


		// assertEquals( optiSort < unoptiSort, true);
		// 		assertEquals( optiSort <= unoptiSort /2, true);

	 }

	 @Test
	 public void testBubbleSortHalf(){
	 String[] array = {"c", "b", "a", "d", "e", "f"};
	 	 String[] array2 = {"c", "b", "a", "d", "e", "f"};



	 	OptimizedBubbleSort sort = new OptimizedBubbleSort();

		// int optiSort = sort.sort(array, comArrString, true);
		// System.out.println("done");
		// int unoptiSort = sort.sort(array2, comArrString, false);
		// System.out.println("done");

		// 		assertEquals( optiSort <= (unoptiSort /2), true);

	 }


	 @Test
	 public void testGameUserbubble(){
	 GameUser jack = new GameUser("cringe", 8888);
	GameUser tony = new GameUser("duck", 98);
		GameUser andy = new GameUser("lmao", 11111);

	GameUserComparitor comGamer = new GameUserComparitor();

	 	GameUser[] users = {jack, tony, andy};


		OptimizedBubbleSort sort = new OptimizedBubbleSort();

		sort.sort(users, comGamer, true);

		assertEquals(users[users.length-1].getPoints() == 11111, true);
		assertEquals(users[0].getUserId() == "duck", true);


	 }



	
}
