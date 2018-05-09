
import java.util.ArrayList;
import java.util.Hashtable;

public class OneAway {


    public static void main(String[] args){

        OneAway _OneAway = new OneAway();
        String word1 = "pale",word2 = "ple";

        System.out.println(_OneAway.oneEdit(word1, word2));
         
    }
    
    private boolean oneEdit(String word1,String word2) {

        
        //if word1 contains word2 or word2 contains word1 
        if(word1.contains(word2) || word2.contains(word1)){
            return true;
        }else{

            // What is the largest sub string
            //only one edit action need to be made in order to support the  contains action
            
            // Ways to solve this problem:
            // 1.if change one latter does the string will be contains -> O[N]
            // 2.if remove one latter does the string will be contains -> O[N]
            // 3.if add one latter does the string will be contains -> O[N]
            String largerWord = word1.length() >= word2.length() ? word1 : word2;
            String smallerWord = word1.length() < word2.length() ? word1 : word2;

            int iw1=0,iw2=0;
            int numberOfMisses =0;

            for(;iw1<smallerWord.length() && iw2 <largerWord.length();){
                if(smallerWord.charAt(iw1) != largerWord.charAt(iw2)){
                    numberOfMisses++;       
                    iw2++;
                }
                if(numberOfMisses > 1)
                    return false;
                iw1++;
            }
            
        }
        
        //2.numbers of latter (don't must be relevent)
        return true;
    }

   

}