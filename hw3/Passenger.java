package cscie55.hw3;

/**
 * @Author ssurabhi on 10/15/15.
 * @version 1.0
 */
public class Passenger {

    private int id;
    private int currentFloor =1;
    private int destinationFloor;
    public static final int UNDEFINED_FLOOR = -1;

    /*
    Passenger constructor with id as parameter
    */
    public Passenger(int id){
        this.id = id;
    }

    /*
   The Passenger's current floor
   @param
   */
   public int currentFloor(){
       return currentFloor;
   }

  /*
  The Passenger's destinationFloor
  @param
  */
   public int destinationFloor(){
       return destinationFloor;
   }

    /*
    Sets the Passenger's destination floor to newDestinationFloor
     @param
    */
   public void waitForElevator(int newDestinationFloor){
       destinationFloor = newDestinationFloor;
    }

   /*Sets the Passenger's current floor to be undefined
    @param
    */
   public void boardElevator(){
        currentFloor = UNDEFINED_FLOOR;
    }

   /*The Passenger is on an elevator and arrives at his or her destination*/
    public void arrive(){
        currentFloor= destinationFloor;
        destinationFloor = UNDEFINED_FLOOR;
    }

    @Override
    public String toString(){
        return "CurrentFloor: "+ currentFloor+",DestinationFloor: "+destinationFloor;
    }
}
