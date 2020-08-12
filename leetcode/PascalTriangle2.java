package leetcode;

import java.util.*;

//dynamic programming

class Solution {
	static int[][] d = new int[34][34];

	static void init() {
		for (int i = 0; i <= 33; i++) {
			d[i][0] = 1;
		}

		for (int i = 1; i <= 33; i++) {
			for (int j = 0; j < d[i].length; j++) {
				if (d[i][j] != 0)
					continue;
				d[i][j] = d[i - 1][j - 1] + d[i - 1][j];
			}
		}
	}

	public List<Integer> getRow(int rowIndex) {
		List<Integer> result = new ArrayList<>();
		init();

		for (int i = 0; i < d[0].length; i++) {
			if (d[rowIndex][i] != 0)
				result.add(d[rowIndex][i]);
		}
		return result;
	}
}
