import java.util.LinkedList;

public class PalindromeLinkedList {
    
    public boolean isPalindromeLinkedList(LinkedList<Character> checkList){

        int p1 =0,p2 = checkList.size()-1;
        while (p1<p2){
            if (checkList.get(p1) != checkList.get(p2)){
                return  false;
            }
            p1++;
            p2--;
        }
        return true;

    }

    public static void main(String[] args) {

        PalindromeLinkedList _PalindromeLinkedList = new PalindromeLinkedList();

        LinkedList<Character> mListPoly;
        LinkedList<Character> mListNotPoly;

        mListPoly = new LinkedList<>();
        mListPoly.add('a');
        mListPoly.add('b');
        mListPoly.add('c');
        mListPoly.add('b');
        mListPoly.add('a');

        mListNotPoly = new LinkedList<>();
        mListNotPoly.add('a');
        mListNotPoly.add('b');
        mListNotPoly.add('c');
        mListNotPoly.add('d');
        mListNotPoly.add('e');
        mListNotPoly.add('f');

        System.out.print(_PalindromeLinkedList.isPalindromeLinkedList(mListPoly));
        System.out.print(_PalindromeLinkedList.isPalindromeLinkedList(mListNotPoly));
        
    }
}
