//백준 14889번
//다른 방법으로 풀어보기
//1번 팀에 속하거나 2번 팀에 속하거나로 풀기

package 백준;

import java.util.*;

public class N_14889_v2 {
	static ArrayList<Integer> list = new ArrayList<Integer>();
	static ArrayList<Integer> notlist = new ArrayList<Integer>();
	static int min = 1000000;

	static void go(int index, int N, int[][] A) {
		if (index == N) {
			if (list.size() == N / 2 && notlist.size() == N / 2) {
				int sum1 = 0;
				int sum2 = 0;
				for (int i = 0; i < list.size(); i++) {
					for (int j = 0; j < list.size(); j++) {
						sum1 += A[list.get(i)][list.get(j)];
						sum2 += A[notlist.get(i)][notlist.get(j)];
					}
				}
				if (min > Math.abs(sum1 - sum2)) {
					min = Math.abs(sum1 - sum2);
				}
			}
			return;
		}
		list.add(index);
		go(index + 1, N, A);
		list.remove(list.size() - 1);

		notlist.add(index);
		go(index + 1, N, A);
		notlist.remove(notlist.size() - 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int[][] A = new int[N][N];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				A[i][j] = s.nextInt();
		go(0, N, A);
		System.out.println(min);

	}

}
