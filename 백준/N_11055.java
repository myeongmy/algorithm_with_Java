//백준 11055번
/*문제
수열 A가 주어졌을 때, 그 수열의 증가 부분 수열 중에서 합이 가장 큰 것을 구하는 프로그램을 작성하시오.

예를 들어, 수열 A = {1, 100, 2, 50, 60, 3, 5, 6, 7, 8} 인 경우에 합이 가장 큰 증가 부분 수열은 A = {1, 100, 2, 50, 60, 3, 5, 6, 7, 8} 이고, 합은 113이다.

입력
첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000)이 주어진다.

둘째 줄에는 수열 A를 이루고 있는 Ai가 주어진다. (1 ≤ Ai ≤ 1,000)

출력
첫째 줄에 수열 A의 합이 가장 큰 증가 부분 수열의 합을 출력한다.*/

package codingtest_study.백준;

import java.util.Scanner;

public class N_11055 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int[] A = new int[N];
		for (int i = 0; i < A.length; i++)
			A[i] = s.nextInt();
		int[] d = new int[N];
		d[0] = A[0];
		for (int i = 1; i < d.length; i++) {
			d[i] = A[i];
			for (int j = i - 1; j >= 0; j--) {
				if (A[i] > A[j] && d[i] < d[j] + A[i])
					d[i] = d[j] + A[i];
			}
		}
		int max = d[0];
		for (int i = 0; i < d.length; i++) {
			if (max < d[i])
				max = d[i];
		}
		System.out.println(max);
	}

}
