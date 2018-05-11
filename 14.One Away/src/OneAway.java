
import java.util.ArrayList;
import java.util.Hashtable;

public class OneAway {


    public static void main(String[] args){

        OneAway _OneAway = new OneAway();
        String word1 = "pale",word2 = "ple";

        System.out.println(_OneAway.oneEdit(word1, word2));
         
    }

    private boolean oneEdit(String word1,String word2) {

        //if word1 content equals word2  
        if(word1.contentEquals(word2) ){
            return true;
        }else{
            //comprasion length for both words can one or zero other wise false
            if(Math.abs(word1.length() - word2.length()) > 1){
                return false;
            }else{ 
                
                String largerWord = word1.length() >= word2.length() ? word1 : word2;
                String smallerWord = word1.length() < word2.length() ? word1 : word2;
                
                //let's check for only the same number of latters
                int numbersOfEdits =0;
                // pale, bale -> true --> change one lattar in word one or word two 
                if(largerWord.length() == smallerWord.length()){
                    for (int i=0;i<largerWord.length();i++) {
                        if(largerWord.charAt(i) != smallerWord.charAt(i)){
                            numbersOfEdits++;
                        }    
                        if(numbersOfEdits > 1){
                            return false; //more than one edit
                        }
                    }
                }else{
                    
                    // pale, ple -> true  --> add one latter in word one  or remove one latter in word two
                    // abcde, abde -> true -- > need to add latter 'c' to word 2 or remove one latter
                    numbersOfEdits = 1; //base edit number (need to add one latter to smaller word)
                    String addLatterWord;
                    for(int i=0;i<largerWord.length();i++){
                        if(!smallerWord.contains(new String(largerWord.charAt(i)))){
                            //find the missing char @ place i
                            addLatterWord = new String(
                                smallerWord.substring(0, i)
                                +new String(largerWord.charAt(i))
                                +smallerWord.substring(i+1, smallerWord.length()-1));
                            break; // exit the loop
                        }
                    }

                    for (int i=0;i<largerWord.length();i++) {
                        if(largerWord.charAt(i) != addLatterWord.charAt(i)){
                            return false; //more than one edit return false
                        }    
                    }

                    return true; //only one edit
                }
            }
            

        }
        
        
    }

   

}