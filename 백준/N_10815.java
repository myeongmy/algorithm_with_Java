//���� 10815��
//���� Ž�� ����
/*����
���� ī��� ���� �ϳ��� ������ �ִ� ī���̴�. ����̴� ���� ī�� N���� ������ �ִ�. ���� M���� �־����� ��, �� ���� �����ִ� ���� ī�带 ����̰� ������ �ִ��� �ƴ����� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� ����̰� ������ �ִ� ���� ī���� ���� N(1 �� N �� 500,000)�̰� �־�����. ��° �ٿ��� ���� ī�忡 �����ִ� ������ �־�����. ���� ī�忡 �����ִ� ���� -10,000,000���� ũ�ų� ����, 10,000,000���� �۰ų� ����. �� ���� ī�忡 ���� ���� �����ִ� ���� ����.

��° �ٿ��� M(1 �� M �� 500,000)�� �־�����. ��° �ٿ��� ����̰� ������ �ִ� ���� ī������ �ƴ����� ���ؾ� �� M���� ������ �־�����, �� ���� �������� ���еǾ��� �ִ�. �� ���� -10,000,000���� ũ�ų� ����, 10,000,000���� �۰ų� ����

���
ù° �ٿ� �Է����� �־��� M���� ���� ���ؼ�, �� ���� ���� ���� ī�带 ����̰� ������ ������ 1��, �ƴϸ� 0�� �������� ������ ����Ѵ�.*/

package ����;

import java.util.*;

public class N_10815 {
	static int binarySearch(int [] A, int start, int end, int key) {
		if(start > end)
			return -1;
		else {
			int mid = (start+end)/2;
			if(A[mid] == key)
				return mid;
			else if(A[mid] < key)
				return binarySearch(A, mid+1, end, key);
			else
				return binarySearch(A, start, mid-1, key);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int[] A = new int[N];
		for (int i = 0; i < N; i++)
			A[i] = s.nextInt();
		Arrays.sort(A);
		int M = s.nextInt();
		for (int i = 0; i < M; i++) {
			//int result = Arrays.binarySearch(A, s.nextInt());
			int result = binarySearch(A, 0, A.length-1, s.nextInt());
			if (result >= 0)
				System.out.print(1+" ");
			else
				System.out.print(0+" ");
		}
	}

}
