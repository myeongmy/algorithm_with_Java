//백준 10872번
/*문제
0보다 크거나 같은 정수 N이 주어진다. 이때, N!을 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 정수 N(0 ≤ N ≤ 12)가 주어진다.

출력
첫째 줄에 N!을 출력한다.*/

package codingtest_study.백준;

import java.util.Scanner;

public class N_10872 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int factorial = 1;
		for (int i = 1; i <= N; i++)
			factorial *= i;
		System.out.println(factorial);
	}

}
