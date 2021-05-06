/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.processSale.integration;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.processSale.model.Sale;

/**
 *
 * @author abdig
 */
public class InventoryTest {
    private Inventory instanceToTest;
    
    @BeforeEach
    public void setUp() {
        instanceToTest = new Inventory();
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testCheckIfItemInInventory() {
        int identifier = 5; // no such identifier exists
        Item expResult = null;
        Item result = instanceToTest.checkIfItemInInventory(identifier);
        assertEquals(expResult, result, "Expected null, but received an object");
        
        identifier = 1; // does exist
        result = instanceToTest.checkIfItemInInventory(identifier);
        assertNotNull(result, "Received null but expected and object");
    }
    
}
