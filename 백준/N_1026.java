//���� 1026��
//���� ���� Ǯ��
/*����
���� ������ ������ �׻� ū ��ĩ�Ÿ����� ���� �־���. �� ������ ���� �������� ������ ���� ������ ���� ū ����� �ɾ���.

���̰� N�� ���� �迭 A�� B�� �ִ�. ������ ���� �Լ� S�� ��������.

S = A[0]*B[0] + ... + A[N-1]*B[N-1]

S�� ���� ���� �۰� ����� ���� A�� ���� ��迭����. ��, B�� �ִ� ���� ��迭�ϸ� �� �ȴ�.

S�� �ּڰ��� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� N�� �־�����. ��° �ٿ��� A�� �ִ� N���� ���� ������� �־�����, ��° �ٿ��� B�� �ִ� ���� ������� �־�����. N�� 50���� �۰ų� ���� �ڿ����̰�, A�� B�� �� ���Ҵ� 100���� �۰ų� ���� ���� �ƴ� �����̴�.

���
ù° �ٿ� S�� �ּڰ��� ����Ѵ�.*/

package ����;

import java.util.*;

public class N_1026 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int[] A = new int[N];
		Integer[] B = new Integer[N];     //comparator ���ʸ� Ÿ�� ������ Integer�� �ٲٴ� �� �ٽ�!

		for (int i = 0; i < A.length; i++) {
			A[i] = s.nextInt();
		}
		for (int i = 0; i < B.length; i++) {
			B[i] = s.nextInt();
		}
		Arrays.sort(A);
		Arrays.sort(B, new Comparator<Integer>() {
			public int compare(Integer a, Integer b) {
				if (a > b)
					return -1;
				else
					return 1;
			}
		});

		int result = 0;
		for (int i = 0; i < A.length; i++) {
			result += A[i] * B[i];
		}
		System.out.println(result);
	}

}
