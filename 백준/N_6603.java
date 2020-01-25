//���� 6603��
/*����
���� �ζǴ� {1, 2, ..., 49}���� �� 6���� ����.

�ζ� ��ȣ�� �����ϴµ� ���Ǵ� ���� ������ ������ 49���� �� �� k(k>6)���� ���� ��� ���� S�� ���� ���� �� ���� ������ ��ȣ�� �����ϴ� ���̴�.

���� ���, k=8, S={1,2,3,5,8,13,21,34}�� ��� �� ���� S���� ���� �� �� �ִ� ����� ���� �� 28�����̴�. ([1,2,3,5,8,13], [1,2,3,5,8,21], [1,2,3,5,8,34], [1,2,3,5,13,21], ..., [3,5,8,13,21,34])

���� S�� k�� �־����� ��, ���� ���� ��� ����� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
�Է��� ���� ���� �׽�Ʈ ���̽��� �̷���� �ִ�. �� �׽�Ʈ ���̽��� �� �ٷ� �̷���� �ִ�. ù ��° ���� k (6 < k < 13)�̰�, ���� k�� ���� ���� S�� ���ԵǴ� ���̴�. S�� ���Ҵ� ������������ �־�����.

�Է��� ������ �ٿ��� 0�� �ϳ� �־�����. 

���
�� �׽�Ʈ ���̽����� ���� ���� ��� ����� ����Ѵ�. �̶�, ���� ������ ����Ѵ�.

�� �׽�Ʈ ���̽� ���̿��� �� ���� �ϳ� ����Ѵ�.*/

package ����;

import java.util.Scanner;

public class N_6603 {
	static int[] result = new int[6];

	static void go(int index, int selected, int[] A, int k) {
		if (selected == 6) {
			for (int i = 0; i < 6; i++)
				System.out.print(result[i] + " ");
			System.out.println();
			return;
		}
		if (index == k)
			return;
		result[selected] = A[index];
		go(index + 1, selected + 1, A, k);
		result[selected] = 0;
		go(index + 1, selected, A, k);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int k;
		while (true) {
			String[] arr = s.nextLine().split(" ");
			if (arr[0].equals("0"))
				break;
			k = Integer.parseInt(arr[0]);
			int[] A = new int[k];
			for (int i = 1; i < arr.length; i++) {
				A[i - 1] = Integer.parseInt(arr[i]);
			}
			go(0, 0, A, k);
			System.out.println();
		}
		System.exit(0);
	}

}
