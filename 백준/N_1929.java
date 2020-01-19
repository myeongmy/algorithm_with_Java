//백준 1929번
/*문제
M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다. (1 ≤ M ≤ N ≤ 1,000,000)

출력
한 줄에 하나씩, 증가하는 순서대로 소수를 출력한다.*/

package codingtest_study.백준;

import java.util.Scanner;

public class N_1929 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int M = s.nextInt();
		int N = s.nextInt();
		boolean[] check = new boolean[N + 1]; // 소수가 아니면 true
		check[0] = true;
		check[1] = true;
		for (int i = 2; i <= N; i++) {
			if (check[i] == false) {
				for (int j = 2; i * j <= N; j++) {
					check[i * j] = true;
				}
			}
		}
		for (int i = M; i <= N; i++) {
			if (check[i] == false)
				System.out.println(i);
		}
	}

}
