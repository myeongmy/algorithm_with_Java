//백준 15655번
/*문제
N개의 자연수와 자연수 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오. N개의 자연수는 모두 다른 수이다.

N개의 자연수 중에서 M개를 고른 수열
고른 수열은 오름차순이어야 한다.
입력
첫째 줄에 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)

둘째 줄에 N개의 수가 주어진다. 입력으로 주어지는 수는 10,000보다 작거나 같은 자연수이다.

출력
한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.

수열은 사전 순으로 증가하는 순서로 출력해야 한다.*/

package 백준;

import java.util.Arrays;
import java.util.Scanner;

public class N_15655 {
	static int[] result = new int[10];

	static void go(int index, int selected, int[] A, int N, int M) {
		if (selected == M) {
			for (int i = 0; i < selected; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
			return;
		}
		if (index >= N)
			return;
		result[selected] = A[index];
		go(index + 1, selected + 1, A, N, M);
		result[selected] = 0;
		go(index + 1, selected, A, N, M);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int M = s.nextInt();
		int[] A = new int[N];
		for (int i = 0; i < N; i++)
			A[i] = s.nextInt();

		Arrays.sort(A);
		go(0, 0, A, N, M);
	}

}
