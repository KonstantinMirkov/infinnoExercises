package tradingExample;

import java.util.List;
import java.util.Random;

public class Investor implements Runnable {
    private final int id;
    private final List<Stock> stocks;
    private final Random random;
    private double profitAndLoss;

    public Investor(int id, List<Stock> stocks) {
        this.id = id;
        this.stocks = stocks;
        this.random = new Random();
    }

    public int getId() {
        return id;
    }

    public double getProfitAndLoss() {
        return profitAndLoss;
    }

    @Override
    public void run() {
        while (true) {

        }
    }
}
