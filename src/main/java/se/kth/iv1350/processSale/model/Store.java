package se.kth.iv1350.processSale.model;

/**
 * Holds the name and address of the retail store that is processing a sale 
 * @author abdig
 */
public class Store {
    private final String name = "TIDAB2020";
    private final String address = "Isafjordsgatan 22, 164 40 Kista";
    
    public Store()
    {
        
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getAddress(){
        return this.address;
    }
            
    
}

