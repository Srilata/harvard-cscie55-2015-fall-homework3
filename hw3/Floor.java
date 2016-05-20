package cscie55.hw3;

import java.util.List;
import java.util.ArrayList;

/**
 * @Author ssurabhi on 10/3/15.
 * @version 1.1
 */

public class Floor {

   private int floorNumber;
   private Building building;
   private List<Passenger> passengersResidentOnTheFloor;
   private List<Passenger> passengersWaitingForElevatorGoingUp;
   private List<Passenger> passengersWaitingForElevatorGoingDown;

    /* The floor constructor with building and floorNumber parameter*/
    public Floor(Building building, int floorNumber){
          this.floorNumber = floorNumber;
          this.building = building;
          passengersResidentOnTheFloor = new ArrayList<Passenger>();
          passengersWaitingForElevatorGoingUp = new ArrayList<Passenger>();
          passengersWaitingForElevatorGoingDown = new ArrayList<Passenger>();

    }

    /*
  This allows the Floor to know which Passenger is waiting for the Elevator. And by comparing destinationFloor to the floor number,
   the Floor class knows whether the Passenger is waiting to go up or down
    @param
    */
    public void waitForElevator(Passenger passenger, int destinationFloor){
        passenger.waitForElevator(destinationFloor);

        if(destinationFloor > floorNumber){
            setPassengerWaitingForElevatorGoingUp(passenger);
            if(isResident(passenger)){
                passengersResidentOnTheFloor.remove(passenger);
            }
        }else if(destinationFloor < floorNumber){
            setPassengerWaitingForElevatorGoingDown(passenger);
            if(isResident(passenger)){
                passengersResidentOnTheFloor.remove(passenger);
            }
        }
       }

    /* It retrieves all the passengers residents on the floor
    @param
     */
    protected List<Passenger> getPassengerResidentOnTheFloor(){
        return passengersResidentOnTheFloor;
    }

    /* It sets the passengers residents on the floor
   @param
    */
    private void setPassengerResidentOnTheFloor(Passenger passengerResidentOnTheFloor){
        passengersResidentOnTheFloor.add(passengerResidentOnTheFloor);
    }

    /* It retrieves all the passengers waiting on the floor to go up
     @param
      */
    protected List<Passenger> getPassengerWaitingForElevatorGoingUp(){
        return passengersWaitingForElevatorGoingUp;
    }

    /* It retrieves all the passengers waiting on the floor to go down
    @param
     */
    protected List<Passenger> getPassengerWaitingForElevatorGoingDown(){
        return passengersWaitingForElevatorGoingDown;
    }

    /* It sets the passengers waiting for the elevator going up
   @param passengerGoingUp
    */
    private void setPassengerWaitingForElevatorGoingUp(Passenger passengerGoingUp){
        passengersWaitingForElevatorGoingUp.add(passengerGoingUp);
    }

    /* It sets the passengers waiting for the elevator going down
    @param passengerGoingDown
  */
    private void setPassengerWaitingForElevatorGoingDown(Passenger passengerGoingDown){
        passengersWaitingForElevatorGoingDown.add(passengerGoingDown);
    }

    /*
     which returns true if the passenger is resident on the Floor, (i.e., not waiting to go up and not waiting to go down), false otherwise
     @param passenger
     */
    public boolean isResident(Passenger passenger){
        if(passengersResidentOnTheFloor.contains(passenger)) {
            return true;
        }
        return false;
    }

    /*This method adds a passenger to the Floor's residents.
     @param passenger
     */
    public void enterGroundFloor(Passenger passenger){
        setPassengerResidentOnTheFloor(passenger);
    }
 }


