
/**
 * Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.

For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].

Follow-up: what if you can't use division?
 */
public class DayTwo {

    static int computeProduct(int[] arr, int start, int end){
        int prod = 1;

        for(int i = start; i <= end; i++){
            prod *= arr[i];
        }

        return prod;
    }
    

    static void BuildProductArray(int[] theList){
        int len = theList.length;
        int prod = 1;
        int[] product = new int[len];

        for( int num: theList){
            prod *= num;
        }

        for( int i = 0; i < len; i++){
            product[i] = prod / theList[i];
        }

        System.out.print("[");
        for( int num: product){
            System.out.print(num + ", ");
        }
        System.out.println("\b\b]");
    }

  //O(n^2)
    static void BuildProductArray2(int[] theList){
        int ls, le, rs, re, lprod, rprod;
        int len = theList.length;
        int[] product = new int[len];


        for( int i = 0; i < len; i++){
            ls = 0;
            le = ( i - 1 ) < 0 ? 0 : i - 1;

            rs = ( i + 1 ) > len ? len -1 : i + 1;
            re = len - 1;

            lprod = computeProduct(theList, ls, le);
            rprod = computeProduct(theList, rs, re);
            product[i] =  lprod * rprod;
        }

        System.out.print("[");
        for( int num: product){
            System.out.print(num + ", ");
        }
        System.out.println("\b\b]");
    }


    //O(n^2)
    static void BuildProductArray3(int[] theList){
        int len = theList.length;
        int[] product = new int[len];
        int[] prefix_prod = new int[len];
        int[] suffix_prod = new int[len];

        //build prefix array
        prefix_prod[0] = theList[0];
        for(int i = 1; i < len; i++){
            prefix_prod[i] = theList[i] * prefix_prod[i-1];
        }

        //build suffix array
        suffix_prod[len-1] = theList[len-1];
        for(int i = len-2; i >= 0; i--){
            suffix_prod[i] = theList[i] * suffix_prod[i+1];
        }

        //build product array
        for(int i = 0; i < len; i++){
            if( i == 0 ){
                product[i] = suffix_prod[i+1];
            }
            else if(i == len - 1){
                product[i] =  prefix_prod[i-1];
            } else{
                product[i] =  prefix_prod[i-1] * suffix_prod[i+1];
            }
        }

        //print product
        System.out.print("[");
        for( int num: product){
            System.out.print(num + ", ");
        }
        System.out.println("\b\b]");
    }


    public static void main(String[] args) {
        int[] theList = {1, 2, 3, 4, 5};
        BuildProductArray(theList);
        BuildProductArray2(theList);
        BuildProductArray3(theList);
    }
    
}
