//���� 9095(���Ʈ ���� ������� Ǯ��)
/*����
���� 4�� 1, 2, 3�� ������ ��Ÿ���� ����� �� 7������ �ִ�. ���� ��Ÿ�� ���� ���� 1�� �̻� ����ؾ� �Ѵ�.

1+1+1+1
1+1+2
1+2+1
2+1+1
2+2
1+3
3+1
���� n�� �־����� ��, n�� 1, 2, 3�� ������ ��Ÿ���� ����� ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� �׽�Ʈ ���̽��� ���� T�� �־�����. �� �׽�Ʈ ���̽��� �� �ٷ� �̷���� �ְ�, ���� n�� �־�����. n�� ����̸� 11���� �۴�.

���
�� �׽�Ʈ ���̽�����, n�� 1, 2, 3�� ������ ��Ÿ���� ����� ���� ����Ѵ�.*/

package ����;

import java.util.Scanner;

public class N_9095_v2 {
	static int count = 0;

	static void go(int sum, int goal) {
		if (sum > goal)
			return;
		if (sum == goal) {
			count++;
			return;
		}
		for (int i = 1; i <= 3; i++) {
			go(sum + i, goal);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		for (int i = 0; i < T; i++) {
			int n = s.nextInt();
			go(0, n);
			System.out.println(count);
			count = 0;
		}
	}

}
