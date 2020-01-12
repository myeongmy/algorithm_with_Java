//���� 9465��
/*����
������� ������ ����̴� ���汸���� ��ƼĿ 2n���� �����ߴ�. ��ƼĿ�� �׸� (a)�� ���� 2�� n���� ��ġ�Ǿ� �ִ�. ����̴� ��ƼĿ�� �̿��� å���� �ٹ̷��� �Ѵ�.

����̰� ������ ��ƼĿ�� ǰ���� �ſ� ���� �ʴ�. ��ƼĿ �� ���� ����, �� ��ƼĿ�� ���� �����ϴ� ��ƼĿ�� ��� �������� ����� �� ���� �ȴ�. ��, �� ��ƼĿ�� ����, ������, ��, �Ʒ��� �ִ� ��ƼĿ�� ����� �� ���� �ȴ�.



��� ��ƼĿ�� ���� �� ���Ե� ����̴� �� ��ƼĿ�� ������ �ű��, ������ ���� �ִ밡 �ǰ� ��ƼĿ�� ������� �Ѵ�. ����, �׸� (b)�� ���� �� ��ƼĿ�� ������ �Ű��. ����̰� �� �� �ִ� ��ƼĿ�� ������ �ִ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�. ��, 2n���� ��ƼĿ �߿��� ������ ���� �ִ밡 �Ǹ鼭 ���� ���� ���� ���� �ʴ� ��ƼĿ ������ ���ؾ� �Ѵ�.

���� �׸��� ��쿡 ������ 50, 50, 100, 60�� ��ƼĿ�� ����, ������ 260�� �ǰ� �� ���� �ִ� �����̴�. ���� ���� ������ ������ �� ��ƼĿ (100�� 70)�� ���� �����ϱ� ������, ���ÿ� �� �� ����.

�Է�
ù° �ٿ� �׽�Ʈ ���̽��� ���� T�� �־�����. �� �׽�Ʈ ���̽��� ù° �ٿ��� n (1 �� n �� 100,000)�� �־�����. ���� �� �ٿ��� n���� ������ �־�����, �� ������ �� ��ġ�� �ش��ϴ� ��ƼĿ�� �����̴�. �����ϴ� �� ���� ���̿��� �� ĭ�� �ϳ� �ִ�. ������ 0���� ũ�ų� ����, 100���� �۰ų� ���� �����̴�. 

���
�� �׽�Ʈ ���̽� ����, 2n���� ��ƼĿ �߿��� �� ���� �������� �ʴ� ��ƼĿ ������ �ִ��� ����Ѵ�.*/

package codingtest_study.����;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_9465 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int T = Integer.parseInt(br.readLine());
			for (int k = 0; k < T; k++) {
				int n = Integer.parseInt(br.readLine());
				int[][] score = new int[2][n];
				for (int i = 0; i < 2; i++) {
					String[] arr = br.readLine().split(" ");
					for (int j = 0; j < n; j++) {
						score[i][j] = Integer.parseInt(arr[j]);
					}
				}
				long[][] d = new long[n + 1][3];
				d[1][0] = 0;
				d[1][1] = score[0][0];
				d[1][2] = score[1][0];
				for (int i = 2; i <= n; i++) {
					d[i][0] = Math.max(Math.max(d[i - 1][0], d[i - 1][1]), d[i - 1][2]);
					d[i][1] = Math.max(d[i - 1][0] + score[0][i - 1], d[i - 1][2] + score[0][i - 1]);
					d[i][2] = Math.max(d[i - 1][0] + score[1][i - 1], d[i - 1][1] + score[1][i - 1]);
				}
				System.out.println(Math.max(Math.max(d[n][0], d[n][1]), d[n][2]));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
