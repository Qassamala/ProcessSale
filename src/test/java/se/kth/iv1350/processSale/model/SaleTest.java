/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.processSale.model;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.processSale.integration.Inventory;
import se.kth.iv1350.processSale.integration.Item;

/**
 *
 * @author abdig
 */
public class SaleTest {
    
    private Sale instanceToTest;
    private Inventory helperInstance;
    
    @BeforeEach
    public void setUp() {
        
        helperInstance = new Inventory();
        instanceToTest = new Sale();
    }
    
    @AfterEach
    public void tearDown() {
        helperInstance = null;
        instanceToTest = null;
    }

    @Test
    public void testCheckIfItemInSale() {
        int identifier = 1; // no such identifier exists
        Item expResult = null;
        Item result = instanceToTest.checkIfItemInSale(identifier);
        assertEquals(expResult, result, "Expected null, but received an object");
        
        Item item = helperInstance.checkIfItemInInventory(identifier);
        instanceToTest.addItemToSale(item);
        result = instanceToTest.checkIfItemInSale(identifier);
        assertNotNull(result, "Received null but expected an object");
    }

    @Test
    public void testAddItemToSale() {
        
        int identifier = 2;
        Item item = helperInstance.checkIfItemInInventory(identifier);
        
        instanceToTest.addItemToSale(item);
        List<Item> items = instanceToTest.getItems();
        Item result = items.get(0);
        Item expResult = item;
        assertTrue(expResult == result, "Expected objects to be equal, but they were not");
    }

    @Test
    public void testSetRunningTotal() {
        //Adding the first item
        double oldRunningTotal = 0;
        int identifier = 2;
        Item item = helperInstance.checkIfItemInInventory(identifier);
        instanceToTest.addItemToSale(item);
        
        Item i = helperInstance.checkIfItemInInventory(identifier);
        double expectedPrice = 0 + (i.getPrice() * (1+i.getVATRate()));
        
        instanceToTest.setRunningTotal();
        double result = instanceToTest.getRunningTotal();
        
        assertTrue(expectedPrice == result, "First item added. Expected price is: " + expectedPrice + ", but was: " + result);
        
        // Adding another item
        identifier = 1;
        item = helperInstance.checkIfItemInInventory(identifier);
        instanceToTest.addItemToSale(item);
        
        i = helperInstance.checkIfItemInInventory(identifier);
        expectedPrice = (instanceToTest.getRunningTotal()) + (i.getPrice() * (1+i.getVATRate()));
        
        instanceToTest.setRunningTotal();
        result = instanceToTest.getRunningTotal();
        
        assertTrue(expectedPrice == result, "Second item added. Expected price is: " + expectedPrice + ", but was: " + result);
        
    }

    @Test
    public void testCalculateChange() {
        double amount = 30;
        
        int identifier = 1;
        Item item = helperInstance.checkIfItemInInventory(identifier);
        instanceToTest.addItemToSale(item);
        
        instanceToTest.setRunningTotal();
        double saleTotal = instanceToTest.getRunningTotal();
        double expResult = amount - saleTotal;
        
        double result = instanceToTest.calculateChange(amount);
        assertTrue(expResult == result, "Expected result is: " + expResult + ", but was: " + result);
    }
    
}
