package se.kth.iv1350.processSale.model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import se.kth.iv1350.processSale.integration.Item;

/**
 * Creates a receipt with information about the sale that will be sent
 * to the printer for printing.
 * @author abdig
 */
public class Receipt {
    private LocalTime timeOfSale;
    private Store store;
    private List<PrintItem> printItems = new ArrayList<PrintItem>();
    private Sale sale;
    
    public Receipt(Sale sale, Store store){
        timeOfSale = LocalTime.now();
        this.store = store;
        this.sale = sale;
        createPrintItems();
    }
    
    public LocalTime getTimeOfSale()
    {
        return this.timeOfSale;
    }
    
    public Store getStore()
    {
        return this.store;
    }
    
    public Sale getSale(){
        return this.sale;
    }
    
    public List<PrintItem> getPrintItems(){
        return this.printItems;
    }
    
    private void createPrintItems()
    {
        List<Item> items = sale.getItems();
        
        for(int i = 0; i < items.size(); i++)
        {
            int identifier = items.get(i).getIdentifier();
            // Search if printItem exists
            PrintItem printItem = null;
            
            for (PrintItem p : printItems) {
                if (identifier == p.getIdentifier()) {
                    printItem = p;
                }
            }
            
            if(printItem != null)
            {
                for(int j = 0; j < printItems.size(); j++)
                {
                    if(printItems.get(j).getIdentifier() == identifier)
                        printItems.get(j).setQuantity();
                }
            }
            else
                printItems.add(new PrintItem(identifier, items.get(i).getName(), items.get(i).getPrice() ));
        }
    }
    
}
