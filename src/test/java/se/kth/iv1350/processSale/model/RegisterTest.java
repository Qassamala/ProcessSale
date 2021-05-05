/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.processSale.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.processSale.view.View;

/**
 *
 * @author abdig
 */
public class RegisterTest {
    private Register instanceToTest;
    
    public RegisterTest() {
    }
    
    @BeforeEach
    public void setUp() {
        instanceToTest = new Register();
    }
    
    @AfterEach
    public void tearDown() {
        instanceToTest = null;
    }

    @Test
    public void testIncreaseRegisterAmount() {
        double amount = 20.4;
//        Register instance = new Register();
        double initialAmount = instanceToTest.getAmount();
        instanceToTest.increaseRegisterAmount(amount);
        double expected = initialAmount + amount;
        double actual = instanceToTest.getAmount();
        assertEquals(expected, actual, "Value should be: " + expected + ", but was: " + actual);
    }
    
}
