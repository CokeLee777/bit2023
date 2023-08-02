package day02;

import java.util.*;

public class Lottery {
	
	private final Set<Integer> numbers = new HashSet<>();
	
	public void addNumbers(Set<Integer> numbers) {
		this.numbers.addAll(numbers);
	}
	
	public Set<Integer> getNumbers() {
		return this.numbers;
	}
}
