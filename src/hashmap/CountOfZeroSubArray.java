package hashmap;

// Read me:
// Problem statement :
// 1. Given array of integers of size n.
// 2. You have to find the count of subarray with 0 sum.

// Example : Array = {2, 8, -3, -5};
// Answer will be 1 as we have 1 subarray {8, -3, -5}.
// Logic : if ith remainder mai x ayya hai aur i+k th index pai phir se x aata hai to
// it means i+k - i ke between jo bhi number hai unka sum 0 hai.

import java.util.HashMap;
import java.util.Scanner;

public class CountOfZeroSubArray {

    public static void solution(int[] arr){

        HashMap<Integer, Integer> map = new HashMap<>(); // sum as a key and value as their frequency
        int i = -1;
        int sum =0;
        int count = 0;
        map.put(sum, 1); // 0 sum key pe 1 daal diye
        while(i < arr.length -1){ // arr.length -1 kyu ????? kyu ki i ko +1 se badha rahe hai
            i++;
            sum += arr[i]; // sum nikala
            if(map.containsKey(sum)){ // check kiya ki pahele ye sum aa chuka hai ki nhi
                count += map.get(sum); // uska frequency nikal ke cound mai add kar do
                map.put(sum, map.get(sum)+1); // freq ko update kar do map mai
            }
            else{
                map.put(sum, 1); // pahele bar aaya hai to sum pai 1 daal do
            }
        }
        System.out.println(count);
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
