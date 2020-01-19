//���� 11055��
/*����
���� A�� �־����� ��, �� ������ ���� �κ� ���� �߿��� ���� ���� ū ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

���� ���, ���� A = {1, 100, 2, 50, 60, 3, 5, 6, 7, 8} �� ��쿡 ���� ���� ū ���� �κ� ������ A = {1, 100, 2, 50, 60, 3, 5, 6, 7, 8} �̰�, ���� 113�̴�.

�Է�
ù° �ٿ� ���� A�� ũ�� N (1 �� N �� 1,000)�� �־�����.

��° �ٿ��� ���� A�� �̷�� �ִ� Ai�� �־�����. (1 �� Ai �� 1,000)

���
ù° �ٿ� ���� A�� ���� ���� ū ���� �κ� ������ ���� ����Ѵ�.*/

package codingtest_study.����;

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
