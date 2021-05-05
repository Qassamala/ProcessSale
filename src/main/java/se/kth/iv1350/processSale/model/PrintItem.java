package se.kth.iv1350.processSale.model;

import se.kth.iv1350.processSale.integration.Item;

/**
 *  This class represents an entry on a receipt that should contain
 *  Name, aggregated quantity and price for each item of a sale.This is created
 *  by the Receipt class
 * @author abdig
 */
public class PrintItem {
        private Item item;
        private int quantity;

        protected PrintItem(Item item) {
            this.item = item;
            this.quantity = 1;
        }
        
        public int getIdentifier()
        {
            return this.item.getIdentifier();
        }

        public double getPrice()
        {
            return this.item.getPrice();
        }
        
        /**
         * This is called the k:th time(where k is > 1), whenever an item
         * identifier already exists in the list of items of the sale.
         * 
         */
        public void setQuantity()
        {
            this.quantity +=1;
        }  
        
        /**
         * This is used to create a string of the values of Printitem
         * @return The printItems values that should be printed
         */
        public String toString() { 
            return "Name: '" + this.item.getName() + "', Quantity: '" + this.quantity + "', Price: '" + this.item.getPrice() + "'";
        } 
        
    }
