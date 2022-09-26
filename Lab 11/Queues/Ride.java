package Queues;

import java.util.*;
public class Ride {
    private String name;
    private int maxCapacity;
    private int currentCapacity;
    private Queue<Customer> queue;
    private boolean supportsFastPass;

    public Ride(String name,  int maxCapacity, boolean supportsFastPass) {
        this.name=name;
        this.maxCapacity=maxCapacity;
        if(queue==null) {
            this.currentCapacity = 0;
        }
        else{
            this.currentCapacity=queue.size();
        }
        if(supportsFastPass) {
            this.queue = new PriorityQueue<Customer>(maxCapacity);
        }
        else{
            this.queue=new ArrayDeque<>(maxCapacity);
        }
        this.supportsFastPass=supportsFastPass;
    }
    public void info(){
        Iterator<Customer> it=queue.iterator();
        if(queue!=null&&queue.size()!=0) {
            System.out.println("Ride name: " + name +", Accepts Fastpass: "+supportsFastPass + ", Current capacity: " + currentCapacity + ", Max capacity: " + maxCapacity + ", People in queue: " + queue.size() + "\n");
            System.out.println(name+" queue: \n");
            while(it.hasNext()){
                System.out.println(it.next().toString());
            }
            System.out.println();


        }
        else {
            System.out.println("Ride name: " + name + ", Current capacity: " + currentCapacity + ", Max capacity: " + maxCapacity + ", People in queue: 0");
            System.out.println("No one left in queue...\n");
        }

    }
    public void run(){
        ArrayList<Customer> custArray = new ArrayList<Customer>();
        //removes each customer from the queue and adds them to the ride as long as the max capacity isn't reached and
        //there are still people in the queue
        while(!queue.isEmpty()&&currentCapacity<maxCapacity){
            custArray.add(queue.remove());
            currentCapacity++;
        }
        System.out.println(name+" boarding list: \n");
        String temp="";
        for(Customer c:custArray){
            temp+=c.getName()+", Fast Pass: "+c.hasFastPass()+"\n";
        }
        System.out.println(temp);
    }

    /**
     *
     * @param l the list of customers to add to the queue
     */
    public void addToQueue(List<Customer> l){
        ArrayList<Customer> fastPassArr = new ArrayList<Customer>();
        ArrayList<Customer> regularArr=new ArrayList<Customer>();
        //in the case that the code didn't use a priority queue and the ride accepted fastpasses, it would still put
        //the customers in the correct order
        if(supportsFastPass) {
            while (!queue.isEmpty()) {
                if (queue.peek().hasFastPass()) {
                    fastPassArr.add(queue.remove());
                } else {
                    regularArr.add(queue.remove());
                }
            }
            for (Customer c : l) {
                if (c.hasFastPass()) {
                    fastPassArr.add(c);
                } else {
                    regularArr.add(c);
                }
            }
            for (Customer c : fastPassArr) {
                queue.add(c);
            }
            for (Customer c : regularArr) {
                queue.add(c);
            }
        }
        else{
            for(Customer c:l){
                queue.add(c);
            }
        }
    }
}
