package org.pg4200.les03.sort;

import java.util.Comparator;

public class GameUserComparitor implements Comparator<GameUser> {

	@Override
	public int compare(GameUser user1, GameUser user2) {
		
	int pointComp = user1.getPoints() -  user2.getPoints();


	if(pointComp < 0){
	return -1;
	}

	if(pointComp > 0){
		return 1;
	}

	return user1.getUserId().compareTo(user2.getUserId());



	}




	
}
