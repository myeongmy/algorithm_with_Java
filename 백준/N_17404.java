//백준 17404번
/*문제
RGB거리에 사는 사람들은 집을 빨강, 초록, 파랑중에 하나로 칠하려고 한다. 또한, 그들은 모든 이웃은 같은 색으로 칠할 수 없다는 규칙도 정했다. 집 i의 이웃은 집 i-1과 집 i+1이고, 첫 집과 마지막 집도 이웃이다.

각 집을 빨강으로 칠할 때 드는 비용, 초록으로 칠할 때 드는 비용, 파랑으로 드는 비용이 주어질 때, 모든 집을 칠하는 비용의 최솟값을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 집의 수 N이 주어진다. N은 1,000보다 작거나 같다. 둘째 줄부터 N개의 줄에 각 집을 빨강으로, 초록으로, 파랑으로 칠하는 비용이 주어진다. 비용은 1,000보다 작거나 같은 자연수이다.

출력
첫째 줄에 모든 집을 칠하는 비용의 최솟값을 출력한다.*/

package 백준;

import java.util.Scanner;

public class N_17404 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int[][] A = new int[N + 1][3];
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < 3; j++) {
				A[i][j] = s.nextInt();
			}
		}
		int[][] d = new int[N + 1][3];
		int result = 1000 * 1000 + 1;
		for (int i = 0; i < 3; i++) {
			// 1번 집 색을 한가지 색으로 고정한다.
			// d[1][0] = A[1][i];
			// d[1][1] = A[1][i];
			// d[1][2] = A[1][i];
			for (int z = 0; z < 3; z++) {
				if (z == i)
					d[1][z] = A[1][i];
				else
					d[1][z] = 1000 * 1000 + 1;
			}

			for (int j = 2; j <= N; j++) {
				d[j][0] = (int) Math.min(d[j - 1][1], d[j - 1][2]) + A[j][0];
				d[j][1] = (int) Math.min(d[j - 1][0], d[j - 1][2]) + A[j][1];
				d[j][2] = (int) Math.min(d[j - 1][0], d[j - 1][1]) + A[j][2];

			}
			for (int k = 0; k < 3; k++) {
				if (i == k)
					continue;
				result = Math.min(result, d[N][k]);
			}

		}
		System.out.println(result);
	}

}
