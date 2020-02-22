//���� 1920��
//���� Ž�� ����
/*����
N���� ���� A[1], A[2], ��, A[N]�� �־��� ���� ��, �� �ȿ� X��� ������ �����ϴ��� �˾Ƴ��� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� �ڿ��� N(1��N��100,000)�� �־�����. ���� �ٿ��� N���� ���� A[1], A[2], ��, A[N]�� �־�����. ���� �ٿ��� M(1��M��100,000)�� �־�����. ���� �ٿ��� M���� ������ �־����µ�, �� ������ A�ȿ� �����ϴ��� �˾Ƴ��� �ȴ�. ��� �������� ������ int �� �Ѵ�.

���
M���� �ٿ� ���� ����Ѵ�. �����ϸ� 1��, �������� ������ 0�� ����Ѵ�.*/

package ����;

import java.util.*;

public class N_1920 {
	static int binarySearch(int key, int start, int end, int[] A) {
		if (start > end)
			return -1;

		int mid = (start + end) / 2;
		if (A[mid] > key)
			return binarySearch(key, start, mid - 1, A);
		else if (A[mid] < key)
			return binarySearch(key, mid + 1, end, A);
		else
			return mid;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int[] A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = s.nextInt();
		}
		Arrays.sort(A);
		// 1. ǥ�� ���̺귯���� �̿��� ����

		int M = s.nextInt();
		for (int i = 0; i < M; i++) {
			int key = s.nextInt();
			if (Arrays.binarySearch(A, key) < 0) {
				System.out.println(0);
			} else {
				System.out.println(1);
			}
		}

		// 2.���� ����
		int M = s.nextInt();
		for (int i = 0; i < M; i++) {
			int key = s.nextInt();
			int result = binarySearch(key, 0, A.length - 1, A);

			if (result == -1)
				System.out.println(0);
			else
				System.out.println(1);

		}

	}

}
