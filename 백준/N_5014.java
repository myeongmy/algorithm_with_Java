//���� 5014��
//BFS ����

/*����
��ȣ�� �ڵ� ������ �ϴ� ��ŸƮ�� ��ŸƮ��ũ�� �����ߴ�. ������ ��ȣ�� �������̴�. ������, ������ �� ��ȣ�� ��ŸƮ��ũ�� �ִ� �ǹ��� �ʰ� �����ϰ� ���Ҵ�.

��ŸƮ��ũ�� �� F������ �̷���� ���� �ǹ��� �繫���� �ְ�, ��ŸƮ��ũ�� �ִ� ���� ��ġ�� G���̴�. ��ȣ�� ���� �ִ� ���� S���̰�, ���� ���������͸� Ÿ�� G������ �̵��Ϸ��� �Ѵ�.

���� ���������Ϳ��� � ������ �̵��� �� �ִ� ��ư�� ������, ��ȣ�� ź ���������ʹ� ��ư�� 2���ۿ� ����. U��ư�� ���� U���� ���� ��ư, D��ư�� �Ʒ��� D���� ���� ��ư�̴�. (����, U�� ��, �Ǵ� D�� �Ʒ��� �ش��ϴ� ���� ���� ����, ���������ʹ� �������� �ʴ´�)

��ȣ�� G���� �����Ϸ���, ��ư�� ��� �� �� ������ �ϴ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�. ����, ���������͸� �̿��ؼ� G���� �� �� ���ٸ�, "use the stairs"�� ����Ѵ�.

�Է�
ù° �ٿ� F, S, G, U, D�� �־�����. (1 �� S, G �� F �� 1000000, 0 �� U, D �� 1000000) �ǹ��� 1������ �����ϰ�, ���� ���� ���� F���̴�.

���
ù° �ٿ� ��ȣ�� S������ G������ ���� ���� ������ �ϴ� ��ư�� ���� �ּڰ��� ����Ѵ�. ����, ���������ͷ� �̵��� �� ���� ���� "use the stairs"�� ����Ѵ�.*/

package ����;

import java.util.*;

class Stair {
	int num;
	int cnt;

	Stair(int num, int cnt) {
		this.num = num;
		this.cnt = cnt;
	}
}

public class N_5014 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int F = s.nextInt(); // �� ��
		int S = s.nextInt(); // ���� ��
		int G = s.nextInt(); // ��ǥ ��
		int U = s.nextInt(); // �� �� ������ ���� �� �� �ö󰡴���
		int D = s.nextInt(); // �� �� ������ �Ʒ��� �� �� ����������
		int[] A = new int[F + 1]; // �湮 ���� ����

		Queue<Stair> q = new LinkedList<Stair>();
		A[S] = 1;
		q.offer(new Stair(S, 0));

		while (!q.isEmpty()) {
			Stair st = q.poll();
			if (st.num == G) {
				System.out.println(st.cnt);
				System.exit(0);
			}
			if (st.num + U < A.length && A[st.num + U] == 0) {
				A[st.num + U] = 1;
				q.offer(new Stair(st.num + U, st.cnt + 1));
			}

			if (st.num - D >= 1 && A[st.num - D] == 0) {
				A[st.num - D] = 1;
				q.offer(new Stair(st.num - D, st.cnt + 1));
			}
		}
		System.out.println("use the stairs");

	}

}
