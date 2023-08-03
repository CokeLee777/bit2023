package day02;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static day02.LotteryProperties.*;

public class LotteryCalculator {
	
	private final List<Person> participants;
	private final Map<Integer, List<Person>> lotteryRankingStore;
	
	public LotteryCalculator(List<Person> participants, Map<Integer, List<Person>> lotteryRankingStore) {
		this.participants = participants;
		this.lotteryRankingStore = lotteryRankingStore;
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
			switch (sameNumberCount) {
				case 5:
					putPersonInLotteryRankingStore(1, person);
					break;
				case 4:
					putPersonInLotteryRankingStore(2, person);
					break;
				case 3:
					putPersonInLotteryRankingStore(3, person);
					break;
				case 2:
					putPersonInLotteryRankingStore(4, person);
					break;
				case 1:
					putPersonInLotteryRankingStore(5, person);
					break;
				default: break;
			}
		}
	}
	
	private void putPersonInLotteryRankingStore(int ranking, Person person) {
		if(lotteryRankingStore.containsKey(ranking)) {
			lotteryRankingStore.get(ranking).add(person);
		} else {
			List<Person> people = new ArrayList<>();
			people.add(person);
			lotteryRankingStore.put(ranking, people);
		}
	}
	
	public long calcReward(long totalReward, double percentOfReward, int sameRankingCount) {
		return (long) (totalReward * percentOfReward / sameRankingCount);
	}
}
