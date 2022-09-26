public abstract class BankAccount {
    private String accoutOwnerName;
    private double currentAccountBalance;
    //constructor for the BankAccount class
    public BankAccount(String accoutOwnerName, double currentAccountBalance){
        this.accoutOwnerName = accoutOwnerName;
        this.currentAccountBalance = currentAccountBalance;
    }
    //getter methods
    public String getAccoutOwnerName(){
        return accoutOwnerName;
    }
    public double getCurrentAccountBalance(){
        return currentAccountBalance;
    }
    //sets a new account balance
    public void setCurrentAccountBalance(double newBalance){
        currentAccountBalance=newBalance;
    }
    //deposits money if the total after the deposit is positive
    public double deposit(double amount){
        if (amount+currentAccountBalance>=0) {
            currentAccountBalance += amount;
            return currentAccountBalance;
        }
        else{
            throw new IllegalArgumentException();
        }
    }
    //abstract methods used in child classes to withdraw and transfer money
    public abstract double withdraw(double withdrawAmount, int currentMonth);
    public abstract void transferMoney(double amountToTransfer, BankAccount accountToTransferTo, int currentMonth);

}
