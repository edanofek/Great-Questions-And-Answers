
import java.util.Arrays;


import java.util.Hashtable;


public class Main {

    private Hashtable<Integer ,String> zeroToNine;
    private Hashtable<Integer ,String> tenToNinety;
    private Hashtable<Integer ,String> hundredThousend;

    private static Integer  divider;// = 1000; 

    public Main() {
        super();
        zeroToNine = new Hashtable<Integer ,String>();
        tenToNinety = new Hashtable<Integer,String>();
        divider = 1000;
    }

    private static String convertNumberToWords(Integer  number){
        
        if(number<divider){
            return number.toString();
        }
        number/=(divider/10);
        return convertNumberToWords(number%divider);
        
    }

	public static void main(String[] args) {
        Integer  number = 112;
        
        System.out.println("number intger");
        System.out.println(number);

        System.out.println("number converted to words");
        System.out.println(convertNumberToWords(number));
        
	}

}
