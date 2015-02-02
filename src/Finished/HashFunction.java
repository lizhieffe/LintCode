package Finished;

public class HashFunction {
	/**
     * @param key: A String you should hash
     * @param HASH_SIZE: An integer
     * @return an integer
     */
    public int hashCode(char[] key,int HASH_SIZE) {
        // write your code here
        long result = 0;
        for (int i = 0; i < key.length; ++i)
            result = ((result * 33) % HASH_SIZE + (int)key[i]) % HASH_SIZE;
        return (int)result;
    }
}
