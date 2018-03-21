import java.lang.String;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main {
    
    public static String removeNotLatters(String strToRemoveRegex){
        String pattern = "\\w";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(strToRemoveRegex); 
        return m.group(0);
    }
    public static boolean isPoli(String checkPoli){
    
        if(checkPoli.charAt(0) == checkPoli.charAt(checkPoli.length() - 1)){
            return isPoli(checkPoli.substring(1,checkPoli.length() - 2));
        }
        return false;
        
    }

	public static void main(String[] args) { 
        String checkPoliandrome1 = "$XY123m422X*";
        String checkPoliandrome2 = "$X123m4*22X*";

        
        System.out.println(String.valueOf(isPoli(removeNotLatters(checkPoliandrome1))));
        System.out.println(String.valueOf(isPoli(removeNotLatters(checkPoliandrome2))));
	}

}
