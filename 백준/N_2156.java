//���� 2156��
/*����
ȿ�ִ� ������ �ý�ȸ�� ����. �� ���� ������, ���̺� ���� �پ��� �����ְ� ����ִ� ������ ���� �Ϸķ� ���� �־���. ȿ�ִ� ������ �ý��� �Ϸ��� �ϴµ�, ���⿡�� ������ ���� �� ���� ��Ģ�� �ִ�.

������ ���� �����ϸ� �� �ܿ� ����ִ� �����ִ� ��� ���ž� �ϰ�, ���� �Ŀ��� ���� ��ġ�� �ٽ� ���ƾ� �Ѵ�.
�������� ���� �ִ� 3���� ��� ���� ���� ����.
ȿ�ִ� �� �� �ִ� ��� ���� ���� �����ָ� ������ ���ؼ� � ������ ���� �����ؾ� ���� ����ϰ� �ִ�. 1���� n������ ��ȣ�� �پ� �ִ� n���� ������ ���� ������� ���̺� ���� ���� �ְ�, �� ������ �ܿ� ����ִ� �������� ���� �־����� ��, ȿ�ָ� ���� ���� ���� ���� �����ָ� ���� �� �ֵ��� �ϴ� ���α׷��� �ۼ��Ͻÿ�. 

���� ��� 6���� ������ ���� �ְ�, ������ �ܿ� ������� 6, 10, 13, 9, 8, 1 ��ŭ�� �����ְ� ��� ���� ��, ù ��°, �� ��°, �� ��°, �ټ� ��° ������ ���� �����ϸ� �� ������ ���� 33���� �ִ�� ���� �� �ִ�.

�Է�
ù° �ٿ� ������ ���� ���� n�� �־�����. (1��n��10,000) ��° �ٺ��� n+1��° �ٱ��� ������ �ܿ� ����ִ� �������� ���� ������� �־�����. �������� ���� 1,000 ������ ���� �ƴ� �����̴�.

���
ù° �ٿ� �ִ�� ���� �� �ִ� �������� ���� ����Ѵ�.*/

package codingtest_study.����;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_2156 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int n = Integer.parseInt(br.readLine());
			int[] amount = new int[n + 1];
			for (int i = 0; i < n; i++) {
				amount[i + 1] = Integer.parseInt(br.readLine());
			}
			long[][] d = new long[n + 1][3];
			d[1][0] = 0;
			d[1][1] = amount[1];
			d[1][2] = 0;
			for (int i = 2; i <= n; i++) {
				d[i][0] = Math.max(Math.max(d[i - 1][0], d[i - 1][1]), d[i - 1][2]);
				d[i][1] = d[i - 1][0] + amount[i];
				d[i][2] = d[i - 1][1] + amount[i];
			}
			System.out.println(Math.max(Math.max(d[n][0], d[n][1]), d[n][2]));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
