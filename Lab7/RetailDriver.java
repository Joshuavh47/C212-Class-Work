import java.util.*;

public class RetailDriver {
    public static ArrayList<Customer> customers = new ArrayList<Customer>();
    public static ArrayList<RetailStore> stores = new ArrayList<RetailStore>();
    static Scanner scanInt = new Scanner(System.in);
    static Scanner scanString = new Scanner(System.in);
    static Scanner scanDouble = new Scanner(System.in);
    public static int menu(){
        System.out.println("1. Create new store\n2. Create new customer\n3. Add new item to store\n4. View stores\n5. Exit");
        int selection= scanInt.nextInt();
        if (selection == 1){
            newStore();
        }
        else if(selection==2){
            newCustomer();
        }
        else if (selection==3){
            addItem();
        }
        else if(selection==4){
            viewStores();
        }
        return -1;

    }
    public static void newStore(){
        System.out.print("Enter the name of the store: ");
        String storeName = scanString.nextLine();
        System.out.println();
        new RetailStore(storeName);
        System.out.println("Store created! Returning to main menu...");
        menu();
    }
    public static void newCustomer(){
        System.out.print("Enter name of new customer: ");
        String custName=scanString.nextLine();
        System.out.println();
        System.out.print("Enter the budget of the new customer: $");
        double custBudget=scanDouble.nextDouble();
        System.out.println();
        System.out.print("Is the new customer wearing a mask (yes/no): ");
        String maskStatus=scanString.nextLine();
        System.out.println();
        if (maskStatus.equalsIgnoreCase("yes")){
            customers.add(new Customer(custName, custBudget, true));
        }
        else if(maskStatus.equalsIgnoreCase("no")){
            customers.add(new Customer(custName, custBudget, false));
        }
        else{
            while(!maskStatus.equalsIgnoreCase("yes")&&!maskStatus.equalsIgnoreCase("no")){
                System.out.print("Is the new customer wearing a mask (yes/no): ");
                maskStatus=scanString.nextLine();
                System.out.println();
            }
            if (maskStatus.equalsIgnoreCase("yes")){
                customers.add(new Customer(custName, custBudget, true));
            }
            else if(maskStatus.equalsIgnoreCase("no")){
                customers.add(new Customer(custName, custBudget, false));
            }

        }
        System.out.println("New customer created! Returning to main menu...\n");
        menu();
    }
    public static void addItem(){
        String storesString="";
        for(RetailStore r:stores){
            storesString+=r.getName()+", ";
        }
        storesString=storesString.substring(0, storesString.length()-2);
        System.out.println("Stores: "+storesString);
        System.out.print("Enter the name of the store you'd like to add an item to: ");
        String storeToAdd = scanString.nextLine();
        System.out.println();
        int indexOfStore=-1;
        for(int i = 0;i<stores.size();i++){
            if(stores.get(i).getName().equalsIgnoreCase(storeToAdd)){
                indexOfStore=i;
            }
        }
        if (indexOfStore==-1){
            System.out.println("Store does not exist! Please try again!\n");
            addItem();
        }
        else{
            System.out.print("Enter the name of the item: ");
            String nameOfItem=scanString.nextLine();
            System.out.println();
            System.out.print("Enter its price: $");
            double priceOfItem=scanDouble.nextDouble();
            System.out.println();
            System.out.print("How many would you like to add to the store?: ");
            int amountToAdd = scanInt.nextInt();
            if (stores.get(indexOfStore).containsItem(nameOfItem)){
                stores.get(indexOfStore).addItems(stores.get(indexOfStore).getItem(nameOfItem), amountToAdd);
            }
            else{
                stores.get(indexOfStore).addItems(new Item(nameOfItem, priceOfItem),amountToAdd);
            }
            System.out.println("Item added! Returning to main menu...\n");
            menu();
        }
    }
    public static void viewStores(){
        String allStores = "";
        if (stores.size()>0) {
            for (RetailStore r : stores) {
                allStores += r.getName() + ", People: " + r.amountOfCustomers() + "; ";
            }
            allStores = allStores.substring(0, allStores.length() - 2);
            System.out.println(allStores+"\n");
            enterStore();
        }
        else{
            System.out.println("No stores exist! Returning to main menu...\n");
            menu();
        }
    }
    public static void enterStore(){
        RetailStore tempStore=null;
        Customer customerObj=null;
        System.out.print("Enter the name of the store you want to enter: ");
        String storeName=scanString.nextLine();
        System.out.println();
        for(RetailStore s:stores){
            if(s.getName().equalsIgnoreCase(storeName)){
                tempStore=s;
            }
        }
        if(tempStore==null){
            System.out.println("There were no stores with that name, try again!\n");
            enterStore();
        }
        if(tempStore.amountOfCustomers()==5){
            System.out.println("This store is full due to covid restrictions. Pick another!\n");
            enterStore();
        }
        System.out.print("Type the name of the customer entering the store: ");
        String custName=scanString.nextLine();
        System.out.println();
        for(Customer c:customers){
            if(c.getName().equalsIgnoreCase(custName)){
                customerObj=c;
                break;
            }
        }
        if(customerObj.isWearingMask()) {
            customerObj.setStore(tempStore);
            tempStore.addCustomer(customerObj);
            System.out.println(customerObj.getName() + " has entered " + tempStore.getName() + "!");
            tempStore.groceryMenu(customerObj);
        }
        else{
            System.out.println("You must wear a mask to enter the store. Returning to main manu...\n");
            menu();
        }
    }
}
