package leetcode;

import java.util.TreeMap;

class Solution {
	public int[] findRightInterval(int[][] intervals) {
		int[] result = new int[intervals.length];
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();

		for (int i = 0; i < intervals.length; i++) {
			map.put(intervals[i][0], i);
		}

		for (int i = 0; i < intervals.length; i++) {
			if (map.ceilingKey(intervals[i][1]) == null)
				result[i] = -1;
			else
				result[i] = map.get(map.ceilingKey(intervals[i][1]));
		}

		return result;
	}
}
