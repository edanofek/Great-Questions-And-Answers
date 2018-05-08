
import java.util.ArrayList;
import java.util.Hashtable;

public class OneAway {

    // Way to solve this problem:
    // 1.check for each word the numer of latters.
    // 2.check for each word the latter places.
    // 3.check for number of removeals (can be such as #1 with minus operation)
    // 4.need to rethink about how to solve this problem.

    // private Hashtable<Character,Integer> angramCheck;

    // Cto'r
    public OneAway(){
        // diffrentOfLaters = new Hashtable<Character,Integer>();
        
    }

    private boolean oneEdit(String word1,String word2) {

        boolean retRes = true;
        //word1 contains word2
        if(word1.contains(word2)){
            return true;
        }else{
            //only one edit action need to be made in order to support the  contains action
            // TODO:Con't here
            
        }
        
        //2.numbers of latter (don't must be relevent)
        return retRes;
    }

    public static void main(String[] args){

        OneAway _OneAway = new OneAway();
        String word1 = "pale",word2 = "ple";

        System.out.println(_OneAway.oneEdit(word1, word2));
         
    }

}