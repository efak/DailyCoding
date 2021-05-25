import java.util.HashSet;

public class Problem4 {

    static int missingNumber(int[] arr){

        HashSet<Integer> set = new HashSet<>();
        int i = 1;

        for(int num: arr){
            set.add(num);
        }

        while( set.contains(i) ){
            i++;
        }

        return i;
    }  
    
    public static void main(String[] args) {
        int[] arr = {3, 4, -1, 1};
        int[] eg2 = {1, 2, 0};
        System.out.println("Missing number: " + missingNumber(arr));
        System.out.println("Missing number: " + missingNumber(eg2));
    }
}
