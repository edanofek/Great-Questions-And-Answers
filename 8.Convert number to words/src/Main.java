
import java.util.Arrays;


public class Main {

    private static  void switchCells(int[] array,int leftIndex,int rightIndex){
        int temp =
        array[leftIndex];

        array[leftIndex] = array[rightIndex];

        array[rightIndex] = temp;
    }

    
    public static void switchZerosAndOnes(int[] array){

        int leftIndex =0,rightIndex = array.length-1;
        final int numberToLeft = 0,numberToRight = 1;

        do{

            if(array[leftIndex] == numberToLeft){
                leftIndex++;
            }else{
                // switch the number at the left
                //1.find the nearest number from to right switch
                do{
                    if(array[rightIndex] == numberToLeft )
                    {
                        //2.switch between the cells
                        switchCells(array,leftIndex,rightIndex);
                        break;
                    }else{
                        rightIndex--;
                    }
                }while(leftIndex<rightIndex);
            }

            if(array[rightIndex] == numberToRight){
                rightIndex--;
            }else{
                // switch the number at the right
                //1.find the nearest number from to left switch
                do{
                    if(array[leftIndex] == numberToRight )
                    {
                        //2.switch between the cells
                        switchCells(array,leftIndex,rightIndex);
                        break;
                    }else{
                        leftIndex++;
                    }
                }while(leftIndex<rightIndex);
            }

        }while(leftIndex<rightIndex);
    }

	public static void main(String[] args) {
        int[] mockArray = {1,1,1,0,0,1,0,1,0};
        
        System.out.println("mock array befroe switch");
        System.out.println(Arrays.toString(mockArray));
        switchZerosAndOnes(mockArray);
        System.out.println("mock array after switch");
        System.out.println(Arrays.toString(mockArray));
	}

}
