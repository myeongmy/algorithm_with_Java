//백준 1676번
/*문제
N!에서 뒤에서부터 처음 0이 아닌 숫자가 나올 때까지 0의 개수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N이 주어진다. (0 ≤ N ≤ 500)

출력
첫째 줄에 구한 0의 개수를 출력한다.*/

package codingtest_study.백준;

import java.util.Scanner;

public class N_1676 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int numOfZero = 0;
		for (int i = 1; Math.pow(5, (double) i) <= N; i++) {
			numOfZero += N / (int) Math.pow(5, (double) i);
		}
		System.out.println(numOfZero);
	}

}
