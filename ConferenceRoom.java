//백준 1931번

// 객체 배열 사용(정렬)
// Comparable interface
// 정렬할 때는 같은 경우 어떻게 처리해야할지 구현해야함
package codingtest_study;

import java.util.Arrays;
import java.util.Scanner;

class Time implements Comparable<Time> {
	int start;
	int finish;

	Time(int start, int finish) {
		this.start = start;
		this.finish = finish;
	}

	public int compareTo(Time time) {
		if (this.finish < time.finish)
			return -1;
		else if (this.finish == time.finish) {
			if (this.start < time.start)
				return -1;
			else
				return 1;
		}

		else
			return 1;
	}

}

public class ConferenceRoom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int testCase = s.nextInt();

		Time[] t = new Time[testCase];
		int num = 0;
		for (int k = 0; k < t.length; k++)
			t[k] = new Time(s.nextInt(), s.nextInt());
		Arrays.sort(t);
		int current_finish = 0;
		for (int j = 0; j < t.length; j++) {
			if (j == 0) {
				num += 1;
				current_finish = t[j].finish;
			} else {
				if (current_finish > t[j].start)
					continue;
				else {
					num += 1;
					current_finish = t[j].finish;
				}
			}
		}
		System.out.println(num);
	}

}
