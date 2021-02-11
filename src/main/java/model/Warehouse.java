package model;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private Map<String, Integer> inventory = new HashMap<>();
    public Integer getInventory(String item) {
        return inventory.get(item);
    }

    public void setInventory(String item, int amount) {
        if(amount < 0 )
            throw new RuntimeException("amount is negative");
        this.inventory.put(item, amount);
    }
}


