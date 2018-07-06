import java.util.ArrayList;

public class ZeroOneTwoArray {

    private ArrayList<Integer> oneTwoArray;
    public ZeroOneTwoArray(){

        oneTwoArray = new ArrayList<Integer>();
        oneTwoArray.add(2);
        oneTwoArray.add(1);
        oneTwoArray.add(0);
        oneTwoArray.add(1);
        oneTwoArray.add(2);
        oneTwoArray.add(1);
        oneTwoArray.add(0);

    }

    private void swapValuesByIndexes(int leftInd,int rightInd){

        Integer tempValue = oneTwoArray.get(leftInd);
        Integer rightValue = oneTwoArray.get(rightInd);

        oneTwoArray.set(leftInd,rightValue);
        oneTwoArray.set(rightInd,tempValue);
    }

    private int sortTwoValuesIntoLeftAndRightInArr(int leftValue,int rightValue,int rightIndex){
        int p1=0,p2=rightIndex;
        boolean swapValue;
        do{
            swapValue = false;
            if(oneTwoArray.get(p2).intValue() != rightValue){ //check the left value is in right place
                while(swapValue == false && p1<p2){
                    if(oneTwoArray.get(p1).intValue() == rightValue){
                        swapValuesByIndexes(p1,p2);
                        swapValue = true;
                    }
                    p1++;
                }

            }

            p2--;

        }while (p1<p2);
        return p2;
    }
    public void zeroOneTwoArrayOrder(){

        int firstRoundRightPointer = sortTwoValuesIntoLeftAndRightInArr(0,2,oneTwoArray.size()-1);
        sortTwoValuesIntoLeftAndRightInArr(0,1,firstRoundRightPointer);
        System.out.print(oneTwoArray);
    }

    public static void main(String[] args) {

        ZeroOneTwoArray _zeroOneTwoArray = new ZeroOneTwoArray();
        _zeroOneTwoArray.zeroOneTwoArrayOrder();
        
    }
}
