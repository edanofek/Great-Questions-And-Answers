import java.lang.String;

public class Main {
    
    public static String removeNotLatters(String strToRemoveRegex){
        String pattern = "\\w";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(strToRemoveRegex);
        return m.group(0);
    }
    public static boolean isPoli(String checkPoli){
    
        int leftIndex =0,rightIndex = array.length-1;
        
        if(checkPoli.charAt(0) == checkPoli.charAt(checkPoli.length-1)){
            return isPoli(checkPoli.substring(1,checkPoli.length - 2));
        }
        return false;
        
    }

	public static void main(String[] args) {
        String checkPoliandrome1 = "$XY123m422X*";
        String checkPoliandrome2 = "$X123m4*22X*";

        System.out.println("mock array befroe switch");
        System.out.println(removeNotLatters(checkPoliandrome1));
        System.out.println("mock array after switch");
        System.out.println(removeNotLatters(checkPoliandrome2));
	}

}
