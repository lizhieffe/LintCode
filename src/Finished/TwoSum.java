package Finished;

import java.util.Arrays;

public class TwoSum {

	public int[] twoSum(int[] numbers, int target) {
        // write your code here
        
        int[] numbersCopy = new int[numbers.length];
        System.arraycopy(numbers, 0, numbersCopy, 0, numbers.length);
        
        // O(1) space, O(nlogn) time
        int[] result = {0, 0};
        if (numbers == null || numbers.length < 2)
            return result;
        Arrays.sort(numbers);
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                for (int k = 0; k < numbers.length; ++k) {
                    if (numbersCopy[k] == numbers[i])
                        result[0] = k + 1;
                    else if (numbersCopy[k] == numbers[j])
                        result[1] = k + 1;
                }
                if (result[0] > result[1]) {
                    int tmp = result[0];
                    result[0] = result[1];
                    result[1] = tmp;
                }
                return result;
            }
            else if (sum < target)
                ++i;
            else
                --j;
        }
        return result;
    }
}
