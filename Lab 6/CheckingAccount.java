public class CheckingAccount extends BankAccount{
    public CheckingAccount(String accoutOwnerName, double currentAccountBalance){
        super(accoutOwnerName,currentAccountBalance);
    }
    //method to transfer money from a checking account to another account (if the end balance is greater than 0)
    //Includes a 3% fee
    @Override
    public void transferMoney(double amountToTransfer, BankAccount accountToTransferTo, int currentMonth){
        if(amountToTransfer>getCurrentAccountBalance()) {
            throw new IllegalArgumentException("You can only transfer an amount less than your current balance");
        }
        else{
            deposit(-1*amountToTransfer*.97);
            accountToTransferTo.deposit(amountToTransfer);
        }
    }
    //method to withdraw money from a checking account (if the end balance is greater than 0)
    @Override
    public double withdraw(double withdrawAmount, int currentMonth){
        if (withdrawAmount>getCurrentAccountBalance()){
            throw new IllegalArgumentException("You can only transfer an amount less than your current balance");
        }
        else{
            deposit(-1*withdrawAmount*.97);
            return getCurrentAccountBalance();
        }
    }

}
