//���� 16947��
/*����
���� ����ö 2ȣ���� ������ ���� �����.



����ö 2ȣ������ 51���� ���� �ְ�, ���� �� ���̸� �����ϴ� ������ 51�� �ִ�. ��, ������ 51���̰�, ����� ������ 51���� �׷����� ��Ÿ�� �� �ִ�. 2ȣ���� ��ȯ�� 1���� 2���� �������� �̷���� �ִ�. �� ������ ����ؼ� ��� ���� �ٽ� ����� ������ ���ƿ� �� �ִ� �뼱�� ��ȯ���̶�� �Ѵ�. ������ ��ȯ���� ���ϴ� �� ������ �����ϴ� Ʈ�� ������ �뼱�̴�.

�� ��(����) ������ �Ÿ��� ������ �ϴ� ����(����)�� �����̴�. �� A�� ��ȯ�� ������ �Ÿ��� A�� ��ȯ���� ���ϴ� �� ������ �Ÿ� �� �ּڰ��̴�.

����ö 2ȣ���� ���� ������ �뼱���� �־����� ��, �� ���� ��ȯ�� ������ �Ÿ��� ���غ���.

�Է�
ù° �ٿ� ���� ���� N(3 �� N �� 3,000)�� �־�����. ��° �ٺ��� N���� �ٿ��� ���� ���� �����ϴ� ������ ������ �־�����. ���� ������ ���� �� �־����� ���� ����, ���� 1������ N������ ��ȣ�� �Ű��� �ִ�. ������ �� �� ���̿� ��ΰ� �׻� �����ϴ� �뼱�� �Է����� �־�����.

���
�� N���� ������ ����Ѵ�. 1�� ���� ��ȯ�� ������ �Ÿ�, 2�� ���� ��ȯ�� ������ �Ÿ�, ..., N�� ���� ��ȯ�� ������ �Ÿ��� �������� ������ ����Ѵ�.*/

package ����;

import java.util.*;

public class N_16947 {
	static int[] c = new int[3000];
	static int curculationFlag = 0;
	static ArrayList<Integer> subList = new ArrayList<Integer>();
	static void go(int v, int index, ArrayList<Integer>[] adlist, int[] result) {
		if (index >= 3) {
			if (adlist[result[0]].contains(result[index - 1])) {
				curculationFlag = 1;
				if(subList.size() == 0) {
				for(int i=0;i<index;i++)
					subList.add(result[i]);
				}
				return;
			}
		}
		for (int a : adlist[v]) {
			if (c[a] == 1)
				continue;
			c[a] = 1;
			result[index] = a;
			go(a, index + 1, adlist, result);
			c[a] = 0;
			result[index] = 0;
		}
	}
	static void bfs(int v, ArrayList<Integer> [] adlist, int [] dist) {
		Queue<Integer> q = new LinkedList<Integer>();
		dist[v] = 1;
		q.offer(v);
		
		while(!q.isEmpty()) {
			int a = q.poll();
			
			for(int k : adlist[a]) {
				if(dist[k] == 0) {
					q.offer(k);
					dist[k] = dist[a] + 1;
				}
			}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		ArrayList<Integer>[] adlist = (ArrayList<Integer>[]) new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			adlist[i] = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			int a = s.nextInt();
			int b = s.nextInt();
			adlist[a].add(b);
			adlist[b].add(a);
		}
		int[] result = new int[3001];
		for (int i = 1; i <= N; i++) {
			
			result[0] = i;
			c[i] = 1;
			go(i, 1, adlist, result);
			if (curculationFlag == 1)
				break;
		}
		//subList ����Ʈ�� ��ȯ���� ���Ե� ������ ����Ǿ� ����
		for(int i=1;i<=N;i++) {
			int [] dist = new int[N+1]; //���� i���� ��� �ٸ� ������ ���� �� �ʿ��� �Ÿ�
			bfs(i, adlist, dist);
			int min = 4000;
			for(int j=0;j<subList.size();j++) {
				if(min > dist[subList.get(j)])
					min = dist[subList.get(j)];
			}
			System.out.print(min-1+" ");
		}
	}

}
