package Lab9;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class IOReader {

    public static void main(String[] args) {
        menu();
    }
    public static void menu(){
        //Initializes a menu for the user to either add, delete, or display student information
        Scanner stringScan=new Scanner(System.in);
        System.out.println("1. Add a student to the file students.txt\n2. Delete a record\n3. Count of seniors, juniors, sophomores, and freshmen\n4. Total count of students\n5. Exit");
        System.out.print("Pick an option: ");
        String option = stringScan.nextLine();
        System.out.println();
        if (option.equals("1")){
            addStudent();
        }
        if (option.equals("2")){
            deleteStudent();
        }
        if (option.equals("3")){
            printGrade();
        }
        if (option.equals("4")){
            totalCount();
        }
        if (option.equals("5")){
            System.exit(0);
        }
        else{
            menu();
        }
    }
    public static void addStudent() {
        //prompts the user for information about the student being added
        Scanner stringScan=new Scanner(System.in);
        System.out.print("Enter the name of the student: ");
        String studentName=stringScan.nextLine();
        System.out.println();
        System.out.print("Enter the the age of the student (F/s/J/S): ");
        String studentGrade=stringScan.nextLine();
        System.out.println();
        if (!studentGrade.equals("F")&&!studentGrade.equals("s")&&!studentGrade.equals("J")&&!studentGrade.equals("S")){
            System.out.println("You must enter F, s, J, or S for the student grade");
            addStudent();
        }
        try {
            //uses a FileWriter instead of a PrintWriter so that the program can append the student information to the
            //students.txt file given with the lab
            FileWriter fw = new FileWriter("src/Lab9/students.txt", true);
            fw.write("\n"+studentGrade+" "+studentName);
            fw.close();

        } catch (FileNotFoundException e) {
            System.out.println("Operation failed!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Success!");


    }
    public static void deleteStudent(){
        //prompts the user for information about the student being deleted
        Scanner stringScan = new Scanner(System.in);
        System.out.print("Enter the name of the student to delete: ");
        String name=stringScan.nextLine();
        System.out.println();
        System.out.print("Enter the the age of the student (F/s/J/S): ");
        String grade=stringScan.nextLine();
        System.out.println();
        if (!grade.equals("F")&&!grade.equals("s")&&!grade.equals("J")&&!grade.equals("S")){
            System.out.println("You must enter F, s, J, or S for the student grade");
            deleteStudent();
        }
        try {
            //loops through the students.txt file and puts the data into an array
            ArrayList<String> arr=new ArrayList<String>();
            boolean found = false;
            File f=new File("src/Lab9/students.txt");
            Scanner in=new Scanner(f);
            while(in.hasNextLine()){

                String line = in.nextLine();
                arr.add(line);
            }
            //if the user input matches one of the entries in the students.txt file, it will delete that index from
            //the array
            if(arr.contains(grade+" "+name)) {
                arr.remove(grade + " " + name);
                //new FileWriter to clear the data in the original students.txt file
                FileWriter erase=new FileWriter("src/Lab9/students.txt", false);
                erase.write("");
                erase.close();
                //rewrite all the information that is still left in the array to the students.txt file
                FileWriter fr = new FileWriter("src/Lab9/students.txt", true);
                for(int i=0;i<arr.size()-1;i++){
                    fr.write(arr.get(i)+"\n");
                }
                fr.write(arr.get(arr.size()-1));
                fr.close();
            }
            else{
                //if the information entered by the user doesn't match any records, it prints a message and returns to
                //the main menu
                System.out.println("Student not found!");
                menu();
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    public static void printGrade(){
        //establishes variables for keeping track of the amount of people in each grade
        int fresh=0;
        int soph=0;
        int junior=0;
        int senior=0;
        try {
            File f = new File("src/Lab9/students.txt");
            Scanner in = new Scanner(f);
            //scans through file, increasing the counter variables for each entry in the students.txt file
            while(in.hasNextLine()){
                String line = in.nextLine();
                if(line.charAt(0)=='F'){
                    fresh++;
                }
                else if(line.charAt(0)=='s'){
                    soph++;
                }
                else if(line.charAt(0)=='J'){
                    junior++;
                }
                else if(line.charAt(0)=='S'){
                    senior++;
                }
            }
            //prints the amount of people in each grade level
            System.out.println("Freshman: "+fresh+"\nSophomores: "+soph+"\nJuniors: "+junior+"\nSenior: "+senior);
            System.out.println();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    public static void totalCount(){
        try {
            int total=0;
            File f = new File("src/Lab9/students.txt");
            Scanner in = new Scanner(f);
            //adds one to the counter for each line in the text file
            while(in.hasNextLine()){
                String line = in.nextLine();
                total++;
            }
            //prints the count of entries
            System.out.println("There are "+total+" students");
            System.out.println();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
