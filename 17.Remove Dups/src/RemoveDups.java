import java.util.*;

public class RemoveDups {

   private LinkedList<Integer> m_unsorted_list;

   //Cto'r
    public RemoveDups(){
        //un sorted list
        m_unsorted_list = new LinkedList<Integer>(3,2,1,5,6,7,3,2,1,8,9);

    }
    
    //Solution one : with extra space - O[n-all items in the list] time complex / O[unique keys] memory
    private void removeDupsWithMemoryHelp() {

        Hashtable<Integer,Integer> repNumbers = new Hashtable<Integer,Integer>(0);

        for (Integer item : m_unsorted_list) {
            Integer value = repNumbers.get(item);
            
            repNumbers.put(item, value+1);
            if(repNumbers.get(item)>1){
                m_unsorted_list.remove(item);
                repNumbers.put(item, 1);
            }
        }
        
    }
    
    //Solution Two : without exta space - o[n*n] time / o[1] memory
    private void removeDupsWithoutMemoryHelp() {

       int i=0,j=0;
       do{

        for(j=i+1;j<m_unsorted_list.size();j++){
            
            if(m_unsorted_list.get(i).intValue() == m_unsorted_list.get(j).intValue()){
                m_unsorted_list.remove(j);
            }

        }
        
        i++;

       }while(i<m_unsorted_list.size());

    }

    public static void main(String[] args) {

        RemoveDups m_RemoveDups = new RemoveDups();
        System.out.println("Before:");
        System.out.println(m_RemoveDups.m_unsorted_list);
        
        m_RemoveDups.removeDupsWithMemoryHelp();
        System.out.println("After solution one:");
        System.out.println(m_RemoveDups.m_unsorted_list);

        m_RemoveDups.removeDupsWithoutMemoryHelp();
        System.out.println("After solution two:");
        System.out.println(m_RemoveDups.m_unsorted_list);
    }
    
}