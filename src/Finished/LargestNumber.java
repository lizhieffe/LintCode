package Finished;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Test;

public class LargestNumber {
    /**
     *@param num: A list of non negative integers
     *@return: A string
     */
    public String largestNumber(int[] num) {
        // write your code here
        StringBuilder builder = new StringBuilder();
        if (num == null || num.length == 0)
            return builder.toString();
        Integer[] numInt = new Integer[num.length];
        for (int i = 0; i < num.length; ++i)
        	numInt[i] = num[i];
        Arrays.sort(numInt, new IntComparator());
        for (int n : numInt)
            builder.insert(0, n);
        String result = builder.toString();
        if (result.charAt(0) == '0')
            return "0";
        return result;
    }
    
    @Test
    public void tc01() {
    	int[] num = {41,23,87,55,50,53,18,9,39,63,35,33,54,25,26,49,74,61,32,81,97,99,38,96,22,95,35,57,80,80,16,22,17,13,89,11,75,98,57,81,69,8,10,85,13,49,66,94,80,25,13,85,55,12,87,50,28,96,80,43,10,24,88,52,16,92,61,28,26,78,28,28,16,1,56,31,47,85,27,30,85,2,30,51,84,50,3,14,97,9,91,90,63,90,92,89,76,76,67,55};
    	String result = new LargestNumber().largestNumber(num);
    	System.out.println(result);
    }
}

class IntComparator implements Comparator <Integer> {
    public int compare(Integer i1, Integer i2) {
        char[] c1 = String.valueOf(i1).toCharArray();
        char[] c2 = String.valueOf(i2).toCharArray();
        int i = 0;
        for (i = 0; i < Math.min(c1.length, c2.length); ++i) {
            if (c1[i] < c2[i])
                return -1;
            else if (c1[i] > c2[i])
                return 1;
        }
        if (c1.length == c2.length)
            return 0;
        else if (c1.length > c2.length) {
            if (c1[i] > c2[0])
                return 1;
            else if (c1[i] < c2[0])
                return -1;
            else
                return 0;
        }
        else {
            if (c2[i] > c1[0])
                return -1;
            else if (c2[i] < c1[0])
                return 1;
            else
                return 0;
        }
    }
 }