package hashmap;

import java.util.HashMap;
import java.util.Scanner;

// Read me:
// Problem statement :
// 1. Given array of integers of size n.
// 2. You have to find the length of the largest subarray with 0 sum.

// Example : Array = {2, 8, -3, -5};
// Answer will be 3 because sum of {8, -3, -5} will be 0 and largest.

// Logic : if ith remainder mai x ayya hai aur i+k th index pai phir se x aata hai to
// it means i+k - i ke between jo bhi number hai unka sum 0 hai.

public class LargestSubArrayWithZeroSum {

    public static void solution(int[] arr){
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum =0;
        int i= -1;
        int mLen=0;
        map.put(sum, i);  // we are putting sum pe index value
        while (i < arr.length-1){
            i++;
            sum += arr[i];
            if(map.containsKey(sum) == false){
                map.put(sum, i);  // if pahele nhi aaya to map mai daal denge
            }
            else{
                int len = i - map.get(sum); // nhi to last time ye sum kab aaya tha uska index nikal denge
                if(len > mLen){
                    mLen = len; // max length update kar denge
                }
            }
        }
        System.out.println(mLen);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i< n;i++){
            arr[i] = sc.nextInt();
        }
        solution(arr);
    }

}
