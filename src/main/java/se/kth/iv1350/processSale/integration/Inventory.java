package se.kth.iv1350.processSale.integration;

import java.util.ArrayList;
import java.util.List;
import se.kth.iv1350.processSale.model.Sale;

/**
 *  Contains a list of all items that a customer can buy in a retails store.
 * @author abdig
 */
public class Inventory {
    private List<Item> items = new ArrayList<Item>();
    
    /**
     * Creates a new instance of the system's inventory. This is called from
     * startup. This is called once from startup and it creates an inventory 
     * of items.
     */
    public Inventory(){
        addItemsToInventory();
    }
    
    /**
     * Searches the inventory for the provided identifier and returns and item if found,
     * else null.
     * @param identifier Matches with a type of item, such as standard milk.
     */
    private void getItemDetails(int identifier){
        //Search inventory for item here
         
    }
    
    private void addItemsToInventory() {
        items.add(new Item(1, 5, 0.1, "Standard Milk", "Vitamin D Enriched Milk."));
        items.add(new Item(2, 7.2, 0.1, "Bread", "Whole Wheat Bread."));
        items.add(new Item(3, 3, 0.1, "Eggs", "12 Large Eggs."));
    }
    
    /**
     * Checks if an item with the same identifier already exists in the sale
     * and returns the Item if found, else null.
     * @param identifier The value used to find a match in the list of items.
     * @return Is the Item found or null, if it doesn't exist in the list of
     * items.
     */
    public Item checkIfItemInInventory(int identifier){
        
        for(int i = 0; i < items.size(); i++)
        {
            Item item = items.get(i);
            if(item.getIdentifier() == identifier)
                return item;
        }
        return null;
    }

    public void updateInventory(Sale sale) {
        // Should update Inventory
    }
    
}
