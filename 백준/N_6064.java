//���� 6064��
/*����
�ֱٿ� ICPC Ž���� ���Ƹ޸�ī�� ��ī ������ ���� ������ ���� ī�� ������ ���� �Ͽ� �������ٴ� ����� �߰��ߴ�. ī�� ������ �鼺���� Ư���� �޷��� ����� ������ �˷��� �ִ�. �׵��� M�� N���� �۰ų� ���� �� ���� �ڿ��� x, y�� ������ �� �⵵�� <x:y>�� ���� �������� ǥ���Ͽ���. �׵��� �� ������ ���ʿ� �ش��ϴ� ù ��° �ظ� <1:1>�� ǥ���ϰ�, �� ��° �ظ� <2:2>�� ǥ���Ͽ���. <x:y>�� ���� �ظ� ǥ���� ���� <x':y'>�̶�� ����. ���� x < M �̸� x' = x + 1�̰�, �׷��� ������ x' = 1�̴�. ���� ������� ���� y < N�̸� y' = y + 1�̰�, �׷��� ������ y' = 1�̴�. <M:N>�� �׵� �޷��� ������ �طμ�, �� �ؿ� ������ ������ �����Ѵٴ� ������ ���� �´�. 

���� ���, M = 10 �̰� N = 12��� ����. ù ��° �ش� <1:1>�� ǥ���ǰ�, 11��° �ش� <1:11>�� ǥ���ȴ�. <3:1>�� 13��° �ظ� ��Ÿ����, <10:12>�� �������� 60��° �ظ� ��Ÿ����. 

�� ���� ���� M, N, x�� y�� �־��� ��, <M:N>�� ī�� �޷��� ������ �ض�� �ϸ� <x:y>�� �� ��° �ظ� ��Ÿ������ ���ϴ� ���α׷��� �ۼ��϶�. 

�Է�
�Է� �����ʹ� ǥ�� �Է��� ����Ѵ�. �Է��� T���� �׽�Ʈ �����ͷ� �����ȴ�. �Է��� ù ��° �ٿ��� �Է� �������� ���� ��Ÿ���� ���� T�� �־�����. �� �׽�Ʈ �����ʹ� �� �ٷ� �����ȴ�. �� �ٿ��� �� ���� ���� M, N, x�� y�� �־�����. (1 �� M, N �� 40,000, 1 �� x �� M, 1 �� y �� N) ���⼭ <M:N>�� ī�� �޷��� ������ �ظ� ��Ÿ����.

���
����� ǥ�� ����� ����Ѵ�. �� �׽�Ʈ �����Ϳ� ����, ���� k�� �� �ٿ� ����Ѵ�. ���⼭ k�� <x:y>�� k��° �ظ� ��Ÿ���� ���� �ǹ��Ѵ�. ���� <x:y>�� ���� ǥ���Ǵ� �ذ� ���ٸ�, ��, <x:y>�� ��ȿ���� ���� ǥ���̸�, -1�� ����Ѵ�.*/

package ����;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_6064 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int T = Integer.parseInt(br.readLine());
			Label: for (int i = 0; i < T; i++) {
				String[] arr = br.readLine().split(" ");
				int M = Integer.parseInt(arr[0]);
				int N = Integer.parseInt(arr[1]);
				int x = Integer.parseInt(arr[2]);
				int y = Integer.parseInt(arr[3]);

				int a = 1;
				int b = 1;
				long year = 1;
				while (true) {
					if (a == x)
						break;
					a++;
					if (a == M + 1)
						a = 1;
					b++;
					if (b == N + 1)
						b = 1;
					year++;
				}

				int count = 1;
				while (true) {
					if (b == y)
						break;
					if (count > N) { //N�� ���Ҵµ� ���� ��ã�� ���� ���� �������� �ʴ� ��
						System.out.println(-1);
						continue Label;
					}
					year += M;
					b += M;
					while (b > N) // if(b>N)�̶�� �ؼ� ���� ������. ex) b=24�� ����  N(=11) �ѹ��� ���ָ� ������ ���� �ƴ�.
						b = b - N;
					count++;
				}
				System.out.println(year);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
