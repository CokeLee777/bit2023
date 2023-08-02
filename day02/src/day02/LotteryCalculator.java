package day02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LotteryCalculator {
	
	private static final int totalCountOfNumbers = 5;
	
	private final List<Person> participants;
	private final Map<Integer, List<Person>> lotteryRanking;
	
	public LotteryCalculator(List<Person> participants, Map<Integer, List<Person>> lotteryRanking) {
		this.participants = participants;
		this.lotteryRanking = lotteryRanking;
	}
	
	public void calcRanking(Set<Integer> winNumbers) {
		for(int i = 0; i < participants.size(); i++) {
			Person person = participants.get(i);
			Integer[] numbers = person.getLottery().getNumbers().toArray(new Integer[totalCountOfNumbers]);
			
			// calc same number 
			int sameNumberCount = 0;
			for(int j = 0; j < numbers.length; j++) {
				if(winNumbers.contains(numbers[j]))
					sameNumberCount += 1;
			}
			
			// add ranking store
			switch(sameNumberCount) {
				case 5:
					putPersonInLotteryRanking(1, person);
					break;
				case 4:
					putPersonInLotteryRanking(2, person);
					break;
				case 3:
					putPersonInLotteryRanking(3, person);
					break;
				case 2:
					putPersonInLotteryRanking(4, person);
					break;
				case 1:
					putPersonInLotteryRanking(5, person);
					break;
				default:
					break;
			}
		}
	}
	
	private void putPersonInLotteryRanking(int ranking, Person person) {
		if(lotteryRanking.containsKey(ranking)) {
			lotteryRanking.get(ranking).add(person);
		} else {
			List<Person> people = new ArrayList<>();
			people.add(person);
			lotteryRanking.put(ranking, people);
		}
	}
	
	public long calcReward(long totalReward, double percentOfReward, int duplicateNumberOfPeople) {
		return (long) (totalReward * percentOfReward / duplicateNumberOfPeople);
	}
}
