package model;

import model.Warehouse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MockitoOrderUnitTest {


    @Test
    void testOrderFillingWithStubbedWarehouse() {
        // setup
        Warehouse wh = mock(Warehouse.class); // mock an object
        when(wh.getInventory("Lagavulin")).thenReturn(10);// add some behaviour: when getInventory is called, return 10 (aka "stubbing")

        // exercise
        Order order = new Order("Lagavulin", 2);
        order.fill(wh);

        // verify (behavioral verification)
        InOrder inOrder = inOrder(wh); // we care about execution order
        inOrder.verify(wh).getInventory("Lagavulin");// we check whether the getInventory() method was executed 'Lagavulin' as parameter
        inOrder.verify(wh).setInventory("Lagavulin",8);// we check whether the setInventory() method was executed with ("Lagavulin",8)
        assertTrue(order.isFilled());
    }

    @Mock private Warehouse wh;

    @Test
    void testOrderFillingWontRemoveIfNotEnoughInStock(@Mock Warehouse wh) {
//        Warehouse wh = mock(Warehouse.class);

        // stubbing
        when(wh.getInventory("Lagavulin")).thenReturn(10);

        Order order = new Order("Lagavulin", 20);
        order.fill(wh);

        verify(wh).getInventory("Lagavulin");
        verify(wh, times(0)).setInventory(anyString(), anyInt());
        }
}
