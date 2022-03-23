package learn.data;

public class DataException extends Exception {

    public DataException( String message, Throwable inner ){
        super( message, inner );
    }

}
