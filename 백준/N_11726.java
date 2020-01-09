//백준 11726번
/*문제
2×n 크기의 직사각형을 1×2, 2×1 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.

아래 그림은 2×5 크기의 직사각형을 채운 한 가지 방법의 예이다.



입력
첫째 줄에 n이 주어진다. (1 ≤ n ≤ 1,000)

출력
첫째 줄에 2×n 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지를 출력한다.
*/
package codingtest_study.백준;

import java.util.Scanner;

public class N_11726 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] d = new int[n + 1];

		d[0] = 1;
		d[1] = 1;
		for (int i = 2; i <= n; i++) {
			d[i] = d[i - 1] + d[i - 2];
			d[i] = d[i] % 10007;
		}
		System.out.println(d[n]);
	}

}
