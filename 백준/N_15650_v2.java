//���� 15650��
/*����
�ڿ��� N�� M�� �־����� ��, �Ʒ� ������ �����ϴ� ���̰� M�� ������ ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

1���� N���� �ڿ��� �߿��� �ߺ� ���� M���� �� ����
�� ������ ���������̾�� �Ѵ�.
�Է�
ù° �ٿ� �ڿ��� N�� M�� �־�����. (1 �� M �� N �� 8)

���
�� �ٿ� �ϳ��� ������ ������ �����ϴ� ������ ����Ѵ�. �ߺ��Ǵ� ������ ���� �� ����ϸ� �ȵǸ�, �� ������ �������� �����ؼ� ����ؾ� �Ѵ�.

������ ���� ������ �����ϴ� ������ ����ؾ� �Ѵ�.*/

package ����;

import java.util.Scanner;

public class N_15650_v2 {
	static int[] result = new int[10];

	static void go(int index, int selected, int N, int M) {
		if (selected == M) {
			for (int i = 0; i < selected; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
			return;
		}
		if (index > N)
			return;
		result[selected] = index;
		go(index + 1, selected + 1, N, M);
		result[selected] = 0;
		go(index + 1, selected, N, M);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int M = s.nextInt();
		go(1, 0, N, M);
	}

}
