//���� 11054��
/*����
���� S�� � �� Sk�� �������� S1 < S2 < ... Sk-1 < Sk > Sk+1 > ... SN-1 > SN�� �����Ѵٸ�, �� ������ ������� �����̶�� �Ѵ�.

���� ���, {10, 20, 30, 25, 20}�� {10, 20, 30, 40}, {50, 40, 25, 10} �� ������� ����������,  {1, 2, 3, 2, 1, 2, 3, 2, 1}�� {10, 20, 30, 40, 20, 30} �� ������� ������ �ƴϴ�.

���� A�� �־����� ��, �� ������ �κ� ���� �� ������� �����̸鼭 ���� �� ������ ���̸� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� ���� A�� ũ�� N�� �־�����, ��° �ٿ��� ���� A�� �̷�� �ִ� Ai�� �־�����. (1 �� N �� 1,000, 1 �� Ai �� 1,000)

���
ù° �ٿ� ���� A�� �κ� ���� �߿��� ���� �� ������� ������ ���̸� ����Ѵ�.*/

package codingtest_study.����;

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
		int[] sum = new int[N]; // d�� v �迭�� ���� ����� ���� �迭
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
