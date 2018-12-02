package Backend;
/**
 *exception for creating a product that already exists
 */
public class ProductAlredayExistsException extends Exception {

    public ProductAlredayExistsException()
    {
        super("Product Already Exists");
    }
}
