//  Lab 2
//
//  Released:  1/27/2021
//
//  @Author  Your Name and username
//  Last Edited: 1/27/2021
//
//
//  Directions: The given file is not according to java coding guidelines
//              and may have compilation errors to be fixed.
//              Tasks to be performed:
//              1. Edit the file to make it according to java coding guidelines
//              and fix the errors if any.
//              2. Include comments to indicate the changes made to the file
//              to make it according to coding conventions or fix issues.
//
//////////////////////////////////////////////////////////////////////////////



/*

Note: The file is a standalone java file, meaning you can run this file directly without having to set up the other 2 files.

About the java file: The current Program performs Square and Power operations.

User Input:
1. choice: User should enter either 5 or 6 depending on which operation the user wants to perform.
2. first_operand, second_operand: The operands on which the Square/Power operation is to be performed.

Expected Program Output:
The correct result for Square and Power operations

Eg:
Welcome to Square/Power Calculator:
Choose your operation:
5. Square
6. Power
Enter 5 for performing Square
Enter 6 for performing Power
5
Enter operand to be squared
4
The result of the operation is:
16
*/
import java.util.Scanner;

public class DebugProgramThree {

    public static void main(String[] args) {
        //added semicolon
        int result=0;
        operationThree obj=new operationThree();
        //added double quotes to the end of the string instead of single quotes
        System.out.println("Welcome to Square/Power Calculator:");
//      Initializing Scanner object
        //removed random indent
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose your operation:");
        //changed to option 5 and 6 to match the user input
        System.out.println("5. Square\n6. Power");
        //added double quotes to string
        System.out.println("Enter 5 for "+"performing Square");
        System.out.println("Enter 6 for performing Power");
//      Taking an int input using Scanner object
        int choice = sc.nextInt();
        if(choice==5){
            System.out.println("Enter operand to be squared");
            //changed variable to sc
            //added camel case
            int firstOperand = sc.nextInt();
            //changed method to square
            result=obj.square(firstOperand);
        }
        //turned into else if
        else if(choice==6){
            System.out.println("Enter the base");
            //added camel case
            int firstOperand = sc.nextInt();
            System.out.println("Enter the power");
            //added camel case
            int secondOperand = sc.nextInt();
            result=obj.power(firstOperand,secondOperand);
        }
        System.out.println("The result of the operation is:"+result);
    }
}
class operationThree{
    //    function to perform square of an integer
    //changed variable name to camel case
    public static int square(int firstOperand){
        //added semicolon
        //added return statement
        return firstOperand*firstOperand;
    }
    //    function to calculate base integer raised to a power integer
    //changed variable names to camel case
    public static int power(int firstOperand, int secondOperand){
        //fixed the logic of the for loop by making the result start at 1 so that when the first operand is multiplied it won't always be 0
        int result = 1;
        if (firstOperand>0||firstOperand<0){
            for(int i=0;i<secondOperand;i++){
                //split the initialization of the result variable and the multiplication of it with the firstOperand variable
                result *= firstOperand;
            }
        }
        else if (firstOperand==0){
            result = 0;
        }

        return result;
    }
}