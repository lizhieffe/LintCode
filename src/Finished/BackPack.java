package Finished;

import static org.junit.Assert.*;

import org.junit.Test;

public class BackPack {

	/**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
	public int backPack(int m, int[] A) {
        if (A == null || A.length == 0 || m <= 0)
            return 0;
        boolean[] canFill = new boolean[m + 1];
        canFill[0] = true;
        for (int i = 0; i < A.length; ++i) {
            for (int j = m; j > 0; --j) {
                if (canFill[j] == false)
                    if (A[i] <= j && canFill[j - A[i]] == true)
                        canFill[j] = true;
            }
        }
        for (int i = m; i >= 0; --i)
            if (canFill[i] == true)
                return i;
        return 0;
	}
	
    @Test
    public void tc01() {
    	int[] A = {3,4,8,5};
    	int m = 10;
    	assertEquals(new BackPack().backPack(m, A), 9);
    }
}
