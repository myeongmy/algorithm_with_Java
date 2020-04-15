package 프로그래머스;

import java.math.*;
import java.util.*;

class Solution21 {
	static class Time {
		BigDecimal start;
		BigDecimal end;

		Time(BigDecimal start, BigDecimal end) {
			this.start = start;
			this.end = end;
		}
	}

	public int solution(String[] lines) {
		int answer = 0;

		Time[] timeline = new Time[lines.length];
		BigDecimal on = new BigDecimal("0.001");
		BigDecimal one = new BigDecimal("1");

		for (int i = 0; i < lines.length; i++) {
			String[] arr = lines[i].split(" ");
			BigDecimal period = new BigDecimal(arr[2].substring(0, arr[2].length() - 1));

			// arr[1] 파싱
			String[] arr1 = arr[1].split(":");
			BigDecimal hour = new BigDecimal(arr1[0]);
			BigDecimal minute = new BigDecimal(arr1[1]);
			BigDecimal sec = new BigDecimal(arr1[2]);
			BigDecimal sixty = new BigDecimal("60");

			BigDecimal end = hour.multiply(sixty).multiply(sixty).add(minute.multiply(sixty)).add(sec);
			BigDecimal start = end.subtract(period).add(on);
			timeline[i] = new Time(start, end);
		}

		for (int i = 0; i < timeline.length; i++) {
			// start 기준
			BigDecimal si = timeline[i].start;
			BigDecimal fi = si.add(one).subtract(on);
			int cnt = 0;

			for (int j = 0; j < timeline.length; j++) {
				if (si.compareTo(timeline[j].start) >= 0 && si.compareTo(timeline[j].end) <= 0)
					cnt++;
				else if (fi.compareTo(timeline[j].start) >= 0 && fi.compareTo(timeline[j].end) <= 0)
					cnt++;
				else if (si.compareTo(timeline[j].start) <= 0 && timeline[j].end.compareTo(fi) <= 0)
					cnt++;
			}

			if (answer < cnt)
				answer = cnt;

			// end 기준
			si = timeline[i].end;
			fi = si.add(one).subtract(on);
			cnt = 0;

			for (int j = 0; j < timeline.length; j++) {
				if (si.compareTo(timeline[j].start) >= 0 && si.compareTo(timeline[j].end) <= 0)
					cnt++;
				else if (fi.compareTo(timeline[j].start) >= 0 && fi.compareTo(timeline[j].end) <= 0)
					cnt++;
				else if (si.compareTo(timeline[j].start) <= 0 && timeline[j].end.compareTo(fi) <= 0)
					cnt++;
			}

			if (answer < cnt)
				answer = cnt;
		}
		return answer;
	}
}

public class ChuSeokTraffic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] lines = { "2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s" };
		System.out.println(new Solution21().solution(lines));
	}

}
