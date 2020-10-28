//백준 16681번 등산
//다익스트라 응용(한 점에서 다른 모든 지점까지의 최단 경로 구하기)

package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class N_16681 {
	static class Node implements Comparable<Node> {
		int num;
		int weight;

		Node(int num, int weight) {
			this.num = num;
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
			String[] input = br.readLine().split(" ");
			int N = Integer.parseInt(input[0]);
			int M = Integer.parseInt(input[1]);
			int D = Integer.parseInt(input[2]);
			int E = Integer.parseInt(input[3]);

			// 각 지점의 높이 저장
			input = br.readLine().split(" ");
			int[] h = new int[N + 1];
			for (int i = 1; i <= N; i++)
				h[i] = Integer.parseInt(input[i - 1]);

			// 엣지 저장
			ArrayList<Node>[] adlist = (ArrayList<Node>[]) new ArrayList[N + 1];
			for (int i = 1; i <= N; i++)
				adlist[i] = new ArrayList<Node>();

			for (int i = 0; i < M; i++) {
				String[] arr = br.readLine().split(" ");
				int start = Integer.parseInt(arr[0]);
				int end = Integer.parseInt(arr[1]);
				int weight = Integer.parseInt(arr[2]);

				adlist[start].add(new Node(end, weight));
				adlist[end].add(new Node(start, weight));
			}

			// 집에서 모든 지점까지의 최단 거리 구하기
			PriorityQueue<Node> pq = new PriorityQueue<Node>();
			int[] dist = new int[N + 1];
			for (int i = 1; i <= N; i++)
				dist[i] = MAX;

			dist[1] = 0;
			pq.offer(new Node(1, 0));

			while (!pq.isEmpty()) {
				Node n = pq.poll();

				for (Node a : adlist[n.num]) {
					if (h[a.num] <= h[n.num])
						continue;
					if (dist[a.num] > dist[n.num] + a.weight) {
						dist[a.num] = dist[n.num] + a.weight;
						pq.offer(new Node(a.num, dist[a.num]));
					}
				}
			}

			// 고려대학교에서 모든 지점까지의 최단 거리 구하기
			pq.clear();
			int[] dist1 = new int[N + 1];
			for (int i = 1; i <= N; i++)
				dist1[i] = MAX;

			dist1[N] = 0;
			pq.offer(new Node(N, 0));

			while (!pq.isEmpty()) {
				Node n = pq.poll();

				for (Node a : adlist[n.num]) {
					if (h[a.num] <= h[n.num])
						continue;
					if (dist1[a.num] > dist1[n.num] + a.weight) {
						dist1[a.num] = dist1[n.num] + a.weight;
						pq.offer(new Node(a.num, dist1[a.num]));
					}
				}
			}

			// 가치 최대 지점 구하기
			int max = Integer.MIN_VALUE;
			for (int i = 2; i < N; i++) {
				if (dist[i] == MAX || dist1[i] == MAX)
					continue;
				int sum = 0;
				sum += (h[i] * E);
				sum = sum - D * (dist[i] + dist1[i]);
				if (max < sum)
					max = sum;
			}
			if (max == Integer.MIN_VALUE)
				System.out.println("Impossible");
			else
				System.out.println(max);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
