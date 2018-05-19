import java.util.*;

public class RemoveDups {

   private LinkedList<Integer> m_unsorted_list;

   //Cto'r
    public RemoveDups(){
        //un sorted list
        m_unsorted_list = new LinkedList<Integer>(3,2,1,5,6,7,3,2,1,8,9);

    }
    
    private void removeDups() {

        Hashtable<Integer,Integer> repNumbers = new Hashtable<Integer,Integer>(0);

        for (Integer item : m_unsorted_list) {
            Integer value = repNumbers.get(item);
            
            System.out.println(value);
            // repNumbers.put(item, );
        }
    }

    public static void main(String[] args) {

        RemoveDups m_RemoveDups = new RemoveDups();
        System.out.println("Before:");
        System.out.println(m_RemoveDups.m_unsorted_list);
        m_RemoveDups.removeDups();
        System.out.println("After:");
        System.out.println(m_RemoveDups.m_unsorted_list);
    }
    
}