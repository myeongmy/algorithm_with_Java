package codingtest_study;

import java.util.Arrays;
import java.util.Scanner;

public class ProgrammingContest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		for (int i = 0; i < T; i++) {
			int N = s.nextInt();
			int M = s.nextInt();
			int numPeople;
			int numProblem;

			int[][] problem = new int[N][M];
			int[] correct = new int[N];
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					problem[j][k] = s.nextInt();
				}
			}
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					correct[j] += problem[j][k];
				}
			}
			Arrays.sort(correct);

			numProblem = correct[N - 1];
			numPeople = 1;
			for (int j = N - 2; j >= 0; j--) {
				if (correct[j] == numProblem)
					numPeople += 1;
				else
					break;
			}
			System.out.println("#" + (i + 1) + " " + numPeople + " " + numProblem);
		}

	}

}
