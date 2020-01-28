//백준 14889번(비트마스크)

package 백준;

import java.util.*;

public class N_14889_v3 {
	static ArrayList<Integer> team1 = new ArrayList<Integer>();
	static ArrayList<Integer> team2 = new ArrayList<Integer>();
	static int min = 1000000;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int[][] S = new int[N][N];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				S[i][j] = s.nextInt();

		for (long i = 0; i < (1 << N); i++) {
			int count = 0;
			team1.clear();
			team2.clear();
			for (int j = 0; j < N; j++) {
				if ((i & (1 << j)) != 0) {
					count++;
					team1.add(j);
				} else {
					team2.add(j);
				}

			}
			if (count != N / 2)
				continue;

			int sum1 = 0;
			int sum2 = 0;
			for (int k = 0; k < N / 2; k++) {
				for (int w = 0; w < N / 2; w++) {
					// S[k][w]
					sum1 += S[team1.get(k)][team1.get(w)];
					sum2 += S[team2.get(k)][team2.get(w)];

				}
			}
			if (min > Math.abs(sum1 - sum2))
				min = Math.abs(sum1 - sum2);
		}
		System.out.println(min);
	}

}
