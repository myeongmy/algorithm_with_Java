//백준 15988번
/*문제
정수 4를 1, 2, 3의 합으로 나타내는 방법은 총 7가지가 있다. 합을 나타낼 때는 수를 1개 이상 사용해야 한다.

1+1+1+1
1+1+2
1+2+1
2+1+1
2+2
1+3
3+1
정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, 정수 n이 주어진다. n은 양수이며 1,000,000보다 작거나 같다.

출력
각 테스트 케이스마다, n을 1, 2, 3의 합으로 나타내는 방법의 수를 1,000,000,009로 나눈 나머지를 출력한다.*/

package codingtest_study.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_15988 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long[] d = new long[1000001];
		d[0] = 1;
		for (int i = 1; i <= 1000000; i++) {
			if (i - 1 >= 0)
				d[i] += d[i - 1];
			if (i - 2 >= 0)
				d[i] += d[i - 2];
			if (i - 3 >= 0)
				d[i] += d[i - 3];
			d[i] %= 1000000009;
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int T = Integer.parseInt(br.readLine());
			for (int i = 0; i < T; i++) {
				int n = Integer.parseInt(br.readLine());
				System.out.println(d[n]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
