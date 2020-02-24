//���� 1966��
//�ùķ��̼� ����
/*����
�����е� �˴ٽ��� �������� ������ ���� �������� �μ��ϰ��� �ϴ� ������ �μ� ����� ���� ��������Ρ�, �� ���� ��û�� ���� ���� �μ��Ѵ�. ���� ���� ������ ���δٸ� Queue �ڷᱸ���� �׿��� FIFO - First In First Out - �� ���� �μⰡ �ǰ� �ȴ�. ������ ����̴� ���ο� �����ͱ� ���� ����Ʈ��� �����Ͽ��µ�, �� �����ͱ�� ������ ���� ���ǿ� ���� �μ⸦ �ϰ� �ȴ�.

���� Queue�� ���� �տ� �ִ� ������ ���߿䵵���� Ȯ���Ѵ�.
������ ������ �� ���� �������� �߿䵵�� ���� ������ �ϳ��� �ִٸ�, �� ������ �μ����� �ʰ� Queue�� ���� �ڿ� ���ġ �Ѵ�. �׷��� �ʴٸ� �ٷ� �μ⸦ �Ѵ�.
���� ��� Queue�� 4���� ����(A B C D)�� �ְ�, �߿䵵�� 2 1 4 3 ��� C�� �μ��ϰ�, �������� D�� �μ��ϰ� A, B�� �μ��ϰ� �ȴ�.

�������� �� ����, ���� Queue�� �ִ� ������ ���� �߿䵵�� �־����� ��, � �� ������ �� ��°�� �μ�Ǵ��� �˾Ƴ��� ���̴�. ���� ��� ���� ������ C������ 1��°��, A������ 3��°�� �μ�ǰ� �ȴ�.

�Է�
ù �ٿ� test case�� ���� �־�����. �� test case�� ���ؼ� ������ �� N(100����)�� �� ��°�� �μ�Ǿ����� �ñ��� ������ ���� Queue�� � ��ġ�� �ִ����� �˷��ִ� M(0�̻� N�̸�)�� �־�����. �����ٿ� N�� ������ �߿䵵�� �־����µ�, �߿䵵�� 1 �̻� 9 �����̴�. �߿䵵�� ���� ������ ���� �� ���� ���� �ִ�. ���� ���� N=4, M=0(A������ �ñ��ϴٸ�), �߿䵵�� 2 1 4 3�� �ȴ�.

���
�� test case�� ���� ������ �� ��°�� �μ�Ǵ��� ����Ѵ�.*/

package ����;

import java.util.*;

class Print {
	int idx;
	int impo;

	Print(int idx, int impo) {
		this.idx = idx;
		this.impo = impo;
	}
}

public class N_1966 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		for (int i = 0; i < T; i++) {
			int N = s.nextInt();
			int M = s.nextInt();
			LinkedList<Print> q = new LinkedList<Print>(); // �߿䵵 �����ϴ� ť
			for (int j = 0; j < N; j++)
				q.offer(new Print(j, s.nextInt()));
			int cnt = 0;
			while (true) {
				int flag = 0;
				for (int j = 1; j < q.size(); j++) {
					if (q.get(0).impo < q.get(j).impo) {
						flag = 1;
						break;
					}
				}
				if (flag == 1) {
					q.offer(q.remove(0));
				} else {
					cnt++;
					if (q.remove(0).idx == M)
						break;
				}
			}
			System.out.println(cnt);
		}
	}

}
