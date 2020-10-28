//백준 1916번 최소비용 구하기
//다익스트라

package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class N_1916 {
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

	static final int MAX = 100000000;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());

			ArrayList<Node>[] adlist = (ArrayList<Node>[]) new ArrayList[N + 1];
			for (int i = 1; i <= N; i++)
				adlist[i] = new ArrayList<Node>();

			for (int i = 0; i < M; i++) {
				String[] arr = br.readLine().split(" ");
				int start = Integer.parseInt(arr[0]);
				int end = Integer.parseInt(arr[1]);
				int weight = Integer.parseInt(arr[2]);

				adlist[start].add(new Node(end, weight));
			}

			String[] arr = br.readLine().split(" ");
			int startNode = Integer.parseInt(arr[0]);
			int finishNode = Integer.parseInt(arr[1]);

			// 최단 거리 저장 배열
			int[] dist = new int[N + 1];
			for (int i = 1; i <= N; i++)
				dist[i] = MAX;

			dist[startNode] = 0;

			PriorityQueue<Node> pq = new PriorityQueue<Node>();
			pq.offer(new Node(startNode, 0));

			while (!pq.isEmpty()) {
				Node n = pq.poll();

				for (Node n1 : adlist[n.v]) {
					if (dist[n1.v] > dist[n.v] + n1.weight) {
						dist[n1.v] = dist[n.v] + n1.weight;
						pq.offer(new Node(n1.v, dist[n1.v]));
					}
				}
			}
			
			System.out.println(dist[finishNode]);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
