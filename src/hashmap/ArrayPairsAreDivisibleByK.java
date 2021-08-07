package hashmap;

// Read me:
// Problem statement :
// 1. Given array of integers of size n, and a number k.
// 2. You have to find if the given array can be divided into pairs such that the sum of every pairs is
// divisible by k.

// Example : Array = {56, 22, 34, 12, 78, 11, 98, 69};, k=10;
// Pairs will be {56, 34}, {22, 78}, {12,78}, {11,69} and in this case ans will be True.

import java.util.HashMap;
import java.util.Scanner;

public class ArrayPairsAreDivisibleByK {

    public static void solution(int[] arr, int k){
        HashMap<Integer, Integer> map = new HashMap<>(); // it wil store frequency of remainder
        for(int val : arr){
            int rem = val % k;
            int oldFreq = map.getOrDefault(rem, 0); // for first time it will give 0
            map.put(rem, oldFreq+1);
        }
        for(int val : arr){
            int rem = val % k;
            if(rem == 0){  // it means it is completely divisible by k,it should be even
                int freq = map.get(rem);
                if(freq % 2 == 1){ // checking even or not
                    System.out.println(false);
                    return;
                }
            }
            else if(2*rem == k){ // do not give k/2 ....checking if it is completely half then it should be even
                int freq = map.get(rem);
                if(freq % 2 == 1){
                    System.out.println(false);
                    return;
                }
            }
            else{
                int freq = map.get(rem); // otherwise frequency of remainder x and k-x should be same
                int otherFreq = map.getOrDefault(k-rem, 0);
                if(freq != otherFreq){
                    System.out.println(false);
                    return;
                }
            }
        }
        System.out.println(true);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i< n;i++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        solution(arr, k);
    }
}
