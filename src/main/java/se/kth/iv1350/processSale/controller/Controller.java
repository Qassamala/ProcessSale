package se.kth.iv1350.processSale.controller;

import se.kth.iv1350.processSale.integration.Accounting;
import se.kth.iv1350.processSale.integration.Inventory;
import se.kth.iv1350.processSale.integration.Item;
import se.kth.iv1350.processSale.integration.Printer;
import se.kth.iv1350.processSale.model.Receipt;
import se.kth.iv1350.processSale.model.Register;
import se.kth.iv1350.processSale.model.Sale;
import se.kth.iv1350.processSale.model.Store;

/**
 *  This is the application's only controller. All calls to the model pass
 * through this class.
 * @author abdig
 */
public class Controller {
    private Sale sale;
    private Inventory inventory;
    private Accounting accounting;
    private Printer printer;
    private Register register;
    private Store store;
    
    public Controller (Inventory inventory, Accounting accounting, Printer printer, Register register, Store store){
        this.inventory = inventory;
        this.accounting = accounting;
        this.printer = printer;
        this.register = register;
        this.store = store;
    }
    
    /**
     * Starts a new sale. This method must be called before doing anything else
     * during a sale.
     */
    public void startSale() {
        sale = new Sale();
    }
    
    /**
     * First checks if an item with the same identifier exists in the sale, if
     * not, it checks if an item with the identifier exists in the inventory. If
     * still not found, the item returned is null and the View will handle that
     * present and errorMessage. If item was found either in the sale or 
     * inventory it will be added to the sale and returned to the view.
     * @param identifier The value used to find a matching item.
     * @return Is either a successfully identified item or null.
     */
    public Item addItemToSale(int identifier){
        System.out.println("Checking in sale...");
        Item item = sale.checkIfItemInSale(identifier);
        
        if(item == null)
        {
            System.out.println("Checking in inventory...");
            item = inventory.checkIfItemInInventory(identifier);
        }

        if(item != null)
        {
            sale.addItemToSale(item);
            sale.setRunningTotal();
        }
        
        return item;
    }
    
    /**
     * Can be rewritten, return sale object or just primitive value?
     * @return 
     */
    public double getSaleDetails(){
        
        return sale.getRunningTotal();
    }
    
    public double endSale(){
        return this.getSaleDetails();
    } 

    public double enterAmountPaid(double amount) {
        double change = sale.processPayment(amount);
        // Log completed sale???
        
        accounting.bookSale(sale);
        inventory.updateInventory(sale);
        register.increaseRegisterAmount(sale.getRunningTotal());
        Receipt receipt = new Receipt(sale, store, amount, change);
        printer.print(receipt);
        
        return change;
    }
    
    
    
}
