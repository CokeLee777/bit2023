package day02;

public interface LotteryProperties {

    int totalCountOfNumbers = 5;
    int minNumber = 1;
    int maxNumber = 40;
    long totalReward = 5000000000L;
    double[] percentOfReward = new double[] {0.5, 0.3, 0.1, 0.08, 0.02};
}
