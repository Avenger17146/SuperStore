package Backend;

public class ProductAlredayExistsException extends Exception {
    public ProductAlredayExistsException()
    {
        super("Product Already Exists");
    }
}
