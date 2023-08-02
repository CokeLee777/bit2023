package day02;

import java.util.*;

public class LotteryProgram {
	
	private static final int totalCountOfNumbers = 5;
	private static final int minNumber = 1;
	private static final int maxNumber = 40;
	
	public static final Random random = new Random();
	private static final long totalReward = 5000000000l;
	private static final double[] percentOfReward = new double[] {0.5, 0.3, 0.1, 0.08, 0.02};
	
	private static final List<Person> participants = new ArrayList<>();
	private static final Map<Integer, List<Person>> lotteryRanking = new HashMap<>();
	
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
		Set<Integer> myNumbers = new HashSet<>();
		while(myNumbers.size() < totalCountOfNumbers) {
			int inputNumber = sc.nextInt();
			if(inputNumber < minNumber || inputNumber > maxNumber || myNumbers.contains(inputNumber))
				continue;
			
			myNumbers.add(inputNumber);
		}
		
		Person me = addParticipant(myNumbers);
		
		// set dummy data
		setDummyData();
		
		// pick lottery numbers
		office.pickWinNumbers();
		
		// calc ranking
		calculator.calcRanking(office.getWinNumbers());
		
		// print result
		printResult(lotteryRanking, me);
		
		sc.close();
	}
	
	public void printResult(Map<Integer, List<Person>> lotteryRanking, Person me) {
		int myrank = -1;
		int duplicateNumberOfPeople = 0;
		for(int rank = 1; rank <= 5; rank++) {
			List<Person> people = lotteryRanking.getOrDefault(rank, new ArrayList<>());
			if(people.contains(me)) {
				myrank = rank;
				duplicateNumberOfPeople = people.size();
				me.setReward(calculator.calcReward(totalReward, percentOfReward[myrank - 1], duplicateNumberOfPeople));
			}
			System.out.println(rank + "등: " + people.size() + "명");
		}
		
		if(myrank == -1) {
			System.out.println("꽝");
		} else {
			System.out.println("내 등수: " + myrank + " 상금: " + me.getReward() + "원");
		}
	}
	
	private void setDummyData() {
		for(int i = 0; i < 999; i++) {
			Set<Integer> numbers = new HashSet<>(); 
					
			int pickCount = 0;
			while(pickCount++ < totalCountOfNumbers) {
				int randomNumber = LotteryProgram.random.nextInt(maxNumber + 1);
				// check if is not possible number
				if(randomNumber == 0 || numbers.contains(randomNumber))
					continue;
				
				numbers.add(randomNumber);
			}
			
			addParticipant(numbers);
		}
	}
	
	private Person addParticipant(Set<Integer> numbers) {
		Lottery lottery = new Lottery();
		lottery.addNumbers(numbers);
		
		Person person = new Person();
		person.buyLottery(lottery);
		
		participants.add(person);
		
		return person;
	}

	public static void main(String[] args) {
		Office office = new Office();
		LotteryCalculator calculator = new LotteryCalculator(participants, lotteryRanking);
		LotteryProgram lotteryProgram = new LotteryProgram(office, calculator);
		lotteryProgram.operator();
	}

}
