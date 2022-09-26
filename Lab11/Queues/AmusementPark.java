package Queues;
import java.util.*;

public class AmusementPark {
    private List<Ride> ridesList;
    public AmusementPark(List<Ride> ridesList){
        this.ridesList=ridesList;
    }
    public AmusementPark(){
        this.ridesList=new ArrayList<Ride>();
    }

    /**
     *
     * @param r adds a ride to the list of rides in the amusement park
     */
    public void addRide(Ride r){
        ridesList.add(r);
    }

    /**
     *
     * @param r each ride in a given list of rides to the list of rides in the amusement park
     */
    public void addRide(List<Ride> r){
        for(Ride ride:r){
            ridesList.add(ride);
        }
    }
    public void printStats(){

        for(Ride r:ridesList){
            r.info();
        }

    }
}
