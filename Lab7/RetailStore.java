import java.util.*;
public class RetailStore {
    private String name;
    private ArrayList<Customer> custs;
    private HashMap<Item, Integer> items;

    public RetailStore(String name) {
        this.name = name;
        custs = new ArrayList<Customer>();
        items=new HashMap<Item, Integer>();
        RetailDriver.stores.add(this);
    }
    public String getName(){
        return name;
    }
    public Item getItem(String s){
        for(Item i:items.keySet()){
            if(i.getName().equalsIgnoreCase(s)){
                return i;
            }
        }
        return null;
    }
    public boolean containsItem(String s){
        for(Item i:items.keySet()){
            if(i.getName().equalsIgnoreCase(s)){
                return true;
            }
        }
        return false;
    }
    public int getValue(Item i){
        return items.get(i);
    }
    public void setName(String s){
        name=s;
    }
    public int amountOfCustomers(){
        return custs.size();
    }
    public void addItems(Item item, int amount){
        if (items.containsKey(item)){
            items.replace(item, items.get(item)+amount);
        }
        else{
            items.put(item, amount);
        }

    }
    public boolean removeItems(Item item, int amount){
        if (items.containsKey(item)&&items.get(item)>(amount)){
            items.replace(item, items.get(item)-amount);
            return true;
        }
        else if(items.containsKey(item)&&items.get(item)==amount){
            items.replace(item, 0);
            return true;
        }
        else if(items.containsKey(item)&&items.get(item)<amount){
            System.out.println("Not enough "+item.getName()+"s!");
            return false;
        }
        return false;
    }
    public void addCustomer(Customer c){
        custs.add(c);
    }
    public void removeCustomer(Customer c){
        custs.remove(c);
    }
    public void groceryMenu(Customer c){
        int count=1;
        System.out.println();
        System.out.println("Your budget: $"+c.getBudget());
        for (Item i:items.keySet()){
            System.out.println(count+". "+i.getName()+"    Quantity: "+items.get(i));
            count++;
        }
        c.shop();
    }

}
