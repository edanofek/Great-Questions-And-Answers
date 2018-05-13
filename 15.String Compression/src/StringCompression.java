
public class StringCompression {

    public static void main(String args[]){

        String str = "aabcccccaaa";
        StringCompression _StringCompression = new StringCompression();

        // should return a2blc5a3
        System.out.println(_StringCompression.stringCompressionCount(str));
        
    }

    private string stringCompressionCount(String str){
        int baseCount = str.length();
        String reString = new String();

        int currentCharCounter = 1;
        
        for(int i=0;i<str.length()-1;i++){
            if(str.charAt(i) == str.charAt(i+1)){
                currentCharCounter++;
            }else{
                reString+=String.valueOf(str.charAt(i))+String.valueOf(currentCharCounter);
                currentCharCounter = 1;
            }
        }
        reString+=String.valueOf(str.charAt(i))+String.valueOf(currentCharCounter);
        return reString.length() >= str.length() ? str : reString;
    }

}
