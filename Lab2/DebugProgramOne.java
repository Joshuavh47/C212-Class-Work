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

About the java file: The current Program performs Addition and Subtraction operations.

User Input:
1. choice: User should enter either 1 or 2 depending on which operation the user wants to perform.
2. first_operand, second_operand: The operands on which the addition/subtraction operation is to be performed.

Expected Program Output:
The correct result for Addition and Subtraction operations

Eg:
Welcome to Addition/Subtraction Calculator:
Choose your operation:
1. Add
2. Subtract
Enter 1 for performing Addition
Enter 2 for performing Subtraction
1
Enter first operand
5
Enter second operand
4
The result of the operation is:
9
*/
import java.util.Scanner;

public class DebugProgramOne
{
    public static void main(String[] args)
    {
        //Changed to OperationOne
        OperationOne obj = new OperationOne();
//      Initializing Scanner object
        Scanner sc = new Scanner(System.in);
        int result = 0;
        System.out.println("Welcome to Addition/Subtraction Calculator:");
        System.out.println("Choose your operation:");
        System.out.println("1. Add\n2. Subtract");
        System.out.println("Enter 1 for performing Addition");
        System.out.println("Enter 2 for performing Subtraction");
        int choice = sc.nextInt();
        System.out.println("Enter first operand");
        //changed to camel case
        int firstOperand = sc.nextInt();
        System.out.println("Enter second operand");
//        Taking an int input using Scanner object
        //changed to camel case and deleted number in variable name
        int secondOperand = sc.nextInt();
        if(choice==1)
        {
            result = obj.add(firstOperand,secondOperand);
        }
        else if(choice==2)
        {
            result = obj.subtract(firstOperand,secondOperand);
        }
        //added space between text and result
        System.out.println("The result of the operation is: "+result);
    }
}
//changed class name to start with a capital letter
class OperationOne
{
    //    function to add 2 integers
    //Changed variables to camel case
    public static int add(int firstOperand,int secondOperand){
        return firstOperand+secondOperand;
    }
    //    function to subtract 2 integers
    //changed variable names to camel case
    public static int subtract(int firstOperand,int secondOperand){
        return firstOperand-secondOperand;
    }
}