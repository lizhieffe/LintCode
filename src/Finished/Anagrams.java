package Finished;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Anagrams {

	/**
     * @param strs: A list of strings
     * @return: A list of strings
     */
    public List<String> anagrams(String[] strs) {
        // write your code here
        List<String> result = new ArrayList<String>();
        if (strs == null || strs.length == 0)
            return result;
        Map<String, List<String>> exist = new HashMap<String, List<String>>();
        for (String str : strs) {
            String tmp = sort(str);
            if (exist.containsKey(tmp))
                exist.get(tmp).add(str);
            else {
                List<String> list = new ArrayList<String>();
                list.add(str);
                exist.put(tmp, list);
            }        
        }
        Iterator<Entry<String, List<String>>> it
                = exist.entrySet().iterator();
        while (it.hasNext()) {
            Entry<String, List<String>> entry
                    = it.next();
            if (entry.getValue().size() > 1)
                result.addAll(entry.getValue());
        }
        return result;
    }
    
    private String sort(String s) {
        char[] c = s.toCharArray();
        Arrays.sort(c);
        return String.valueOf(c);
    }
}
