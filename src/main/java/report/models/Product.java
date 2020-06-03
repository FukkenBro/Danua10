package report.models;

public class Product {

    private int price;
    private String productName;

    public Product(int price, String productName) {
        this.price = price;
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public String getProductName() {
        return productName;
    }

}
