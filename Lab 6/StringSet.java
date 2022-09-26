import java.util.*;

public class StringSet implements StringCollection{
    private ArrayList<String> elements;
    //constructor for the StringSet class
    public StringSet() {
        elements=new ArrayList<String>();
    }
    //gets the size of all of the elements in the set
    public int getSize(){
        return elements.size();
    }
    //adds an element to the set if it doesn't previously exist
    public void add(String e){
        boolean found=false;
        for(String s:elements){
            if (s.equals(e)){
                found=true;
            }
        }
        if (!found){
            elements.add(e);
        }
    }
    //iterates through the set and checks to see if it contains the String in the argument
    public boolean contains(String e){
        for(String s:elements){
            if (s.equals(e)){
                return true;
            }
        }
        return false;
    }
    //removes an element from the set if it contains the string in the argument
    public boolean remove(String e){
        for (int i = 0;i<elements.size();i++){
            if (elements.get(i).equals(e)){
                elements.remove(i);
                return true;
            }
        }
        return false;
    }
    //adds all of the elements from another StringSet or StringLinkedList to the current StringSet
    public void addAllFromCollection(StringCollection collection){
        for(int i=0;i<collection.getSize();i++){
            elements.add(collection.toList().get(i));
        }
    }
    //returns a list of all of the string values in the set
    public List<String> toList(){
        return elements;
    }

}
