package Backend;

public class InvalidPathException extends Exception {
    /**
     *exception for invalid path in database
     */
    public InvalidPathException()
    {
        super("The path provided is invalid");
    }
}
