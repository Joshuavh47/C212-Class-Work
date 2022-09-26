import java.util.*;
public class Receipt {
    private HashMap<Item, Integer> items;
    public Receipt(HashMap<Item, Integer> items) {
        this.items=items;
    }
    public void printReceipt(){

        for (Item i : items.keySet()) {
            System.out.println(items.get(i) + " " + i.getName() + "    Price: $" + (i.getPrice() * items.get(i)));
        }
    }
    public double getTotal(){
        double total=0;
        for(Item i:items.keySet()){
            total += i.getPrice() * items.get(i);
        }
        return total;
    }
}
