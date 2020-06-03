package products;

public class TyresChange implements Service {

    private int price = 200;

    public void perform() {
        System.out.println("Tyres have been changed!");
    }

    @Override
    public int getPrice() {
        return price;
    }
}
