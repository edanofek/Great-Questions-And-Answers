import java.lang.String;
import java.lang.Integer;

import java.util.Hashtable;


 
public class Main {
    
    public class Mergesort {
        private int[] numbers;
        private int[] helper;
    
        private int number;
    
        public void sort(int[] values) {
            this.numbers = values;
            number = values.length;
            this.helper = new int[number];
            mergesort(0, number - 1);
        }
    
        private void mergesort(int low, int high) {
            // check if low is smaller than high, if not then the array is sorted
            if (low < high) {
                // Get the index of the element which is in the middle
                int middle = low + (high - low) / 2;
                // Sort the left side of the array
                mergesort(low, middle);
                // Sort the right side of the array
                mergesort(middle + 1, high);
                // Combine them both
                merge(low, middle, high);
            }
        }
    
        private void merge(int low, int middle, int high) {
    
            // Copy both parts into the helper array
            for (int i = low; i <= high; i++) {
                helper[i] = numbers[i];
            }
    
            int i = low;
            int j = middle + 1;
            int k = low;
            // Copy the smallest values from either the left or the right side back
            // to the original array
            while (i <= middle && j <= high) {
                if (helper[i] <= helper[j]) {
                    numbers[k] = helper[i];
                    i++;
                } else {
                    numbers[k] = helper[j];
                    j++;
                }
                k++;
            }
            // Copy the rest of the left side of the array into the target array
            while (i <= middle) {
                numbers[k] = helper[i];
                k++;
                i++;
            }
            // Since we are sorting in-place any leftover elements from the right side
            // are already at the right position.
    
        }
    }

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
    
    public static boolean isUniqueMergesort(String str){

        boolean isUniqueFlag = true;
        int []arr = new int[str.length()];
        int i=0;

        for(;i<str.length();i++){
            arr[i] = Character.getNumericValue(str.charAt(i));
        }

        // Mergesort _Mergesort = new Mergesort();
        // Mergesort.sort(arr);

        for(i=1;i<str.length() && isUniqueFlag == true;i++){
            if(arr[0] == arr[1]){
                isUniqueFlag = false;
            }
        }

        return isUniqueFlag;
    }

	public static void main(String[] args) { 

        String checkIsUnique1 = "#44",
        checkIsUnique2 = "#117",
        checkIsUnique3 = "#132";

        System.out.println(isUnique(checkIsUnique1));
        System.out.println(isUnique(checkIsUnique2));
        System.out.println(isUnique(checkIsUnique3));
        
        // System.out.println(isUniqueMergesort(checkIsUnique1));
		// System.out.println(isUniqueMergesort(checkIsUnique2));
        // System.out.println(isUniqueMergesort(checkIsUnique3));
        
	}

}
