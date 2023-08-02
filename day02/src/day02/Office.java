package day02;

import java.util.*;

public class Office {
	
	private final Set<Integer> winNumbers = new HashSet<>();
	
	// pick random 5 numbers
	public void pickWinNumbers() {
		int pickCount = 0;
		while(pickCount++ < 5) {
			int randomNumber = LotteryProgram.random.nextInt(41);
			// check if is not possible number
			if(randomNumber == 0 || winNumbers.contains(randomNumber))
				continue;
			
			winNumbers.add(randomNumber);
		}
	}
	
	public Set<Integer> getWinNumbers() {
		return this.winNumbers;
	}
}
