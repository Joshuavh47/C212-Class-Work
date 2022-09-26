package Lab9;

import java.io.*;
import java.util.*;


public class CSVReader {
    public static void main(String[] args) {
        read();
    }
    public static void read(){
        //HashMap stores the category as the key and the prices of each product in each category as an ArrayList for
        //the value
        HashMap<String, ArrayList<Double>> h =new HashMap<String, ArrayList<Double>>();

        try {
            File f = new File("src/Lab9/products.csv");
            Scanner in = new Scanner(f);
            int count=0;
            while (in.hasNextLine()){
                if(count>=1) {
                    String temp = in.nextLine();
                    //goes line to line and parses the data into the HashMap
                    //(except for the first line as that is the header)
                    if (!h.containsKey(temp.split(",")[1])) {
                        h.put(temp.split(",")[1], new ArrayList<Double>());
                        h.get(temp.split(",")[1]).add(Double.valueOf(temp.split(",")[2]));
                    } else {
                        h.get(temp.split(",")[1]).add(Double.valueOf(temp.split(",")[2]));
                    }
                }
                else{
                    in.nextLine();
                }
                count++;
            }
            System.out.println("Average for each category: ");
            double temp=0;
            for(String s:h.keySet()){
                //calculates the average for each key (category) in the HashMap
                for (double d:h.get(s)){
                    temp+=d;
                }
                temp/=h.get(s).size();
                //prints the average cost for each category
                System.out.printf(s+": "+"$%,-10.2f%n",temp);
                temp=0;
            }
            System.out.println();
            System.out.print("Highest costing product(s): ");
            in.close();
            Scanner newIn=new Scanner(f);
            HashMap<String,Double> priceMap=new HashMap<String,Double>();
            //makes a new HashMap to store the name of the product with the highest price as a key and its price as
            //the value (skipping the first line, as this is the header)
            int tempCount=0;
            while(newIn.hasNext()){
                if(tempCount>=1) {
                    String line = newIn.nextLine();
                    priceMap.put(line.split(",")[0], Double.valueOf(line.split(",")[2]));
                }
                else{
                    newIn.nextLine();
                }
                tempCount++;
            }
            ArrayList<String> highestName=new ArrayList<String>();
            //establishes an ArrayList to store products in cases where 2 or more products have the highest value
            double highestPrice=0;
            //calculates the product(s) with the highest value
            for(String s:priceMap.keySet()){
                if(priceMap.get(s)>highestPrice){
                    highestName.clear();
                    highestName.add(s);
                    highestPrice=priceMap.get(s);
                }
                else if(priceMap.get(s)==highestPrice){
                    highestName.add(s);
                }
            }
            String printStr="";
            for(String s:highestName){
                printStr+=s+", ";
            }
            printStr=printStr.substring(0,printStr.length()-2);
            //prints the product(s) with the highest value and their price(s)
            System.out.printf(printStr+" - $%,-10.2f%n",highestPrice);
            System.out.println();
            System.out.println("Amount of items per category: ");
            for(String s:h.keySet()){

                System.out.print(s+": ");
                //uses the size of the arrays in the first HashMap which stored the prices for each category
                int amount=h.get(s).size();
                System.out.println(amount);
            }
            newIn.close();
        }
        catch (FileNotFoundException e){
            System.out.println("File not found");
        }

    }
}
