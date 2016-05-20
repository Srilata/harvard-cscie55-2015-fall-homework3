package cscie55.hw3;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
/**
 * @Author ssurabhi on 9/13/15.
 * @version 1.2
 */

public class Elevator {

    public static final int CAPACITY = 10;
    private int currentFloor = 1;
    private Direction direction = Direction.UP;
    private Building building;
    private Set<Passenger> passengersOnTheElevator;

    /*
     Elevator constructor with building as parameter
     */
    public Elevator(Building building){
        this.building = building;
        passengersOnTheElevator = new HashSet<Passenger>();
    }

    /*
       This method modifies the Elevator's state.
       It checks passengers on the elevator.
       If passengers destination floor is equals to elevators current floor then it removes passengers from the elevator.And calls arrive method on passenger.
       If the elevator is going up it modifies  passengersWaitingForElevatorGoingUp array list based on the capacity.
       If the elevator is going down it modifies  passengersWaitingForElevatorGoingDown array list based on the capacity.
      @param
     */
     public void move(){

        if(direction.equals(Direction.UP)) {
            currentFloor ++;
        }

        if(direction.equals(Direction.DOWN)) {
            currentFloor --;
        }

        if(currentFloor == 1){
            direction = Direction.UP;
        }

        if(currentFloor == Building.FLOORS){
            direction = Direction.DOWN;
        }

        Floor currentFloorObj = building.floor(currentFloor);

        Set<Passenger> passengersToRemove = new HashSet<Passenger>();
        for(Passenger passenger : passengersOnTheElevator){
            if (passenger.destinationFloor() == currentFloor) {
                passengersToRemove.add(passenger);
                passenger.arrive();
            }
        }
        passengersOnTheElevator.removeAll(passengersToRemove);
        currentFloorObj.getPassengerResidentOnTheFloor().addAll(passengersToRemove);

        if(goingUp()){
            if(!currentFloorObj.getPassengerWaitingForElevatorGoingUp().isEmpty()){
                int passengersThatCanBoard = CAPACITY-passengersOnTheElevator.size();
                List<Passenger> passengersEligibleToBoard = new ArrayList<Passenger>();
                if(currentFloorObj.getPassengerWaitingForElevatorGoingUp().size() >= passengersThatCanBoard) {
                    for(int i=0;i<passengersThatCanBoard;i++){
                        passengersEligibleToBoard.add(currentFloorObj.getPassengerWaitingForElevatorGoingUp().get(i));
                        currentFloorObj.getPassengerWaitingForElevatorGoingUp().get(i).boardElevator();
                    }
                    passengersOnTheElevator.addAll(passengersEligibleToBoard);
                    currentFloorObj.getPassengerWaitingForElevatorGoingUp().removeAll(passengersEligibleToBoard);
                }else {
                    passengersOnTheElevator.addAll(currentFloorObj.getPassengerWaitingForElevatorGoingUp());
                    currentFloorObj.getPassengerWaitingForElevatorGoingUp().clear();
                }
            }
        }

        if(goingDown()){
            if(!currentFloorObj.getPassengerWaitingForElevatorGoingDown().isEmpty()) {
                int passengersThatCanBoard = CAPACITY - passengersOnTheElevator.size();
                List<Passenger> passengersEligibleToBoard = new ArrayList<Passenger>();
                if (currentFloorObj.getPassengerWaitingForElevatorGoingDown().size() >= passengersThatCanBoard) {
                    for (int i = 0; i < passengersThatCanBoard; i++) {
                        passengersEligibleToBoard.add(currentFloorObj.getPassengerWaitingForElevatorGoingDown().get(i));
                        currentFloorObj.getPassengerWaitingForElevatorGoingDown().get(i).boardElevator();
                    }
                    passengersOnTheElevator.addAll(passengersEligibleToBoard);
                    currentFloorObj.getPassengerWaitingForElevatorGoingDown().removeAll(passengersEligibleToBoard);
                } else {
                    passengersOnTheElevator.addAll(currentFloorObj.getPassengerWaitingForElevatorGoingDown());
                    currentFloorObj.getPassengerWaitingForElevatorGoingDown().clear();
                }
            }
        }

}

    /*
    Return the elevator's current floor number. I.e., this is the number of the floor reached by the last call to Elevator.move()
    @param
    */
    public int currentFloor() {
        return currentFloor;
    }

    /*
    Return the number of passengers currently on the elevator
    @param
    */
    public Set<Passenger> passengers() {
        return passengersOnTheElevator;
    }

    /*Return true if the elevator is going up, false otherwise
     @param
     */
   public  boolean goingUp(){
       if(direction.equals(Direction.UP)){
           return true;
       }
       return false;
   }

    /*Return true if the elevator is going down, false otherwise
     @param
     */
    public  boolean goingDown(){
        if(direction.equals(Direction.DOWN)){
            return true;
        }
        return false;
    }


















}
