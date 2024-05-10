package ExceptionCodeWrite.UserSystem;

public class UsernameAlreadyExistsException extends Exception{
    public UsernameAlreadyExistsException() {
    }

    public UsernameAlreadyExistsException(String message) {
        super(message);
    }
}
