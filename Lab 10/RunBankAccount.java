import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Map;

public class RunBankAccount {
    public static void main(String[] args) throws FileNotFoundException {
        BankAccount bank = new BankAccount("src/transactions.txt");
        Iterator<Map.Entry<String, Double>> itr = bank.currentBalance().entrySet().iterator();
        System.out.println("Before scheme: ");
        while (itr.hasNext()){
            Map.Entry<String, Double> entry = itr.next();
            System.out.printf(entry.getKey() + ": "+"$%,.2f%n", entry.getValue());
        }
        System.out.println("\nAfter scheme: ");
        Iterator<Map.Entry<String, Double>> itr2 = bank.updateBalances().entrySet().iterator();
        while (itr2.hasNext()){
            Map.Entry<String, Double> entry2 = itr2.next();
            System.out.printf(entry2.getKey() + ": "+"$%,.2f%n", entry2.getValue());
        }
    }
}
