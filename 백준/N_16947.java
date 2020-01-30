//백준 16947번
/*문제
서울 지하철 2호선은 다음과 같이 생겼다.



지하철 2호선에는 51개의 역이 있고, 역과 역 사이를 연결하는 구간이 51개 있다. 즉, 정점이 51개이고, 양방향 간선이 51개인 그래프로 나타낼 수 있다. 2호선은 순환선 1개와 2개의 지선으로 이루어져 있다. 한 역에서 출발해서 계속 가면 다시 출발한 역으로 돌아올 수 있는 노선을 순환선이라고 한다. 지선은 순환선에 속하는 한 역에서 시작하는 트리 형태의 노선이다.

두 역(정점) 사이의 거리는 지나야 하는 구간(간선)의 개수이다. 역 A와 순환선 사이의 거리는 A와 순환선에 속하는 역 사이의 거리 중 최솟값이다.

지하철 2호선과 같은 형태의 노선도가 주어졌을 때, 각 역과 순환선 사이의 거리를 구해보자.

입력
첫째 줄에 역의 개수 N(3 ≤ N ≤ 3,000)이 주어진다. 둘째 줄부터 N개의 줄에는 역과 역을 연결하는 구간의 정보가 주어진다. 같은 구간이 여러 번 주어지는 경우는 없고, 역은 1번부터 N번까지 번호가 매겨져 있다. 임의의 두 역 사이에 경로가 항상 존재하는 노선만 입력으로 주어진다.

출력
총 N개의 정수를 출력한다. 1번 역과 순환선 사이의 거리, 2번 역과 순환선 사이의 거리, ..., N번 역과 순환선 사이의 거리를 공백으로 구분해 출력한다.*/

package 백준;

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
		//subList 리스트에 순환선에 포함된 정점들 저장되어 있음
		for(int i=1;i<=N;i++) {
			int [] dist = new int[N+1]; //정점 i에서 모든 다른 점으로 가는 데 필요한 거리
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
