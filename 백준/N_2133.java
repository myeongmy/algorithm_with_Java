//백준 2133번
/*문제
3×N 크기의 벽을 2×1, 1×2 크기의 타일로 채우는 경우의 수를 구해보자.

입력
첫째 줄에 N(1 ≤ N ≤ 30)이 주어진다.

출력
첫째 줄에 경우의 수를 출력한다.*/

package codingtest_study.백준;

import java.util.Scanner;

public class N_2133 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		long[] d = new long[N + 1];
		d[0] = 1;
		d[1] = 0;
		for (int i = 2; i <= N; i++) {
			for (int j = 2; j <= i; j = j + 2) {
				if (j == 2)
					d[i] += 3 * d[i - 2];
				else
					d[i] += 2 * d[i - j];
			}
		}
		System.out.println(d[N]);

	}

}
