package cscie55.hw3;

/**
 * Created by ssurabhi on 10/3/15.
 */
public class ElevatorFullException extends Exception{

    ElevatorFullException(String msg)
    {
        super("ElevatorFullException thrown: " + msg);
    }
}
