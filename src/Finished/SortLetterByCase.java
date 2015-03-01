package Finished;

public class SortLetterByCase {

	/** 
     *@param chars: The letter array you should sort by Case
     *@return: void
     */
    public void sortLetters(char[] chars) {
        //write your code here
        if (chars == null || chars.length < 2)
            return;
        int first = 0;
        int second = chars.length - 1;
        while (first < second) {
            if (chars[first] >= 'A' && chars[first] <= 'Z') {
                swap(chars, first, second--);
            }
            else
                ++first;
        }
    }
    
    private void swap(char[] c, int i, int j) {
        if (i != j) {
            char tmp = c[i];
            c[i] = c[j];
            c[j] = tmp;
        }
    }
}
