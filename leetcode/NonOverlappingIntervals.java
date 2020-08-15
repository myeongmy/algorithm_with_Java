package leetcode;

import java.util.*;

class Solution {
	static class Interval {
		int start;
		int end;
		int cnt; // 합쳐진 구간의 수

		Interval(int start, int end, int cnt) {
			this.start = start;
			this.end = end;
			this.cnt = cnt;
		}
	}

	// 겹치지 않는 구간의 최대 수 구하기(그리디 알고리즘)
	// 1. 구간들을 finish time이 빠른 순서대로 정렬
	// 2. 맨 처음 구간부터 탐색하면서 겹쳐지는 구간은 제외 (finish time이 더 큰 것을 제외해야 최대 수를 구할 수 있음)
	public int eraseOverlapIntervals(int[][] intervals) {
		int eraseNum = 0;
		List<Interval> list = new ArrayList<>();

		Integer[][] intervals_v = new Integer[intervals.length][2];
		for (int i = 0; i < intervals.length; i++) {
			for (int j = 0; j < 2; j++) {
				intervals_v[i][j] = intervals[i][j];
			}
		}
		// intervals 정렬(finish time이 빠른 순서대로 정렬)
		Arrays.sort(intervals_v, new Comparator<Integer[]>() {
			public int compare(Integer[] a, Integer[] b) {
				if (a[1] < b[1])
					return -1;
				else if (a[1] > b[1])
					return 1;
				else
					return 0;
			}
		});

		Label: for (int i = 0; i < intervals_v.length; i++) {

			if (list.size() == 0) {
				list.add(new Interval(intervals_v[i][0], intervals_v[i][1], 1));
				continue;
			}
			// list에 있는 interval들 중에 겹치는 것이 있는지 확인
			for (int j = 0; j < list.size(); j++) {
				if ((list.get(j).start <= intervals_v[i][0] && list.get(j).end >= intervals_v[i][1])
						|| (list.get(j).start >= intervals_v[i][0] && list.get(j).end <= intervals_v[i][1])
						|| (list.get(j).start < intervals_v[i][0] && list.get(j).end > intervals_v[i][0])
						|| (list.get(j).start > intervals_v[i][0]) && list.get(j).start < intervals_v[i][1]) {

					continue Label; // 겹치는 경우 finish time이 뒤에 있는 것은 제외

				}
			}

			// list에 새롭게 추가
			if (list.size() == 0) {
				list.add(new Interval(intervals_v[i][0], intervals_v[i][1], 1));
				continue;
			}
			for (int j = 0; j < list.size(); j++) {
				if (list.get(j).end == intervals_v[i][0]) {
					list.set(j, new Interval(list.get(j).start, intervals_v[i][1], list.get(j).cnt + 1));
					continue Label;
				}
			}
			list.add(new Interval(intervals_v[i][0], intervals_v[i][1], 1));
		}
		int listNum = 0;
		for (int i = 0; i < list.size(); i++) {
			listNum += list.get(i).cnt;
		}
		eraseNum = intervals.length - listNum;
		return eraseNum;
	}
}
