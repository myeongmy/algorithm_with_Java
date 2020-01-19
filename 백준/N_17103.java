//���� 17103��
/*����
�������� ����: 2���� ū ¦���� �� �Ҽ��� ������ ��Ÿ�� �� �ִ�.
¦�� N�� �� �Ҽ��� ������ ��Ÿ���� ǥ���� ������ ��Ƽ���̶�� �Ѵ�. ¦�� N�� �־����� ��, ������ ��Ƽ���� ������ ���غ���. �� �Ҽ��� ������ �ٸ� ���� ���� ��Ƽ���̴�.

�Է�
ù° �ٿ� �׽�Ʈ ���̽��� ���� T (1 �� T �� 100)�� �־�����. �� �׽�Ʈ ���̽��� �� �ٷ� �̷���� �ְ�, ���� N�� ¦���̰�, 2 < N �� 1,000,000�� �����Ѵ�.

���
������ �׽�Ʈ ���̽����� ������ ��Ƽ���� ���� ����Ѵ�.*/

package codingtest_study.����;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class N_17103 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean[] check = new boolean[1000001];
		ArrayList<Integer> prime = new ArrayList<Integer>();
		check[0] = true;
		check[1] = true;
		for (int i = 2; i <= 1000000; i++) {
			if (check[i] == false) {
				prime.add(i);
				for (int j = 2; i * j <= 1000000; j++) {
					check[i * j] = true;
				}
			}
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int T = Integer.parseInt(br.readLine());
			for (int i = 0; i < T; i++) {
				int N = Integer.parseInt(br.readLine());
				int resultNum = 0;
				for (int j = 0; j< prime.size() && prime.get(j) < N; j++) {  //��Ÿ�� ������ �κ�
					if (check[N - prime.get(j)] == false) {
						if (prime.get(j) <= N - prime.get(j))
							resultNum++;
					}
				}
				System.out.println(resultNum);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
