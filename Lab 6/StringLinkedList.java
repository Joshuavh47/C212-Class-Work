import java.util.*;

public class StringLinkedList implements StringCollection{
    private List<StringLinkedList> elements=new ArrayList<StringLinkedList>();
    private String value;
    private StringLinkedList nextElement;
    //constructor
    public StringLinkedList(String value){
        this.value=value;
        //adds the first node of the linked list to the manager list
        if (elements.size()==0) {
            elements.add(this);
        }
    }

    public StringLinkedList(String value, StringLinkedList nextElement){
        this.value=value;
        this.nextElement=nextElement;
        //adds the first and second node of the linked list to the manager list
        if (elements.size()==0) {
            elements.add(this);
            elements.add(nextElement);
        }
    }
    //Tests to see if the next element in the list is null. If it is, it is the last one in the list.
    public boolean isLastElementInList(){
        if (nextElement==null){
            return true;
        }
        return false;
    }
    //method to set the next element to a different StringLinkedList
    public void changeNextElement(StringLinkedList e){
        boolean isLast=elements.get(getIndexOf(this)+1).isLastElementInList();
        elements.remove(getIndexOf(this)+1);
        for(int i = 0;i<e.elements.size();i++){
            elements.add(getIndexOf(this)+1, e.getArr().get(e.elements.size()-i-1));
        }
        if(!isLast){
            elements.get(getIndexOf(this)+e.elements.size()).nextElement=elements.get(getIndexOf(this)+e.elements.size()+1);
        }
    }
    //gets the index of a specific StringLinkedList that is passed as an argument
    public int getIndexOf(StringLinkedList e){
        for(int i=0;i<elements.size();i++){
            if (elements.get(i)==e){
                return i;
            }
        }
        return -1;
    }
    //returns the manager array
    public List<StringLinkedList> getArr(){
        return elements;
    }

    //adds a node to the Linked list at a certain index (unless it is the first node), updates the nextElement
    //variables of the adjacent StringLinkedLists to point to the correct nodes
    public void add(String e, int index){
        elements.add(index, new StringLinkedList(e, elements.get(index)));
        elements.get(index-1).nextElement=elements.get(index);
        if (index!=0){
            elements.get(index-1).nextElement=elements.get(index);
        }
    }
    //returns the next element in the list
    public StringLinkedList getNextElement(){
        return nextElement;
    }
    //gets the string value of a specific element in the list
    public String getValue(){
        return value;
    }
    //gets the size of the list
    public int getSize(){
        return elements.size();
    }
    //adds a node to the end of the list and changes the former last node to point to the newly added one
    public void add(String e){
        elements.add(new StringLinkedList(e));
        elements.get(elements.size()-2).nextElement=elements.get(elements.size()-1);
        if (elements.size()>1){
            elements.get(elements.size()-2).nextElement=elements.get(elements.size()-1);
        }
    }
    //checks to see if the value of a node equals the string in the argument
    public boolean contains(String e){
        for(StringLinkedList s:elements){
            if (s.getValue().equals(e)){
                return true;
            }
        }
        return false;
    }
    //gets the index of a node if its value equals the string in the argument, otherwise returns -1
    public int getIndexOf(String e){
        int count = 0;
        for(StringLinkedList s:elements){
            if (s.getValue().equals(e)){
                return count;
            }
            count++;
        }
        return -1;
    }
    //removes a node with the value of the argument, and changes the nextElements of the adjacent nodes to point to the
    //correct ones. Doesn't do this if the node with an equal value to the argument is the first node
    public boolean remove(String e){
        if (getIndexOf(e)!=-1&&getIndexOf(e)!=0){

            if(!elements.get(getIndexOf(e)).isLastElementInList())
                elements.get(getIndexOf(e)-1).nextElement=elements.get(getIndexOf(e)+1);
                elements.remove(getIndexOf(e));
            return true;
        }

        else if (elements.get(getIndexOf(e)).isLastElementInList()&&getIndexOf(e)!=0&&getIndexOf(e)!=-1){
            elements.get(getIndexOf(e)-1).nextElement=null;
            elements.remove(getIndexOf(e));
            return true;
        }
        return false;

    }
    //adds all of the values from a StringLinkedList or a StringSet to the original StringLinkedList
    public void addAllFromCollection(StringCollection collection){
        List<String> strList=collection.toList();
        for (String s:strList){
            elements.add(new StringLinkedList(s));
        }
    }
    //returns a list of all of the String values of the linked list in order
    public List<String> toList(){
        List<String> newList = new ArrayList<String>();
        for(StringLinkedList s:elements){
            newList.add(s.value);
        }
        return newList;
    }

}
