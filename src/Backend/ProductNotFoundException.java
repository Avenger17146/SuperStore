package Backend;
/**
 *exception in database when product not found
 */
public class ProductNotFoundException extends Exception{

    public ProductNotFoundException()
    {
        super("Product not found");
    }
}
