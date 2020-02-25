//���� 14226��
/*����
�����̴� �ſ� ��ڱ� ������, ȿ���̿��� ������ �̸�Ƽ���� S�� �������� �Ѵ�.

�����̴� �̹� ȭ�鿡 �̸�Ƽ�� 1���� �Է��ߴ�. ����, ������ ���� 3���� ���길 ����ؼ� �̸�Ƽ���� S�� ����� ������ �Ѵ�.

ȭ�鿡 �ִ� �̸�Ƽ���� ��� �����ؼ� Ŭ�����忡 �����Ѵ�.
Ŭ�����忡 �ִ� ��� �̸�Ƽ���� ȭ�鿡 �ٿ��ֱ� �Ѵ�.
ȭ�鿡 �ִ� �̸�Ƽ�� �� �ϳ��� �����Ѵ�.
��� ������ 1�ʰ� �ɸ���. ��, Ŭ�����忡 �̸�Ƽ���� �����ϸ� ������ Ŭ�����忡 �ִ� ������ ����Ⱑ �ȴ�. Ŭ�����尡 ����ִ� ���¿��� �ٿ��ֱ⸦ �� �� ������, �Ϻθ� Ŭ�����忡 ������ ���� ����. ����, Ŭ�����忡 �ִ� �̸�Ƽ�� �� �Ϻθ� ������ �� ����. ȭ�鿡 �̸�Ƽ���� �ٿ��ֱ� �ϸ�, Ŭ�����忡 �ִ� �̸�Ƽ���� ������ ȭ�鿡 �߰��ȴ�.

�����̰� S���� �̸�Ƽ���� ȭ�鿡 ����µ� �ɸ��� �ð��� �ּڰ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� S (2 �� S �� 1000) �� �־�����.

���
ù° �ٿ� �̸�Ƽ���� S�� ����� ���� �ʿ��� �ð��� �ּڰ��� ����Ѵ�.*/

package ����;

import java.util.*;

class Sticker {
	int s;
	int c;
	int cnt;

	Sticker(int s, int c, int cnt) {
		this.s = s;
		this.c = c;
		this.cnt = cnt;
	}
}

public class N_14226 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int S = s.nextInt();
		int[][] c = new int[2000][2000]; // �湮 ���� ����

		Queue<Sticker> q = new LinkedList<Sticker>();
		c[1][0] = 1;
		q.offer(new Sticker(1, 0, 0));

		while (!q.isEmpty()) {
			Sticker st = q.poll();
			if(st.s == S) {
				System.out.println(st.cnt);
				System.exit(0);
			}
			// 1��° ����: Ŭ�����忡 ȭ�鿡 �ִ� �̸�Ƽ�� �����ϱ�
			if (st.s < 2000 && c[st.s][st.s] == 0) {
				q.offer(new Sticker(st.s, st.s, st.cnt + 1));
				c[st.s][st.s] = 1;
			}
			
			//2��° ����: Ŭ�����忡 �ִ� ��� �̸�Ƽ���� ȭ�鿡 �ٿ��ֱ�
			if(st.s+st.c < 2000 && c[st.s+st.c][st.c] == 0) {
				q.offer(new Sticker(st.s+st.c, st.c, st.cnt+1));
				c[st.s+st.c][st.c] = 1;
			}
			
			//3��° ����: ȭ�鿡 �ִ� �̸�Ƽ�� �� �ϳ��� ����
			if(st.s-1 >=0 && c[st.s-1][st.c] == 0) {
				q.offer(new Sticker(st.s-1, st.c, st.cnt+1));
				c[st.s-1][st.c] = 1;
			}
		}
	}

}
