import java.util.*;
public class Customer {
    private String name;
    private double budget;
    private boolean wearingMask;
    private HashMap<Item, Integer> cart;
    private RetailStore store;

    public Customer(String name, double budget, boolean wearingMask){
        this.name = name;
        this.budget = budget;
        this.wearingMask = wearingMask;
        cart=new HashMap<Item, Integer>();
        RetailDriver.customers.add(this);
    }
    public String getName() {
        return name;
    }
    public double getBudget() {
        return budget;
    }
    public boolean isWearingMask() {
        return wearingMask;
    }
    public void setName(String n){
        name=n;
    }
    public void setBudget(double b){
        budget=b;
    }
    public void setWearingMask(boolean w){
        wearingMask=w;
    }
    public void setStore(RetailStore r){
        store=r;
    }
    public HashMap<Item, Integer> getCart(){
        return cart;
    }
    public int getCartSize(){
        return cart.size();
    }
    public void addToCart(Item item, int amount){
        if(store.removeItems(item, amount)&&item.getPrice()*amount<=budget){
            budget-= item.getPrice()*amount;
            cart.put(item, amount);
        }
        else if(store.removeItems(item, amount)&&item.getPrice()*amount>budget){
            System.out.println("You don't have enough money to add these to your cart");
        }
        else if (!store.removeItems(item, amount)){
            System.out.println("There aren't enough "+ item.getName() +"s in stock!");
        }
    }
    public void removeFromCart(Item item, int amount){
        if(cart.containsKey(item)&&amount<cart.get(item)){
            store.addItems(item, amount);
            cart.replace(item, cart.get(item)-amount);
            budget+=item.getPrice()*amount;
        }
        else if(cart.containsKey(item)&&amount==cart.get(item)){
            store.addItems(item, amount);
            cart.remove(item);
            budget+=item.getPrice()*amount;
        }
        else if(cart.containsKey(item)&&amount>cart.get(item)){
            System.out.println("There aren't "+amount+" "+item.getName()+"s in your cart.\nRemoving "+cart.get(item)+" "+item.getName()+"s instead.");
            store.addItems(item, amount);
            budget+= item.getPrice()*cart.get(item);
            cart.remove(item);
        }
    }
    public void shop(){
        Scanner scanString = new Scanner(System.in);
        Scanner scanInt = new Scanner(System.in);
        System.out.print("Type the name of an item to put it in your cart.\nType back to go back to the main menu.\nType \"view cart\" to view your cart: ");
        String nameOfItem = scanString.nextLine();
        if(nameOfItem.equalsIgnoreCase("back")){
            RetailDriver.menu();
            store=null;
        }
        else if(nameOfItem.equalsIgnoreCase("view cart")){
            viewCart();
        }
        else if(!store.containsItem(nameOfItem)){
            System.out.println("Item not found!");
            store.groceryMenu(this);
        }

        else{
            System.out.print("How many "+store.getItem(nameOfItem).getName()+"s would you like?: ");
            int numberOfItems = scanInt.nextInt();
            if(store.getValue(store.getItem(nameOfItem))-numberOfItems<0){
                System.out.println();
                System.out.println("Not enough "+store.getItem(nameOfItem).getName()+"s in stock!");
                store.groceryMenu(this);
            }
            else {
                addToCart(store.getItem(nameOfItem), numberOfItems);
                System.out.println();
                System.out.print(numberOfItems + " " + store.getItem(nameOfItem).getName() + "s added to cart!\n");
                store.groceryMenu(this);
            }
        }
    }
    public void viewCart(){
        double total=0;
        Scanner scanInt=new Scanner(System.in);
        System.out.println();
        if(cart.size()>0) {
            for (Item i : cart.keySet()) {
                System.out.println(cart.get(i) + " " + i.getName()+ "    Price: $" + (i.getPrice() * cart.get(i)));
                total += i.getPrice() * cart.get(i);
            }
            System.out.print("Type \"1\" to check out, type \"2\" to go back: ");
            int selection = scanInt.nextInt();
            System.out.println();
            if (selection==1){
                checkout();
            }
            else if(selection==2){
                store.groceryMenu(this);
            }
        }
        else{
            System.out.println("There's nothing in your cart! Do some more shopping!\n");
            store.groceryMenu(this);
        }
    }
    public int checkout(){
        Scanner scanInt=new Scanner(System.in);
        Receipt r=new Receipt(getCart());
        r.printReceipt();
        System.out.print("Your total is $"+r.getTotal()+". Thanks for shopping! Press 1 to go do more shopping, press 2 to quit the program: ");
        int selection=scanInt.nextInt();
        System.out.println();
        cart.clear();
        if(selection==1){
            store.groceryMenu(this);
        }
        return -1;
    }
}
