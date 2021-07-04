package programs;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.*;
import java.util.regex.*;

public class findpairs {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) { //1,2,1,2,1,3,2
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            if (map.containsKey(ar[i])) {
                map.put(ar[i],map.get(ar[i])+1);
            }
            else{
            	map.put(ar[i], 1); 
            }
        }
        System.out.println(map);
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        int pairs=0;
		while (iterator.hasNext()) {
			Map.Entry entry = iterator.next();
			int a=(int) entry.getValue();
			pairs=pairs+(a/2);
		}
		return pairs;

    }


    public static void main(String[] args){
        int[] ar = {1,2,1,2,1,3,2};
        int n=7;
        int result = sockMerchant(n, ar);
        System.out.println(result);
        System.out.println(countingValleys(8,"UDDDUDUU"));
    }
    
    
    public static int countingValleys(int steps, String path) { //UDDDUDUU
        int v = 0;     // # of valleys
        int lvl = 0;   // current level
        for(char c : path.toCharArray()){
        	if(c == 'U') {
        		++lvl;
        		System.out.println("lvl1="+lvl);
        	}
            if(c == 'D') {
            	--lvl;
            	System.out.println("lvl2="+lvl);

            }
        	// if we just came UP to sea level
            if(lvl == 0 && c == 'U')
                ++v;
        }
        return v;
    }
    public static int countingValleys1(int steps, String path) {//UDDDUDUU
        int sum = 0; 
        int count = 0;
        for(int i=0;i<steps;i++){ 
        if(path.charAt(i)=='U'){
            if(++sum==0)
            count++;
        }
        else sum--;
        }
        return count;
    }

}
