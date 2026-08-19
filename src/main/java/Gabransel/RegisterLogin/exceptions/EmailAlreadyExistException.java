package Gabransel.RegisterLogin.exceptions;

public class EmailAlreadyExistException extends RuntimeException {
    public EmailAlreadyExistException(String message) {
        super("Email already exists: " + message);
    }
}
