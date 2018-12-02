package Backend;

public class UnavailableStockException extends Exception{
    public UnavailableStockException()
    {
        super("Quatity specified is not available");
    }
}
