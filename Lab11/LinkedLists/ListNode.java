package LinkedLists;

import java.util.*;
class ListNode {
    int val;
    ListNode next;
    public ListNode(int val) {
        this.val = val;
    }
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
    public int size(ListNode node){
        int count=0;
        ListNode temp = node;
        while(temp!=null) {
            temp = temp.next;
            count++;
        }
        return count;
    }

    /**
     *
     * @param l The LinkedList to perform the swap on
     * @param first The first index to swap
     * @param second The second index to swap
     * @return A new LinkedList with the specified spots swapped
     */
    public LinkedList<ListNode> swap(LinkedList<ListNode> l, int first, int second){

        ArrayList<ListNode> arr=new ArrayList<ListNode>();
        //adds all the nodes to an ArrayList
        for(ListNode ln:l){
            arr.add(ln);
        }
        if(first>=second){
            System.out.println("End can't be smaller than start");
            return null;
        }
        else if(second>=arr.size()||(first<0||first>=arr.size())){
            System.out.println("Either start or end is wrong.");
        }
        //swaps the specified indices of the ArrayList
        Collections.swap(arr, first, second);
        //if the second index isn't at the end, it will make every node except for the last one point to the node after
        //it in the ArrayList
        if(first!=0&&second!=arr.size()-1){
            for(int i=0;i<arr.size()-2;i++){
                arr.get(i).next=arr.get(i+1);
            }
        }
        //if the second index is at the end, it will make every node point to the next in the ArrayList and the last
        //one point to null
        else{
            for(int i=0;i<arr.size()-2;i++){
                arr.get(i).next=arr.get(i+1);
            }
            arr.get(arr.size()-1).next=null;
        }

        LinkedList<ListNode> retList = new LinkedList<ListNode>();
        for(ListNode retNode:arr){
            retList.add(retNode);
        }
        //returns the new LinkedList
        return retList;
    }

    /**
     *
     * @param l The LinkedList to test
     * @return If the LinkedList is infinitely looping or not
     */
    public boolean isLoop(LinkedList<ListNode> l){
        ArrayList<ListNode> arrList=new ArrayList<ListNode>();
        //Adds each node to an ArrayList, checking if the next node points to any of the previous nodes stored in the
        //ArrayList (if this is the case, the LinkedList will loop infinitely and return true, otherwise returning false).
        for(ListNode ln:l){
            arrList.add(ln);
            for(int j=0;j<arrList.size();j++){
                if (ln.next==arrList.get(j)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LinkedList<ListNode> ll=new LinkedList<ListNode>();
        ListNode n4=new ListNode(4);
        ListNode n3=new ListNode(3, n4);
        ListNode n2=new ListNode(2, n3);
        ListNode n1=new ListNode(1, n2);

        ll.add(n1);
        ll.add(n2);
        ll.add(n3);
        ll.add(n4);
        //prints original nodes in order
        for(ListNode l:ll){
            System.out.println(l.val);
        }
        System.out.println();
        //prints nodes in order after swapping index 1 and 2
        for(ListNode l:n1.swap(ll, 1, 2)){
            System.out.println(l.val);
        }
        System.out.println();
        //prints nodes in order after swapping index 2 and 3
        for(ListNode l:n1.swap(ll, 2, 3)){
            System.out.println(l.val);
        }
        System.out.println();

        //tests to see if the original LinkedList is infinitely looping (it should not)
        System.out.println(n1.isLoop(ll));
        //added a previous node to the end to cause an infinite loop
        ll.add(n2);
        //tests to see if the new LinkedList is infinitely looping (it should now return true)
        System.out.println(n1.isLoop(ll));
    }
}
/*
 * For this problem, I put all the nodes into an ArrayList and used the swap method in the Collections interface.
 * I looped through the List, making each node point to the next node except for the last one, which would point to the
 * one that it was pointing to previously. If the last node is being swapped, I repeat this process but make the last
 * node after the swap point to null, as is shown in the examples included in the lab. To determine if the list loops,
 * put all the nodes in the LinkedList into an ArrayList and after each one is added, it will test each of the
 * previously added nodes to see if they are equal to the next node being added. If they are equal, the List will
 * repeat infinitely and return true. Otherwise, it will return false.
 */
