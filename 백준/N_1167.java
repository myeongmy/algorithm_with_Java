//백준 1167번
/*문제
트리의 지름이란, 트리에서 임의의 두 점 사이의 거리 중 가장 긴 것을 말한다. 트리의 지름을 구하는 프로그램을 작성하시오.

입력
트리가 입력으로 주어진다. 먼저 첫 번째 줄에서는 트리의 정점의 개수 V가 주어지고 (2≤V≤100,000)둘째 줄부터 V개의 줄에 걸쳐 간선의 정보가 다음과 같이 주어진다. (정점 번호는 1부터 V까지 매겨져 있다고 생각한다)

먼저 정점 번호가 주어지고, 이어서 연결된 간선의 정보를 의미하는 정수가 두 개씩 주어지는데, 하나는 정점번호, 다른 하나는 그 정점까지의 거리이다. 예를 들어 네 번째 줄의 경우 정점 3은 정점 1과 거리가 2인 간선으로 연결되어 있고, 정점 4와는 거리가 3인 간선으로 연결되어 있는 것을 보여준다. 각 줄의 마지막에는 -1이 입력으로 주어진다. 주어지는 거리는 모두 10,000 이하의 자연수이다.

출력
첫째 줄에 트리의 지름을 출력한다.*/

package 백준;

import java.util.*;

class Node1 {
	int v;
	int weight;

	Node1(int v, int weight) {
		this.v = v;
		this.weight = weight;
	}
}

public class N_1167 {
	static ArrayList<Node1>[] adlist;

	static void dfs(int v, int[] c, int[] depth) {
		c[v] = 1;

		for (Node1 n : adlist[v]) {
			if (c[n.v] == 0) {
				depth[n.v] = depth[v] + n.weight;
				dfs(n.v, c, depth);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		adlist = (ArrayList<Node1>[]) new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			adlist[i] = new ArrayList<Node1>();
		for (int i = 1; i <= N; i++) {
			int root = s.nextInt();
			int a, b;
			while ((a = s.nextInt()) != -1) {
				b = s.nextInt();
				adlist[root].add(new Node1(a, b));
			}
		}
		int[] c = new int[N + 1];
		int[] depth = new int[N + 1];
		dfs(1, c, depth);
		int max = 0; // 가장 긴 경로 점 선택
		int max_v = 0;
		for (int i = 2; i <= N; i++) {
			if (max < depth[i]) {
				max = depth[i];
				max_v = i;
			}
		}
		int[] depth1 = new int[N + 1];
		int[] c1 = new int[N + 1];
		dfs(max_v, c1, depth1);
		max = 0;
		for (int i = 1; i <= N; i++) {
			if (max < depth1[i])
				max = depth1[i];
		}
		System.out.println(max);
	}

}
