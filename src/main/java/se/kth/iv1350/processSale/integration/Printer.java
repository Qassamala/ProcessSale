package se.kth.iv1350.processSale.integration;

import java.util.ArrayList;
import java.util.List;
import se.kth.iv1350.processSale.model.PrintItem;
import se.kth.iv1350.processSale.model.Receipt;

/**
 * Responsible for printing a receipt of the customer's purchase at a retail
 * store according to a specified format.
 * @author abdig
 */
public class Printer {
    
    public Printer()
    {
    
    }
    /**
     * This method prints the receipt for the customer.
     * @param receipt 
     */
    public void print(Receipt receipt){
        System.out.println("Printing receipt...");
        System.out.println("Time of sale: " + receipt.getTimeOfSale());
        System.out.println("Store name: " + receipt.getStore().getName());
        System.out.println("Store address: " + receipt.getStore().getAddress());
        
        System.out.println("List of items below:");
        List<PrintItem> items = receipt.getPrintItems();
        for (PrintItem printItem : items) 
        { 
            System.out.println(printItem.toString());
        }
        
        
    }

    
    
}