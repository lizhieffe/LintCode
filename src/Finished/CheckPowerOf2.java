package Finished;

public class CheckPowerOf2 {
	/*
     * @param n: An integer
     * @return: True or false
     */
    public boolean checkPowerOf2(int n) {
        if (n <= 0)
            return false;
        // write your code here
        return (n & (n - 1)) == 0;
    }
}
