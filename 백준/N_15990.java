//백준 15990번
/*문제
정수 4를 1, 2, 3의 합으로 나타내는 방법은 총 3가지가 있다. 합을 나타낼 때는 수를 1개 이상 사용해야 한다. 단, 같은 수를 두 번 이상 연속해서 사용하면 안 된다.

1+2+1
1+3
3+1
정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, 정수 n이 주어진다. n은 양수이며 100,000보다 작거나 같다.

출력
각 테스트 케이스마다, n을 1, 2, 3의 합으로 나타내는 방법의 수를 1,000,000,009로 나눈 나머지를 출력한다.*/

package codingtest_study.백준;

import java.util.Scanner;

public class N_15990 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long [][] d = new long[100001][4];
		
		for (int i = 1; i <= 100000; i++) {
			if (i - 1 >= 0) {
				d[i][1] = d[i - 1][2] + d[i - 1][3];
				if (i == 1)
					d[i][1] = 1;
			}
			if (i - 2 >= 0) {
				d[i][2] = d[i - 2][1] + d[i - 2][3];
				if (i == 2)
					d[i][2] = 1;
			}
			if (i - 3 >= 0) {
				d[i][3] = d[i - 3][1] + d[i - 3][2];
				if (i == 3)
					d[i][3] = 1;
			}
			d[i][1] %= 1000000009L;
			d[i][2] %= 1000000009L;
			d[i][3] %= 1000000009L;
		}
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		for (int t = 0; t < T; t++) {
			int n = s.nextInt();
			System.out.println((d[n][1] + d[n][2] + d[n][3]) % 1000000009L);
		}
	}

}
