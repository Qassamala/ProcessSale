package se.kth.iv1350.processSale.view;

import se.kth.iv1350.processSale.controller.Controller;
import se.kth.iv1350.processSale.integration.Item;
import se.kth.iv1350.processSale.model.Sale;

/**
 * This is a placeholder for the real view. It contains a hard-coded execution with calls
 * to all system operations in the controller.
 * @author abdig
 */
public class View {
    private Controller controller;
    
    /**
     * Creates a new instance that uses the specified controller for all calls
     * to other layers.
     * @param controller The controller to use for all calls to other layers.
     */
    public View (Controller controller) {
        this.controller = controller;
    }
    
    /**
     * Performs a fake sale, by calling all system operations in the controller.
     */
    public void runFakeExecution() {
        controller.startSale();
        System.out.println("A new sale has been started.");
        
        addItemToSale(1);
        addItemToSale(1);
        addItemToSale(2);
        addItemToSale(4);
        addItemToSale(3);
        
        System.out.println("Ending sale...");
        System.out.println("Total sum for payment: " + controller.endSale());
        
        System.out.println("Entering amount 30 as payment...");
        double change = controller.enterAmountPaid(30);
        System.out.println("Change to give to customer: " + change);

    }
    
    private void addItemToSale(int identifier){
        System.out.println("Adding item with identifier " + identifier + " to sale...");
        Item item = controller.addItemToSale(identifier);
        
        if(item == null)
            System.out.println("Item could not be identified.");
        else
        {
            System.out.println("Item description: " + item.getDescription());
            System.out.println("Item price: " + item.getPrice());;
            System.out.println("Running Total is: " + controller.getSaleDetails());
        }
    }
}
