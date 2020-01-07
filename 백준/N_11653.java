//백준 11653번
/*문제
정수 N이 주어졌을 때, 소인수분해하는 프로그램을 작성하시오.

입력
첫째 줄에 정수 N (1 ≤ N ≤ 10,000,000)이 주어진다.

출력
N의 소인수분해 결과를 한 줄에 하나씩 오름차순으로 출력한다.*/

package codingtest_study.백준;

import java.util.Scanner;

public class N_11653 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		long N = s.nextLong();
		for (int i = 2; i * i <= N; i++) {
			while (N % i == 0) {
				System.out.println(i);
				N /= i;
			}
		}
		if (N > 1) {
			System.out.println(N);
		}
	}

}
