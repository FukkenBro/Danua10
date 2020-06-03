package products;

import java.util.Random;

public class OilCheck implements Service {
    private int price = 50;

    public void perform() {
        boolean oilStatus = new Random().nextBoolean();
        System.out.println("Oil status - " + oilStatus);
    }

    @Override
    public int getPrice() {
        return price;
    }
}
