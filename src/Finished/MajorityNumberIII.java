package Finished;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class MajorityNumberIII {

	/**
     * @param nums: A list of integers
     * @param k: As described
     * @return: The majority number
     */
    public int majorityNumber(ArrayList<Integer> nums, int k) {
        // write your code
        if (nums == null || nums.size() == 0 || k == 0)
            return 0;
        if (k == 1)
            return nums.get(0);
        Map<Integer, Integer> appear = new HashMap<Integer, Integer>();
        for (Integer num : nums) {
            if (appear.containsKey(num))
                appear.put(num, appear.get(num) + 1);
            else {
                if (appear.size() < k - 1)
                    appear.put(num, 1);
                else {
                    Iterator<Entry<Integer, Integer>> it = appear.entrySet().iterator();
                    while (it.hasNext()) {
                        Entry<Integer, Integer> entry = it.next();
                        if (entry.getValue() == 1)
                            it.remove();
                        else
                        	entry.setValue(entry.getValue() - 1);
                    }
                }
            }
        }
        Iterator<Entry<Integer, Integer>> it = appear.entrySet().iterator();
        while (it.hasNext()) {
            Entry<Integer, Integer> entry = it.next();
            entry.setValue(0);
        }
        for (Integer num : nums)
            if (appear.containsKey(num)) {
                if (appear.get(num) + 1 > (nums.size() / k))
                    return num;
                appear.put(num, appear.get(num) + 1);
            }
        return 0;
    }
}
