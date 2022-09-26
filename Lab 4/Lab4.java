import java.util.*;
public class Lab4 {
    public static void secretNumber(){
        int count = 1;
        boolean guessed = false;
        Random r = new Random();
        int rand = r.nextInt(10)+1;
        Scanner scan = new Scanner(System.in);
        System.out.println(rand);
        System.out.println("Pick a number 1-10");
        while(!guessed){
            int usrGuess = scan.nextInt();
            if (usrGuess<rand){
                System.out.println("Too low. Try again.");
                count++;
            }
            else if(usrGuess>rand){
                System.out.println("Too High. Try again.");
                count++;
            }
            else{
                System.out.println("Correct! It took you "+count+" attempts!");
                count++;
                guessed=true;
            }
        }
    }

    public static String designPattern(){
        Random r = new Random();
        int rand = r.nextInt(8)+3;
        Scanner scan = new Scanner(System.in);
        System.out.println("A. Pattern 1\nB. Pattern 2\nC. Pattern 3\nD. Pattern 4\nE. Exit");
        String option = scan.nextLine();
        String patternLine="";
        String stars="";
        String spaces="";
        if (option.equals("a")||option.equals("A")){
            System.out.println("Random number: "+rand+"\n");
            for (int i = 0;i<rand-1;i++){
                spaces+=" ";
            }
            for (int i = 0;i<rand;i++){
                stars+="*";
                patternLine=spaces.substring(i)+stars;
                System.out.println(patternLine);
            }

            for (int i = 0;i<rand;i++){
                patternLine=" "+patternLine;
                patternLine=patternLine.substring(0,patternLine.length()-1);
                System.out.println(patternLine);
            }
            designPattern();

        }
        else if (option.equals("b")||option.equals("B")){
            System.out.println("Random number: "+rand+"\n");
            spaces="";
            stars="";
            patternLine="";
            for (int i = 0;i<rand;i++){
                patternLine+=rand;
                System.out.println(patternLine);
            }
            designPattern();
        }
        else if (option.equals("c")||option.equals("C")){
            spaces="";
            stars="";
            patternLine="";
            System.out.println("Random number: "+rand+"\n");
            for (int i = 0;i<rand;i++){
                patternLine+="* ";
            }
            System.out.println(patternLine);
            patternLine="* ";
            for (int i = 0;i<rand-2;i++){
                patternLine+="  ";
            }
            patternLine+="*";
            for(int i = 0;i<rand-2;i++){
                System.out.println(patternLine);
            }
            patternLine="";
            for(int i = 0;i<rand;i++){
                patternLine+="* ";
            }
            System.out.println(patternLine);
            designPattern();
        }
        else if (option.equals("d")||option.equals("D")){
            spaces="";
            stars="";
            patternLine="";
            System.out.println("Random number: "+rand+"\n");
            for (int i=0; i<rand;i++){
                for (int j=rand-i; j>1; j--) {
                    System.out.print(" ");
                }
                for (int j=0; j<=i; j++){
                    System.out.print("* ");
                }
            System.out.println();
            }
            designPattern();
        }
        else{
            return "";
        }

        return "";
    }

    public static String exponentCalculator(int base, int exp){
        int ans = 1;
        if (base==0&&exp==0){
            throw new IllegalArgumentException("Error: operand(s) can't both be 0");
        }
        if (exp<0){
            throw new IllegalArgumentException("Error: operand(s) can't be negative");
        }
        else{
            for (int i = 0;i<exp;i++){
                ans=ans*base;
            }
        }
        return String.valueOf(ans);
    }

    public static String rectangle(int width, int length){
        String patternLine = "";
        String wholePattern="";
        for (int i = 0;i<length;i++){
            for (int j = 0;j<width;j++){
                patternLine+="#";

            }
            wholePattern+=patternLine+"\n";
            patternLine="";

        }
        return wholePattern.substring(0,wholePattern.length()-1);
    }

    public static void main(String[] args) {
        System.out.println(rectangle(3,4));
    }
}
