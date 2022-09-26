//  Lab 3
//
//  Released:  9/8/2021
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

About the java file: The current Program computes Area of different shapes based on user input.

User Input:
1. choice: User should enter either 1 or 2 depending on which shape the user wants to compute area for.
2. base, height for triangle and radius for circle: The lengths of shapes for which areas must be computed.

Expected Program Output:
The correct result for this program

Eg:

Find area of
1 . Triangle
2 . Circle
Select a choice : 1
Enter the length of base :
2
Enter the length of height :
2
Area of triangle with length of sides 2 and 2 is : 2
*/
import java.io.*;
//added java.util
import java.util.*;
class DebugProgramTwo
{
    //added public static void
    //changed method name so it didn't overlap with other debug programs
    public static void findAreaTri(int a, int b)
    {
        //changed to 2.0 so it is always a double
        double area = ( a*b) / 2.0 ;
        System.out.println( "\n Area of triangle with length of sides "+a+ " and " +b+" is : "+ area);
    }
    //added public static
    public static void findAreaCir(int a)
    {
        //added parenthesis around the 3.14 and a, fixed formula for area of a circle
        System.out.println( "\n Area of circle with  radius " +a+ " is :" + (3.14 * a*a));
    }
    //added static, changed argument of main method to String[] args
    public static void main(String[] args) throws IOException
    {
        //removed unnecessary instantiation of DebugProgramTwo
        Scanner keyboard = new Scanner(System.in);
        System.out.print("\n Find area of \n 1 . Triangle \n 2 . Circle \n\nSelect a choice : ");
        int choice = keyboard.nextInt();
        //changed so if choice is equal to 1, it will execute the if statement
        if(choice == 1){

            System.out.print("\n Enter the length of base : ");
            //added space beteen int and x
            int x =keyboard.nextInt();
            System.out.print("\n Enter the length of height : ");
            //added int and nextInt()
            int y=keyboard.nextInt();
            //added calculation method
            findAreaTri(x,y);

        }
        //changed to else if, changed so if choice is equal to 2, it will execute the if statement
        else if (choice == 2){
            System.out.print("\n Enter the radius : ");
            int r =keyboard.nextInt();
            //removed unnecessary object instance and added calculation method
            findAreaCir(r);

        }
        //removed static
        else {
            System.out.println("Invalid choice");
        }

    }
}
