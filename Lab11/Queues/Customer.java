package Queues;

public class Customer implements Comparable<Customer>{
    private String name;
    private boolean fastPass;
    public Customer(String name, boolean fastPass){
        this.name=name;
        this.fastPass=fastPass;
    }
    public String getName(){
        return name;
    }
    public boolean hasFastPass(){
        if(fastPass){
            return true;
        }
        return false;
    }
    @Override
    /**
     * @param o the customer to compare
     * @return the place the customer would have in the PriorityQueue
     */
    public int compareTo(Customer o) {
        //comparator for the priority queue
        if(hasFastPass()&&!o.hasFastPass()){
            return -1;
        }
        else if(!hasFastPass()&&o.hasFastPass()){
            return 1;
        }
        return 0;
    }
    public String toString(){
        return "Customer name: "+name+", Fastpass: "+fastPass;
    }

}
