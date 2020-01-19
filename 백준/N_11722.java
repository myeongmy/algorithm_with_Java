//백준 11722번
/*문제
수열 A가 주어졌을 때, 가장 긴 감소하는 부분 수열을 구하는 프로그램을 작성하시오.

예를 들어, 수열 A = {10, 30, 10, 20, 20, 10} 인 경우에 가장 긴 감소하는 부분 수열은 A = {10, 30, 10, 20, 20, 10}  이고, 길이는 3이다.

입력
첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000)이 주어진다.

둘째 줄에는 수열 A를 이루고 있는 Ai가 주어진다. (1 ≤ Ai ≤ 1,000)

출력
첫째 줄에 수열 A의 가장 긴 감소하는 부분 수열의 길이를 출력한다.*/

package codingtest_study.백준;

import java.util.Scanner;

public class N_11722 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int[] A = new int[N];
		for (int i = 0; i < A.length; i++)
			A[i] = s.nextInt();
		int[] d = new int[N];
		d[0] = 1;
		for (int i = 1; i < d.length; i++) {
			d[i] = 1;
			for (int j = i - 1; j >= 0; j--) {
				if (A[i] < A[j] && d[i] < d[j] + 1)
					d[i] = d[j] + 1;
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
