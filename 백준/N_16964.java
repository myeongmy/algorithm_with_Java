//���� 16964��
/*����
BOJ���� ������ ���������� ��쿡�� ����� ������ ����Ѵ�. ����� ������ ������ ����� ���� �����ϴ� �ڵ带 ���ؼ� ���� ������ �����ϴ� ����̴�. ������ ����� ���� �ڵ带 �ϳ� �������� �Ѵ�.

������ ������ N�̰�, ������ 1���� N���� ��ȣ�� �Ű����ִ� ����� �׷����� ���� ��, DFS �˰����� ������ ���� ���·� �̷���� �ִ�.

void dfs(int x) {
    if (check[x] == true) {
        return;
    }
    check[x] = true;
    // x�� �湮
    for (int y : x�� ������ ����) {
        if (check[y] == false) {
            dfs(y);
        }
    }
}
�� �������� ���� ������ 1�̱� ������ ���� ó���� ȣ���ϴ� �Լ��� dfs(1)�̴�. DFS �湮 ������ dfs�Լ����� // x�� �湮 �̶�� ���� ���� ������ ���� ��ȣ�� ������� ������ ���̴�.

Ʈ���� �־����� ��, �ùٸ� DFS �湮 �������� ���غ���.

�Է�
ù° �ٿ� ������ �� N(2 �� N �� 100,000)�� �־�����. ��° �ٺ��� N-1���� �ٿ��� Ʈ���� ���� ������ �־�����. ������ �ٿ��� DFS �湮 ������ �־�����. DFS �湮 ������ �׻� N���� ������ �̷���� ������, 1���� N���� �ڿ����� �� ���� �����Ѵ�.

���
�Է����� �־��� DFS �湮 ������ �ùٸ� ������ 1, �ƴϸ� 0�� ����Ѵ�.*/

package ����;

import java.util.*;

public class N_16964 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		ArrayList<Integer>[] adlist = (ArrayList<Integer>[]) new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			adlist[i] = new ArrayList<Integer>();

		for (int i = 0; i < N - 1; i++) {
			int a = s.nextInt();
			int b = s.nextInt();
			adlist[a].add(b);
			adlist[b].add(a);
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < N; i++)
			list.add(s.nextInt());

		// dfs(������ �̿��ؼ� ����)
		if (list.get(0) != 1) { // ���� ������ 1�� �ƴϸ� 0 ����
			System.out.println(0);
			System.exit(0);
		}

		Stack<Integer> st = new Stack<Integer>();
		st.push(1);

		for (int i = 1; i < N; i++) {
			
			while (true) {
				if (st.empty()) {
					System.out.println(0);
					System.exit(0);
				}
				if (adlist[st.peek()].contains(list.get(i))) { // �θ� ������
					st.push(list.get(i));
					break;
				} else {
					st.pop();
				}
			}
		}
		System.out.println(1);

	}

}
