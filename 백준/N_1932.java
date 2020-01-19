//���� 1932��
/*����
        7
      3   8
    8   1   0
  2   7   4   4
4   5   2   6   5
�� �׸��� ũ�Ⱑ 5�� ���� �ﰢ���� �� ����̴�.

�� ���� 7���� �����ؼ� �Ʒ��� �ִ� �� �� �ϳ��� �����Ͽ� �Ʒ������� ������ ��, �������� ���õ� ���� ���� �ִ밡 �Ǵ� ��θ� ���ϴ� ���α׷��� �ۼ��϶�. �Ʒ����� �ִ� ���� ���� ������ ���õ� ���� �밢�� ���� �Ǵ� �밢�� �����ʿ� �ִ� �� �߿����� ������ �� �ִ�.

�ﰢ���� ũ��� 1 �̻� 500 �����̴�. �ﰢ���� �̷�� �ִ� �� ���� ��� �����̸�, ������ 0 �̻� 9999 �����̴�.

�Է�
ù° �ٿ� �ﰢ���� ũ�� n(1 �� n �� 500)�� �־�����, ��° �ٺ��� n+1��° �ٱ��� ���� �ﰢ���� �־�����.

���
ù° �ٿ� ���� �ִ밡 �Ǵ� ��ο� �ִ� ���� ���� ����Ѵ�.*/

package codingtest_study.����;

import java.util.Scanner;

public class N_1932 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[][] A = new int[n][n];
		long[][] d = new long[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				A[i][j] = s.nextInt();
			}
		}
		d[0][0] = A[0][0];
		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				if (j - 1 >= 0)
					d[i][j] = Math.max(d[i - 1][j] + A[i][j], d[i - 1][j - 1] + A[i][j]);
				else
					d[i][j] = d[i - 1][j] + A[i][j];
			}
		}
		long max = d[n - 1][0];
		for (int i = 0; i < n; i++) {
			if (max < d[n - 1][i])
				max = d[n - 1][i];
		}
		System.out.println(max);
	}

}
