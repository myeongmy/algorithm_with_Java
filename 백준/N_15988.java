//���� 15988��
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
ù° �ٿ� �׽�Ʈ ���̽��� ���� T�� �־�����. �� �׽�Ʈ ���̽��� �� �ٷ� �̷���� �ְ�, ���� n�� �־�����. n�� ����̸� 1,000,000���� �۰ų� ����.

���
�� �׽�Ʈ ���̽�����, n�� 1, 2, 3�� ������ ��Ÿ���� ����� ���� 1,000,000,009�� ���� �������� ����Ѵ�.*/

package codingtest_study.����;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_15988 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long[] d = new long[1000001];
		d[0] = 1;
		for (int i = 1; i <= 1000000; i++) {
			if (i - 1 >= 0)
				d[i] += d[i - 1];
			if (i - 2 >= 0)
				d[i] += d[i - 2];
			if (i - 3 >= 0)
				d[i] += d[i - 3];
			d[i] %= 1000000009;
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int T = Integer.parseInt(br.readLine());
			for (int i = 0; i < T; i++) {
				int n = Integer.parseInt(br.readLine());
				System.out.println(d[n]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
