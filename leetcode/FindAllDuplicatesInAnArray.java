package leetcode;

import java.util.*;

class Solution {
	public List<Integer> findDuplicates(int[] nums) {
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

		for (int i = 0; i < nums.length; i++) {
			hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
		}

		List<Integer> result = new ArrayList<Integer>();
		Set s = hm.keySet();
		Iterator<Integer> it = s.iterator();
		while (it.hasNext()) {
			Integer a = it.next();
			if (hm.get(a) == 2)
				result.add(a);
		}

		return result;
	}
}
