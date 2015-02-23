package Finished;

public class StrStr {

	/**
     * Returns a index to the first occurrence of target in source, or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public int strStr(String source, String target) {
        //write your code here
        if (source == null || target == null || source.length() < target.length())
            return -1;
        if (source.length() == 0)
            return target.length() == 0 ? 0 : -1;
        int patternLength = target.length();
        
        int mul = 23;
        int mod = 47;
        
        int hash = getHash(target, mul, mod);
        int tmp = 0;
        for (int i = 0; i < source.length() - target.length(); ++i) {
            if (i == 0)
                tmp = getHash(source.substring(0, patternLength), mul, mod);
            else
                tmp = getHash(source, tmp, i - 1, i + patternLength - 2, mul, mod);
            if (tmp == hash && target.equals(source.substring(i, i + patternLength)))
                return i;
        }
        return -1;
    }
    
    private int getHash(String str, int mul, int mod) {
        int hash = 0;
        for (int i = 0; i < str.length(); ++i) {
            hash = ((hash * mul) % mod + (int)(str.charAt(i) - '0')) % mod;
        }
        return hash;
    }
    
    private int getHash(String str, int hash, int beg, int end, int mul, int mod) {
        if (str.length() <= end + 1)
            return -1;
        int result = (int)(hash - ((int)(str.charAt(beg) - '0') * Math.pow(mul, end - beg)) % mod);
        if (result < 0)
            result += mod;
        result = ((result * mul) % mod + (int)(str.charAt(end + 1) - '0')) % mod;
        return result;
    }
}
