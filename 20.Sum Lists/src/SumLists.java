import java.util.LinkedList;

public class SumLists {

    private LinkedList<Integer> m_list1;
    private LinkedList<Integer> m_list2;

    public SumLists(){

        m_list1 = new LinkedList<>();
        m_list2 = new LinkedList<>();

        
        m_list1.add(1);
        m_list1.add(7);

        m_list2.add(5);
        m_list2.add(9);
        m_list2.add(2);
        m_list2.add(2);
        m_list2.add(3);


    }

    public LinkedList<Integer> sumLists() {

        LinkedList<Integer> retList = new LinkedList<Integer>();

        createEqualLists();

        int indexRetList=0,sumTwoValues =0;
        for(int i=0;i<m_list1.size();i++){
            sumTwoValues = m_list1.get(i)+m_list2.get(i);
            if(sumTwoValues > 9){
                retList.add(indexRetList,sumTwoValues%10);
                indexRetList++;
                retList.add(indexRetList,sumTwoValues/10);
            }else{
                retList.add(indexRetList,sumTwoValues);
            }
            indexRetList++;
        }


        return retList;
    }


    private void createEqualLists(){
        int addZeroLength;
        if (m_list1.size() > m_list2.size()){
            addZeroLength = (m_list1.size() - m_list2.size());
            //add to m_list 1 zeros
            for (int i =0;i<addZeroLength;i++){
                m_list2.addFirst(0);
            }
        }else{
            addZeroLength = (m_list2.size() - m_list1.size());
            //add to m_list 2 zeros
            for (int i =0;i<addZeroLength;i++){
                m_list1.addFirst(0);
            }
        }
    }

}
