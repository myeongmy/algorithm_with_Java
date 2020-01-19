//백준 13398번
/*문제
n개의 정수로 이루어진 임의의 수열이 주어진다. 우리는 이 중 연속된 몇 개의 수를 선택해서 구할 수 있는 합 중 가장 큰 합을 구하려고 한다. 단, 수는 한 개 이상 선택해야 한다. 또, 수열에서 수를 하나 제거할 수 있다. (제거하지 않아도 된다)

예를 들어서 10, -4, 3, 1, 5, 6, -35, 12, 21, -1 이라는 수열이 주어졌다고 하자. 여기서 수를 제거하지 않았을 때의 정답은 12+21인 33이 정답이 된다.

만약, -35를 제거한다면, 수열은 10, -4, 3, 1, 5, 6, 12, 21, -1이 되고, 여기서 정답은 10-4+3+1+5+6+12+21인 54가 된다.

입력
첫째 줄에 정수 n(1≤n≤100,000)이 주어지고 둘째 줄에는 n개의 정수로 이루어진 수열이 주어진다. 수는 -1,000보다 크거나 같고, 1,000보다 작거나 같은 정수이다.

출력
첫째 줄에 답을 출력한다.*/

package codingtest_study.백준;

import java.util.Scanner;

public class N_13398 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] A = new int[n];
		for (int i = 0; i < A.length; i++)
			A[i] = s.nextInt();
		long[] d = new long[n];
		long[] v = new long[n]; // A[i]로 시작하는 연속합의 최대값
		long[] sum = new long[n];
		d[0] = A[0];
		v[n - 1] = A[n - 1];
		for (int i = 1; i < n; i++) {
			d[i] = A[i];
			if (d[i] < d[i - 1] + A[i])
				d[i] = d[i - 1] + A[i];
		}
		for (int i = n - 2; i >= 0; i--) {
			v[i] = A[i];
			if (v[i] < v[i + 1] + A[i])
				v[i] = v[i + 1] + A[i];
		}
		long max_d = d[0];
		for (int i = 0; i < d.length; i++) {
			if (max_d < d[i])
				max_d = d[i];
		}
		sum[0] = v[1];
		sum[n-1] = d[n-2];
		for (int i = 1; i < sum.length-1; i++) {
			sum[i] = d[i - 1] + v[i + 1];
		}
		long max_sum = sum[0];
		for (int i = 0; i < sum.length; i++) {
			if (max_sum < sum[i])
				max_sum = sum[i];
		}
		System.out.println(Math.max(max_d, max_sum));

	}

}
