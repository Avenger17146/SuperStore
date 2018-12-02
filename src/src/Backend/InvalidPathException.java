package Backend;

public class InvalidPathException extends Exception {
    public InvalidPathException()
    {
        super("The path provided is invalid");
    }
}
