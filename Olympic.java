package codingtest_study;

import java.util.Scanner;

public class Olympic {
	public static int max(int[] arr) {
		int max_index = 0;
		int i;
		for (i = 1; i < arr.length; i++) {
			if (arr[i] > arr[max_index]) {
				max_index = i;
			}
		}

		return max_index;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		int testCase = s.nextInt();
		for (int t = 0; t < testCase; t++) {
			int N = s.nextInt();
			int M = s.nextInt();
			int[] A = new int[N];
			int[] B = new int[M];
			int[] numOfVotes = new int[N]; //numOfVotes[i]는 i번째 종목의 투표 받은 횟수 저장
			for (int i = 0; i < N; i++) {
				A[i] = s.nextInt();
			}
			for (int j = 0; j < M; j++) {
				B[j] = s.nextInt();
			}
			for (int k = 0; k < M; k++) {
				for (int z = 0; z < N; z++) {
					if (B[k] >= A[z]) {
						numOfVotes[z] += 1;
						break;
					}
				}
			}
			System.out.println("#" + (t + 1) + " " + (max(numOfVotes) + 1));

		}
	}

}
