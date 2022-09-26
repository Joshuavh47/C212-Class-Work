//  Lab 2
//
//  Released:  1/20/20
//
//  @Author  Your Name and username
//  Last Edited:
//
//
//  Directions:  Implement the following methods
//
//
//////////////////////////////////////////////////////////////////////////////////

// Note:  Do not need to explicitly import classes from java.lang but wanted to make it explicit
// Goal - understand using Static classes - i.e. the Math class was not designed to be Instantiated (make objects)
// It is a class that provides functionality and will be used to complete one of the methods

import java.util.*;



public class Lab2Exercises {

    // computes area of a trapezoid when given its upper side, lower side and height
    public static int areaOfATrapezoid(double a, double b, double h) {

        return (int) (.5*(a+b)*h);
    }

    // computes perimeter of a trapezoid when given its sides
    public static int perimeterOfATrapezoid(double a, double b, double c, double d) {

        return (int) (a+b+c+d);
    }

    // Returns the count of character that is not vowels in the given String
    // Added on 8/31: I would suggest using built-in String methods (not a loop).
    // See a related note in lab instructions.
    public static int countNotVowels(String str) {
        int count = 0;
        //loops through each index of the string to check if the character is equal to a,e,i,o,u
        for (int i = 0;i<str.length();i++){
            if (!(str.charAt(i)=='a'||str.charAt(i)=='e'||str.charAt(i)=='i'||str.charAt(i)=='o'||str.charAt(i)=='u')){
                count++;
            }
        }
        return count;
    }

    // Use a Scanner to reads a number between 1000 and 1 Trillion and print it with commas (,) separating
    // every three digits. for example: 12317910.67 will be printed as $12,317,910.67
    // You MUST use divide and/or modulus operators and may save part of the number, then concatenate back
    // together as a String
    // You must use printf to print the combined string and everything else in this method.
    // Question: There is an easier way to print a number with commas (,) separating every 3 digits without
    // doing all the computations with %. What is it? Answer: Use printf .... How? write the code that will do it.
    public static String addCommas() {
        //initialize scanner
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a number: ");
        double usrNumber = scan.nextDouble();
        //initialize long variables and string variables for formatting zeros
        long hun;
        long thous;
        long mil;
        long bil;
        long tril = 0;
        String hunS;
        String thousS;
        String milS;
        String bilS;
        //takes the each place value as a variable. Ex. for 123456789, thous = 456
        int dec = (int)((usrNumber%1)*100);
        hun = (long) (usrNumber%1000);
        thous = (long) (usrNumber/1000)%1000;
        mil = (long) ((usrNumber/1000000)%1000);
        bil = (long) ((usrNumber/1000000000)%1000);
        //sets condition for trillions as it is the upper bound of the task, therefore if the trillions place is equal to 1 a trillion will be printed automatically
        if (usrNumber==1000000000000L){
            System.out.printf("$1,000,000,000,000.00");
            return "";
        }
        //sets the strings to the same value as the longs
        hunS = String.valueOf(hun);
        thousS = String.valueOf(thous);
        milS = String.valueOf(mil);
        bilS = String.valueOf(bil);

        //sets conditions for if certain number places are equal to 0 and prints the strings based on what is 0 and what has other values
        if (thous==0){
            thousS="000";
        }
        if (hun==0){
            hunS="000";
        }
        if (tril==0){
            if (bil==0){
                bilS="000";
                if (mil==0){
                    milS="000";
                    System.out.printf("$"+thousS+","+hunS+"."+dec);
                    return "";
                }
                System.out.printf("$"+milS+","+thousS+","+hunS+"."+dec);
                return "";
            }
            System.out.printf("$"+bilS+","+milS+","+thousS+","+hunS+"."+dec);
            return "";
        }


        return "";

    }

    // test client
    public static void main(String[] args) {
        System.out.println(areaOfATrapezoid(2,6,4));//16
        System.out.println(perimeterOfATrapezoid(2, 4, 6, 7));//19
        System.out.println(countNotVowels("sldkfjasdlkfj"));//12
        addCommas();

    }
}

////////////////////////////////////
//                                //
// ANSWER THE FOLLOWING QUESTIONS //
//                                //
////////////////////////////////////

/*
 * Questions 1-3 are on explicit and implicit casting of some numerical types
 *
 * 1.  What happens if you multipy an int with a char?
 *  The ASCII value of the char will be multiplied with the int and returned
 * 2.  What happens if you multipy a double with a char?
 *  The ASCII value of the char will be multiplied by the floating point double and returned
 * 3.  What happens if you square a char?
 *      The ASCII value of the char will be squared and returned
 * 4.  What happens if a method has a paramater of type int, but you pass it a char?
 *      The parameter wil equal the ASCII value of the char that is passed
 * 5.  What happens if a method has a paramater of type char, but you pass it an int?
 *      There is an incompatible types error
 * 6.  What is the difference between two floating point primitive data types in the Java?
 *      A float takes up less space than a double, but is less precise in its amount of possible decimal spaces. Doubles take up more space, but are more precise
 * 7.  Consider the following code snippet.
 *     int i = 10;
 *     n = ++(i++);
 *     System.out.println(++(i++) % 5);
 *
 *     Without Compiling the Program:
 *     What {do you think} are the values of i and n if the code is executed?
 *     What are the final value printed?
 *     Now Compile and Run the Program to check your answers. If they are different, explain why
 *     and provide updated code!
 *      I think it would print n=12, i=12, Final value=3. The code had errors and wouldn't compile for me to check my answers
 * 8.  If I define a class as below:
 *     class calc {
 *            public static int addOperation(int firstOperand, int sop){
 *                   return firstOperand+sop;
 *            }
 *            ...
 *     }
 *     Looking at Java Coding Conventions, what suggestions would you give for code refactoring?
 *      Make the class name start with a capital letter. Also, maybe make the arguments and return types doubles so you can add floating point values.
 * 9.  int i = 10000000 * 100000000;
 *	   System.out.println(i);
 *
 *     Why does the code above print a weird answer? How will you fix it (for same computation)?
 *      Because int i exceeds the range of values that an int can store. You can fix this by using a different data type such as a long.
 */
