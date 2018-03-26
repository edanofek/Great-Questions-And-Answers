import java.lang.String;
import java.lang.Integer;

import java.util.Hashtable;


public class Main {
    
	public static boolean isUnique(String str){

		boolean isUniqueFlag = true;
		int i=0;
		Hashtable<Character,Integer> lattersTable =
			 new Hashtable<Character,Integer>();

		do{
			 
			Character key = str.charAt(i);

			if(lattersTable.get(key) != null){
				isUniqueFlag = false;
			}

			lattersTable.put(key,lattersTable.get(key) == null ? 1 : lattersTable.get(key)+1);
			i++;

		}while(isUniqueFlag == true && i< str.length() );

		return isUniqueFlag;
	}

	public static void main(String[] args) { 
	  String checkIsUnique1 = "#44",
	  checkIsUnique2 = "#117",
	  checkIsUnique3 = "#132";

		System.out.println(isUnique(checkIsUnique1));
		System.out.println(isUnique(checkIsUnique2));
		System.out.println(isUnique(checkIsUnique3));
	}

}
