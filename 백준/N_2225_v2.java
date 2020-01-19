//백준 2225번
/*문제
0부터 N까지의 정수 K개를 더해서 그 합이 N이 되는 경우의 수를 구하는 프로그램을 작성하시오.

덧셈의 순서가 바뀐 경우는 다른 경우로 센다(1+2와 2+1은 서로 다른 경우). 또한 한 개의 수를 여러 번 쓸 수도 있다.

입력
첫째 줄에 두 정수 N(1 ≤ N ≤ 200), K(1 ≤ K ≤ 200)가 주어진다.

출력
첫째 줄에 답을 1,000,000,000으로 나눈 나머지를 출력한다.*/

package 백준;

import java.util.Scanner;

public class N_2225_v2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int K = s.nextInt();
		long[][] d = new long[N + 1][201];

		for (int i = 1; i <= 200; i++) {
			d[1][i] = i;
		}
		for (int i = 2; i <= N; i++) {
			for (int j = 1; j <= 200; j++) {
				d[i][j] = d[i - 1][j] + d[i][j - 1];
				d[i][j] %= 1000000000;
			}
		}
		System.out.println(d[N][K]);
	}

}
