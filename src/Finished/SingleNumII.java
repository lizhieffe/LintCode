package Finished;

public class SingleNumII {

	/**
	 * @param A : An integer array
	 * @return : An integer 
	 */
    public int singleNumberII(int[] A) {
        // write your code here
        if (A == null || A.length % 3 != 1)
            return 0;
        int[] record = new int[32];
        for (int val : A) {
            String s = Integer.toBinaryString(val);
            char[] c = s.toCharArray();
            for (int i = 0; i < c.length; ++i)
                if (c[i] == '1') {
                    record[c.length - i - 1] = (++record[c.length - i - 1]) % 3;
                }
        }
        int result = 0;
        for (int i = record.length - 1; i >= 0; --i)
            result = result * 2 + record[i];
        return result;
    }
}
