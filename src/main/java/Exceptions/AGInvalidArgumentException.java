package Exceptions;

/**
 * Exception that is throws for invalid inputs.
 *
 * @author hvy
 * @version 1.0
 */
public class AGInvalidArgumentException extends Exception {

    public AGInvalidArgumentException(String message) {
        super(message);
    }
}
