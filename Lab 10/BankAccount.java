import java.util.*;
import java.io.*;

public class BankAccount {
    private String fileName;
    private File f;
    public BankAccount(String fileName){
        this.fileName=fileName;
        f = new File(fileName);
    }
    public ArrayList<String> parseData() throws FileNotFoundException{

        Scanner scan = new Scanner(f);
        ArrayList<String> lines=new ArrayList<String>();
        while(scan.hasNextLine()){
            lines.add(scan.nextLine());
        }
        return lines;
    }
    public HashMap<String, Double> currentBalance() throws FileNotFoundException {
        ArrayList<String> lines=parseData();
        HashMap<String, Double> data = new HashMap<String, Double>();
        Iterator<String> it=lines.iterator();
        while(it.hasNext()){
            String[] lineData=it.next().split(",");
            if(lineData[2].equals("d")){
                if(data.containsKey(lineData[0])){
                    data.put(lineData[0], Double.parseDouble(lineData[1])+data.get(lineData[0]));
                }
                else{
                    data.put(lineData[0], Double.parseDouble(lineData[1]));
                }
            }
            else if(lineData[2].equals("w")){
                data.put(lineData[0], data.get(lineData[0])-Double.parseDouble(lineData[1]));
            }
        }
        return data;
    }
    public HashMap<String, Double> updateBalances() throws FileNotFoundException {
        HashMap<String, Double> data=currentBalance();
        Iterator<Map.Entry<String, Double>> itr = data.entrySet().iterator();
        while (itr.hasNext()){
            Map.Entry<String, Double> entry = itr.next();
            if(entry.getValue()>=1500){
                data.put(entry.getKey(), entry.getValue()+100);
            }
        }
        return data;

    }
}