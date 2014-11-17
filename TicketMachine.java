/**
 * TicketMachine models a ticket machine that issues
 * flat-fare tickets.
 * The price of a ticket is specified via the constructor.
 * Instances will check to ensure that a user only enters
 * sensible amounts of money, and will only print a ticket
 * if enough money has been input.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class TicketMachine
{
    // The price of a ticket from this machine.
    private int price;
    // The price of a ticket with discount
    private float price2;
    // The amount of money entered by a customer so far.
    private float balance;
    // The total amount of money collected by this machine.
    private float total;
    // True if the machine has discount
    private boolean discounted;
    
   
    
    /**
     * Create a machine that issues tickets of the given price. Put 0 in discount for no discount
     */
    public TicketMachine(int cost, float descuento )
    {
        price = cost;
        balance = 0;
        total = 0;
        if (descuento == 0.0f){
            discounted = false;      
        }
        
        else if (descuento>0){
            discounted=true;
            price2=price*(100-descuento)/100;
        }
    }

    /**
     * @Return The price of a ticket.
     */
    public int getPrice()
    {
        return price;
    }

    /**
     * Return The amount of money already inserted for the
     * next ticket.
     */
    public float getBalance()
    {
        return balance;
    }

    /**
     * Receive an amount of money from a customer.
     * Check that the amount is sensible.
     */
    public void insertMoney(int amount)
    {
        if(amount > 0) {
            balance = balance + amount;
        }
        else {
            System.out.println("Use a positive amount rather than: " +
                               amount);
        }
    }
    
    public void printTicket()
    {
        if(balance >= price) {
            // Simulate the printing of a ticket.
            System.out.println("##################");
            System.out.println("# The BlueJ Line");
            System.out.println("# Ticket");
            System.out.println("# " + price + " cents.");
            System.out.println("##################");
            System.out.println();

            // Update the total collected with the price.
            total = total + price;
            // Reduce the balance by the prince.
            balance = balance - price;
        }
            else {
            float amountLeftToPay=price-balance;
            System.out.println("You must insert at least: " +
                               amountLeftToPay + " more cents.");
                               
        }
    }
    
    /**
     * Imprime un ticket con 10% de descuento si la maquina tiene descuento.
     */
    public void printTicketD()
    {
        if ((balance >= price2 && discounted)) {
            // Simulate the printing of a ticket.
            System.out.println("##################");
            System.out.println("# The BlueJ Line");
            System.out.println("# Ticket");
            System.out.println("# " + price2 + " cents.");
            System.out.println("##################");
            System.out.println();
            total = total + price2;
            balance = balance - price2;
        }
        
        else if (!discounted) {
            System.out.println("This machine doesn't have any discount");
        }
            
        else {
            float amountLeftToPay=price2-balance;
            System.out.println("You must insert at least: " +
                               amountLeftToPay + " more cents.");   
                               
        }
         
    }                       
    
    /**
     * Return the money in the balance.
     * The balance is cleared.
     */
    public float refundBalance()
    {
        float amountToRefund;
        amountToRefund = balance;
        balance = 0;
        return amountToRefund;
    }
    
    public float getAmountLeftToPay()
    {
         float AmountLeftToPay;
         AmountLeftToPay = price-balance;
         return AmountLeftToPay;

    }
    
    public float emptyMachine()
    {
        float totalMoney;
        totalMoney=balance+total;
        balance=0;
        total=0;
        return totalMoney;
    }
}
