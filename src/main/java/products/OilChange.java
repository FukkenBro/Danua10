package products;

public class OilChange implements Service {

    private int price = 100;

    public void perform() {
        System.out.println("Oil has been changed!");
    }

    @Override
    public int getPrice() {
        return price;
    }
}
