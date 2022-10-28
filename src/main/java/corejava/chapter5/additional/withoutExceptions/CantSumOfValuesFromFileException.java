package corejava.chapter5.additional.withoutExceptions;

public class CantSumOfValuesFromFileException extends RuntimeException{
    public CantSumOfValuesFromFileException( String message, Throwable cause) {
        super(message, cause);
    }
}
