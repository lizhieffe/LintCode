package Finished;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Delete_Digits {

	/**
     *@param A: A positive integer which has N digits, A is a string.
     *@param k: Remove k digits.
     *@return: A string
     */
    public String DeleteDigits(String A, int k) {
        // write your code here
        if (A == null || A.length() == 0 || k == A.length())
            return "";
        List<Integer> stack = new ArrayList<Integer>();
        int deleted = 0;
        int skiped = 0;
        for (int i = 0; i < A.length(); ++i) {
            int curr = (int)(A.charAt(i) - '0');
            while (deleted < k && stack.size() > 0) {
                if (curr < stack.get(stack.size() - 1)) {
                    stack.remove(stack.size() - 1);
                    ++deleted;
                }
                else
                    break;
            }
            if (stack.size() == 0 && curr == 0) {
            	++skiped;
                continue;
            }
            stack.add(curr);
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < A.length() - k - skiped; ++i)
            builder.append(stack.get(i));
        return builder.toString();
    }
    
    @Test
    public void test01() {
    	String A = "90249";
    	int k = 2;
    	String result = new Delete_Digits().DeleteDigits(A, k);
    	System.out.println(result);
    }
}
