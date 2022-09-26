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

About the java file: The current Program uses string built in functions like length(), charAt(), concat() and substring(). 

Expected Program Output:
The correct result for this program

Eg: 

*/

import java.io.*;

import java.util.Scanner;
class DebugProgramThree {
//changed argument in main to String[] args
    public static void main(String[] args) throws IOException {
        String str = "This is a debugging exercise";
        //added parenthesis to the .length method
        int len = str.length();
        //changed to str.length()-1
        char ch1 = str.charAt(str.length()-1);
        System.out.println("The last character of the string is " + ch1);

        String str1 = "Hello";
        String str2 = " World";
        //removed static, used "+" instead of concat() because concat() cannot be referenced in a static context and
        //main has to be static.
        System.out.println(str1+str2);

        System.out.println(str.replace('i', 'K'));

        System.out.println("Substring starting from index 15:");
        System.out.println(str.substring(15));
        System.out.println("Substring starting from index 15 and ending at 20:");
        //changed so substring ends at 20 instead of 30
        System.out.println(str.substring(15, 20));
    }
}