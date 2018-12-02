package Backend;

public class InsufficientFundsException extends Exception {
    public InsufficientFundsException()
    {
        super("Insufficient funds for Checkout");
    }
}
