package Finished;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ThreeSum {
	/**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        // write your code here
        if (numbers == null || numbers.length < 3)
            return new ArrayList<ArrayList<Integer>>();
        
        Arrays.sort(numbers);
        Set<ArrayList<Integer>> tmp = new HashSet<ArrayList<Integer>>();
        for (int i = 0; i < numbers.length - 2; ++i) {
            int beg = i + 1;
            int end = numbers.length - 1;
            while (beg < end) {
                int sum = numbers[i] + numbers[beg] + numbers[end];
                if (sum == 0) {
                    ArrayList<Integer> solution = new ArrayList<Integer>();
                    solution.add(numbers[i]);
                    solution.add(numbers[beg]);
                    solution.add(numbers[end]);
                    if (!tmp.contains(solution))
                        tmp.add(solution);
                    ++beg;
                    --end;
                }
                else if (sum > 0)
                    --end;
                else
                    ++beg;
            }
        }
        return new ArrayList<ArrayList<Integer>>(tmp);
    }
}
