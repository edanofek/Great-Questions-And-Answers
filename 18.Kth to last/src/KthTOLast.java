import java.util.LinkedList;


public class KthTOLast {

    private LinkedList<Integer> m_list;

    public KthTOLast() {

        m_list = new LinkedList<>();
        m_list.add(0);
        m_list.add(1);
        m_list.add(2);
        m_list.add(3);
        m_list.add(4);
        m_list.add(5);
        m_list.add(6);
        m_list.add(7);
        m_list.add(8);
        m_list.add(9);
        m_list.add(10);
        m_list.add(11);
        m_list.add(12);
        m_list.add(13);
        m_list.add(14);

    }

    private Integer advanceListIndexes(int p1,int p2){
        for(i=0;i<k;i++){
            if(p1 < m_list.size()){
                p1++;
                p2++;
            }else{
                return m_list.get(p2);
            }
        }
    }
    public Integer returnKthTOLast(int k){

        int p1=0,p2=0;
        if(k ==0) {
            k =1;
        }

        advanceListIndexes(p1,p2);
        p2=0;
        
        while(p1 < m_list.size()){
            advanceListIndexes(p1,p2);
        }

        return m_list.get(p2);
    }


    public static void main(String[] args) {
     
        KthTOLast _KthTOLast = new KthTOLast();
        System.out.print(" Kth last item in list is :"+ _KthTOLast.returnKthTOLast(3));

    }

}
