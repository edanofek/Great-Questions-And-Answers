import java.lang.String;
import java.lang.Integer;


public class Main {
    
    private static int returnNewLength(char[] val){
        
        int newLength = 0;
        int lastLatterPlace = getLastLatterPlace(val);
        int valIndex = 0;

        for (char letter : val) {
            if(letter == ' '){
                newLength += 3; //replace space with new length '%20' + 2 new chars places
            }else{
                newLength += 1;
            }

            if(valIndex == lastLatterPlace){
                break;
            }
            valIndex += 1;
        }

        return newLength;

    }

    private static int getLastLatterPlace(char []val) {
        
        int lastLatterPlace = 0;
        int index =0;
        for (char letter : val) {

            if(letter != ' '){
                lastLatterPlace = index;
            }
            
            index +=1;
            
        }

        return lastLatterPlace;

    }

    public static char[] repalceAllSpaces(char[] val,int length){
        
        int newLength = returnNewLength(val);
        char[] retValue = new char[newLength];
               
        int index = 0,valIndex = 0;
        int lastLatterPlace = getLastLatterPlace(val);

        for (char letter : val) {
            if(letter == ' ' && index > 0  && valIndex < lastLatterPlace ){
                retValue[index] = '%';
                retValue[index+1] = '2';
                retValue[index+2] = '0';
                index += 3;
            }else {
                retValue[index] = letter;
                index += 1;
            }

            
            if(valIndex == lastLatterPlace){
                
                break;
            }

            valIndex += 1;
        }

        return retValue;
    }

	public static void main(String[] args) { 

        int length = 13;
        char[] val = {'M','r',' ','J','o','h','n',' ','S','m','i','t','h',' '};
        
        System.out.println(repalceAllSpaces(val,length));
                        
	}

}
