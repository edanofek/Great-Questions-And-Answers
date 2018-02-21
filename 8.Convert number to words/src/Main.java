import java.util.Arrays;
import java.util.Hashtable;

class Main {
  
    private static Hashtable<Integer ,String> zeroToNine;
    private static Hashtable<Integer ,String> tenToNinety;
    private static Hashtable<Integer ,String> hundredThousend;
    private static Integer divider = 1000; 



    private static String convertNumberToWords(Integer  number){
       
        if(number < divider){
            // convert to words - future coding
            // con't here
            return number.toString();
        }
         
        return convertNumberToWords((number%divider))+convertNumberToWords(number/divider);
    }

	public static void main(String[] args) {
        Integer  number = 1986710102;
        zeroToNine = new Hashtable<Integer ,String>();
        tenToNinety = new Hashtable<Integer,String>();
        
        System.out.println("number intger");
        System.out.println(number);

        System.out.println("number converted to words");
        System.out.println(convertNumberToWords(number));
        
	}

}