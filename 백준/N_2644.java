//���� 2644��
//BFS ����
/*����
�츮 ����� ���� Ȥ�� ģô�� ������ ���踦 �̼���� ������ ǥ���ϴ� ��Ư�� ��ȭ�� ������ �ִ�. �̷��� �̼��� ������ ���� ������� ���ȴ�. �⺻������ �θ�� �ڽ� ���̸� 1������ �����ϰ� �̷κ��� ����� ���� �̼��� ����Ѵ�. ���� ��� ���� �ƹ���, �ƹ����� �Ҿƹ����� ���� 1������ ���� �Ҿƹ����� 2���� �ǰ�, �ƹ��� ������� �Ҿƹ����� 1��, ���� �ƹ��� ��������� 3���� �ȴ�.

���� ����鿡 ���� �θ� �ڽĵ� ���� ���谡 �־����� ��, �־��� �� ����� �̼��� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
������� 1, 2, 3, ��, n (1��n��100)�� ���ӵ� ��ȣ�� ���� ǥ�õȴ�. �Է� ������ ù° �ٿ��� ��ü ����� �� n�� �־�����, ��° �ٿ��� �̼��� ����ؾ� �ϴ� ���� �ٸ� �� ����� ��ȣ�� �־�����. �׸��� ��° �ٿ��� �θ� �ڽĵ� ���� ������ ���� m�� �־�����. ��° �ٺ��ʹ� �θ� �ڽİ��� ���踦 ��Ÿ���� �� ��ȣ x,y�� �� �ٿ� ���´�. �̶� �տ� ������ ��ȣ x�� �ڿ� ������ ���� y�� �θ� ��ȣ�� ��Ÿ����.

�� ����� �θ�� �ִ� �� �� �־�����.

���
�Է¿��� �䱸�� �� ����� �̼��� ��Ÿ���� ������ ����Ѵ�. � ��쿡�� �� ����� ģô ���谡 ���� ���� �̼��� ����� �� ���� ���� �ִ�. �̶����� -1�� ����ؾ� �Ѵ�.*/

package ����;

import java.util.*;

public class N_2644 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int start = s.nextInt();
		int end = s.nextInt();
		ArrayList<Integer>[] adlist = (ArrayList<Integer>[]) new ArrayList[n + 1];
		for (int i = 1; i <= n; i++)
			adlist[i] = new ArrayList<Integer>();
		int m = s.nextInt();
		for (int i = 0; i < m; i++) {
			int a = s.nextInt();
			int b = s.nextInt();

			adlist[a].add(b);
			adlist[b].add(a);
		}

		// bfs ������
		int[] c = new int[n + 1];
		Queue<Integer> q = new LinkedList<Integer>();

		c[start] = 1;
		q.offer(start);

		while (!q.isEmpty()) {
			int a = q.poll();

			for (int k : adlist[a]) {
				if (c[k] == 0) {
					q.offer(k);
					c[k] = c[a] + 1;
				}
			}
		}
		System.out.println(c[end] - 1);
	}

}
