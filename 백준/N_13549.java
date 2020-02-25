//���� 13549��
/*����
�����̴� ������ ���ٲ����� �ϰ� �ִ�. �����̴� ���� �� N(0 �� N �� 100,000)�� �ְ�, ������ �� K(0 �� K �� 100,000)�� �ִ�. �����̴� �Ȱų� �����̵��� �� �� �ִ�. ����, �������� ��ġ�� X�� �� �ȴ´ٸ� 1�� �Ŀ� X-1 �Ǵ� X+1�� �̵��ϰ� �ȴ�. �����̵��� �ϴ� ��쿡�� 0�� �Ŀ� 2*X�� ��ġ�� �̵��ϰ� �ȴ�.

�����̿� ������ ��ġ�� �־����� ��, �����̰� ������ ã�� �� �ִ� ���� ���� �ð��� �� �� ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù ��° �ٿ� �����̰� �ִ� ��ġ N�� ������ �ִ� ��ġ K�� �־�����. N�� K�� �����̴�.

���
�����̰� ������ ã�� ���� ���� �ð��� ����Ѵ�.*/

package ����;

import java.util.*;

class Hide {
	int x;
	int cnt;

	Hide(int x, int cnt) {
		this.x = x;
		this.cnt = cnt;
	}
}

public class N_13549 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int K = s.nextInt();

		// bfs Ǯ��
		int[] c = new int[100001]; // �湮 ���� ����
		ArrayDeque<Hide> q = new ArrayDeque<Hide>();

		c[N] = 1;
		q.offerLast(new Hide(N, 0));

		while (!q.isEmpty()) {
			Hide h = q.poll();
			if (h.x == K) {
				System.out.println(h.cnt);
				System.exit(0);
			}

			if (2 * h.x <= 100000 && c[2 * h.x] == 0) {
				q.offerFirst(new Hide(2 * h.x, h.cnt));
				c[2 * h.x] = 1;
			}
			if (h.x - 1 >= 0 && c[h.x - 1] == 0) {
				q.offerLast(new Hide(h.x - 1, h.cnt + 1));
				c[h.x - 1] = 1;
			}
			if (h.x + 1 <= 100000 && c[h.x + 1] == 0) {
				q.offerLast(new Hide(h.x + 1, h.cnt + 1));
				c[h.x + 1] = 1;
			}
		}
	}

}
