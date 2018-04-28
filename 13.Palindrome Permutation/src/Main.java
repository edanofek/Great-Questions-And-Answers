import java.lang.String;
import java.lang.Integer;


public class Main {

    private static Boolean isPalindrome(String val){

        Boolean _isPalindrome = true;

        return _isPalindrome;

    }

    // private static String[] returnPermutation(String val) {

    //     return [];

    // }

    // public static String[] palindromePermutation(String val){
        
    //     return [];

    // }

    public static void printPermutation(String val) {

        if(val.length() == 0){
            System.out.println("---");
            return ;            
        }
        String valTemp = new String(val);
        for (char ch : val.toCharArray()) {
            
            System.out.println(ch);
            valTemp = valTemp.replace(String.valueOf(ch),"");
            // System.out.println(valTemp);
            printPermutation(valTemp);
        }

    }

	public static void main(String[] args) { 

        String input = "ABC"; //Tact Coa";
        
        printPermutation(input);
        
                        
	}

}
