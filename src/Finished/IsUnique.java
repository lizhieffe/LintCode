package Finished;

public class IsUnique {

	/**
     * @param str: a string
     * @return: a boolean
     */
    public boolean isUnique(String str) {
        // write your code here
        if (str == null || str.length() <= 1)
            return true;
        boolean[] appeared = new boolean[256];
        for (int i = 0; i < str.length(); ++i) {
            int index = (int)str.charAt(i);
            if (appeared[index])
                return false;
            appeared[index] = true;
        }
        return true;
    }
}
