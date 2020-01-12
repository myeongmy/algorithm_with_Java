//백준 11054번
/*문제
수열 S가 어떤 수 Sk를 기준으로 S1 < S2 < ... Sk-1 < Sk > Sk+1 > ... SN-1 > SN을 만족한다면, 그 수열을 바이토닉 수열이라고 한다.

예를 들어, {10, 20, 30, 25, 20}과 {10, 20, 30, 40}, {50, 40, 25, 10} 은 바이토닉 수열이지만,  {1, 2, 3, 2, 1, 2, 3, 2, 1}과 {10, 20, 30, 40, 20, 30} 은 바이토닉 수열이 아니다.

수열 A가 주어졌을 때, 그 수열의 부분 수열 중 바이토닉 수열이면서 가장 긴 수열의 길이를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 수열 A의 크기 N이 주어지고, 둘째 줄에는 수열 A를 이루고 있는 Ai가 주어진다. (1 ≤ N ≤ 1,000, 1 ≤ Ai ≤ 1,000)

출력
첫째 줄에 수열 A의 부분 수열 중에서 가장 긴 바이토닉 수열의 길이를 출력한다.*/

package codingtest_study.백준;

import java.util.Scanner;

public class N_11054 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int[] A = new int[N];
		for (int i = 0; i < A.length; i++)
			A[i] = s.nextInt();
		int[] d = new int[N];
		int[] v = new int[N];
		int[] sum = new int[N]; // d와 v 배열을 합한 결과를 담을 배열
		d[0] = 1;
		v[N - 1] = 1;
		for (int i = 1; i < N; i++) {
			d[i] = 1;
			for (int j = i - 1; j >= 0; j--) {
				if (A[i] > A[j] && d[i] < d[j] + 1)
					d[i] = d[j] + 1;
			}
		}
		for (int i = A.length - 2; i >= 0; i--) {
			v[i] = 1;
			for (int j = i + 1; j < A.length; j++) {
				if (A[i] > A[j] && v[i] < v[j] + 1)
					v[i] = v[j] + 1;
			}
		}
		for (int i = 0; i < N; i++) {
			sum[i] = d[i] + v[i];
		}
		int max = sum[0];
		for (int i = 0; i < sum.length; i++) {
			if (max < sum[i])
				max = sum[i];
		}
		System.out.println(max - 1);

	}

}
