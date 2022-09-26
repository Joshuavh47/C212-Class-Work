
import java.util.*;
public class Lab5Fixed {
    public static String maxMin(String input){
        //establishes a new ArrayList with each index containing a word from the string argument
        ArrayList<String> strs=new ArrayList<>(Arrays.asList(input.split(" ")));
        int indexHigh = 0;
        int indexLow = 0;
        //establishes 2 new string arrays for the output
        String[] names = new String[2];
        int[] indexes = new int[2];
        //tests to see if the length of each word is either the lowest or highest length in the sentence
        for (int i =0;i<strs.size();i++){
            if (strs.get(i).length()<strs.get(indexLow).length()){
                indexLow = i;
            }
            if (strs.get(i).length()>strs.get(indexHigh).length()){
                indexHigh=i;
            }
        }
        names[0]=strs.get(indexLow);
        names[1]=strs.get(indexHigh);
        indexes[0]=indexLow;
        indexes[1]=indexHigh;
        //converts the arrays to an output string
        String output=Arrays.toString(indexes);

        return output;
    }
    public static int[] findStudents(){
        //2d int array literal for the students' information
        int[][] students={{1, 18, 12, 90}, {2, 16, 10, 75}, {3, 15, 9, 85}};
        //establishes ArrayLists for each value being compared
        ArrayList<Integer> ageIndexes=new ArrayList<Integer>();
        ArrayList<Integer> yearIndexes = new ArrayList<Integer>();
        ArrayList<Integer> gradeIndexes = new ArrayList<Integer>();
        //establishes an ArrayList to add common id values to
        ArrayList<Integer> outputList = new ArrayList<Integer>();
        Scanner scan = new Scanner(System.in);
        //takes use input
        System.out.print("Minimum Age: ");
        int minAge = scan.nextInt();
        System.out.println();
        System.out.print("Minimum Year: ");
        int minYear = scan.nextInt();
        System.out.println();
        System.out.print("Minimum Grade: ");
        int minGrade = scan.nextInt();
        System.out.println();
        //for each category, if the user inputs anything except -1, it will loop through and see if each student's age
        //is greater or equal to the minimum age value, and if it is, it adds the index of the student to the
        //comparison ArrayList
        if (minAge!=-1){
            for (int i = 0;i<students.length;i++){
                if (students[i][1]>=minAge){
                    ageIndexes.add(i);
                }
            }
        }
        if (minYear!=-1){
            for (int i=0;i<students.length;i++){
                if (students[i][2]>=minYear){
                    yearIndexes.add(i);
                }
            }
        }
        if(minGrade!=-1){
            for(int i = 0;i<students.length;i++){
                if(students[i][3]>=minGrade){
                    gradeIndexes.add(i);;
                }
            }
        }
        //implements logic for comparing the values between the arrays of each category that isn't equal to -1.
        //If a match is found, it adds the ID of the student to the output ArrayList.
        if (minGrade!=-1&&minYear!=-1&&minAge!=-1){
            for(int i:ageIndexes){
                if (yearIndexes.contains(i)&&ageIndexes.contains(i)){
                    outputList.add(students[i][0]);
                }
            }
        }
        else if(minGrade!=-1&&minYear!=-1&&minAge==-1){
            for(int i:gradeIndexes){
                if(yearIndexes.contains(i)){
                    outputList.add(students[i][0]);
                }
            }
        }
        else if(minGrade!=-1&&minYear==-1&&minAge!=-1){
            for(int i:gradeIndexes){
                if(ageIndexes.contains(i)){
                    outputList.add(students[i][0]);
                }
            }
        }
        else if(minGrade==1&&minYear!=1&&minAge!=1){
            for(int i:yearIndexes){
                if(ageIndexes.contains(i)){
                    outputList.add(students[i][0]);
                }
            }
        }
        else if(minGrade!=-1&&minYear==-1&&minAge==-1){
            for(int i:gradeIndexes){
                outputList.add(students[i][0]);
            }
        }
        else if(minGrade==-1&&minYear!=-1&&minAge==-1){
            for(int i:yearIndexes){
                outputList.add(students[i][0]);
            }
        }
        else if(minGrade==-1&&minYear==-1&&minAge!=-1){
            for(int i:ageIndexes){
                outputList.add(students[i][0]);
            }
        }
        else if(minGrade==-1&&minYear==-1&&minAge==-1){
            return new int[0];
        }
        //initializes an int array that is the size of the ArrayLists containing the IDs that satisfy the search
        int[] output = new int[outputList.size()];
        //adds each index of the ArrayList to the new array
        for(int i = 0;i<outputList.size();i++){
            output[i]=outputList.get(i);
        }
        return output;
    }




}
