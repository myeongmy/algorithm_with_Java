package codingtest_study;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class ConnectingElec {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int testCase = s.nextInt();
		LinkedList<Integer> interval = new LinkedList<Integer>();
		for (int i = 0; i < testCase; i++) {
			int N = s.nextInt();
			int K = s.nextInt();
			int result = 0;
			int[] x = new int[N];

			for (int j = 0; j < N; j++) {
				x[j] = s.nextInt();
			}
			for (int j = 0; j < N - 1; j++) {
				interval.add(x[j + 1] - x[j]);
			}
			Collections.sort(interval);
			Collections.reverse(interval);

			for (int j = 1; j <= K - 1; j++) {
				if (interval.size() == 0)
					break;
				interval.remove(0);
			}
			for (int j = 0; j < interval.size(); j++)
				result += interval.get(j);
			System.out.println("#" + (i + 1) + " " + result);
			interval.clear();

		}
	}

}
