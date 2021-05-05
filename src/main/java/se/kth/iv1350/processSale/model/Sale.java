package se.kth.iv1350.processSale.model;

import java.util.ArrayList;
import java.util.List;
import se.kth.iv1350.processSale.integration.Item;

/**
 * One single sale made by one single customer and payed with one payment.
 * @author abdig
 */
public class Sale {
    private double runningTotal;
    private List<Item> items = new ArrayList<Item>();
    
    /**
     * Creates a new instance and...finish this comment!!!
     */
    public Sale() {
    
    }
    
    /**
     * Checks if an item with the same identifier already exists in the sale
     * and returns the Item if found, else null.
     * @param identifier The value used to find a match in the list of items.
     * @return Is the Item found or null, if it doesn't exist in the list of
     * items.
     */
    public Item checkIfItemInSale(int identifier){
        
        for(int i = 0; i < items.size(); i++)
        {
            Item item = items.get(i);
            if(item.getIdentifier() == identifier)
                return item;
        }
        return null;
    }
    
    /**
     * Adds an Item to the list of items of the current Sale.
     * @param item The item that should be added to the list of items.
     */
    public void addItemToSale(Item item)
    {
        this.items.add(item);
    }
    
    public double getRunningTotal(){
        return this.runningTotal;
    }
    
    public List<Item> getItems(){
        return this.items;
    }
    
    /**
     * Sets the runningTotal of the sale by retrieving the price and VATRate
     * of the last item entered into the list, and calculating the net price
     * and adding this to the runningTotal
     */
    public void setRunningTotal(){
        
        double price = this.items.get(items.size()-1).getPrice();
        double priceIncludingVAT = price * (1 + this.items.get(items.size()-1).getVATRate());
        
        this.runningTotal += priceIncludingVAT;
    }

    /**
     * Returns the difference of the amount paid and the sale's total amount. 
     * @param amount The amount that the Cashier entered as customer payment.
     * @return The difference between amount paid and the sale's final total
     * amount.
     */
    public double calculateChange(double amount) {
        return amount - this.getRunningTotal();
    }
}
