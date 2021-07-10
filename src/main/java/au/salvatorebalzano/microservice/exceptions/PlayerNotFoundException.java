package au.salvatorebalzano.microservice.exceptions;

public class PlayerNotFoundException extends Exception {
    public PlayerNotFoundException() {
        super("Player not found");
    }
}
