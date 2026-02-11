package models;

public class Product {
    private int id;
    private String name;
    private String description;
    private double price;
    private int stockQty;


    public Product(int id, String name, String description, double price, int stockQty) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stockQty = stockQty;
    }

    public Product(String name, String description, double price, int stockQty) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stockQty = stockQty;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getStockQty() {
        return stockQty;
    }

    @Override
    public String toString() {
        return String.format(
                "Product[ID: %d, Name: %s, Price: $%.2f, Stock: %d, Desc: %s]",
                id, name, price, stockQty, description
        );
    }
}
