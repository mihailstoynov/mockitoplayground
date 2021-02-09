package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TraditionalOrderUnitTest {
    private Warehouse wh;

    @BeforeEach
    public void setUp() {
        wh = new Warehouse(); // Maybe a database connection here or other dependencies
        wh.setInventory("Lagavulin", 10);
        wh.setInventory("Absinthe 55", 100);
    }

    @Test
    public void testOrderFilling() {
        Order order = new Order("Lagavulin", 5);
        order.fill(wh);
        assertTrue(order.isFilled());
        assertEquals(5, wh.getInventory("Lagavulin"));
    }
}
