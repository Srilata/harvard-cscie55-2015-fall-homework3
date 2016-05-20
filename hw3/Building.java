package cscie55.hw3;

/**
 * @Author ssurabhi on 10/3/15.
 * @version 1.1
 */

public class Building {

    private Elevator elevator;
    private Floor[] floors;
    public static final int FLOORS = 7;

    /*The Building constructor creates an Elevator, and one floor for each floor number.*/
    public Building(){
        elevator = new Elevator(this);
            floors = new Floor[FLOORS+1];
            for (int i=0; i<FLOORS+1; i++) {
                floors[i] = new Floor(this,i);
            }
        }

    /*Returns the building's Elevator
     @param
    */
    public Elevator elevator() {
        return elevator;
    }

   /*
   Returns the Floor object for the given floor number
   @param floorNumber
    */
   public Floor floor(int floorNumber){
       return floors[floorNumber];
   }

   /*Simply calls Floor.enterGroundFloor(passenger) for the Floor representing the ground floor
    @param passenger
    */
   public void enter(Passenger passenger){
       floor(1).enterGroundFloor(passenger);
   }

}
