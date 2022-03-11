package auxiliars;

public class PostgresException extends Exception {
    public PostgresException() {}

    public PostgresException(String message) {
        super(message);
    }

    public PostgresException(String message, Throwable cause) {
        super(message, cause);
    }
}
