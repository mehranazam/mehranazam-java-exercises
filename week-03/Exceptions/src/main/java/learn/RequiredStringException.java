package learn;

public class RequiredStringException extends RuntimeException{
    public RequiredStringException(String message){
        super(message);
    }
}
