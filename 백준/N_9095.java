//���� 9095��
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

package codingtest_study.����;

import java.util.Scanner;

public class N_9095 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// �̸� ����صα�!
		int[] d = new int[11];
		d[0] = 1;
		d[1] = 1;
		d[2] = 2;
		for (int i = 3; i <= 10; i++) {
			d[i] = d[i - 1] + d[i - 2] + d[i - 3];
		}
		Scanner s = new Scanner(System.in);

		int T = s.nextInt();
		for (int i = 0; i < T; i++) {
			int n = s.nextInt();
			System.out.println(d[n]);

		}
	}

}
