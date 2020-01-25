//���� 10973��
/*����
1���� N������ ���� �̷���� ������ �ִ�. �̶�, ���������� �ٷ� ������ ���� ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

���� ������ ���� �ռ��� ������ ������������ �̷���� �����̰�, ���� �������� ���� ������ ������������ �̷���� �����̴�.

N = 3�� ��쿡 ���������� ������ �����ϸ� ������ ����.

1, 2, 3
1, 3, 2
2, 1, 3
2, 3, 1
3, 1, 2
3, 2, 1
�Է�
ù° �ٿ� N(1 �� N �� 10,000)�� �־�����. ��° �ٿ� ������ �־�����.

���
ù° �ٿ� �Է����� �־��� ������ ������ ���� ������ ����Ѵ�. ����, ���������� ���� ó���� ���� ������ ��쿡�� -1�� ����Ѵ�.*/

package ����;

import java.util.Scanner;

public class N_10973 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int[] A = new int[N];
		for (int i = 0; i < A.length; i++)
			A[i] = s.nextInt();

		// ������ �������� ���ϱ�
		int index;
		for (index = A.length - 1; index >= 0; index--) {
			if (index == 0) {
				System.out.println(-1);
				System.exit(0);
			}
			if (A[index] > A[index - 1])
				continue;
			break;
		}

		// �ٲ� ��� ���ϱ�
		int i;
		for (i = index; i < A.length; i++) {
			if (A[i] > A[index - 1])
				break;
		}
		int temp = A[index - 1];
		A[index - 1] = A[i - 1];
		A[i - 1] = temp;

		for (int j = 0; j <= index - 1; j++)
			System.out.print(A[j] + " ");
		for (int j = A.length - 1; j >= index; j--)
			System.out.print(A[j] + " ");
	}

}
