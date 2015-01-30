package Finished;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class MajorityNumberII {
	/**
     * @param nums: A list of integers
     * @return: The majority number that occurs more than 1/3
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        // write your code
        if (nums == null || nums.size() == 0)
            return -1;
        int limit = 2;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (Integer num : nums) {
            if (map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else {
                if (map.size() == limit) {
                    Iterator<Entry<Integer, Integer>> it = map.entrySet().iterator();
                    while (it.hasNext()) {
                        Entry<Integer, Integer> pair = it.next();
                        if (pair.getValue() == 1)
                            it.remove();
                        else
                            pair.setValue(pair.getValue() - 1);
                    }
                }
                else {
                    map.put(num, 1);
                }
            }
        }
        Iterator<Entry<Integer, Integer>> it = map.entrySet().iterator();
        int cand1 = it.next().getKey();
        int cand2 = 0;
        if (!it.hasNext())
            return cand1;
        else
            cand2 = it.next().getKey();
        int count1 = 0;
        int count2 = 0;
        for (Integer num : nums) {
            if (num == cand1)
                ++count1;
            else if (num == cand2)
                ++count2;
        }
        if (count1 > count2)
            return cand1;
        else
            return cand2;
    }
}
