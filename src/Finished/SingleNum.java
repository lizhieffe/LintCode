package Finished;

public class SingleNum {

	/**
	 *@param A : an integer array
	 *return : a integer 
	 */
	public int singleNumber(int[] A) {
		if (A == null || A.length % 2 == 0)
		    return 0;
		int result = 0;
		for (int val : A)
		    result ^= val;
		return result;
	}
}
