package Finished;

import java.util.HashMap;
import java.util.Map;

public class CompareString {

	/**
     * @param A : A string includes Upper Case letters
     * @param B : A string includes Upper Case letter
     * @return :  if string A contains all of the characters in B return true else return false
     */
    public boolean compareStrings(String A, String B) {
        // write your code here
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        Map<Character, Integer> dict = new HashMap<Character, Integer>();
        for (char c : a) {
            if (dict.containsKey(c))
                dict.put(c, dict.get(c) + 1);
            else
                dict.put(c, 1);
        }
        for (char c : b) {
            if (!dict.containsKey(c) || dict.get(c) == 0)
                return false;
            else
                dict.put(c, dict.get(c) - 1);
        }
        return true;
    }
}
