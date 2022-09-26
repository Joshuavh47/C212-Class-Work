package Queues;
import java.util.*;
public class AmusementParkExample {
    public static void main(String[] args) {
        Customer c1=new Customer("Josh", true);
        Customer c2=new Customer("Joe", false);
        Customer c3=new Customer("John", true);
        Customer c4=new Customer("Nick", false);
        Customer c5=new Customer("Jacob", true);
        Customer c6=new Customer("Sean", false);
        Customer c7=new Customer("Lauren", true);
        Customer c8=new Customer("Sarah", false);
        Customer c9=new Customer("Ben", true);
        Customer c10=new Customer("Jack", false);
        List<Customer> custList=new ArrayList<Customer>();
        custList.add(c1);
        custList.add(c2);
        custList.add(c3);
        custList.add(c4);
        custList.add(c5);
        custList.add(c6);
        custList.add(c7);
        custList.add(c8);
        custList.add(c9);
        custList.add(c10);
        Ride r1=new Ride("ride 1", 10, true);
        Ride r2=new Ride("ride 2", 10, false);
        r1.addToQueue(custList);
        r2.addToQueue(custList);
        List<Ride> ridesList=new ArrayList<Ride>();
        ridesList.add(r1);
        ridesList.add(r2);
        AmusementPark a1=new AmusementPark(ridesList);
        System.out.println("Stats before running queue: ");
        a1.printStats();
        r1.run();
        r2.run();
        System.out.println("Stats after running queue: ");
        a1.printStats();
    }
}
