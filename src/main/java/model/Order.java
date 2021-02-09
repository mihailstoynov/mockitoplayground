package model;

public class Order {
    private String name;
    private int amount;
    private boolean filled;

    public Order(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean isFilled() {
        return filled;
    }

    public void fill(Warehouse warehouse) {
        int available = warehouse.getInventory(name);
        if (available > amount) {
            warehouse.setInventory(this.name, available - amount);
            this.filled = true;
        }
    }
}
