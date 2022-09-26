package Stacks;

import java.util.Stack;

public class Palindromes {
    /**
     *
     * @param a the number to test
     * @return if the number is a palindrome
     */
    public static boolean isIntPalindrome(int a){
        Stack<Integer> temp = new Stack<Integer>();
        int tempNum=a;
        int count=0;
        //Finds the length of the integer
        while(tempNum!=0){
            tempNum/=10;
            count++;
        }
        int divide=1;
        int multiply=10;
        //algorithm to get the first number and push it to the top of the stack
        for(int i =0;i<count-1;i++){
            divide*=10;
        }
        temp.push((a/divide));
        divide/=10;

        for(int i=0;i<count-1;i++){
            temp.push((a/divide)%multiply);
            divide/=10;
        }
        //Pops the numbers off the stack so that they are in the reverse order
        int result=0;
        while(!temp.isEmpty()){
            result*=10;
            result+=temp.pop();
        }
        //checks to see if the two numbers are equal
        if(a==result){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     *
     * @param a the string to test
     * @return if the string is a palindrome
     */
    public static boolean isStrPalindrome(String a){
        Stack temp=new Stack();
        String firstHalf="";
        String secondHalf="";
        //determines if the length of the string is even or odd
        if(a.length()%2==0){
            firstHalf=a.substring(0,a.length()/2);
            secondHalf=a.substring(a.length()/2);
        }
        //if the length is odd, it will split it as if the middle character didn't exist, as the middle character would
        //not affect if the string is a palindrome or not
        else{
            firstHalf=a.substring(0,a.length()/2);
            secondHalf=a.substring(a.length()/2+1);
        }
        //pushes the first half onto the stack character by character
        String tempString="";
        for (int i=0;i<firstHalf.length();i++){
            temp.push(secondHalf.charAt(i));
        }
        //pops each character off the stack so into a temp string that is the reverse of the first half of the original
        //string
        while(!temp.isEmpty()){
            tempString+=temp.pop();
        }
        //checks if the two halves are equal to each other ignoring capitalization
        if(tempString.equalsIgnoreCase(firstHalf)){
            return true;
        }
        else{
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isStrPalindrome("aSdsa"));
        System.out.println(isStrPalindrome("aSdfDsa"));
        System.out.println(isStrPalindrome("aSdfsdsa"));
        System.out.println(isIntPalindrome(1234321));
        System.out.println(isIntPalindrome(123431));
        System.out.println(isIntPalindrome(12321));
    }
}
