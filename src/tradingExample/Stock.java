package tradingExample;

public class Stock {
    private final String name;
    private double price;
    private int volume;

    public Stock(String name, double price, int volume) {
        this.name = name;
        this.price = price;
        this.volume = volume;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getVolume() {
        return volume;
    }

    public void startTradingSession() {

    }

    public void endTradingSession() {

    }

    public void buy(int quantity) {

    }

    public void sell(int quantity) {

    }
}
