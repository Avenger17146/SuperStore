package Backend;
/**
 *exception if quantity demanded is more than what is available
 */
public class UnavailableStockException extends Exception{

    public UnavailableStockException()
    {
        super("Quatity specified is not available");
    }
}
