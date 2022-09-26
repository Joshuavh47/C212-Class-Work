import java.util.*;
public class Lab2Integers {
    public static void printInt(){
        //initializes scanner
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter text: ");
        String input = scan.nextLine();
        //loops through each character and prints their ASCII values followed by a space
        for (int i = 0;i<input.length();i++){
            System.out.print((int)input.charAt(i));
            System.out.print(" ");
        }


    }

    public static void main(String[] args){
        printInt();
    }
}
