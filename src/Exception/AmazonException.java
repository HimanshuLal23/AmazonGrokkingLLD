package Exception;
import Exception.ExceptionType;

public class AmazonException extends Exception{
    private ExceptionType exceptionType;

    public AmazonException(String message, ExceptionType exceptionType) {
        super(message);
        this.exceptionType = exceptionType;
    }

    public AmazonException() {

    }

    public String getMessage() {
        return super.getMessage();
    }
}
