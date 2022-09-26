import java.util.*;

public class MyArrayList {
    //initializes private variables to use for each MyArrayList instance
    private int count;
    private int size;
    private int[] data;
    //constructor for the MyArrayList object sets the initial size to 16, initializes a new int array, and makes a
    //counter variable to know how many indexes have been taken up
    public MyArrayList(){
        size = 16;
        data=new int[size];
        count = 0;
    }

    //if there are less spots than the default size of the array, add a value to the index of the counter variable
    public void add(int n){
        if (count<size){
            data[count]=n;
            count++;
        }
        //if there are more or the same amount of spots than the default size of the array, it will make a new array
        //that is one index larger, copy the previous array values into the temporary array, and add the new value to
        //the new open spot at the end of the array
        else{

            int[] dataCopy = new int[count];
            for(int i = 0;i<data.length;i++){
                dataCopy[i]=data[i];
            }
            data=dataCopy;
            data[data.length-1]=n;
            size=count;
            count++;
        }
    }
    public String toString() {
        String output = "";
        //if there are no spots in the array, it will return empty square brackets
        if (count ==0){

            return "[]";
        }
        //if there are less than the default number of indexes used, the loop will add each index of the data array
        //followed by a comma and a space, then take the substring of it to cut off the last comma and space
        else if (count < 16){
            output += "[";
            for (int i = 0; i < count; i++) {
                output += data[i] + ", ";
            }
            output = output.substring(0, output.length()-2);
            output += "]";
            return output;
        }
        //if the MyArrayList size is greater than or equal to the default size, the toString will just use the Arrays
        //version of toString because there are not any unused array value that would be printed in error
        else{
            return Arrays.toString(data);
        }
    }
    public int remove(int n){
        //if there is only one index before removing the value, it will make a new array with the default length
        //like the ArrayList method, this method will also return the value being deleted
        if (data.length==1){
            int returnInt=data[n];
            data=new int[16];
            count = 0;

            return returnInt;
        }
        //if there is more than one index before removing the value, the array gets split up into two parts and
        //put back into an array with a length of the data.length-1
        else{
            int returnInt=data[n];
            int[] part1=new int[n];
            int[] part2=new int[data.length-(n+1)];
            for(int i = 0;i<n;i++){
                part1[i]=data[i];
            }
            for(int i = 0;i<part2.length;i++){
                part2[i]=data[n+1+i];
            }
            if (count>16){
                count--;
                size=count;
            }
            else{
                count--;
            }
            data=new int[data.length-1];
            for (int i = 0;i<part1.length;i++){
                data[i]=part1[i];
            }
            for (int i = 0;i<part2.length;i++){
                data[part1.length+i]=part2[i];
            }
            return returnInt;
        }

    }
    public int getSize(){
        //returns the count of how many indexes have been used in the array
        return count;
    }
    public boolean isEmpty(){
        //If the count equals 0, the array is empty so true is returned. Otherwise, false is returned
        if (count==0){
            return true;
        }
        return false;
    }
    public boolean contains(int n){
        //Loops through the array to check if the argument is present. If if is, the method returns true, otherwise,
        //the method will return false
        for (int i = 0;i<data.length;i++){
            if (data[i]==n){
                return true;
            }
        }
        return false;
    }
    public int indexOf(int n) {
        //Does the same thing as contains(), but instead of returning true in the case of a matching value, it will
        //return the index of the argument value in the array. If no match is found, it will return -1.
        for (int i = 0;i<data.length;i++){
            if(data[i]==n){
                return i;
            }
        }
        return -1;
    }
}
