package Finished;

import java.util.Arrays;

public class ThreeSumClosest {

	/**
     * @param numbers: Give an array numbers of n integer
     * @param target : An integer
     * @return : return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers ,int target) {
        // write your code here
        if (numbers == null || numbers.length < 3)
            return 0;
        int diff = Integer.MAX_VALUE;
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 2; ++i) {
            if (numbers[i] > target && diff < Integer.MAX_VALUE)
                return target + diff;
            int tmpDiff = twoSumClosest(numbers, i + 1, target - numbers[i]);
            if (tmpDiff == 0)
                return target;
            if (Math.abs(diff) > Math.abs(tmpDiff))
                diff = tmpDiff;
        }
        return target + diff;
    }
    
    private int twoSumClosest(int[] numbers, int beg, int target) {
        int diff = Integer.MAX_VALUE;
        int i = beg;
        int j = numbers.length - 1;
        while (i < j) {
            int tmpDiff = numbers[i] + numbers[j] - target;
            if (tmpDiff == 0)
                return tmpDiff;
            if (Math.abs(diff) > Math.abs(tmpDiff))
                diff = tmpDiff;
            if (tmpDiff > 0)
                --j;
            else
                ++i;
        }
        return diff;
    }
}
