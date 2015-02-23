package Finished;

public class RotateString {

	/*
     * param A: A string
     * param offset: Rotate string with offset.
     * return: Rotated string.
     */
    public char[] rotateString(char[] A, int offset) {
        // wirte your code here
        if (A == null || A.length < 2)
            return A;
        offset = offset % A.length;
        if (offset < 0)
            offset += A.length;
        if (offset == 0)
            return A;
        int loop = findGCD(A.length, offset);
        for (int i = 0; i < loop; ++i) {
            int beg = i;
            int curr = beg;
            char cache = A[beg];
            do {
                curr = findNext(curr, offset, A.length);
                char tmp = A[curr];
                A[curr] = cache;
                cache = tmp;
            } while (curr != beg);
        }
        return A;
    }
    
    private int findGCD(int a, int b) {
        if (a % b == 0)
            return b;
        else
            return findGCD(b, a % b);
    }
    
    private int findNext(int curr, int offset, int length) {
        return (curr + offset) % length;
    }
}
