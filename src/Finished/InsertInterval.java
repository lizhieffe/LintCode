package Finished;

import java.util.ArrayList;

import Utils.Interval;

public class InsertInterval {

	/**
     * Insert newInterval into intervals.
     * @param intervals: Sorted interval list.
     * @param newInterval: A new interval.
     * @return: A new sorted interval list.
     */
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> result = new ArrayList<Interval>();
        // write your code here
        if (intervals == null || newInterval == null)
            return result;
        int i = 0;
        boolean inserted = false;
        while (i < intervals.size()) {
            Interval inte = intervals.get(i);
            if (inte.start > newInterval.end) {
                if (!inserted) {
                    result.add(newInterval);
                    inserted = true;
                }
                result.add(inte);
            }
            else if (inte.end < newInterval.start)
                result.add(inte);
            else
                merge(newInterval, inte);
            ++i;
        }
        if (!inserted)
            result.add(newInterval);
        return result;
    }
    
    private void merge(Interval inte1, Interval inte2) {
        inte1.start = Math.min(inte1.start, inte2.start);
        inte1.end = Math.max(inte1.end, inte2.end);
    }
}
