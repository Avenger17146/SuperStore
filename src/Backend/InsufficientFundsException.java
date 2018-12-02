package Backend;

public class InsufficientFundsException extends Exception {
    /**
     *exception for insufficient funds
     */
    public InsufficientFundsException()
    {
        super("Insufficient funds for Checkout");
    }
}
