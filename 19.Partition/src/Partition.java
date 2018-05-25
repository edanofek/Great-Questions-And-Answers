import java.util.LinkedList;


public class Partition {

    private LinkedList<Integer> m_list;

    public Partition(){

        m_list = new LinkedList<>();
        m_list.add(3);
        m_list.add(5);
        m_list.add(8);
        m_list.add(5);
        m_list.add(10);
        m_list.add(2);
        m_list.add(1);

    }

    public LinkedList<Integer> partition(int x) {
        
        LinkedList<Integer> retList = new LinkedList<Integer>();
        int i=0,j=0;
        do{
            if(m_list.get(j).intValue() < x){
                retList.add(i,m_list.get(j));
                m_list.remove(j);
                i++;
            }else{
                j++;
            }

        }while (j<m_list.size());


        j=0;
        do{
            retList.add(i,m_list.get(j));
            m_list.remove(j);
            i++;
        }while (m_list.size() > 0);
        return retList;
        
    }

    public static void main(String[] args) {
     
        Partition partition = new Partition();
        System.out.print(partition.partition(5));

    }
}

