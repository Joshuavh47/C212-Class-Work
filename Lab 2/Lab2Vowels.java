/*
First, I will have to establish 2 char arrays, one for the input characters and one for the output characters
Next, I will have a for loop loop through each index of the input array and check the case
If the character is a vowel and uppercase, I will take the ASCII value of that number, subtract 65 as that is what 'A' is in ASCII,
and subtract that value from 90, as that is what 'Z' is in ASCII.
If the character is a vowel and lowercase, I will repeat this process but use the correct ASCII values that correspond to lowercase
letters.
*/
public class Lab2Vowels {
    public static String replaceVowels(String inputString){
        char[] charInput = new char[inputString.length()];
        char[] charOutput = new char[inputString.length()];
        String outputString = "";
        int asciiValue;
        for (int i = 0;i<charInput.length;i++){
            charInput[i] = inputString.charAt(i);
        }
        for (int i = 0;i<charInput.length;i++){
            if (charInput[i]=='A'||charInput[i]=='E'||charInput[i]=='I'||charInput[i]=='O'||charInput[i]=='U'){
                asciiValue=((int)charInput[i])-65;
                charOutput[i]=(char)(90-asciiValue);
            }
            else if(charInput[i]=='a'||charInput[i]=='e'||charInput[i]=='i'||charInput[i]=='o'||charInput[i]=='u'){
                asciiValue=((int)charInput[i])-97;
                charOutput[i]=(char)(122-asciiValue);
            }
            else{
                charOutput[i]=charInput[i];
            }
        }
        for (int i = 0;i<charOutput.length;i++){
            outputString+=charOutput[i];
        }
        return outputString;
    }
    public static void main(String[] args){
        System.out.println(replaceVowels("dlkasfjsdkfjakjfd"));
    }
}
