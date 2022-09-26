import java.lang.Math;
import java.math.BigInteger;
import java.util.*;
public class Lab3Exercises {
    //a method that returns true if the char argument is a vowel
    public static boolean isVowel(char ch){
        return (ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'||ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U');
    }

    public static String pigLatinEncoder(String engInput){
        //index of the first vowel
        int index = -1;
        String output = "";
        //a string array of the input split at each space (an array of each word)
        String[] words = engInput.split(" ");
        //when implementing the whole sentence for loop remember to reset the index to 0
        for (int j = 0;j<words.length;j++) {
            //resets the index for each word
            index=-1;
            for (int i = 0; i < words[j].length(); i++) {
                //checks if each character in the string is a vowel and if it is, sets the index variable to that
                // character index in the string
                if (isVowel(words[j].charAt(i))) {
                    index = i;
                    break;
                }
                //if the first letter of the word is not a vowel and not 'y', and one of the latter characters is a 'y',
                //it will set the index variable to the 'y'
                else if((!isVowel(words[j].charAt(0))&&(words[j].charAt(0)!='y'||words[j].charAt(0)!='Y'))&&(words[j].charAt(i)=='y'||words[j].charAt(i)=='Y')){
                    index = i;
                    break;
                }
            }
            //if no vowels are present in the word then it will add the word with a "-way " after it to the output string
            if (index == -1||index==0) {
                output += words[j] + "-way ";
            }
            //if there are vowels present in the word, it takes the substring of the word from the index of the vowel
            //+ "-" + the substring of the word from 0 to the index of the vowel + "ay "
            else {
                output += words[j].substring(index) + "-" + words[j].substring(0, index) + "ay ";
            }
        }
        return output;
    }

    public static String pigLatinDecoder (String pigInput){
        //splits input argument by spaces (makes array containing each word)
        String[] words= pigInput.split(" ");
        //establishes the starting and ending index for each word
        int startIndex = -1;
        int endIndex = -1;
        //a boolean to check if the piglatin word contains only "-way" at the end to recommend 2 options
        boolean containsW=false;
        String output="";
        for (int i = 0; i < words.length; i++) {
            //resets all variables after each word is checked
            containsW=false;
            startIndex = -1;
            endIndex = -1;
            for (int j = 0; j < words[i].length(); j++) {
                //sets the starting index to 1 after the '-'
                if(words[i].charAt(j)=='-'){
                    startIndex=j+1;
                }
                //if the end of the word is not simply "-way", it sets the end index to the spot of the last 'a'
                if (words[i].charAt(j)=='a'){
                    endIndex=j;
                }
                //sets the boolean to true if the ending of the word is only "-way"
                else if (words[i].substring(words[i].length()-3).equalsIgnoreCase("way")){
                    containsW=true;
                }
            }
            //if the word ending is only "-way", it will recommend 2 possible options to the user
            if (containsW){
                output+="(w"+words[i].substring(0,startIndex-1)+"/"+words[i].substring(0,startIndex-1)+") ";
            }
            //otherwise, it will add the substring of the word from the starting index to the end index + the substring
            //of the word from 0 to the starting index-1 (because the starting index is 1 after the '-') to the output string
            else{
                output+=words[i].substring(startIndex,endIndex)+words[i].substring(0,startIndex-1)+" ";
            }
        }
        return output;
    }

    public static String randomCarsGenerator (int numCars){
        //Establishes String array literals for the car collors, types, and special cars
        String[] colors = {"Red","Blue","Black","White","Yellow","Grey","Orange","Purple","Green"};
        String[] brands = {"Truck","Sedan","Coupe","Convertible","Hatchback","Minivan","RV"};
        String[] special = {"Police car","Garbage truck"};
        //Establishes the output String array and the output string
        String[] output = new String[numCars];
        String outStr = "";
        //Creates loop that gets color combination for each car
        for (int i = 0;i<numCars;i++){
            //Picks a random color and car type for each combination
            int randomColor = (int)(Math.random()* colors.length);
            //The range for the randomBrand is the brands array length plus the special cars array length so if the
            //random number is higher than the length of the brand array, it will simply print the special car of the
            //index [randomBrand-brands.length]
            int randomBrand = (int)(Math.random()*(brands.length+special.length));
            //if the random brand index number is higher than the length of the brand array,
            if (randomBrand>brands.length-1){
                output[i]=special[randomBrand-brands.length];
            }
            else{
                output[i] = colors[randomColor]+" "+brands[randomBrand];
            }
        }
        for (int i = 0;i<output.length;i++){
            if (i<output.length-1) {
                outStr += output[i] + ", ";
            }
            else{
                outStr += output[i];
            }
        }
        return outStr;

    }

    public static String hexToIntNBin (String hexInput){
        //Initializes a new BigInteger with a regex of 16, as that is the base of hex values
        //I used BigInteger in case the value of the decimal is too big to store in an int
        BigInteger decOut = new BigInteger(hexInput, 16);
        //converts the decimal BigInteger to a String containing the binary equivalent using toString with a regex of 2,
        //as that is the base of binary values
        String binOut = decOut.toString(2);

        return "Your number is "+ decOut +" (in decimal) and "+ binOut +" (in binary).";

    }

    public static void main(String[] args) {

    }
}

/*
3.  a.
    i. error: equality, not a statement
    ii. double, 37.349999999999994
    iii. int
    iv. int+String, "1725"

    b.
    i. 9.78
       9
       9
       18.78
       99.78

   ii. 007

  iii. Bee BeeBee

  c. Strings are immutable in java because they can not be changed. A String that is created will reference the String
     object that is created. If the same String is assigned a new value, the String will reference a new String object,
     but not change the value of the previous String object created. Since the value cannot be changed, this provides
     security, especially in the context of loading classes, so there cannot be an attack on the class that is loaded
     in a particular piece of code.

 */
