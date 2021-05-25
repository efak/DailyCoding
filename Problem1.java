/**
 * This problem was recently asked by Google.
Given a list of numbers and a number
k, return whether any two numbers from the list addup to
k. For example, given [10, 15, 3, 7] and k of 17, return true since
10 + 7 is 17.
Bonus: Can you do this in one pass?
 */

import java.util.ArrayList;

public class Problem1 {
    
    static boolean TwoSum(int[] theList, int k){
        int diff;
        ArrayList<Integer> alist = new ArrayList<>();

        for(int num: theList){
            diff = k - num;
            System.out.println("diff = " + diff);
            if ( alist.contains(diff)){
                return true;
            }
            else{
                alist.add(num);
            }
        }
        
        return false;
    }

    public static void main(String[] args) {
        int[] theList = {10, 15, 3, 7};
        int k = 17;

        if (TwoSum(theList, k)){
            System.out.println("Yes, two numbers add up to " + k);
        }
        else{
            System.out.println("Nope");
        }
    }
}
