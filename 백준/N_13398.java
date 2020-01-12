//���� 13398��
/*����
n���� ������ �̷���� ������ ������ �־�����. �츮�� �� �� ���ӵ� �� ���� ���� �����ؼ� ���� �� �ִ� �� �� ���� ū ���� ���Ϸ��� �Ѵ�. ��, ���� �� �� �̻� �����ؾ� �Ѵ�. ��, �������� ���� �ϳ� ������ �� �ִ�. (�������� �ʾƵ� �ȴ�)

���� �� 10, -4, 3, 1, 5, 6, -35, 12, 21, -1 �̶�� ������ �־����ٰ� ����. ���⼭ ���� �������� �ʾ��� ���� ������ 12+21�� 33�� ������ �ȴ�.

����, -35�� �����Ѵٸ�, ������ 10, -4, 3, 1, 5, 6, 12, 21, -1�� �ǰ�, ���⼭ ������ 10-4+3+1+5+6+12+21�� 54�� �ȴ�.

�Է�
ù° �ٿ� ���� n(1��n��100,000)�� �־����� ��° �ٿ��� n���� ������ �̷���� ������ �־�����. ���� -1,000���� ũ�ų� ����, 1,000���� �۰ų� ���� �����̴�.

���
ù° �ٿ� ���� ����Ѵ�.*/

package codingtest_study.����;

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
		long[] v = new long[n]; // A[i]�� �����ϴ� �������� �ִ밪
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
