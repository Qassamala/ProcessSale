package se.kth.iv1350.processSale.model;

/**
 * Represents the physical register that contains an amount that is increased 
 * by the amount of a finished sale. Only created once on system startup.
 * @author abdig
 */
public class Register {
    private double amount = 100;
    
    public Register()
    {
    
    }
    
    /**
     * Increases the amount in the register with the amount of the sale
     * @param amount The total amount of a finished sale.
     */
    public void increaseRegisterAmount(double amount)
    {
        this.amount += amount;
    }
    
    public double getAmount(){
        return this.amount;
    }
    
}
