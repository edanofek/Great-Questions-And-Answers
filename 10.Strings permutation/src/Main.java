import java.lang.String;
import java.lang.Integer;

import java.util.Hashtable;

public class Main {
    
 
        public static boolean isPermutation(String checkStr1,String checkStr2){
              if (str1.length() != str2.length())
                return false;
          
              char[] a = str1.toCharArray();
              char[] b = str2.toCharArray();
          
              Arrays.sort(a);
              Arrays.sort(b);
          
              return Arrays.equals(a, b);
                
        }

	public static void main(String[] args) { 

                String str1 = "7",
                str2 = "84",
                str3 = "722",
                str4 = "737";

                System.out.println(isPermutation(str1,str2));
                System.out.println(isPermutation(str3,str4));
                        
	}

}
