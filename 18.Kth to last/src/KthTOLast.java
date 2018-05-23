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

    public Integer returnKthTOLast(int k){

        int kPlace = 0,kThLastPlace = 0;
        while(kPlace  < m_list.size()){

            for (int j=0;j<k && kPlace < m_list.size();j++){
                kThLastPlace++;
                kPlace++;
                if(kPlace == m_list.size()){
                    return m_list.get(kThLastPlace);
                }
            }
            kThLastPlace-=1;
        }
        return m_list.get(kThLastPlace+1);
    }

    public static void main(String[] args) {
     
        KthTOLast _KthTOLast = new KthTOLast();
        System.out.print(" Kth last item in list is :"+ _KthTOLast.returnKthTOLast(3));

    }

}
