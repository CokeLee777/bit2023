package day02;

public class Person {
	
	private Lottery lottery;
	private long reward;
	
	public void buyLottery(Lottery lottery) {
		this.lottery = lottery;
	}
	
	public long getReward() {
		return this.reward;
	}
	
	public void setReward(long reward) {
		this.reward = reward;
	}
	
	public Lottery getLottery() {
		return this.lottery;
	}
}
