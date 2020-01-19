//���� 11722��
/*����
���� A�� �־����� ��, ���� �� �����ϴ� �κ� ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

���� ���, ���� A = {10, 30, 10, 20, 20, 10} �� ��쿡 ���� �� �����ϴ� �κ� ������ A = {10, 30, 10, 20, 20, 10}  �̰�, ���̴� 3�̴�.

�Է�
ù° �ٿ� ���� A�� ũ�� N (1 �� N �� 1,000)�� �־�����.

��° �ٿ��� ���� A�� �̷�� �ִ� Ai�� �־�����. (1 �� Ai �� 1,000)

���
ù° �ٿ� ���� A�� ���� �� �����ϴ� �κ� ������ ���̸� ����Ѵ�.*/

package codingtest_study.����;

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
