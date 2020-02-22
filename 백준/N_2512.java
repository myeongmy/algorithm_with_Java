//���� 2512��
//����Ž�� ����
/*����
������ ���� �� �ϳ��� ���� ������ �����û�� �ɻ��Ͽ� ������ ������ �й��ϴ� ���̴�. ���������� �Ѿ��� �̸� ������ �־ ��� �����û�� ������ �ֱ�� ����� ���� �ִ�. �׷��� ������ �Ѿ� ���Ͽ��� ������ �� �ִ��� �� ������ ������ ���� ������� �����Ѵ�.

��� ��û�� ������ �� �ִ� ��쿡�� ��û�� �ݾ��� �״�� �����Ѵ�.
��� ��û�� ������ �� ���� ��쿡�� Ư���� ���� ���Ѿ��� ����Ͽ� �� �̻��� �����û���� ��� ���Ѿ��� �����Ѵ�. ���Ѿ� ������ �����û�� ���ؼ��� ��û�� �ݾ��� �״�� �����Ѵ�. 
���� ���, ��ü ���������� 485�̰� 4�� ������ �����û�� ���� 120, 110, 140, 150�̶�� ����. �� ���, ���Ѿ��� 127�� ������, ���� ��û�鿡 ���ؼ� ���� 120, 110, 127, 127�� �����ϰ� �� ���� 484�� ������ �ִ밡 �ȴ�. 

���� ������ �����û�� ���������� �Ѿ��� �־����� ��, ���� ������ ��� �����ϵ��� ������ �����ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ��� ������ ���� �ǹ��ϴ� ���� N�� �־�����. N�� 3 �̻� 10,000 �����̴�. ���� �ٿ��� �� ������ �����û�� ǥ���ϴ� N���� ������ ��ĭ�� ���̿� �ΰ� �־�����. �� ������ ��� 1 �̻� 100,000 �����̴�. �� ���� �ٿ��� �� ������ ��Ÿ���� ���� M�� �־�����. M�� N �̻� 1,000,000,000 �����̴�. 

���
ù° �ٿ��� ������ ����� �� �ִ��� ������ ����Ѵ�. */

package ����;

import java.util.*;

public class N_2512 {
	static int totalMax = -1;
	static int idx = 0;

	static void binarySearch(int[] A, int start, int end, long M) {
		if (start > end)
			return;
		int mid = (start + end) / 2;
		int sum = 0;
		int max = -1;
		for (int i = 0; i < A.length; i++) {
			if (mid > A[i]) {
				sum += A[i];
				if (max < A[i])
					max = A[i];
			} else {
				sum += mid;
				if (max < mid)
					max = mid;
			}
		}
		if (M >= sum) {
			if (totalMax < sum) {
				totalMax = sum;
				idx = max;
			}
			binarySearch(A, mid + 1, end, M);
		} else {
			binarySearch(A, start, mid - 1, M);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int[] A = new int[N];
		int sum = 0;
		int max = -1;
		for (int i = 0; i < N; i++) {
			A[i] = s.nextInt();
			sum += A[i];
			if (max < A[i])
				max = A[i];
		}
		long M = s.nextLong();
		if (M >= sum) {
			System.out.println(max);
		} else {
			binarySearch(A, 1, max, M);
			System.out.println(idx);
		}
	}

}
