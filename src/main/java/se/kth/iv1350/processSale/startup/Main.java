package se.kth.iv1350.processSale.startup;

import se.kth.iv1350.processSale.controller.Controller;
import se.kth.iv1350.processSale.integration.Accounting;
import se.kth.iv1350.processSale.integration.Inventory;
import se.kth.iv1350.processSale.integration.Printer;
import se.kth.iv1350.processSale.model.Register;
import se.kth.iv1350.processSale.model.Store;
import se.kth.iv1350.processSale.view.View;

/**
 * Starts the entire application.
 * @author abdig
 */
public class Main {
    /**
     * The main method used to start the entire application.
     * @param args The application does not take any command line parameters.
     */
    public static void main(String[] args) {
        
        Inventory inventory = new Inventory();
        Accounting accounting = new Accounting();
        Printer printer = new Printer();
        Register register = new Register();
        Store store = new Store();
        
        Controller controller = new Controller(inventory, accounting, printer, register, store);
        
        View view = new View(controller);
        view.runFakeExecution();
    }
    
}
