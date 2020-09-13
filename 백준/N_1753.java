//백준 1753번 최단경로
//다익스트라

package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class N_1753 {
	static class Node implements Comparable<Node> {
		int v;
		int weight;

		Node(int v, int weight) {
			this.v = v;
			this.weight = weight;
		}

		public int compareTo(Node n) {
			if (this.weight < n.weight)
				return -1;
			else if (this.weight > n.weight)
				return 1;
			else
				return 0;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String[] input = br.readLine().split(" ");
			int V = Integer.parseInt(input[0]);
			int E = Integer.parseInt(input[1]);

			int start = Integer.parseInt(br.readLine());
			ArrayList<Node>[] adlist = (ArrayList<Node>[]) new ArrayList[V + 1];
			for (int i = 1; i <= V; i++)
				adlist[i] = new ArrayList<Node>();

			for (int i = 0; i < E; i++) {
				String[] arr = br.readLine().split(" ");
				adlist[Integer.parseInt(arr[0])].add(new Node(Integer.parseInt(arr[1]), Integer.parseInt(arr[2])));
			}

			int[] d = new int[V + 1]; // 시작지점에서 각 노드까지의 최단 거리 저장
			for (int i = 1; i <= V; i++) {
				if (start == i)
					d[i] = 0;
				else
					d[i] = Integer.MAX_VALUE;
			}
			PriorityQueue<Node> pq = new PriorityQueue<Node>();
			pq.offer(new Node(start, 0));

			while (!pq.isEmpty()) {
				Node a = pq.poll();

				for (Node n : adlist[a.v]) {
					if (d[n.v] > d[a.v] + n.weight) {
						d[n.v] = d[a.v] + n.weight;
						pq.offer(new Node(n.v, d[n.v]));
					}
				}
			}

			for (int i = 1; i <= V; i++) {
				if (d[i] == Integer.MAX_VALUE)
					System.out.println("INF");
				else
					System.out.println(d[i]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
