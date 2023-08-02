package day02;

import java.util.*;

public class LotteryProgram {
	
	private static final int totalCountOfNumbers = 5;
	private static final int minNumber = 1;
	private static final int maxNumber = 40;
	private static final long totalReward = 5000000000l;
	private static final double[] percentOfReward = new double[] {0.5, 0.3, 0.1, 0.08, 0.02};
	
	public static final Random random = new Random();
	
	private static final List<Person> participants = new ArrayList<>();
	private static final Map<Integer, List<Person>> lotteryRankingStore = new HashMap<>();
	
	private final Office office;
	private final LotteryCalculator calculator;
	
	public LotteryProgram(Office office, LotteryCalculator calculator) {
		this.office = office;
		this.calculator = calculator;
	}
	
	public void operator() {
		System.out.println("로또번호 5개를 입력해주세요(1 ~ 40사이의 숫자)");
		Scanner sc = new Scanner(System.in);
		
		// my input
		Lottery myLottery = new Lottery();
		Set<Integer> myNumbers = myLottery.getNumbers();
		while(myNumbers.size() < totalCountOfNumbers) {
			int inputNumber = sc.nextInt();
			if(inputNumber < minNumber || inputNumber > maxNumber || myNumbers.contains(inputNumber))
				continue;
			
			myNumbers.add(inputNumber);
		}
		Person me = new Person();
		me.buyLottery(myLottery);
		participants.add(me);
		
		// set dummy data
		setDummyData(999);
		
		// pick winner lottery numbers in office
		office.pickWinNumbers();
		
		// calc ranking
		Set<Integer> winNumbers = office.getWinNumbers();
		calculator.calcRanking(winNumbers);
		
		// print total result and my result
		printTotalResult();
		printSpecificResult(me);
		
		sc.close();
	}
	
	public void printTotalResult() {
		for(int rank = 1; rank <= 5; rank++) {
			List<Person> people = lotteryRankingStore.getOrDefault(rank, new ArrayList<>());
			System.out.println(rank + "등: " + people.size() + "명");
		}
	}
	
	public void printSpecificResult(Person person) {
		int myRank = -1;
		int numberOfSameRankingPeople = 0;
		for(int rank = 1; rank <= 5; rank++) {
			List<Person> people = lotteryRankingStore.getOrDefault(rank, new ArrayList<>());
			if(people.contains(person)) {
				myRank = rank;
				numberOfSameRankingPeople = people.size();
				long myReward = calculator.calcReward(totalReward, percentOfReward[myRank - 1], numberOfSameRankingPeople);
				person.setReward(myReward);
				break;
			}
		}
		
		if(myRank == -1) {
			System.out.println("꽝");
		} else {
			System.out.println("내 등수: " + myRank + "등 상금: " + person.getReward() + "원");
		}
	}
	
	private void setDummyData(int size) {
		for(int i = 0; i < size; i++) {
			Lottery lottery = new Lottery();
			Set<Integer> numbers = lottery.getNumbers();
					
			int pickCount = 0;
			while(pickCount++ < totalCountOfNumbers) {
				int randomNumber = LotteryProgram.random.nextInt(maxNumber + 1);
				// check if is not possible number
				if(randomNumber == 0 || numbers.contains(randomNumber))
					continue;
				
				numbers.add(randomNumber);
			}
			
			Person person = new Person();
			person.buyLottery(lottery);
			participants.add(person);
		}
	}

	public static void main(String[] args) {
		Office office = new Office();
		LotteryCalculator calculator = new LotteryCalculator(participants, lotteryRankingStore);
		LotteryProgram lotteryProgram = new LotteryProgram(office, calculator);
		lotteryProgram.operator();
	}

}
