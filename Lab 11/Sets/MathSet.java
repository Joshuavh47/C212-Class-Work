package Sets;


import java.util.*;

public class MathSet {
    /**
     *
     * @param a the first set to intersect
     * @param b the second set to intersect
     * @return a set of the intersection of set a and set b
     */
    public static Set<Integer> intersection (Set<Integer> a, Set<Integer> b) {
        Set<Integer> result = new HashSet<Integer>();
        //Checks to see which integers are contained in both sets and adds them to a set to be returned
        for(int i:a){
            if(b.contains(i)){
                result.add(i);
            }
        }
        return result;
    }
    /**
     *
     * @param a the first set
     * @param b the second set
     * @return a set of the union of set a and set b
     */
    public static Set<Integer> union (Set<Integer> a, Set<Integer> b){
        Set<Integer> result = new HashSet<Integer>();
        //Adds all the integers from both sets to a set to be returned. This works because sets can not contain more
        //than one of the same element
        for(int i:a){
            result.add(i);
        }
        for(int i:b){
            result.add(i);
        }
        return result;
    }
    /**
     *
     * @param a the first set
     * @param b the second set
     * @return a set of the compliment of set a in respect to set b
     */
    public static Set<Integer> compliment (Set<Integer> a, Set<Integer> b){
        Set<Integer> result = new HashSet<Integer>();
        //Checks to see if all the integers in the second set are not in the first set. If this is the case, it adds
        //the value to a set to be returned
        for(int i:b){
            if(!a.contains(i)){
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Set<Integer> a = new HashSet<Integer>();
        a.add(1);
        a.add(2);
        a.add(3);
        Set<Integer> b = new HashSet<Integer>();
        b.add(1);


    }
}
