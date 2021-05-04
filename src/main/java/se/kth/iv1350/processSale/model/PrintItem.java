package se.kth.iv1350.processSale.model;

/**
 *  This class represents an entry on a receipt that should contain
 *  Name, aggregated quantity and price for each item of a sale.
 * @author abdig
 */
public class PrintItem {
        private int identifier;
        private int quantity;
        private String name;
        private double price;

        protected PrintItem(int identifier, String name, double price) {
            this.identifier = identifier;
            this.quantity = 1;
            this.name = name;
            this.price = price;
        }
        
        public int getIdentifier()
        {
            return this.identifier;
        }

        public double getPrice()
        {
            return this.price;
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
            return "Name: '" + this.name + "', Quantity: '" + this.quantity + "', Price: '" + this.price + "'";
        } 
        
    }
