public class SavingsAccount extends BankAccount{
    private int withdrawalsThisMonth;
    private int currentMonth;
    //constructor
    public SavingsAccount(String accoutOwnerName, double currentAccountBalance, int currentMonth){
        super(accoutOwnerName,currentAccountBalance);
        this.currentMonth=currentMonth;
        this.withdrawalsThisMonth=0;
    }
    //getter methods
    public int getWithdrawalsThisMonth(){
        return withdrawalsThisMonth;
    }
    public int getCurrentMonth(){
        return currentMonth;
    }
    //sets the withdrawals in that month
    public void setWithdrawalsThisMonth(int num){
        withdrawalsThisMonth=num;
    }
    //sets the current month
    public void setCurrentMonth(int num){
        currentMonth=num;
    }
    //withdraws money from the account if the withdrawals that month is less than 7 and the balance won't go negative
    @Override
    public double withdraw(double withdrawAmount, int currentMonth) {
        if (withdrawalsThisMonth>=6){
            throw new IllegalArgumentException("Only 6 withdrawals per month are allowed");
        }
        else {
            if (getCurrentAccountBalance() >= withdrawAmount) {
                deposit(-1 * withdrawAmount);
                withdrawalsThisMonth++;
                return withdrawAmount;
            } else if (getCurrentAccountBalance() <= 0) {
                throw new IllegalArgumentException("Insufficient funds");
            } else {
                double insufficientAmount = getCurrentAccountBalance();
                deposit(-1 * getCurrentAccountBalance());
                withdrawalsThisMonth++;
                return insufficientAmount;
            }
        }
    }
    //Transfers money to another account. The same conditions as withdrawing apply, including the withdrawal limit
    @Override
    public void transferMoney(double amountToTransfer, BankAccount accountToTransferTo, int currentMonth) {
        if(amountToTransfer>getCurrentAccountBalance()){
            throw new IllegalArgumentException();
        }
        else{
            withdraw(amountToTransfer, currentMonth);
            accountToTransferTo.deposit(amountToTransfer);
        }
    }
}
