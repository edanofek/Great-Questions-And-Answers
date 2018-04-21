import java.lang.String;
import java.lang.Integer;


public class Main {
    
    private static int returnNewLength(char[] val){
        
        int newLength = 0;

        for (char letter : val) {
            if(letter == ' '){
                newLength += 2; //replace space with new length '%20' + 2 new chars places
            }
            else{
                newLength += 1;
            }
        }

        return newLength;

    }

    public static char[] repalceAllSpaces(char[] val,int length){
        
        int newLength = returnNewLength(val);
        char[] retValue = new char[newLength];
       
        int index = 0;
        for (char letter : val) {
            if(letter == ' '){
                retValue[index] = '%';
                retValue[index+1] = '2';
                retValue[index+2] = '0';
                index += 2;
            }
            else{
                retValue[index] = letter;
                index += 1;
            }
        }

        return retValue;
    }

	public static void main(String[] args) { 

        int length = 13;
        String str = "Mr John Smith "; 
        char []val = str.toCharArray();
        // TODO:Fix the value here

        System.out.println(repalceAllSpaces(val,length));
                        
	}

}
