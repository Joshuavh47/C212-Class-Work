public class Palindromes {
    public static void main(String[] args) {

    }
    public static boolean isIntPalindromeRecursive(int num){
        int reversed = 0;
        int initNum=num;
        //run loop until there are no numbers to parse
        while(num != 0) {

            //uses modulus 10 to get the last number of the num argument
            int digit = num % 10;
            //multiplies the reversed string by 10, moving each number to the right, and adds the digit that was taken
            //from the argument int
            reversed = reversed * 10 + digit;

            //remove the last digit from num
            num /= 10;
        }
        //if the original and reversed numbers are the same then they are palindromes
        if (reversed==initNum){
            return true;
        }
        return false;
    }
    public static boolean isIntPalindromeIterative(int num){
        int initNum=num;
        int reversed=0;
        //for loop iterates through each place of the number and adds it to a new int
        for (;num!=0;num/=10){
            int digit = num % 10;
            reversed = reversed * 10 + digit;
        }
        //if the reversed int and the original int are equal, the number is a palindrome
        if(initNum==reversed){
            return true;
        }
        return false;
    }
    public static boolean isStrPalindromeIterative(String str){
        String revStr="";
        //for loop iterates through the original string and takes each letter using charAt from last to first,
        //adding each letter to the beginning of another string
        for(int i=str.length()-1;i>=0;i--){
            revStr+=str.charAt(i);
        }
        //is these two strings are equal, ignoring the case, then they are palindromes
        if(revStr.equalsIgnoreCase(str)){
            return true;
        }
        return false;
    }
    public static boolean isStrPalindromeRecursive(String str){
        //counter to break out of the for loop after each character is parsed
        int count=str.length()-1;
        String revStr="";
        //takes each character from last to first and adds them to the reversed string variable using charAt
        while(count>=0){
            revStr+=str.charAt(count);
            count--;
        }
        //if the two strings are equal ignoring the case, then str is a palindrome
        if(revStr.equalsIgnoreCase(str)){
            return true;
        }
        return false;
    }
}
