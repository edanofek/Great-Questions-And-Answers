// Java program to print all permutations of a
// given string.

import java.util.ArrayList;

public class Permutation
{
    public static void main(String[] args)
    {
        String str = "Tact Coa".toLowerCase(); 
        System.out.println(str);
        int n = str.length();
        Permutation permutation = new Permutation();
        permutation.permutationADT(str, 0, n-1);
    }

    /**
     * Pass on the permutation ADT
     * @param str string to calculate permutation for
     * @param l starting index
     * @param r end index
     */
    private void permutationADT(String str, int l, int r)
    {
        ArrayList<String> valStr = new ArrayList<String>();
        this.permute(valStr, str, l, r);
        System.out.println(valStr);
    }

    /**
     * check if the STR is Palindrome
     * @param val string to check (is palindrome)
     */
    private Boolean isPalindrome(String val)
    {
        Boolean retValue = true;
        int i = 0, j = val.length() - 1;

        do
        {
            if(val.charAt(i) == val.charAt(j))
            {
                i++;
                j--;
            }
            else
            {
                retValue = false;
            }

        }while(i<j && retValue == true);

        return retValue;

    }
 
    

    /**
     * permutation function
     * @param valStr hold the entire permutation strings values (ADT)
     * @param str string to calculate permutation for
     * @param l starting index
     * @param r end index
     */
    private void permute(ArrayList<String> valStr,String str, int l, int r)
    {
        if (l == r)
        {
            //check if is Palindrome
            if(this.isPalindrome(str))
            {
                 valStr.add(new String(str));
            }
        }
        else
        {
            for (int i = l; i <= r; i++)
            {
                str = swap(str,l,i);
                permute(valStr,str, l+1, r);
                str = swap(str,l,i);
            }
        }
        
    }
 
    /**
     * Swap Characters at position
     * @param a string value
     * @param i position 1
     * @param j position 2
     * @return swapped string
     */
    public String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
 
}
 
