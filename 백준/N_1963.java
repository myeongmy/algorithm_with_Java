//���� 1963��
//BFS ���� + �����佺�׳ʽ��� ü
/*����
�Ҽ��� �������� �����ϴ� â���̴� ���� ���̵� ��й�ȣ�� 4�ڸ� ���Ҽ����� ���س��Ҵ�. ��� �� â���̴� ģ�� ģ���� ��ȭ�� �������µ�:

������ ���� ��� �ٲ� ���� ���ݾơ�
���� ������ 1033���� �س��µ�... ���� �Ҽ��� �������� ���� ������̾�"
���׷� 8179�� �ء�
����... ���� �� �غ���. �� ������ �� �̻��ؼ� ��й�ȣ�� �� ���� �� �ڸ� �ۿ� �� �ٲ۴� ���̾�. ���� ��� ���� ù �ڸ��� �ٲٸ� 8033�� �Ǵϱ� �Ҽ��� �ƴ��ݾ�. ���� �ܰ踦 ���ľ� ���� �� ���� �� ������... ���� ���... 1033 1733 3733 3739 3779 8779 8179ó�� ���̾�.��
����...���� �Ҽ��� ���Ʊ�. �׷� �ƿ� ���α׷��� ¥�� �׷�. �� �ڸ� �Ҽ� �� ���� �Է¹޾Ƽ� �ٲٴµ� �� �ܰ質 �ʿ����� ����ϰ� ����.��
�������ơ�
�׷���. �׷��� �������� �� ������ Ǯ�� �Ǿ���. �Է��� �׻� �� �ڸ� �Ҽ���(1000 �̻�) �־����ٰ� ��������. �־��� �� �Ҽ� A���� B�� �ٲٴ� ���������� �׻� �� �ڸ� �Ҽ����� �����ؾ� �ϰ�, ���� �ڸ� ������ �Ͽ��� ������ 0039 �� ���� 1000 �̸��� ��й�ȣ�� ������ �ʴ´�.

�Է�
ù �ٿ� test case�� �� T�� �־�����. ���� T�ٿ� ���� �� �ٿ� 1�־� �� �ڸ� �Ҽ��� �־�����.

���
�� test case�� ���� �� �Ҽ� ������ ��ȯ�� �ʿ��� �ּ� ȸ���� ����Ѵ�. �Ұ����� ��� Impossible�� ����Ѵ�.*/

package ����;

import java.util.*;
import java.io.*;

class Game {
	int num;
	int cnt;

	Game(int num, int cnt) {
		this.num = num;
		this.cnt = cnt;
	}
}

public class N_1963 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		try {
			//�̸� �Ҽ� ���صα� (�����佺�׳ʽ��� ü �̿�)
			boolean [] prime = new boolean[10000];    //true�� �ռ���, false�� �Ҽ�
			for(int i=2;i<10000;i++) {
				if(prime[i] == false) {
					for(int j = i*2;j<10000;j += i)
						prime[j] = true;
				}
			}
			int T = Integer.parseInt(br.readLine());
			for (int i = 0; i < T; i++) {
				String[] arr = br.readLine().split(" ");
				int a = Integer.parseInt(arr[0]);
				int b = Integer.parseInt(arr[1]);

				// bfs Ǯ��
				int[] c = new int[10000];
				Queue<Game> q = new LinkedList<Game>();

				c[a] = 1;
				q.offer(new Game(a, 0));
				while (!q.isEmpty()) {
					Game g = q.poll();
					if (g.num == b) {
						bw.write(Integer.toString(g.cnt));
						bw.newLine();
						break;
					}

					// ù°�ڸ� �� �ٲٱ�
					int temp = g.num / 1000;
					for (int j = 1; j <= 9; j++) {
						if (j == temp)
							continue;
						if (prime[j * 1000 + g.num % 1000] == false && c[j * 1000 + g.num % 1000] == 0) {
							q.offer(new Game(j * 1000 + g.num % 1000, g.cnt + 1));
							c[j * 1000 + g.num % 1000] = 1;
						}
					}

					// ��°�ڸ� �� �ٲٱ�
					temp = (g.num / 100) % 10;
					for (int j = 0; j <= 9; j++) {
						if (j == temp)
							continue;
						if (prime[j * 100 + g.num % 100 + (g.num / 1000) * 1000] == false && c[j * 100 + g.num % 100 + (g.num / 1000) * 1000] == 0) {
							q.offer(new Game(j * 100 + g.num % 100 + (g.num / 1000) * 1000, g.cnt + 1));
							c[j * 100 + g.num % 100 + (g.num / 1000) * 1000] = 1;
						}

					}

					// ��°�ڸ� �� �ٲٱ�
					temp = (g.num % 100) / 10;
					for (int j = 0; j <= 9; j++) {
						if (j == temp)
							continue;
						if (prime[j * 10 + g.num % 10 + (g.num / 100) * 100] == false && c[j * 10 + g.num % 10 + (g.num / 100) * 100] == 0) {
							q.offer(new Game(j * 10 + g.num % 10 + (g.num / 100) * 100, g.cnt + 1));
							c[j * 10 + g.num % 10 + (g.num / 100) * 100] = 1;
						}
					}

					// ��°�ڸ� �� �ٲٱ�
					temp = g.num % 10;
					for (int j = 0; j <= 9; j++) {
						if (j == temp)
							continue;
						if (prime[(g.num / 10) * 10 + j] == false && c[(g.num / 10) * 10 + j] == 0) {
							q.offer(new Game((g.num / 10) * 10 + j, g.cnt + 1));
							c[(g.num / 10) * 10 + j] = 1;
						}
					}

				}
			}
			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
