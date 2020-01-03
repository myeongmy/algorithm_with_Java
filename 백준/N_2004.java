//백준 2004번
/*문제
nCm의 끝자리 0의 개수를 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 정수 n, m(0≤m≤n≤2,000,000,000, n!=0)이 들어온다.

출력
첫째 줄에 0의 개수를 출력한다.*/

package codingtest_study.백준;

import java.util.Scanner;

public class N_2004 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		int numOfTwo = 0;
		int numOfFive = 0;

		for (int i = 1; Math.pow(2, i) <= n; i++) { // n!의 2의 개수 구하기
			numOfTwo += n / (int) Math.pow(2, i);
		}
		for (int i = 1; Math.pow(2, i) <= n - m; i++) { // (n-m)!의 2의 개수 구하기
			numOfTwo -= (n - m) / (int) Math.pow(2, i);
		}
		for (int i = 1; Math.pow(2, i) <= m; i++) { // m!의 2의 개수 구하기
			numOfTwo -= m / (int) Math.pow(2, i);
		}

		for (int i = 1; Math.pow(5, i) <= n; i++) { // n!의 5의 개수 구하기
			numOfFive += n / (int) Math.pow(5, i);
		}
		for (int i = 1; Math.pow(5, i) <= n - m; i++) { // (n-m)!의 5의 개수 구하기
			numOfFive -= (n - m) / (int) Math.pow(5, i);
		}
		for (int i = 1; Math.pow(2, i) <= m; i++) { // m!의 5의 개수 구하기
			numOfFive -= m / (int) Math.pow(5, i);
		}
		if (numOfTwo <= numOfFive)
			System.out.println(numOfTwo);
		else
			System.out.println(numOfFive);
	}

}
