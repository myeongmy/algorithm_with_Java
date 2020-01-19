//백준 1149번
/*문제
RGB거리에 사는 사람들은 집을 빨강, 초록, 파랑중에 하나로 칠하려고 한다. 또한, 그들은 모든 이웃은 같은 색으로 칠할 수 없다는 규칙도 정했다. 집 i의 이웃은 집 i-1과 집 i+1이고, 첫 집과 마지막 집은 이웃이 아니다.

각 집을 빨강으로 칠할 때 드는 비용, 초록으로 칠할 때 드는 비용, 파랑으로 드는 비용이 주어질 때, 모든 집을 칠하는 비용의 최솟값을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 집의 수 N이 주어진다. N은 1,000보다 작거나 같다. 둘째 줄부터 N개의 줄에 각 집을 빨강으로, 초록으로, 파랑으로 칠하는 비용이 주어진다. 비용은 1,000보다 작거나 같은 자연수이다.

출력
첫째 줄에 모든 집을 칠하는 비용의 최솟값을 출력한다.*/

package codingtest_study.백준;

import java.util.Scanner;

public class N_1149 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int[][] A = new int[N][3];
		int[][] d = new int[N][3];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				A[i][j] = s.nextInt();
				if (i == 0)
					d[i][j] = A[0][j];
			}
		}
		for (int i = 1; i < N; i++) {
			if (d[i - 1][1] <= d[i - 1][2])
				d[i][0] = d[i - 1][1] + A[i][0];
			else
				d[i][0] = d[i - 1][2] + A[i][0];

			if (d[i - 1][0] <= d[i - 1][2])
				d[i][1] = d[i - 1][0] + A[i][1];
			else
				d[i][1] = d[i - 1][2] + A[i][1];

			if (d[i - 1][0] <= d[i - 1][1])
				d[i][2] = d[i - 1][0] + A[i][2];
			else
				d[i][2] = d[i - 1][1] + A[i][2];
		}

		int min = d[N - 1][0];
		for (int i = 0; i < 3; i++) {
			if (min > d[N - 1][i])
				min = d[N - 1][i];
		}
		System.out.println(min);
	}

}
